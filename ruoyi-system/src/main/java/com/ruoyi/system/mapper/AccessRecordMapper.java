package com.ruoyi.system.mapper;

import com.ruoyi.system.entity.AccessRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.query.AccessRecordQuery;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
* @author Administrator
* @description 针对表【access_record】的数据库操作Mapper
* @createDate 2023-08-02 09:42:33
* @Entity com.ruoyi.system.entity.AccessRecord
*/
public interface AccessRecordMapper extends BaseMapper<AccessRecord> {

    List<AccessRecord> selectAmount(@Param("accessRecordQuery") AccessRecordQuery accessRecordQuery);


    List<AccessRecord> intraday(@Param("beginTime") Date beginTime,@Param("endTime") Date endTime);
}




