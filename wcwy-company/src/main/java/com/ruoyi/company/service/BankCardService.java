package com.ruoyi.company.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruoyi.company.dto.BankCardDTO;
import com.ruoyi.company.entity.BankCard;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.company.query.BankCardQuery;

/**
* @author Administrator
* @description 针对表【bank_card(银行卡)】的数据库操作Service
* @createDate 2023-08-18 09:18:31
*/
public interface BankCardService extends IService<BankCard> {

    /**
     * 查询申请人信息
     * @param bankCardQuery
     * @return
     */
    IPage<BankCardDTO> selectPage(BankCardQuery bankCardQuery);
}
