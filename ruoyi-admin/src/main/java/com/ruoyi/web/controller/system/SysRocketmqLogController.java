package com.ruoyi.web.controller.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.annotation.TransactionMulti;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.post.service.InformationService;
import com.ruoyi.system.entity.SysRocketmqLog;
import com.ruoyi.system.query.SysRocketmqQuery;
import com.ruoyi.system.service.SysRocketmqLogService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.ruoyi.common.core.domain.AjaxResult.success;

/**
* @author Administrator
* @description 针对表【sys_rocketmq_log(操作日志记录)】的数据库操作Mapper
* @createDate 2023-06-27 19:22:55
* @Entity com.ruoyi.system.entity.SysRocketmqLog
*/
@RestController
@Api(tags ="rockerMq记录接口")
@RequestMapping("/rocketmq")
public class SysRocketmqLogController {

    @Autowired
    private SysRocketmqLogService sysRocketmqLogService;

    @GetMapping("/select")
    @ApiOperation("查询")

    public R<SysRocketmqLog> select(SysRocketmqQuery sysRocketmqQuery ){
        QueryWrapper queryWrapper=new QueryWrapper();
        if(sysRocketmqQuery.getStatus() !=null){
            queryWrapper.eq("status",sysRocketmqQuery.getStatus());

        }
        if(! StringUtils.isEmpty(sysRocketmqQuery.getTitle())){
            queryWrapper.eq("title",sysRocketmqQuery.getTitle());
        }
        if(sysRocketmqQuery.getBusinessType() !=null ){
            queryWrapper.eq("business_type",sysRocketmqQuery.getBusinessType());
        }
        if(sysRocketmqQuery.getParams() !=null){
            queryWrapper.between("create_time",sysRocketmqQuery.getParams().get("beginTime"),sysRocketmqQuery.getParams().get("endTime"));
        }
        queryWrapper.orderByDesc("create_time");
        IPage page = sysRocketmqLogService.page(sysRocketmqQuery.createPage(), queryWrapper);
        return R.ok(page);
    }

    @Log(title = "操作日志", businessType = BusinessType.CLEAN)
    @PreAuthorize("@ss.hasPermi('monitor:operlog:remove')")
    @DeleteMapping("/clean")
    public AjaxResult clean()
    {
        sysRocketmqLogService.cleanLog();
        return success();
    }
    @Autowired
    private InformationService informationService;
    @Log(title = "操作日志", businessType = BusinessType.DELETE)
    @PreAuthorize("@ss.hasPermi('monitor:operlog:remove')")
    @DeleteMapping("/{operIds}")
    @TransactionMulti(value = {"master"})
    public R remove(@PathVariable Long[] operIds)
    {


        sysRocketmqLogService.remove1(operIds);
       // informationService.del();
  /*      int i=1/0;*/
        return R.ok();
    }

}




