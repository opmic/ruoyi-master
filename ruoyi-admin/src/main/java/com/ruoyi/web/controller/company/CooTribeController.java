package com.ruoyi.web.controller.company;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.company.dto.CooCommentDTO;
import com.ruoyi.company.dto.CooTribeDTO;
import com.ruoyi.company.entity.CooComment;
import com.ruoyi.company.entity.CooTribe;
import com.ruoyi.company.entity.TRecommend;
import com.ruoyi.company.query.CommentQuery;
import com.ruoyi.company.query.CooTribeQuery;
import com.ruoyi.company.service.CooCommentService;
import com.ruoyi.company.service.CooTribeService;
import com.ruoyi.company.service.impl.TRecommendServiceImpl;
import com.ruoyi.company.vo.CooTribeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: CooTribeController
 * Description:
 * date: 2024/1/30 8:12
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@Api(tags = "发帖")
@RestController
@RequestMapping("/cooTribe")
@DataSource(value = "slave1")
public class CooTribeController {


    @Autowired
    private CooTribeService cooTribeService;
    @Autowired
    private CooCommentService cooCommentService;

    @Autowired
    private TRecommendServiceImpl tRecommendService;


    @PostMapping("/page")
    @ApiOperation("查询发帖")
    @DataSource(value = "slave1")
    public R<CooTribeDTO> page(@RequestBody CooTribeQuery cooTribeQuery) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (!StringUtils.isEmpty(cooTribeQuery.getTitle())) {
            queryWrapper.like("title", cooTribeQuery.getTitle());
        }
        if (!StringUtils.isEmpty(cooTribeQuery.getProvince())) {
            queryWrapper.eq("province", cooTribeQuery.getProvince());
        }
        if (cooTribeQuery.getType() != null) {
            queryWrapper.eq("type", cooTribeQuery.getType());
        }
        if (cooTribeQuery.getOnLine() != null) {
            queryWrapper.eq("on_line", cooTribeQuery.getOnLine());
        }
        if (cooTribeQuery.getAudit() != null) {
            queryWrapper.eq("audit", cooTribeQuery.getAudit());
        }
        if (cooTribeQuery.getStartTime() != null && cooTribeQuery.getEndTime() != null) {
            queryWrapper.between("create_time", cooTribeQuery.getStartTime(), cooTribeQuery.getEndTime());
        }
        queryWrapper.orderByDesc("create_time");
        IPage<CooTribe> iPage = cooTribeService.page(cooTribeQuery.createPage(), queryWrapper);
        List<CooTribe> records = iPage.getRecords();
        List list = new ArrayList<>(records.size());
        for (CooTribe record : records) {
            CooTribeDTO cooTribeDTO = new CooTribeDTO();
            BeanUtils.copyProperties(record, cooTribeDTO);
            TRecommend byId = tRecommendService.getById(record.getUserId());
            cooTribeDTO.setHeadPath(byId.getHeadPath());
            cooTribeDTO.setUsername(byId.getUsername());
            list.add(cooTribeDTO);
        }
        iPage.setRecords(list);
        return R.ok(iPage);

    }

    @PostMapping("/examine")
    @ApiOperation("审核")
    @DataSource(value = "slave1")
    public R examine(@RequestBody CooTribeVO cooTribeVO) {
        LambdaUpdateWrapper<CooTribe> lambdaQueryWrapper = new LambdaUpdateWrapper();
        lambdaQueryWrapper.eq(CooTribe::getId, cooTribeVO.getId());
        lambdaQueryWrapper.set(CooTribe::getAudit, cooTribeVO.getAudit());
        if (!StringUtils.isEmpty(cooTribeVO.getCauseOfFailure())) {
            lambdaQueryWrapper.set(CooTribe::getCauseOfFailure, cooTribeVO.getCauseOfFailure());
        }
        if (cooTribeVO.getAudit() == 2) {
            lambdaQueryWrapper.set(CooTribe::getOnLine, 1);
        }
        if (cooTribeVO.getAudit() == 1) {
            lambdaQueryWrapper.set(CooTribe::getOnLine, 0);
        }
        boolean update = cooTribeService.update(lambdaQueryWrapper);
        if (update) {
            return R.ok();
        }
        return R.fail();
    }


    @GetMapping("/reply")
    @ApiOperation("获取回答")
    @DataSource(value = "slave1")
    @ApiImplicitParam(name = "id", value = "问题id", required = true)
    public R<CooTribe> reply(@RequestParam("id") Long id, @RequestParam(value = "pageSize") Long pageSize, @RequestParam("pageNum") Long pageNum) {
        if (pageSize == null) {
            pageSize = 10L;
        }
        if (pageNum == null) {
            pageNum = 1L;
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("father", id);
        queryWrapper.orderByDesc("create_time");
        Page<CooTribe> page = cooTribeService.page(new Page(pageNum, pageSize), queryWrapper);
        return R.ok(page);
    }


    @PostMapping("/comment")
    @ApiOperation("获取评论")
    @DataSource(value = "slave1")
    public R<CooCommentDTO> comment(@Valid @RequestBody CommentQuery commentQuery) {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("coo_tribe_id", commentQuery.getCooTribeId());
        if(! StringUtils.isEmpty(commentQuery.getAnswer())){
            queryWrapper.like("answer",commentQuery.getAnswer());
        }
        if(commentQuery.getStartTime() !=null && commentQuery.getEndTime() !=null){
            queryWrapper.between("create_time",commentQuery.getStartTime(),commentQuery.getEndTime());
        }
        queryWrapper.orderByDesc("create_time");
        IPage<CooComment> page1 = commentQuery.createPage();
        IPage page = cooCommentService.page(page1, queryWrapper);
        List<CooComment> records = page.getRecords();
        List<CooCommentDTO> list=new ArrayList<>(records.size());
        for (CooComment record : records) {
            CooCommentDTO cooCommentDTO=new CooCommentDTO();
            BeanUtils.copyProperties(record,cooCommentDTO);
            TRecommend byId = tRecommendService.getById(record.getCreateUser());
            cooCommentDTO.setHeadPath(byId.getHeadPath());
            cooCommentDTO.setUsername(byId.getUsername());
            list.add(cooCommentDTO);
        }
        if(records !=null && records.size()>0){
            page.setRecords(list);
        }
        return R.ok(page);
    }

    @GetMapping("/count")
    @ApiOperation("获取条数")
    @DataSource(value = "slave1")
    public R count() {
        Map map = new HashMap();
        long count = cooTribeService.count();
        map.put("sumCount", count);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("audit", 0);
        long count1 = cooTribeService.count(queryWrapper);
        map.put("audit", count1);

        QueryWrapper queryWrapper1 = new QueryWrapper();
        queryWrapper1.eq("audit", 2);
        long count2 = cooTribeService.count(queryWrapper1);
        map.put("notAudit", count2);
        return R.ok(map);
    }

    @GetMapping("/del")
    @ApiOperation("删除帖子")
    @DataSource(value = "slave1")
    @ApiImplicitParam(name = "id", value = "帖子id", required = true)
    public R del(@RequestParam("id") Long id) {
        boolean b = cooTribeService.removeById(id);
        if (b) {
            return R.ok();
        }
        return R.fail();
    }
}
