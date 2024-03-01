package com.ruoyi.post.service;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.post.entity.RecommendBasics;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【recommend_basics(推荐官基本信息)】的数据库操作Service
* @createDate 2023-09-28 11:41:33
*/

@DataSource(value ="slave")
public interface RecommendBasicsService extends IService<RecommendBasics> {


   /**
    * @Description: 猎企认证
    * @param recommend:推荐官id
    * @return null
    * @Author tangzhuo
    * @CreateTime 2023/9/28 11:43
    */


    public void updateAuthentication(String recommend);
}
