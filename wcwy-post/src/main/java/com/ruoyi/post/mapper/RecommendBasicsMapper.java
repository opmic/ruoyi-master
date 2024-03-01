package com.ruoyi.post.mapper;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.post.entity.RecommendBasics;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【recommend_basics(推荐官基本信息)】的数据库操作Mapper
* @createDate 2023-09-28 11:41:33
* @Entity com.ruoyi.post.entity.RecommendBasics
*/
@Mapper
@DataSource(value ="slave")
public interface RecommendBasicsMapper extends BaseMapper<RecommendBasics> {

}




