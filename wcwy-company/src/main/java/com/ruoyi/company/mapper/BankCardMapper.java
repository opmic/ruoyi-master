package com.ruoyi.company.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.dto.BankCardDTO;
import com.ruoyi.company.entity.BankCard;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.company.query.BankCardQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【bank_card(银行卡)】的数据库操作Mapper
* @createDate 2023-08-18 09:18:31
* @Entity com.ruoyi.company.entity.BankCard
*/
@Mapper
@DataSource(value = "slave1")
public interface BankCardMapper extends BaseMapper<BankCard> {
    @DataSource(value = "slave1")
    IPage<BankCardDTO> selectPage1(@Param("page") IPage page,@Param("bankCardQuery") BankCardQuery bankCardQuery);
}




