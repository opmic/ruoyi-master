package com.ruoyi.company.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.company.entity.TCompany;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_company(企业表)】的数据库操作Service
* @createDate 2023-06-26 11:28:52
*/
@DataSource(value ="slave1")
public interface TCompanyService extends IService<TCompany> {
    //根据id查询
    public TCompany listOne(String id);
    //企业分页查询
    public  Page<TCompany> pageInfo(int page, int pageSize, String companyName,Integer examineStatus,String companyType);
}
