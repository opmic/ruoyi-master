package com.ruoyi.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.TJobhunterProjectRecord;
import com.ruoyi.company.entity.TJobhunterResume;
import com.ruoyi.company.service.TJobhunterResumeService;
import com.ruoyi.company.mapper.TJobhunterResumeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_jobhunter_resume(求职者简历)】的数据库操作Service实现
* @createDate 2023-07-04 10:20:54
*/
@Service
@DataSource(value ="slave1")
public class TJobhunterResumeServiceImpl extends ServiceImpl<TJobhunterResumeMapper, TJobhunterResume>
    implements TJobhunterResumeService{
    //简历
    @Override
    public List<TJobhunterResume> selectId(String resumeId) {
        LambdaQueryWrapper<TJobhunterResume> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(TJobhunterResume::getTJobhunterId,resumeId);
        return this.list(wrapper);
    }
}




