package com.ruoyi.web.controller.company;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.company.entity.RevenueSharing;
import com.ruoyi.company.service.RevenueSharingService;
import com.ruoyi.company.service.TCompanyService;
import com.ruoyi.company.service.TJobhunterService;
import com.ruoyi.company.service.impl.RevenueSharingServiceImpl;
import com.ruoyi.company.service.impl.TJobhunterServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: revenueSharingController
 * Description:分享收益提现表接口
 * date: 2023/7/18 14:01
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@Api(tags = "分享收益提现表接口")
@RestController
@RequestMapping("/revenueSharing")
@DataSource(value = "slave1")
public class RevenueSharingController {
    @Autowired
    private RevenueSharingService revenueSharingService;
    @Autowired
    private TJobhunterService jobhunterService;
    @Autowired
    private TCompanyService tCompanyService;
    @ApiOperation("查询")
    @GetMapping("/select")
    public R select(){
        tCompanyService.getById("1");
        jobhunterService.getById("TJ2301171519325-1");
        revenueSharingService.getById("1");
        RevenueSharing byId = revenueSharingService.getById("1");
        // Page<RevenueSharing> page = revenueSharingService.page(new Page<>(0, 10));


        return R.ok(byId);
    }
}
