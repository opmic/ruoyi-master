package com.ruoyi.web.controller.company;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.company.entity.Report;
import com.ruoyi.company.query.ReportQuery;
import com.ruoyi.company.service.ReportService;
import com.ruoyi.company.vo.ReportVO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * ClassName: ReportController
 * Description:
 * date: 2023/9/21 9:37
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@Api(tags = "举报接口")
@RestController
@RequestMapping("/report")
@DataSource(value = "slave1")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/selectReport")
    @ApiOperation("查看举报")
    public R<Report> selectReport(@RequestBody ReportQuery reportQuery) {
        if (StringUtils.isEmpty(reportQuery.getIdentity())) {
            reportQuery.setIdentity(0);
        }
        LambdaQueryWrapper<Report> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Report::getIdentity, reportQuery.getIdentity());
        if (reportQuery.getStartDate() != null && reportQuery.getEndDate() == null) {
            queryWrapper.ge(Report::getCreateTime, reportQuery.getStartDate());
        }
        if (reportQuery.getStartDate() == null && reportQuery.getEndDate() != null) {
            queryWrapper.le(Report::getCreateTime, reportQuery.getEndDate());
        }
        if (reportQuery.getStartDate() != null && reportQuery.getEndDate() != null) {
            queryWrapper.between(Report::getCreateTime, reportQuery.getStartDate(), reportQuery.getEndDate());
        }
        if (!StringUtils.isEmpty(reportQuery.getType())) {
            queryWrapper.eq(Report::getType,reportQuery.getType());
        }
        if (!StringUtils.isEmpty(reportQuery.getKeyword())) {
            queryWrapper.and(i->{
                i.like(Report::getCompanyName,reportQuery.getKeyword()).or().like(Report::getPostName,reportQuery.getKeyword()).or().like(Report::getJobHunterName,reportQuery.getKeyword());
            });
        }
        queryWrapper.orderByDesc(Report::getCreateTime);
        IPage<Report> page = reportService.page(reportQuery.createPage(), queryWrapper);
        return R.ok(page);
    }



    @PostMapping("/disposeReport")
    @ApiOperation("审核举报")
    public R disposeReport(@Valid @RequestBody ReportVO reportVO){
        UpdateWrapper updateWrapper=new UpdateWrapper();
        updateWrapper.eq("report_id",reportVO.getReportId());
        updateWrapper.set("state",reportVO.getState());
        updateWrapper.set("feedback",reportVO.getFeedback());
        updateWrapper.set("update_time", LocalDateTime.now());
        boolean update = reportService.update(updateWrapper);
        if(update){
            return R.ok();
        }
        return R.fail();
    }

}
