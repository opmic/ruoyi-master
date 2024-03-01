package com.ruoyi.company.mapper;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.TCompanyContractAudit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【t_company_contract_audit(合同审核记录)】的数据库操作Mapper
* @createDate 2023-09-13 16:20:11
* @Entity com.ruoyi.company.entity.TCompanyContractAudit
*/
@Mapper
@DataSource(value = "slave1")
public interface TCompanyContractAuditMapper extends BaseMapper<TCompanyContractAudit> {

}




