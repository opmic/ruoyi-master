package com.ruoyi.post.mapper;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.post.entity.TCompanyPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【t_company_post(企业招聘岗位表)】的数据库操作Mapper
* @createDate 2023-06-27 10:35:57
* @Entity com.ruoyi.post.entity.TCompanyPost
*/
@DataSource(value ="slave")
public interface TCompanyPostMapper extends BaseMapper<TCompanyPost> {

}




