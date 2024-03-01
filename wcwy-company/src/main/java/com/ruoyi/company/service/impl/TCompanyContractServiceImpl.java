package com.ruoyi.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.annotation.TransactionMulti;
import com.ruoyi.company.dto.TCompanyContractDto;
import com.ruoyi.company.entity.TCompany;
import com.ruoyi.company.entity.TCompanyContract;
import com.ruoyi.company.service.TCompanyContractService;
import com.ruoyi.company.mapper.TCompanyContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_company_contract(企业合同)】的数据库操作Service实现
* @createDate 2023-07-03 14:22:39
*/
@Service
@DataSource(value ="slave1")
public class TCompanyContractServiceImpl extends ServiceImpl<TCompanyContractMapper, TCompanyContract> implements TCompanyContractService{
    @Autowired
    private TCompanyServiceImpl tCompanyService;
    @Autowired
    private TCompanyContractMapper tCompanyContractMapper;
    /**
     * 审核岗位分页
     * @param page
     * @param pageSize
     * @param audit
     * @return
     */
    @Override
    @DataSource(value ="slave1")
    public Page<TCompanyContract> pageInfo(int page, int pageSize, Integer audit) {
        Page companyPage=new Page(page,pageSize);
        LambdaQueryWrapper<TCompanyContract> queryWrapper=new LambdaQueryWrapper<>();
        if (audit!=null){
            queryWrapper.eq(TCompanyContract::getAuditContract,audit);
        }
        queryWrapper.orderByDesc(TCompanyContract::getCreateTime);
        Page<TCompanyContract> pages=this.page(companyPage, queryWrapper);
        return pages;
    }

    @Override
    @DataSource(value ="slave1")
    public IPage<TCompanyContractDto> select(Page page, Integer audit, Integer type, String keyword) {
        return tCompanyContractMapper.select(page,audit,type,keyword);
    }
}




