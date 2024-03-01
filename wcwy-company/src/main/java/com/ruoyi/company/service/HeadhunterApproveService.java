package com.ruoyi.company.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.HeadhunterApprove;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.company.entity.TRecommend;

/**
* @author Administrator
* @description 针对表【headhunter_approve(推荐官猎企业认证)】的数据库操作Service
* @createDate 2023-07-24 08:23:58
*/
@DataSource(value ="slave1")
public interface HeadhunterApproveService extends IService<HeadhunterApprove> {
    /***
     * 推荐官猎企认证查询
     * @param page
     * @param pageSize
     * @return
     */
    public  Page<HeadhunterApprove> HeadhunterApprovePage(int page, int pageSize);

    /**
     *  推荐官猎企认证修改状态
     * @param recommendId
     * @param audit
     * @return
     */
    public boolean upadetHeadhunterApprove(String recommendId, Integer audit);
}
