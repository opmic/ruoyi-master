package com.ruoyi.company.service;

import com.ruoyi.company.entity.SourceOfReturns;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
* @author Administrator
* @description 针对表【source_of_returns(分享收益来源详情)】的数据库操作Service
* @createDate 2023-07-17 15:52:06
*/
public interface SourceOfReturnsService extends IService<SourceOfReturns> {



    /**
     * @Description: 邀请求职者下载分成及接单岗位的分成
     * @param referrerId:收益人 referrerMoney:分成金额 jobHunterId:来源的用户 platformMoney:支付金额orderId:订单号
     * @Author tangzhuo
     * @CreateTime 2023/7/17 16:13
     */

    void addJobHunter(String referrerId, BigDecimal referrerMoney, String jobHunterId, BigDecimal platformMoney, String orderId, Integer identification, String payer, LocalDateTime payerTime) throws Exception;
    /**
     * @Description: 邀请推荐官分成
     * @param shareUserId:收益人 shareMoney:分成金额 referrerId:来源的用户 platformMoney:支付金额 orderId:订单号
     * @Author tangzhuo
     * @CreateTime 2023/7/17 16:13
     */
    void addRecommend(String shareUserId, BigDecimal shareMoney, String referrerId, BigDecimal platformMoney, String orderId,String payer,LocalDateTime payerTime)throws Exception;
    /**
     * @Description: 邀请推荐官分成
     * @param shareUserId:收益人 shareMoney:分成金额 referrerId:来源的用户 platformMoney:支付金额 orderId:订单号
     * @Author tangzhuo
     * @CreateTime 2023/7/17 16:13
     */
    void addShareRecommend(String shareUserId, BigDecimal shareMoney, String referrerId, BigDecimal platformMoney, String orderId,String payer,LocalDateTime payerTime) throws Exception;

    void addShareCompany(String inviterCompany, BigDecimal inviterCompanyMoney, String payer, BigDecimal platformMoney, String orderId,LocalDateTime payerTime) throws Exception;
}
