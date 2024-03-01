package com.ruoyi.web.controller.system;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.entity.AccessRecord;
import com.ruoyi.system.query.AccessRecordQuery;
import com.ruoyi.system.service.AccessRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * ClassName: AccessRecordController
 * Description:
 * date: 2023/8/2 9:43
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/accessRecord")
@Api(tags = "访问记录接口")
public class AccessRecordController {

    @Autowired
    private AccessRecordService accessRecordService;

    @PostMapping("/selectPage")
    @ApiOperation("访问总数数据面板")
    public R<AccessRecord> selectAmount(@RequestBody AccessRecordQuery accessRecordQuery) {
     /*   LambdaQueryWrapper<AccessRecord> queryWrapper=new LambdaQueryWrapper();
        if (accessRecordQuery.getBeginTime() != null || accessRecordQuery.getEndTime() != null) {
            if (accessRecordQuery.getBeginTime() != null && accessRecordQuery.getEndTime() != null) {
                queryWrapper.between(AccessRecord::getCreateTime, accessRecordQuery.getBeginTime(), accessRecordQuery.getEndTime());
            }
            if (accessRecordQuery.getBeginTime() != null) {
                queryWrapper.le(AccessRecord::getCreateTime, accessRecordQuery.getBeginTime());
            }
            if (accessRecordQuery.getEndTime() != null) {
                queryWrapper.ge(AccessRecord::getCreateTime, accessRecordQuery.getEndTime());
            }
        }*/
        if (accessRecordQuery.getBeginTime() == null) {
            accessRecordQuery.setBeginTime(LocalDate.now());
        }
        List<AccessRecord> list = accessRecordService.selectAmount(accessRecordQuery);
        return R.ok(list);

    }

    @PostMapping("/intraday")
    @ApiOperation("访问当天数据面板")
    @ApiImplicitParams({
            @ApiImplicitParam(name="beginTime", value="开始时间(yyyy-MM-dd HH:mm:ss)", required = true, dataType="Date", paramType="query"),
            @ApiImplicitParam(name="endTime", value="结束时间(yyyy-MM-dd HH:mm:ss)", required = true, dataType="Date", paramType="query")

    })
    public R<AccessRecord> intraday(@RequestParam(value = "beginTime",required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss ") Date beginTime , @RequestParam(value = "endTime",required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date endTime) {
     /*   LambdaQueryWrapper<AccessRecord> queryWrapper=new LambdaQueryWrapper();
        if (accessRecordQuery.getBeginTime() != null || accessRecordQuery.getEndTime() != null) {
            if (accessRecordQuery.getBeginTime() != null && accessRecordQuery.getEndTime() != null) {
                queryWrapper.between(AccessRecord::getCreateTime, accessRecordQuery.getBeginTime(), accessRecordQuery.getEndTime());
            }
            if (accessRecordQuery.getBeginTime() != null) {
                queryWrapper.le(AccessRecord::getCreateTime, accessRecordQuery.getBeginTime());
            }
            if (accessRecordQuery.getEndTime() != null) {
                queryWrapper.ge(AccessRecord::getCreateTime, accessRecordQuery.getEndTime());
            }
        }*/
        List<AccessRecord> list = accessRecordService.intraday(beginTime,endTime);
        return R.ok(list);

    }
}
