package com.ruoyi.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.TJobhunterEducationRecord;
import com.ruoyi.company.entity.TJobhunterExpectPosition;
import com.ruoyi.company.service.TJobhunterExpectPositionService;
import com.ruoyi.company.mapper.TJobhunterExpectPositionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_jobhunter_expect_position(期望职位表)】的数据库操作Service实现
* @createDate 2023-07-04 10:20:54
*/
@Service
@DataSource(value ="slave1")
public class TJobhunterExpectPositionServiceImpl extends ServiceImpl<TJobhunterExpectPositionMapper, TJobhunterExpectPosition>
    implements TJobhunterExpectPositionService{

    //期望职位
    @Override
    public List<TJobhunterExpectPosition> getByPosition(String resumeId) {
        LambdaQueryWrapper<TJobhunterExpectPosition> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(TJobhunterExpectPosition::getResumeId,resumeId);
        return this.list(wrapper);
    }
}




