package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.system.entity.AccessRecord;
import com.ruoyi.system.query.AccessRecordQuery;
import com.ruoyi.system.service.AccessRecordService;
import com.ruoyi.system.mapper.AccessRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author Administrator
* @description 针对表【access_record】的数据库操作Service实现
* @createDate 2023-08-02 09:42:33
*/
@Service
public class AccessRecordServiceImpl extends ServiceImpl<AccessRecordMapper, AccessRecord>
    implements AccessRecordService{

    @Autowired
    private AccessRecordMapper accessRecordMapper;

    @Override
    public List<AccessRecord> selectAmount(AccessRecordQuery accessRecordQuery) {
        return accessRecordMapper.selectAmount(accessRecordQuery);
    }

    @Override
    public List<AccessRecord> intraday(Date beginTime, Date endTime) {
        return accessRecordMapper.intraday(beginTime,endTime);
    }
}




