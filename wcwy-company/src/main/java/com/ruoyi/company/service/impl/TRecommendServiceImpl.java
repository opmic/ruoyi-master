package com.ruoyi.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.TRecommend;
import com.ruoyi.company.service.TRecommendService;
import com.ruoyi.company.mapper.TRecommendMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.util.List;
import java.util.Set;

/**
* @author Administrator
* @description 针对表【t_recommend(推荐官)】的数据库操作Service实现
* @createDate 2023-07-24 08:30:57
*/

@Service
@DataSource(value ="slave1")
public class TRecommendServiceImpl extends ServiceImpl<TRecommendMapper, TRecommend>
    implements TRecommendService{

    /***
     * 推荐注册分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public Page<TRecommend> RecommPage(int page, int pageSize) {
        Page recommend=new Page(page,pageSize);
        LambdaQueryWrapper<TRecommend> wrapper=new LambdaQueryWrapper<>();
        Page<TRecommend> pages=this.page(recommend);
        return pages;
    }

    /**
     * 修改账号状态
     * @param id
     * @param examineStatus
     * @param status
     * @return
     */
    @Override
    public boolean upadetRecommend(String id, String examineStatus, Integer status) {
        LambdaUpdateWrapper<TRecommend> wrapper=new LambdaUpdateWrapper<>();
        wrapper.eq(TRecommend::getId,id);
        wrapper.set(StringUtils.isNotEmpty(examineStatus),TRecommend::getExamineStatus,examineStatus);
        if (null!=status){
            wrapper.set(TRecommend::getStatus,status);
        }
        return this.update(wrapper);

    }

    @Override
    public void upadetHeadhunterApprove(UpdateWrapper updateWrapper) {
        this.update(updateWrapper);
    }

    @Override
    public List<TRecommend> selectList(Set<String> strings) {
        return this.listByIds(strings);
    }
}




