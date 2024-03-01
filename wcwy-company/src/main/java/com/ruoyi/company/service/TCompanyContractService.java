package com.ruoyi.company.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.dto.TCompanyContractDto;
import com.ruoyi.company.entity.TCompanyContract;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【t_company_contract(企业合同)】的数据库操作Service
* @createDate 2023-07-03 14:22:39
*/
@DataSource(value ="slave1")
public interface TCompanyContractService extends IService<TCompanyContract> {
    /**
     * 审核岗位分页
     * @param page
     * @param pageSize
     * @param audit
     * @return
     */
    public Page<TCompanyContract> pageInfo(int page, int pageSize, Integer audit);

    /**
     * 查询合同审核
     * @param page
     * @param audit
     * @param type
     * @param keyword
     * @return
     */
    IPage<TCompanyContractDto> select(Page page, Integer audit, Integer type, String keyword);
}
