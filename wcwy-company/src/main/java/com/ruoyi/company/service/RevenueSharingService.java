package com.ruoyi.company.service;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.RevenueSharing;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【revenue_sharing(分享收益提现表)】的数据库操作Service
* @createDate 2023-07-17 15:52:00
*/
@DataSource(value ="slave1")
public interface RevenueSharingService extends IService<RevenueSharing> {

    RevenueSharing getId(String referrerId);
}
