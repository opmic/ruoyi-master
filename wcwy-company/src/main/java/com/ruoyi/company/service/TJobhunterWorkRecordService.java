package com.ruoyi.company.service;

import com.ruoyi.company.dto.JobHunterDTO;
import com.ruoyi.company.entity.TJobhunterResume;
import com.ruoyi.company.entity.TJobhunterWorkRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_jobhunter_work_record(工作经历表)】的数据库操作Service
* @createDate 2023-07-20 16:31:09
*/
public interface TJobhunterWorkRecordService extends IService<TJobhunterWorkRecord> {
    //工作经历
    List<TJobhunterWorkRecord> selectId(String workId);

    /**
     *
     * @param records
     * @return
     */
    List<TJobhunterWorkRecord> listIds(List<String> records);
}
