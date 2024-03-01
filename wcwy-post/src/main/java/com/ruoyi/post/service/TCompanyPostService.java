package com.ruoyi.post.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.post.dto.CompanyInfoDto;
import com.ruoyi.post.entity.TCompanyPost;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【t_company_post(企业招聘岗位表)】的数据库操作Service
* @createDate 2023-06-27 10:35:57
*/
public interface TCompanyPostService extends IService<TCompanyPost> {
    //岗位查询
    public Page<TCompanyPost> Pages(int page, int pageSize, String companyName, Integer audit, Integer companyType);

}
