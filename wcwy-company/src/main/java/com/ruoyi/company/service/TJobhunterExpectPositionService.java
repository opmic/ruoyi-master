package com.ruoyi.company.service;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.TJobhunterExpectPosition;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_jobhunter_expect_position(期望职位表)】的数据库操作Service
* @createDate 2023-07-04 10:20:54
*/
@DataSource(value ="slave1")
public interface TJobhunterExpectPositionService extends IService<TJobhunterExpectPosition> {
    //期望职位
    public List<TJobhunterExpectPosition> getByPosition(String resumeId);
}
