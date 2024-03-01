package com.ruoyi.company.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.dto.BankCardDTO;
import com.ruoyi.company.entity.BankCard;
import com.ruoyi.company.query.BankCardQuery;
import com.ruoyi.company.service.BankCardService;
import com.ruoyi.company.mapper.BankCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description 针对表【bank_card(银行卡)】的数据库操作Service实现
 * @createDate 2023-08-18 09:18:31
 */
@Service
@DataSource(value = "slave1")
public class BankCardServiceImpl extends ServiceImpl<BankCardMapper, BankCard>
        implements BankCardService {

    @Autowired
    private BankCardMapper bankCardMapper;

    @Override
    public IPage<BankCardDTO> selectPage(BankCardQuery bankCardQuery) {
        return bankCardMapper.selectPage1(bankCardQuery.createPage(),bankCardQuery);
    }
}




