package com.ruoyi.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.dto.JobHunterDTO;
import com.ruoyi.company.dto.TJobhunterDto;
import com.ruoyi.company.entity.*;
import com.ruoyi.company.mapper.TCompanyMapper;
import com.ruoyi.company.query.TJobHunterQuery;
import com.ruoyi.company.service.TCompanyService;
import com.ruoyi.company.service.TJobhunterService;
import com.ruoyi.company.mapper.TJobhunterMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author Administrator
* @description 针对表【t_jobhunter(求职者用户表)】的数据库操作Service实现
* @createDate 2023-07-04 10:20:54
*/
@Service
@DataSource(value ="slave1")
public class TJobhunterServiceImpl extends ServiceImpl<TJobhunterMapper, TJobhunter> implements TJobhunterService {
    @Autowired
    private TJobHunterAttachmentServiceImpl attachmentService;
    @Autowired
    private TJobhunterEducationRecordServiceImpl educationRecordService;
    @Autowired
    private TJobhunterExpectPositionServiceImpl expectPositionService;
    @Autowired
    private TJobhunterProjectRecordServiceImpl projectRecordService;
    @Autowired
    private TJobhunterResumeServiceImpl resumeService;
    @Autowired
    private TJobhunterServiceImpl jobhunterService;
    @Autowired
    private TJobhunterWorkRecordServiceImpl tJobhunterWorkRecordService;

    @Autowired
    private TJobhunterMapper tJobhunterMapper;

    //查询简历
    @Override
    public Page<TJobhunterDto> pageInfo(
            int page, int pageSize,String loginName,Integer sex,
            String jobStatus,String examineStatus,String status) {
        return null;
/*        Page<TJobhunter> jobhunterPage=new Page<>(page,pageSize);
        LambdaQueryWrapper<TJobhunter> wrapper=new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotEmpty(loginName),TJobhunter::getLoginName,loginName);
        wrapper.like(StringUtils.isNotEmpty(status),TJobhunter::getStatus,status);
        wrapper.like(StringUtils.isNotEmpty(jobStatus),TJobhunter::getJobStatus,jobStatus);
        if (sex!=null){
            wrapper.eq(TJobhunter::getSex,sex);
        }
        if (examineStatus!=null){
            wrapper.like(TJobhunter::getExamineStatus,examineStatus);
        }
        wrapper.orderByDesc(TJobhunter::getCreateTime);
        jobhunterService.page(jobhunterPage,wrapper);
        Page<TJobhunterResume> pageInfos=new Page<>(page,pageSize);
        LambdaQueryWrapper<TJobhunterResume> wrappers=new LambdaQueryWrapper<>();
        resumeService.page(pageInfos,wrappers);
        Page<TJobhunterDto> dto=new Page<>();
        BeanUtils.copyProperties(jobhunterPage,dto,"records");
        List<TJobhunter> jobhunters=jobhunterPage.getRecords();
        List<TJobhunterDto> list=jobhunters.stream().map((item)->{
            TJobhunterDto jobhunterDto=new TJobhunterDto();
            //简历
            List<TJobhunterResume> byResume=resumeService.selectId(item.getUserId());
            String Id=byResume.stream().map((i)->{return i.getResumeId();}).collect(Collectors.joining());
            jobhunterDto.setResumeList(byResume);
            //个人信息
            TJobhunter tJobhunterList=item;
            List data=new ArrayList();
            data.add(tJobhunterList);
            jobhunterDto.setTJobhunterList(data);
            //附件
            List<TJobHunterAttachment> byAid = attachmentService.getByAid(Id);
            jobhunterDto.setAttachmentList(byAid);
            //教育
            List<TJobhunterEducationRecord> byEducat = educationRecordService.getByEducat(Id);
            jobhunterDto.setEducationRecordList(byEducat);
            //期望职位
            List<TJobhunterExpectPosition> byPosition = expectPositionService.getByPosition(Id);
            jobhunterDto.setExpectPositionList(byPosition);
            //项目经验
            List<TJobhunterProjectRecord> byProject = projectRecordService.getByProject(Id);
            jobhunterDto.setProjectRecordList(byProject);
            //工作经历
            List<TJobhunterWorkRecord> bywork = tJobhunterWorkRecordService.selectId(Id);
            System.out.println(bywork);
            jobhunterDto.setTJobhunterWorkRecords(bywork);
            return jobhunterDto;
        }).collect(Collectors.toList());
        dto.setRecords(list);
        return dto;*/
    }

    @Override
    public IPage<JobHunterDTO> select(TJobHunterQuery tJobHunterQuery) {
        return tJobhunterMapper.select(tJobHunterQuery.createPage(),tJobHunterQuery);
    }
}




