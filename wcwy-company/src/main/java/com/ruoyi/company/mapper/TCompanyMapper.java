package com.ruoyi.company.mapper;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.company.entity.TCompany;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【t_company(企业表)】的数据库操作Mapper
* @createDate 2023-06-26 11:28:52
* @Entity com.ruoyi.company.entity.TCompany
*/
@Mapper
@DataSource(value = "slave1")
public interface TCompanyMapper extends BaseMapper<TCompany> {

}




