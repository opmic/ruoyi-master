package com.ruoyi.system.service;

import com.ruoyi.system.entity.AccessRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.query.AccessRecordQuery;

import java.util.Date;
import java.util.List;

/**
* @author Administrator
* @description 针对表【access_record】的数据库操作Service
* @createDate 2023-08-02 09:42:33
*/
public interface AccessRecordService extends IService<AccessRecord> {

    /**
     * @Description:总数据查询
     * @param accessRecordQuery   查询条件
     * @return null
     * @Author tangzhuo
     * @CreateTime 2023/8/2 9:55
     */

    List<AccessRecord> selectAmount(AccessRecordQuery accessRecordQuery);

    /**
     * @Description: 获取当天的数据
     * @param null
     * @return null
     * @Author tangzhuo
     * @CreateTime 2023/8/2 10:18
     */

    List<AccessRecord> intraday(Date beginTime, Date endTime);
}
