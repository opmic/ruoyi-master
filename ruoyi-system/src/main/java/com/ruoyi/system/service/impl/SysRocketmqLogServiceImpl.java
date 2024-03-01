package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.system.entity.SysRocketmqLog;
import com.ruoyi.system.service.SysRocketmqLogService;
import com.ruoyi.system.mapper.SysRocketmqLogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author Administrator
* @description 针对表【sys_rocketmq_log(操作日志记录)】的数据库操作Service实现
* @createDate 2023-06-27 19:22:55
*/
@Service
@DataSource("master")
public class SysRocketmqLogServiceImpl extends ServiceImpl<SysRocketmqLogMapper, SysRocketmqLog>
    implements SysRocketmqLogService{

    @Resource
    private SysRocketmqLogMapper mapper;

    @Override
    public void cleanLog() {
       Boolean b =mapper.cleanLog();
    }

    @Override
    @DataSource("master")
    public void remove1(Long[] operIds) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.in("oper_id",operIds);
    }
}




