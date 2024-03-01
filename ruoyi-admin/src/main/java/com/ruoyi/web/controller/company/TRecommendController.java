package com.ruoyi.web.controller.company;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.annotation.TransactionMulti;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.company.entity.HeadhunterApprove;
import com.ruoyi.company.entity.TRecommend;
import com.ruoyi.company.query.TRecommendQuery;
import com.ruoyi.company.service.impl.HeadhunterApproveServiceImpl;
import com.ruoyi.company.service.impl.TRecommendServiceImpl;
import com.ruoyi.post.service.RecommendBasicsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 文君
 * @Date: 2023-07-24-8:37
 * @Description:
 */
@RestController
@RequestMapping("/TRecommend")
@Api(tags = "推荐官")
public class TRecommendController {
    @Autowired
    private TRecommendServiceImpl tRecommendService;
    @Autowired
    private HeadhunterApproveServiceImpl headhunterApproveService;

    @Autowired
    private RecommendBasicsService recommendBasicsService;

    /**
     * 推荐注册分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "请求页数", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "数据条数", required = true, dataType = "Integer", paramType = "query"),
    })
    @ApiOperation("查询账号信息")
    public R<Page<TRecommend>> getRecommend(int page, int pageSize) {
        Page<TRecommend> pageList = tRecommendService.RecommPage(page, pageSize);
        return R.ok(pageList);
    }

    @PostMapping("/recommendPage")
    @ApiOperation("查询推荐官")
    @DataSource(value ="slave1")
    public R<Page<TRecommend>> recommendPage(@RequestBody TRecommendQuery tRecommendQuery) {
        LambdaQueryWrapper<TRecommend> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (!StringUtils.isEmpty(tRecommendQuery.getKeyword())) {
            lambdaQueryWrapper.like(TRecommend::getLoginName, tRecommendQuery.getKeyword());
            lambdaQueryWrapper.or();
            lambdaQueryWrapper.like(TRecommend::getCompanyName, tRecommendQuery.getKeyword());
            lambdaQueryWrapper.or();
            lambdaQueryWrapper.like(TRecommend::getPosition, tRecommendQuery.getKeyword());
            lambdaQueryWrapper.or();
            lambdaQueryWrapper.like(TRecommend::getAcademy, tRecommendQuery.getKeyword());
        }
        if (! StringUtils.isEmpty(tRecommendQuery.getStartDate()) && StringUtils.isEmpty(tRecommendQuery.getEndDate())) {
            lambdaQueryWrapper.ge(TRecommend::getRegistrantTime,tRecommendQuery.getStartDate());
        }
        if (StringUtils.isEmpty(tRecommendQuery.getStartDate()) &&  ! StringUtils.isEmpty(tRecommendQuery.getEndDate())) {
            lambdaQueryWrapper.le(TRecommend::getRegistrantTime,tRecommendQuery.getEndDate());
        }
        if(! StringUtils.isEmpty(tRecommendQuery.getStartDate()) && ! StringUtils.isEmpty(tRecommendQuery.getEndDate())){
            lambdaQueryWrapper.between(TRecommend::getRegistrantTime,tRecommendQuery.getStartDate(),tRecommendQuery.getEndDate());
        }
        if(! StringUtils.isEmpty(tRecommendQuery.getExamineStatus())){
            lambdaQueryWrapper.eq(TRecommend::getExamineStatus,tRecommendQuery.getExamineStatus());
        }
        lambdaQueryWrapper.orderByDesc(TRecommend::getRegistrantTime);
        IPage<TRecommend> page = tRecommendService.page(tRecommendQuery.createPage(), lambdaQueryWrapper);
        return R.ok(page);
    }

    /**
     * 修改账号状态
     *
     * @param id
     * @param examineStatus
     * @param status
     * @return
     */
    @PostMapping
    @ApiOperation("修改账号状态")
    public R<TRecommend> upadetRecommend(
            @ApiParam("id") String id,
            @ApiParam("审核状态(0待审核1审核中2通过3未通过)") String examineStatus,
            @ApiParam("账号状态(0正常1停用)") Integer status) {
        boolean b = tRecommendService.upadetRecommend(id, examineStatus, status);
        if (b) {
            return R.ok(null, "修改成功");
        } else {
            return R.fail("操作失败");
        }
    }

    /**
     * 推荐官猎企认证查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "请求页数", required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "数据条数", required = true, dataType = "Integer", paramType = "query"),
    })
    @GetMapping("/HeadhunterApprove")
    @ApiOperation("推荐官猎企认证查询")
    public R<Page<HeadhunterApprove>> getHeadhunterApprove(int page, int pageSize) {
        Page<HeadhunterApprove> pageList = headhunterApproveService.HeadhunterApprovePage(page, pageSize);
        return R.ok(pageList);
    }

    /***
     * 推荐官猎企认证修改状态
     * @param recommendId
     * @param audit
     * @return
     */
    @ApiOperation("推荐官猎企认证修改状态")
    @PostMapping("/upadetHeadhunterApprove")
    @TransactionMulti(value = {"slave1", "slave"})
    public R<HeadhunterApprove> upadetHeadhunterApprove(
            @ApiParam("推荐官id") String recommendId,
            @ApiParam("审核状态(0:审核中 1:审核成功 2:审核失败)") Integer audit
    ) {
        boolean b = headhunterApproveService.upadetHeadhunterApprove(recommendId, audit);
        if (b) {
            if (audit == 1) {
                //修改
                UpdateWrapper updateWrapper = new UpdateWrapper();
                updateWrapper.eq("id", recommendId);
                updateWrapper.set("administrator", 2);
                tRecommendService.upadetHeadhunterApprove(updateWrapper);
                recommendBasicsService.updateAuthentication(recommendId);
            }
            return R.ok(null, "修改成功");
        } else {
            return R.fail("操作失败");
        }
    }

    @ApiOperation("通过id查询")
    @PostMapping("/selectId")
    @ApiImplicitParam(name = "recommendId", value = "推荐官id", required = true)
    @DataSource(value = "slave1")
    public R<TRecommend> selectId(@RequestParam("recommendId") String recommendId) {
        TRecommend byId = tRecommendService.getById(recommendId);
        return R.ok(byId);
    }
}
