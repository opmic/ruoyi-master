package com.ruoyi.system.mapper;

import com.ruoyi.system.entity.SysRocketmqLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【sys_rocketmq_log(操作日志记录)】的数据库操作Mapper
* @createDate 2023-06-27 19:22:55
* @Entity com.ruoyi.system.entity.SysRocketmqLog
*/
public interface SysRocketmqLogMapper extends BaseMapper<SysRocketmqLog> {

    Boolean cleanLog();
}




