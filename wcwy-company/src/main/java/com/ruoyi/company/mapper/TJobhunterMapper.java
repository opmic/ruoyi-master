package com.ruoyi.company.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.dto.JobHunterDTO;
import com.ruoyi.company.dto.TJobhunterDto;
import com.ruoyi.company.entity.TJobhunter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.company.query.TJobHunterQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @author Administrator
* @description 针对表【t_jobhunter(求职者用户表)】的数据库操作Mapper
* @createDate 2023-07-04 10:20:54
* @Entity com.ruoyi.company.entity.TJobhunter
*/
@Mapper
@DataSource(value = "slave1")
public interface TJobhunterMapper extends BaseMapper<TJobhunter> {


    IPage<JobHunterDTO> select(@Param("page") IPage page,@Param("tJobHunterQuery") TJobHunterQuery tJobHunterQuery);
}




