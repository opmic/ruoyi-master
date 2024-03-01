package com.ruoyi.system.service;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.system.entity.SysRocketmqLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【sys_rocketmq_log(操作日志记录)】的数据库操作Service
* @createDate 2023-06-27 19:22:55
*/
@DataSource("master")
public interface SysRocketmqLogService extends IService<SysRocketmqLog> {

    /**
     * @Description: 清空
     * @return null
     * @Author tangzhuo
     * @CreateTime 2023/6/28 14:59
     */



    void cleanLog();

    void remove1(Long[] operIds);
}
