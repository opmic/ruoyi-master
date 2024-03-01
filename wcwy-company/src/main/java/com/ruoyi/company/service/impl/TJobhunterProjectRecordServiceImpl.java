package com.ruoyi.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.TJobhunterEducationRecord;
import com.ruoyi.company.entity.TJobhunterProjectRecord;
import com.ruoyi.company.service.TJobhunterProjectRecordService;
import com.ruoyi.company.mapper.TJobhunterProjectRecordMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_jobhunter_project_record(项目经历表)】的数据库操作Service实现
* @createDate 2023-07-04 10:20:54
*/
@Service
@DataSource(value ="slave1")
public class TJobhunterProjectRecordServiceImpl extends ServiceImpl<TJobhunterProjectRecordMapper, TJobhunterProjectRecord>
    implements TJobhunterProjectRecordService{

    //项目经验
    @Override
    public List<TJobhunterProjectRecord> getByProject(String resumeId) {
        LambdaQueryWrapper<TJobhunterProjectRecord> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(TJobhunterProjectRecord::getResumeId,resumeId);
        return this.list(wrapper);
    }
}




