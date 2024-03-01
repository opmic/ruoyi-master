package com.ruoyi.company.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.config.IDGenerator;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.company.entity.RevenueSharing;
import com.ruoyi.company.entity.SourceOfReturns;
import com.ruoyi.company.service.RevenueSharingService;
import com.ruoyi.company.service.SourceOfReturnsService;
import com.ruoyi.company.mapper.SourceOfReturnsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Administrator
 * @description 针对表【source_of_returns(分享收益来源详情)】的数据库操作Service实现
 * @createDate 2023-07-17 15:52:06
 */
@Service
@DataSource(value ="slave1")
public class SourceOfReturnsServiceImpl extends ServiceImpl<SourceOfReturnsMapper, SourceOfReturns>
        implements SourceOfReturnsService {

    @Autowired
    private RevenueSharingService revenueSharingService;

    @Autowired
    private IDGenerator idGenerator;

    @Override
    public void addJobHunter(String referrerId, BigDecimal referrerMoney, String jobHunterId,BigDecimal platformMoney,String orderId,Integer identification,String payer,LocalDateTime payerTime) throws Exception {
        RevenueSharing byId = revenueSharingService.getById(referrerId);
        if (byId == null) {
            RevenueSharing revenueSharing = new RevenueSharing();
            revenueSharing.setUserId(referrerId);
            revenueSharing.setTotalRevenue(new BigDecimal(0.00));
            revenueSharing.setForbid(0);
            revenueSharing.setRemainingSum(new BigDecimal(0.00));
            revenueSharing.setWithdrawDeposit(new BigDecimal(0));
          /*  revenueSharing.setType(identification!=1 ?1:0);*/
            boolean save = revenueSharingService.save(revenueSharing);
            if(save){
                byId = revenueSharing;
            }
        }
        byId.setTotalRevenue(byId.getTotalRevenue().add(referrerMoney));
        boolean b = revenueSharingService.updateById(byId);
        if(b){
            if(referrerMoney.compareTo(new BigDecimal(0))!=0 && referrerMoney.compareTo(new BigDecimal(0))!=-1){
                SourceOfReturns source=new SourceOfReturns();
                source.setSourceOfReturnsId(idGenerator.generateCode("SOR"));
                source.setAggregateAmount(platformMoney);
                source.setIdentity(2);
                source.setOrderId(orderId);
                source.setSourceUser(jobHunterId);
                source.setEarnings(referrerMoney);
                source.setPayer(payer);
                source.setOrderTime(payerTime);
                source.setEarningUser(referrerId);
                source.setType(identification!=1 ?1:0);
                source.setCreateId(SecurityUtils.getUserId().toString());
                source.setCreateTime(LocalDateTime.now());
                source.setDeposit(byId.getTotalRevenue());
                boolean save = this.save(source);
                if(!save){
                    throw  new Exception("更新收益失败");
                }
            }

        }else {
            throw  new Exception("更新收益失败");
        }

    }

    @Override
    public void addRecommend(String shareUserId, BigDecimal shareMoney, String referrerId, BigDecimal platformMoney, String orderId,String payer,LocalDateTime payerTime) throws Exception {
        RevenueSharing byId = revenueSharingService.getById(referrerId);
        if (byId == null) {
            RevenueSharing revenueSharing = new RevenueSharing();
            revenueSharing.setUserId(shareUserId);
            revenueSharing.setTotalRevenue(new BigDecimal(0.00));
            revenueSharing.setForbid(0);
            revenueSharing.setRemainingSum(new BigDecimal(0.00));
            revenueSharing.setWithdrawDeposit(new BigDecimal(0));
            boolean save = revenueSharingService.save(revenueSharing);
            if(save){
                byId = revenueSharing;
            }
        }
        byId.setTotalRevenue(byId.getTotalRevenue().subtract(shareMoney));
        boolean b = revenueSharingService.updateById(byId);
        if(b){
            if(shareMoney.compareTo(new BigDecimal(0))!=0 && shareMoney.compareTo(new BigDecimal(0))!=-1){
                SourceOfReturns source=new SourceOfReturns();
                source.setSourceOfReturnsId(idGenerator.generateCode("SOR"));
                source.setAggregateAmount(platformMoney);
                source.setIdentity(2);
                source.setOrderId(orderId);
                source.setSourceUser(referrerId);
                source.setEarnings(shareMoney);
                source.setPayer(payer);
                source.setOrderTime(payerTime);
                source.setType(0);
                source.setEarningUser(referrerId);
                source.setCreateId(SecurityUtils.getUserId().toString());
                source.setCreateTime(LocalDateTime.now());
                source.setDeposit(byId.getTotalRevenue().subtract(shareMoney));
                boolean save = this.save(source);
                if(!save){
                    throw  new Exception("更新收益失败");
                }
            }

        }else {
            throw  new Exception("更新收益失败");
        }

    }

    @Override
    public void addShareRecommend(String shareUserId, BigDecimal shareMoney, String referrerId, BigDecimal platformMoney, String orderId,String payer,LocalDateTime payerTime) throws Exception {
        RevenueSharing byId = revenueSharingService.getById(shareUserId);
        if (byId == null) {
            RevenueSharing revenueSharing = new RevenueSharing();
            revenueSharing.setUserId(shareUserId);
            revenueSharing.setTotalRevenue(new BigDecimal(0.00));
            revenueSharing.setForbid(0);
            revenueSharing.setRemainingSum(new BigDecimal(0.00));
            revenueSharing.setWithdrawDeposit(new BigDecimal(0));
            boolean save = revenueSharingService.save(revenueSharing);
            if(save){
                byId = revenueSharing;
            }
        }
        byId.setTotalRevenue(byId.getTotalRevenue().add(shareMoney));
        boolean b = revenueSharingService.updateById(byId);
        if(b){
            if(shareMoney.compareTo(new BigDecimal(0))!=0 && shareMoney.compareTo(new BigDecimal(0))!=-1){
                SourceOfReturns source=new SourceOfReturns();
                source.setSourceOfReturnsId(idGenerator.generateCode("SOR"));
                source.setAggregateAmount(platformMoney);
                source.setIdentity(1);
                source.setOrderId(orderId);
                source.setType(0);
                source.setPayer(payer);
                source.setSourceUser(referrerId);
                source.setEarnings(shareMoney);
                source.setOrderTime(payerTime);
                source.setEarningUser(shareUserId);
                source.setCreateId(SecurityUtils.getUserId().toString());
                source.setCreateTime(LocalDateTime.now());
                source.setDeposit(byId.getTotalRevenue());
                boolean save = this.save(source);
                if(!save){
                    throw  new Exception("更新收益失败");
                }
            }

        }else {
            throw  new Exception("更新收益失败");
        }
    }

    @Override
    public void addShareCompany(String inviterCompany, BigDecimal inviterCompanyMoney, String payer, BigDecimal platformMoney, String orderId,LocalDateTime payerTime) throws Exception {
        RevenueSharing byId = revenueSharingService.getById(inviterCompany);
        if (byId == null) {
            RevenueSharing revenueSharing = new RevenueSharing();
            revenueSharing.setUserId(inviterCompany);
            revenueSharing.setTotalRevenue(new BigDecimal(0.00));
            revenueSharing.setForbid(0);
            revenueSharing.setRemainingSum(new BigDecimal(0.00));
            revenueSharing.setWithdrawDeposit(new BigDecimal(0));
            boolean save = revenueSharingService.save(revenueSharing);
            if(save){
                byId = revenueSharing;
            }
        }
        byId.setTotalRevenue(byId.getTotalRevenue().add(inviterCompanyMoney));
        boolean b = revenueSharingService.updateById(byId);
        if(b){
            if(inviterCompanyMoney.compareTo(new BigDecimal(0))!=0 && inviterCompanyMoney.compareTo(new BigDecimal(0))!=-1){
                SourceOfReturns source=new SourceOfReturns();
                source.setSourceOfReturnsId(idGenerator.generateCode("SOR"));
                source.setAggregateAmount(platformMoney);
                source.setIdentity(0);
                source.setOrderId(orderId);
                source.setType(0);
                source.setSourceUser(payer);
                source.setPayer(payer);
                source.setOrderTime(payerTime);
                source.setEarnings(inviterCompanyMoney);
                source.setEarningUser(inviterCompany);
                source.setCreateId(SecurityUtils.getUserId().toString());
                source.setCreateTime(LocalDateTime.now());
                source.setDeposit(byId.getTotalRevenue());
                boolean save = this.save(source);
                if(!save){
                    throw  new Exception("更新收益失败");
                }
            }

        }else {
            throw  new Exception("更新收益失败");
        }
    }
}




