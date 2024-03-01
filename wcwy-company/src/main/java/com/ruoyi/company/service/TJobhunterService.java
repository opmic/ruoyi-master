package com.ruoyi.company.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.dto.JobHunterDTO;
import com.ruoyi.company.dto.TJobhunterDto;
import com.ruoyi.company.entity.TJobhunter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.company.entity.TJobhunterResume;
import com.ruoyi.company.query.TJobHunterQuery;

/**
* @author Administrator
* @description 针对表【t_jobhunter(求职者用户表)】的数据库操作Service
* @createDate 2023-07-04 10:20:54
*/
@DataSource(value ="slave1")
public interface TJobhunterService extends IService<TJobhunter> {
    //查询简历
    public Page<TJobhunterDto> pageInfo(
            int page, int pageSize,String loginName,Integer sex,
            String jobStatus,String examineStatus,String status);

    //查询求职者信息
    IPage<JobHunterDTO> select(TJobHunterQuery tJobHunterQuery);
}
