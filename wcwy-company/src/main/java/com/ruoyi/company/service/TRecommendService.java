package com.ruoyi.company.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.TRecommend;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Set;

/**
* @author Administrator
* @description 针对表【t_recommend(推荐官)】的数据库操作Service
* @createDate 2023-07-24 08:30:57
*/
@DataSource(value ="slave1")
public interface TRecommendService extends IService<TRecommend> {
    /***
     * 推荐注册分页查询
     * @param page
     * @param pageSize
     * @return
     */
    public Page<TRecommend> RecommPage(int page, int pageSize);

    /**
     *  修改账号状态
     * @param id
     * @param examineStatus
     * @param status
     */
    public boolean upadetRecommend(String id, String examineStatus, Integer status);

    /**
     * 修改推荐官的认证
     * @param updateWrapper
     */
    void upadetHeadhunterApprove(UpdateWrapper updateWrapper);

    List<TRecommend> selectList(Set<String> strings);
}
