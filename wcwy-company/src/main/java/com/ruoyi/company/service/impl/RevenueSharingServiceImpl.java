package com.ruoyi.company.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.RevenueSharing;
import com.ruoyi.company.service.RevenueSharingService;
import com.ruoyi.company.mapper.RevenueSharingMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description 针对表【revenue_sharing(分享收益提现表)】的数据库操作Service实现
 * @createDate 2023-07-17 15:52:00
 */
@Service
@DataSource(value ="slave1")
public class RevenueSharingServiceImpl extends ServiceImpl<RevenueSharingMapper, RevenueSharing>
        implements RevenueSharingService {

    @Autowired
    private RevenueSharingMapper revenueSharingMapper;

    @Override
    @DataSource(value = "slave1")
    public RevenueSharing getId(String referrerId) {
        System.out.println(1);
        return revenueSharingMapper.selectById(referrerId);
    }
}




