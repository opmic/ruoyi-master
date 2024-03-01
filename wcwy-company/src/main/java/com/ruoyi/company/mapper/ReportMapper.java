package com.ruoyi.company.mapper;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.Report;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【report(举报)】的数据库操作Mapper
* @createDate 2023-09-21 09:29:12
* @Entity com.ruoyi.company.entity.Report
*/
@Mapper
@DataSource(value = "slave1")
public interface ReportMapper extends BaseMapper<Report> {

}




