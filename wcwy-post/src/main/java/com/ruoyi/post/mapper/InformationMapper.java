package com.ruoyi.post.mapper;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.post.entity.Information;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【information(资讯)】的数据库操作Mapper
* @createDate 2023-04-26 11:57:03
* @Entity com.ruoyi.post.entity.Information
*/
@Mapper
@DataSource(value ="slave")
public interface InformationMapper extends BaseMapper<Information> {

}




