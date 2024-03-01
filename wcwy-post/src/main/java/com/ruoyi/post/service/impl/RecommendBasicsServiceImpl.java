package com.ruoyi.post.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.post.entity.RecommendBasics;
import com.ruoyi.post.service.RecommendBasicsService;
import com.ruoyi.post.mapper.RecommendBasicsMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【recommend_basics(推荐官基本信息)】的数据库操作Service实现
* @createDate 2023-09-28 11:41:33
*/
@Service
@DataSource("slave")
public class RecommendBasicsServiceImpl extends ServiceImpl<RecommendBasicsMapper, RecommendBasics>
    implements RecommendBasicsService{

    @Override
    public void updateAuthentication(String recommend) {
        UpdateWrapper updateWrapper=new UpdateWrapper();
        updateWrapper.eq("recommend_id",recommend);
        updateWrapper.set("administrator",2);
        this.update(updateWrapper);
    }
}




