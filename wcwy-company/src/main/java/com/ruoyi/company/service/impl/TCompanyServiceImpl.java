package com.ruoyi.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.TCompany;
import com.ruoyi.company.service.TCompanyService;
import com.ruoyi.company.mapper.TCompanyMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_company(企业表)】的数据库操作Service实现
* @createDate 2023-06-26 11:28:52
*/
@Service
@DataSource(value ="slave1")
public class TCompanyServiceImpl extends ServiceImpl<TCompanyMapper, TCompany> implements TCompanyService{
    //根据id查询企业信息
    @Override
    //@DataSource(value ="slave1")
    public TCompany listOne(String id) {
       return this.getById(id);
    }
    //企业分页查询
    @Override
    public  Page<TCompany> pageInfo(int page, int pageSize, String companyName, Integer examineStatus, String companyType) {
        Page companyPage=new Page(page,pageSize);
        LambdaQueryWrapper<TCompany> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(companyName),TCompany::getCompanyName,companyName);
        queryWrapper.like(StringUtils.isNotEmpty(companyType),TCompany::getCompanyType,companyType);
        if (examineStatus!=null){
            queryWrapper.eq(TCompany::getExamineStatus,examineStatus);
        }
        queryWrapper.orderByDesc(TCompany::getCreateTime);
        Page<TCompany> pages=this.page(companyPage, queryWrapper);
        return pages;
    }
}




