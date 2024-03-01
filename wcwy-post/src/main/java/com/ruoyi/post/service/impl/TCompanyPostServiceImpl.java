package com.ruoyi.post.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.post.dto.CompanyInfoDto;
import com.ruoyi.post.entity.TCompanyPost;
import com.ruoyi.post.service.TCompanyPostService;
import com.ruoyi.post.mapper.TCompanyPostMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author Administrator
* @description 针对表【t_company_post(企业招聘岗位表)】的数据库操作Service实现
* @createDate 2023-06-27 10:35:57
*/
@Service
@DataSource(value = "slave")
public class TCompanyPostServiceImpl extends ServiceImpl<TCompanyPostMapper, TCompanyPost> implements TCompanyPostService{
    @Override
 //   @DataSource(value = "slave")
    public Page<TCompanyPost> Pages(int page, int pageSize, String companyName, Integer audit, Integer companyType) {
        Page<TCompanyPost> PostPage=new Page(page,pageSize);
        LambdaQueryWrapper<TCompanyPost> wrapper=new LambdaQueryWrapper<>();
        if(!StringUtils.isEmpty(companyName)){
            wrapper.like(TCompanyPost::getCompanyName,companyName)
                    .or(i->i.like(TCompanyPost::getPostLabel,companyName));
        }
        wrapper.like(companyType!=null,TCompanyPost::getCompanyType,companyType);
        wrapper.like(audit!=null, TCompanyPost::getAudit,audit);
        wrapper.orderByDesc(TCompanyPost::getCreateTime);
        Page<TCompanyPost> pagePost = this.page(PostPage, wrapper);
        return pagePost;
    }
}




