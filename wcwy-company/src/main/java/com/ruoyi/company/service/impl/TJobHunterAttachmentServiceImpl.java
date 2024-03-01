package com.ruoyi.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.TJobHunterAttachment;
import com.ruoyi.company.service.TJobHunterAttachmentService;
import com.ruoyi.company.mapper.TJobHunterAttachmentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_job_hunter_attachment(求职者附件)】的数据库操作Service实现
* @createDate 2023-07-04 10:21:31
*/
@Service
@DataSource(value ="slave1")
public class TJobHunterAttachmentServiceImpl extends ServiceImpl<TJobHunterAttachmentMapper, TJobHunterAttachment>
    implements TJobHunterAttachmentService{
    //通过id查询附件
    @Override
    public List<TJobHunterAttachment> getByAid(String tJobhunterId) {
        LambdaQueryWrapper<TJobHunterAttachment> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(TJobHunterAttachment::getTJobHunterId,tJobhunterId);
        return this.list(wrapper);
    }
}




