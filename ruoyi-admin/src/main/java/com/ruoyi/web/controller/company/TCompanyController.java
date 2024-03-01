package com.ruoyi.web.controller.company;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.company.entity.TCompany;
import com.ruoyi.company.service.TCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 文君
 * @Date: 2023-06-26-11:31
 * @Description:
 */

@RestController
@RequestMapping("/tCompany")
@Api(tags = "企业信息")
@DataSource(value = "slave1")
public class TCompanyController {
    @Autowired
    private TCompanyService tCompanyService;

    //查询企业所有信息
    @GetMapping
    @ApiOperation(value="查询企业信息",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page", value="请求页数", required = true, dataType="Integer", paramType="query"),
            @ApiImplicitParam(name="pageSize", value="数据条数", required = true, dataType="Integer", paramType="query"),
            @ApiImplicitParam(name="companyName", value="企业名称", required = false, dataType="String", paramType="query"),
            @ApiImplicitParam(name="examineStatus", value="审核状态", required = false, dataType="Integer", paramType="query"),
            @ApiImplicitParam(name="companyType", value="企业属性(0招聘企业 1猎头企业)", required = false, dataType="String", paramType="query")
    })
    @DataSource(value = "slave1")
    public R<TCompany> getCompany(int page, int pageSize, String companyName,Integer examineStatus,String companyType){
        Page<TCompany> pages = tCompanyService.pageInfo(page,pageSize,companyName,examineStatus,companyType);
        return R.ok(pages);
    }

    /**
     * 修改企业信息
     * @param tCompany
     * @return
     */
    @ApiOperation(value="修改企业信息")
    @PutMapping
    public R<TCompany> PutCompany(@RequestBody TCompany tCompany){
        tCompanyService.updateById(tCompany);
        return R.ok();
    }
}
