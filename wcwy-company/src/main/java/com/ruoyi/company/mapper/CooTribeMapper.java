package com.ruoyi.company.mapper;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.CooTribe;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【coo_tribe】的数据库操作Mapper
* @createDate 2024-01-30 08:10:14
* @Entity com.ruoyi.company.entity.CooTribe
*/
@Mapper
@DataSource(value = "slave1")
public interface CooTribeMapper extends BaseMapper<CooTribe> {

}




