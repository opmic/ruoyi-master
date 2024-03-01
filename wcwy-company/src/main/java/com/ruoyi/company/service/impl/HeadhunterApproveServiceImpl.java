package com.ruoyi.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.HeadhunterApprove;
import com.ruoyi.company.entity.TRecommend;
import com.ruoyi.company.service.HeadhunterApproveService;
import com.ruoyi.company.mapper.HeadhunterApproveMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【headhunter_approve(推荐官猎企业认证)】的数据库操作Service实现
* @createDate 2023-07-24 08:23:58
*/
@Service
@DataSource(value ="slave1")
public class HeadhunterApproveServiceImpl extends ServiceImpl<HeadhunterApproveMapper, HeadhunterApprove>
    implements HeadhunterApproveService{

    /***
     * 推荐官猎企认证查询
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public Page<HeadhunterApprove> HeadhunterApprovePage(int page, int pageSize) {
        Page hunterApprove=new Page(page,pageSize);
        LambdaQueryWrapper<HeadhunterApprove> wrapper=new LambdaQueryWrapper<>();
        Page<HeadhunterApprove> pages=this.page(hunterApprove);
        return pages;
    }

    /***
     * 推荐官猎企认证修改状态
     * @param recommendId
     * @param audit
     * @return
     */
    @Override
    public boolean upadetHeadhunterApprove(String recommendId, Integer audit) {
        LambdaUpdateWrapper<HeadhunterApprove> wrapper=new LambdaUpdateWrapper<>();
        wrapper.eq(HeadhunterApprove::getRecommendId,recommendId);
        if (null!=audit){
            wrapper.set(HeadhunterApprove::getAudit,audit);
        }
        return this.update(wrapper);
    }
}




