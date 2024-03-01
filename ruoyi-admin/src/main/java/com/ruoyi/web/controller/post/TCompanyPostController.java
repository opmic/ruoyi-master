package com.ruoyi.web.controller.post;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.company.entity.TCompany;
import com.ruoyi.company.service.TCompanyService;
import com.ruoyi.post.dto.CompanyInfoDto;
import com.ruoyi.post.entity.TCompanyPost;
import com.ruoyi.post.service.TCompanyPostService;
import com.ruoyi.post.service.impl.TCompanyPostServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 文君
 * @Date: 2023-06-27-10:49
 * @Description:
 */
@RestController
@RequestMapping("/tCompanyPost")
@Api(tags = "企业岗位信息")
@DataSource(value = "slave")
public class TCompanyPostController {

    @Autowired
    private TCompanyPostService tCompanyPostService;
    @Autowired
    private TCompanyService tCompanyService;
    /**
     * 查询岗位查询
     * @param page
     * @param pageSize
     * @param companyName
     * @return
     */
    @GetMapping
    @ApiOperation("查询岗位查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page", value="请求页数", required = true, dataType="Integer", paramType="query"),
            @ApiImplicitParam(name="pageSize", value="数据条数", required = true, dataType="Integer", paramType="query"),
            @ApiImplicitParam(name="companyName", value="企业名称", required = false, dataType="Integer", paramType="query"),
            @ApiImplicitParam(name="audit", value="审核状态(0:审核中 1:审核失败 2:审核成功)", required = false, dataType="Integer", paramType="query"),
            @ApiImplicitParam(name="companyType", value="企业属性(0招聘企业 1猎头企业)", required = false, dataType="Integer", paramType="query")
    })
    public R<CompanyInfoDto> getpost(int page,int pageSize,String companyName,Integer audit,Integer companyType){
        Page<TCompanyPost> PostPage = tCompanyPostService.Pages(page, pageSize, companyName, audit, companyType);
        Page<CompanyInfoDto> companyInfoDtoPage=new Page<>();
        BeanUtils.copyProperties(PostPage,companyInfoDtoPage,"records");
        List<TCompanyPost> records=PostPage.getRecords();
        List<CompanyInfoDto> list=records.stream().map((item)->{
            CompanyInfoDto companyInfoDto=new CompanyInfoDto();
            BeanUtils.copyProperties(item,companyInfoDto);
            TCompany byId = tCompanyService.listOne(item.getCompanyId());
            if (byId!=null){
                companyInfoDto.setAvatar(byId.getAvatar());
                companyInfoDto.setContactName(byId.getContactName());
                companyInfoDto.setJobTitle(byId.getJobTitle());
                companyInfoDto.setContactPhone(byId.getContactPhone());
            }
            return companyInfoDto;
        }).collect(Collectors.toList());
        companyInfoDtoPage.setRecords(list);
        return R.ok(companyInfoDtoPage);
    }

    /**
     * 修改岗位信息
     * @param tCompanyPost
     * @return
     */
    @PutMapping
    @ApiOperation(value="修改岗位信息",notes = "updateId,postId,必传")
    public R<TCompanyPost> putPost(@RequestBody TCompanyPost tCompanyPost){
        if (tCompanyPost.getUpdateId()==null){
            return R.fail("更新人不能为空！");
        }
        tCompanyPostService.updateById(tCompanyPost);
        return R.ok();
    }

    @GetMapping("/selectId")
    @ApiImplicitParam(name = "postId", value = "岗位id", required = true)
    @ApiOperation("通过id查询岗位")
    public R<TCompanyPost> selectId(@RequestParam("postId") String postId){
        TCompanyPost byId = tCompanyPostService.getById(postId);
        return R.ok(byId);
    }
}
