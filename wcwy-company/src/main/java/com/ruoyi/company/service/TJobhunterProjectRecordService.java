package com.ruoyi.company.service;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.TJobhunterProjectRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_jobhunter_project_record(项目经历表)】的数据库操作Service
* @createDate 2023-07-04 10:20:54
*/
@DataSource(value ="slave1")
public interface TJobhunterProjectRecordService extends IService<TJobhunterProjectRecord> {
    //项目经验
    public List<TJobhunterProjectRecord> getByProject(String resumeId);
}
