package com.ruoyi.company.service;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.TCompanyContractAudit;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【t_company_contract_audit(合同审核记录)】的数据库操作Service
* @createDate 2023-09-13 16:20:11
*/
@DataSource(value = "slave1")
public interface TCompanyContractAuditService extends IService<TCompanyContractAudit> {

}
