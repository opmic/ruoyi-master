package com.ruoyi.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.TJobHunterAttachment;
import com.ruoyi.company.entity.TJobhunterEducationRecord;
import com.ruoyi.company.service.TJobhunterEducationRecordService;
import com.ruoyi.company.mapper.TJobhunterEducationRecordMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_jobhunter_education_record(教育经历表)】的数据库操作Service实现
* @createDate 2023-07-04 10:20:54
*/
@Service
@DataSource(value ="slave1")
public class TJobhunterEducationRecordServiceImpl extends ServiceImpl<TJobhunterEducationRecordMapper, TJobhunterEducationRecord> implements TJobhunterEducationRecordService{
    //通过id查询教育
    @Override
    public List<TJobhunterEducationRecord> getByEducat(String resumeId) {
        LambdaQueryWrapper<TJobhunterEducationRecord> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(TJobhunterEducationRecord::getResumeId,resumeId);
        return this.list(wrapper);
    }
}




