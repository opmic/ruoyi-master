package com.ruoyi.company.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.company.dto.TCompanyContractDto;
import com.ruoyi.company.entity.TCompanyContract;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【t_company_contract(企业合同)】的数据库操作Mapper
* @createDate 2023-07-03 14:22:39
* @Entity com.ruoyi.company.entity.TCompanyContract
*/
public interface TCompanyContractMapper extends BaseMapper<TCompanyContract> {

    /**
     * 查询合同
     * @param page
     * @param audit
     * @param type
     * @param keyword
     * @return
     */
    IPage<TCompanyContractDto> select(@Param("page") Page page, @Param("audit") Integer audit, @Param("type") Integer type, @Param("keyword") String keyword);
}




