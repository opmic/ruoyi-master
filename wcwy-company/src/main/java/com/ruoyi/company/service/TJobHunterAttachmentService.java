package com.ruoyi.company.service;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.TJobHunterAttachment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_job_hunter_attachment(求职者附件)】的数据库操作Service
* @createDate 2023-07-04 10:21:31
*/
@DataSource(value ="slave1")
public interface TJobHunterAttachmentService extends IService<TJobHunterAttachment> {
    //通过id查询附件
    public List<TJobHunterAttachment> getByAid(String tJobhunterId);
}
