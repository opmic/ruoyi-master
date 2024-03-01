package com.ruoyi.company.mapper;

import com.ruoyi.company.entity.TJobhunterWorkRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_jobhunter_work_record(工作经历表)】的数据库操作Mapper
* @createDate 2023-07-20 16:31:09
* @Entity com.ruoyi.company.entity.TJobhunterWorkRecord
*/
public interface TJobhunterWorkRecordMapper extends BaseMapper<TJobhunterWorkRecord> {

    /**
     * 通过多个id查询最近的工作经历
     * @param records
     * @return
     */
    List<TJobhunterWorkRecord> listIds(@Param("records") List<String> records);
}




