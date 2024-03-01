package com.ruoyi.company.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.TCompanyContractAudit;
import com.ruoyi.company.service.TCompanyContractAuditService;
import com.ruoyi.company.mapper.TCompanyContractAuditMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_company_contract_audit(合同审核记录)】的数据库操作Service实现
* @createDate 2023-09-13 16:20:11
*/
@Service
@DataSource(value = "slave1")
public class TCompanyContractAuditServiceImpl extends ServiceImpl<TCompanyContractAuditMapper, TCompanyContractAudit>
    implements TCompanyContractAuditService{

}




