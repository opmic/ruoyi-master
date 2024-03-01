package com.ruoyi.company.service;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.TJobhunterEducationRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_jobhunter_education_record(教育经历表)】的数据库操作Service
* @createDate 2023-07-04 10:20:54
*/
@DataSource(value ="slave1")
public interface TJobhunterEducationRecordService extends IService<TJobhunterEducationRecord> {
    //通过id查询教育
    public List<TJobhunterEducationRecord> getByEducat(String resumeId);

}
