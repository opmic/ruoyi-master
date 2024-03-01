package com.ruoyi.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.TJobhunterResume;
import com.ruoyi.company.entity.TJobhunterWorkRecord;
import com.ruoyi.company.service.TJobhunterWorkRecordService;
import com.ruoyi.company.mapper.TJobhunterWorkRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_jobhunter_work_record(工作经历表)】的数据库操作Service实现
* @createDate 2023-07-20 16:31:09
*/
@Service
@DataSource(value ="slave1")
public class TJobhunterWorkRecordServiceImpl extends ServiceImpl<TJobhunterWorkRecordMapper, TJobhunterWorkRecord>
    implements TJobhunterWorkRecordService{

    @Autowired
    private TJobhunterWorkRecordMapper tJobhunterWorkRecordMapper;

    @Override
    public List<TJobhunterWorkRecord> selectId(String workId) {
        LambdaQueryWrapper<TJobhunterWorkRecord> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(TJobhunterWorkRecord::getResumeId,workId);
        System.out.println(this.list(wrapper));
        return this.list(wrapper);
    }

    @Override
    public List<TJobhunterWorkRecord> listIds(List<String> records) {
        return tJobhunterWorkRecordMapper.listIds(records);
    }
}




