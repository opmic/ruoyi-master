package com.ruoyi.web.controller.post;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.annotation.TransactionMulti;
import com.ruoyi.common.config.IDGenerator;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.lock.OrderLock;
import com.ruoyi.common.utils.redis.RedissonUtil;
import com.ruoyi.company.entity.RevenueSharing;
import com.ruoyi.company.service.RevenueSharingService;
import com.ruoyi.company.service.SourceOfReturnsService;
import com.ruoyi.post.dto.OrderInfoDTO;
import com.ruoyi.post.entity.OrderInfo;
import com.ruoyi.post.po.ParticularsPO;
import com.ruoyi.post.query.OrderInfoQuery;
import com.ruoyi.post.service.OrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.redisson.RedissonLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: OrderInfoController
 * Description:
 * date: 2023/7/17 15:23
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@RestController
@RequestMapping("information")
@Api(tags = "订单接口")
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private RevenueSharingService revenueSharingService;
    @Autowired
    private SourceOfReturnsService sourceOfReturnsService;
    @Autowired
    private IDGenerator idGenerator;
    @Autowired
    private RedissonUtil redissonUtil;
    @PreAuthorize("@ss.hasPermi('order:shareAudit:list')")
    @GetMapping("/shareAudit")
    @ApiImplicitParam(name = "orderId", value = "订单id", required = true)
    @ApiOperation("确认分成")
    @Log(title = "确认分成", businessType = BusinessType.UPDATE)
    @TransactionMulti(value = {"master","slave","slave1"})
    public R shareAudit(@RequestParam("orderId") String orderId) throws Exception {
        boolean lock = redissonUtil.tryLock(OrderLock.DIVIDE_INTO.getLock() + orderId, OrderLock.DIVIDE_INTO.getWaitTime(), OrderLock.DIVIDE_INTO.getLeaseTime());
        try {
            if (lock) {
                OrderInfo byId = orderInfoService.getId(orderId);
                if (byId == null) {
                    return R.fail("订单不存在");
                }
                if (byId.getDivideIntoIf() != 2) {
                    return R.fail("该订单暂时不能处理！");
                }
                String referrerId = byId.getReferrerId();
                if (!StringUtils.isEmpty(referrerId)) {
                    sourceOfReturnsService.addJobHunter(referrerId, byId.getReferrerMoney(), byId.getJobhunterId(), byId.getMoney(), byId.getOrderId(),byId.getIdentification(), byId.getPayer() ==null ? byId.getCreateId():byId.getPayer(),byId.getPayerTime());
                }
                String shareUserId = byId.getShareUserId();
                if (!StringUtils.isEmpty(shareUserId)) {
                    sourceOfReturnsService.addShareRecommend(shareUserId, byId.getShareMoney(), byId.getReferrerId(), byId.getMoney(), byId.getOrderId(), byId.getPayer() ==null ? byId.getCreateId():byId.getPayer(),byId.getPayerTime());
                }
                String inviterCompany = byId.getInviterCompany();
                if (!StringUtils.isEmpty(inviterCompany)) {
                    sourceOfReturnsService.addShareCompany(inviterCompany, byId.getInviterCompanyMoney(), byId.getPayer() ==null ? byId.getCreateId():byId.getPayer(), byId.getMoney(), byId.getOrderId(),byId.getPayerTime());
                }
                String inviterCompanyRecommend = byId.getInviterCompanyRecommend();
                if (!StringUtils.isEmpty(inviterCompanyRecommend)) {
                    sourceOfReturnsService.addShareRecommend(inviterCompanyRecommend, byId.getInviterCompanyRecommendMoney(), byId.getInviterCompany(), byId.getMoney(), byId.getOrderId(), byId.getPayer() ==null ? byId.getCreateId():byId.getPayer(),byId.getPayerTime());
                }
                byId.setDivideIntoIf(3);
                boolean b = orderInfoService.updateId(byId);
                if (b) {
                    return R.ok("已分成");
                }
            } else {
                throw new RuntimeException("操作频繁，请稍后重试");
            }
        } finally {
            if (lock) {
                redissonUtil.unlock(OrderLock.DIVIDE_INTO.getLock() + orderId);
            }
        }



        return R.fail("分成失败！");
    }

    @PreAuthorize("@ss.hasPermi('order:shareAudit:list')")
    @PostMapping("/selectOrder")
    @ApiOperation("订单查询")
    @Log(title = "订单查询", businessType = BusinessType.OTHER)
    @DataSource("slave")
    public R<OrderInfoDTO> selectOrder(@RequestBody OrderInfoQuery orderInfoQuery) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (!StringUtils.isEmpty(orderInfoQuery.getOrderId())) {
            queryWrapper.eq("order_id", orderInfoQuery.getOrderId());
        }
        if (!StringUtils.isEmpty(orderInfoQuery.getOrderOn())) {
            queryWrapper.eq("order_on", orderInfoQuery.getOrderOn());
        }
        if (!StringUtils.isEmpty(orderInfoQuery.getTitle())) {
            queryWrapper.like("title", orderInfoQuery.getOrderOn());
        }
        if (!StringUtils.isEmpty(orderInfoQuery.getPostId())) {
            queryWrapper.eq("post_id", orderInfoQuery.getPostId());
        }
        if (!StringUtils.isEmpty(orderInfoQuery.getPaymentType())) {
            queryWrapper.eq("payment_type", orderInfoQuery.getPaymentType());
        }
        if (!StringUtils.isEmpty(orderInfoQuery.getPutInResumeId())) {
            queryWrapper.eq("put_in_resume_id", orderInfoQuery.getPutInResumeId());
        }
        if (!StringUtils.isEmpty(orderInfoQuery.getState())) {
            queryWrapper.eq("state", orderInfoQuery.getState());
        }
        if (!StringUtils.isEmpty(orderInfoQuery.getJobhunterId())) {
            queryWrapper.eq("jobhunter_id", orderInfoQuery.getJobhunterId());
        }
        if (!StringUtils.isEmpty(orderInfoQuery.getRecommendId())) {
            queryWrapper.eq("recommend_id", orderInfoQuery.getRecommendId());
        }
        if (!StringUtils.isEmpty(orderInfoQuery.getDivideIntoIf())) {
            queryWrapper.eq("divide_into_if", orderInfoQuery.getDivideIntoIf());
        }
        if (!StringUtils.isEmpty(orderInfoQuery.getCreateId())) {
            queryWrapper.eq("update_id", orderInfoQuery.getCreateId());
        }
        if (!StringUtils.isEmpty(orderInfoQuery.getPayer())) {
            queryWrapper.eq("payer", orderInfoQuery.getPayer());
        }
        if (orderInfoQuery.getBeginTime() != null || orderInfoQuery.getEndTime() != null) {
            if (orderInfoQuery.getBeginTime() != null && orderInfoQuery.getEndTime() != null) {
                queryWrapper.between("create_time", orderInfoQuery.getBeginTime(), orderInfoQuery.getEndTime());
            }
            if (orderInfoQuery.getBeginTime() != null && orderInfoQuery.getEndTime() == null) {
                queryWrapper.le("create_time", orderInfoQuery.getBeginTime());
            }
            if (orderInfoQuery.getEndTime() != null && orderInfoQuery.getBeginTime() == null) {
                queryWrapper.ge("create_time", orderInfoQuery.getEndTime());
            }
        }
        queryWrapper.orderByDesc("create_time");

        IPage page = orderInfoService.page(orderInfoQuery.createPage(), queryWrapper);
        List<OrderInfo> records = page.getRecords();
        List<OrderInfoDTO> list = new ArrayList<>();
        for (OrderInfo record : records) {
            OrderInfoDTO dto = new OrderInfoDTO();
            dto.setOrderInfo(record);
            dto.setParticularsPO(JSON.parseObject(record.getParticulars(), ParticularsPO.class));
            list.add(dto);
        }
        page.setRecords(list);
        return R.ok(page);
    }
}
