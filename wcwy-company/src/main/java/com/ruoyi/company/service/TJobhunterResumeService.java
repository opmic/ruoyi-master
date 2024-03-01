package com.ruoyi.company.service;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.TJobhunterResume;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_jobhunter_resume(求职者简历)】的数据库操作Service
* @createDate 2023-07-04 10:20:54
*/
@DataSource(value ="slave1")
public interface TJobhunterResumeService extends IService<TJobhunterResume> {
    //简历
    List<TJobhunterResume> selectId(String resumeId);
}
