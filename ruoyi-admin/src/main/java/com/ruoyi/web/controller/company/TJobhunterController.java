package com.ruoyi.web.controller.company;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.company.dto.JobHunterDTO;
import com.ruoyi.company.dto.TJobhunterDto;
import com.ruoyi.company.entity.*;
import com.ruoyi.company.query.TJobHunterQuery;
import com.ruoyi.company.service.TRecommendService;
import com.ruoyi.company.service.impl.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @Author: 文君
 * @Date: 2023-06-26-11:31
 * @Description:
 */

@RestController
@RequestMapping("/Jobhunter")
@Api(tags = "求职者简历")
public class TJobhunterController {
    //求职者信息
    @Autowired
    private TJobhunterServiceImpl jobhunterService;
    //求职者附件
    @Autowired
    private TJobHunterAttachmentServiceImpl jobHunterAttachmentService;
    //求职者教育
    @Autowired
    private TJobhunterEducationRecordServiceImpl jobhunterEducationRecordService;
    //期望职位
    @Autowired
    private TJobhunterExpectPositionServiceImpl jobhunterExpectPositionService;
    //项目教育
    @Autowired
    private TJobhunterProjectRecordServiceImpl jobhunterProjectRecordService;
    //求职者简历
    @Autowired
    private TJobhunterResumeServiceImpl jobhunterResumeService;
    //工作经历
    @Autowired
    private TJobhunterWorkRecordServiceImpl jobhunterWorkRecordService;

    @Autowired
    private TRecommendService tRecommendService;
    //查询简历
    @GetMapping
    @ApiOperation(value="查询求职者简历",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page", value="请求页数", required = true, dataType="Integer", paramType="query"),
            @ApiImplicitParam(name="pageSize", value="数据条数", required = true, dataType="Integer", paramType="query"),
            @ApiImplicitParam(name="loginName", value="登录账号", required = false, dataType="String", paramType="query"),
            @ApiImplicitParam(name="sex", value="用户性别（0男 1女 2未知）", required = false, dataType="Integer", paramType="query"),
            @ApiImplicitParam(name="jobStatus", value="求职状态(1:实习 2:应届生 3:在职暂无跳槽 4:在职急求机会 5:在职看机会 6:离职看机会)", required = false, dataType="String", paramType="query"),
            @ApiImplicitParam(name="examineStatus", value="审核状态(0待审核1审核通过2审核不通过)", required = false, dataType="Integer", paramType="query"),
            @ApiImplicitParam(name="status", value="(帐号状态（0正常 1停用）)", required = false, dataType="String", paramType="query"),
    })
    @DataSource(value ="slave1")
    public R<TJobhunterDto> getTJobhunter(int page, int pageSize,String loginName,Integer sex, String jobStatus,String examineStatus,String status){
        Page<TJobhunterDto> dtoPage=jobhunterService.pageInfo(page,pageSize,loginName,sex,jobStatus,examineStatus,status);
        return R.ok(dtoPage);
    }

    //修改求职者附件
    @PostMapping("/AttachmentUpadte")
    @ApiOperation(value = "修改求职者附件")
    @DataSource(value ="slave1")
    public R<TJobHunterAttachment> AttachmentUpadte(@Validated @RequestBody TJobHunterAttachment tJobHunterAttachment){
        if (tJobHunterAttachment.getTJobHunterId()==""){
            return R.fail("求职者id不能为空");
        }
        tJobHunterAttachment.setCreateDate(LocalDateTime.now());
        boolean b = jobHunterAttachmentService.updateById(tJobHunterAttachment);
        if (b){
            return R.ok();
        }else {
            return R.fail("简历附件id不能为空");
        }
    }
    //修改教育经历
    @PostMapping("/EducationRecordUpdate")
    @ApiOperation(value = "修改教育经历")
    @DataSource(value ="slave1")
    public R<TJobhunterEducationRecord> EducationRecordUpdate(@RequestBody TJobhunterEducationRecord tJobhunterEducationRecord){
        boolean b=jobhunterEducationRecordService.updateById(tJobhunterEducationRecord);
        if (StringUtils.isEmpty(tJobhunterEducationRecord.getResumeId())){
            return R.fail("简历id不能为空");
        }
        if (b){
            return R.ok();
        }else {
            return R.fail("教育经历id不能为空");
        }
    }
    @PostMapping("/ExpectPositionUpdate")
    @ApiOperation(value = "修改求期望职位")
    @DataSource(value ="slave1")
    //期望职位
    public R<TJobhunterExpectPosition> ExpectPositionUpdate(@RequestBody TJobhunterExpectPosition tJobhunterExpectPosition){
        boolean b=jobhunterExpectPositionService.updateById(tJobhunterExpectPosition);
        if (StringUtils.isEmpty(tJobhunterExpectPosition.getResumeId())){
            return R.fail("简历id不能为空");
        }
        if (b){
            return R.ok();
        }else {
            return R.fail("期望职位id不能为空");
        }
    }
    @PostMapping("/ProjectRecordUpdate")
    @ApiOperation(value = "修改项目经历")
    @DataSource(value ="slave1")
    //项目经历
    public R<TJobhunterProjectRecord> ProjectRecordUpdate(@RequestBody TJobhunterProjectRecord tJobhunterProjectRecord){
        boolean b=jobhunterProjectRecordService.updateById(tJobhunterProjectRecord);
        if (StringUtils.isEmpty(tJobhunterProjectRecord.getResumeId())){
            return R.fail("简历id不能为空");
        }
        if (b){
            return R.ok();
        }else {
            return R.fail("项目经历id不能为空");
        }
    }

    @PostMapping("/ResumeUpdate")
    @ApiOperation(value = "修改项求职者简历")
    @DataSource(value ="slave1")
    //求职者简历&个人优势
    public R<TJobhunterResume> ResumeUpdate(@RequestBody TJobhunterResume tJobhunterResume){
        boolean b=jobhunterResumeService.updateById(tJobhunterResume);
        if (b){
            return R.ok();
        }else {
            return R.fail("求职者简历id不能为空");
        }
    }

    @PostMapping("/TJobhunterUpdate")
    @ApiOperation(value = "修改项求个人信息")
    @DataSource(value ="slave1")
    //求职者个人信息
    public R<TJobhunter> TJobhunterUpdate(@RequestBody TJobhunter tJobhunter){
        boolean b=jobhunterService.updateById(tJobhunter);
        if (b){
            return R.ok();
        }else {
            return R.fail("求职者简历id不能为空");
        }
    }

    @PostMapping("/WorkRecord")
    @ApiOperation(value = "修改项工作经验")
    @DataSource(value ="slave1")
    //工作经验
    public R<TJobhunterWorkRecord> WorkRecordUpdate(@RequestBody TJobhunterWorkRecord tJobhunterWorkRecord){
        if (StringUtils.isEmpty(tJobhunterWorkRecord.getResumeId())){
            return R.fail("工作经验id不能为空");
        }
        boolean b=jobhunterWorkRecordService.updateById(tJobhunterWorkRecord);
        if (b){
            return R.ok();
        }else {
            return R.fail("求职者简历id不能为空");
        }
    }

    @GetMapping("/selectId")
    @ApiImplicitParam(name = "id", value = "求职者id", required = true)
    @ApiOperation("通过id查询求职者")
    @DataSource(value ="slave1")
    public R<TJobhunterDto> selectId(@RequestParam("id") String id){
        TJobhunter byId = jobhunterService.getById(id);
        if(byId==null){
            return R.fail("该求职者不存在！");
        }
        TJobhunterDto jobhunterDto=new TJobhunterDto();
        jobhunterDto.setTJobhunterList(byId);


        QueryWrapper queryWrapper4=new QueryWrapper();
        queryWrapper4.eq("t_job_hunter_id",byId.getUserId());
        List list3 = jobHunterAttachmentService.list(queryWrapper4);
        if(list3 !=null){
            jobhunterDto.setAttachmentList(list3);
        }


        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("t_jobhunter_id",byId.getUserId());
        TJobhunterResume one = jobhunterResumeService.getOne(queryWrapper);
        if(one ==null){
            return R.ok(jobhunterDto);
        }
        jobhunterDto.setResumeList(one);

        QueryWrapper queryWrapper1=new QueryWrapper();
        queryWrapper1.eq("resume_id",one.getResumeId());
        List list = jobhunterWorkRecordService.list(queryWrapper1);
        if(list!=null){
            jobhunterDto.setTJobhunterWorkRecords(list);
        }


        QueryWrapper queryWrapper2=new QueryWrapper();
        queryWrapper2.eq("resume_id",one.getResumeId());
        List list1 = jobhunterProjectRecordService.list(queryWrapper2);
        if(list1!=null){
            jobhunterDto.setProjectRecordList(list1);
        }


        QueryWrapper queryWrapper3=new QueryWrapper();
        queryWrapper3.eq("resume_id",one.getResumeId());
        List list2 = jobhunterEducationRecordService.list(queryWrapper3);
        if(list2 !=null){
            jobhunterDto.setEducationRecordList(list2);
        }

        QueryWrapper queryWrapper5=new QueryWrapper();
        queryWrapper5.eq("resume_id",one.getResumeId());
        List<TJobhunterExpectPosition> list4 = jobhunterExpectPositionService.list(queryWrapper5);
        if(list4 !=null){
            jobhunterDto.setExpectPositionList(list4);
        }

        return R.ok(jobhunterDto);
    }



    @PostMapping("/select")
    @ApiOperation("查询求职者")
    @DataSource(value ="slave1")
    public R<JobHunterDTO> select1(@RequestBody TJobHunterQuery tJobHunterQuery){
        if(! StringUtils.isEmpty(tJobHunterQuery.getBeginAge())){
            Calendar mycalendar= Calendar.getInstance();
            String year=String.valueOf(mycalendar.get(Calendar.YEAR));//获取年份
           int a= Integer.parseInt(year)- tJobHunterQuery.getBeginAge();
            tJobHunterQuery.setBeginAge(a);
        }
        System.out.println( tJobHunterQuery.getBeginAge());
        if(! StringUtils.isEmpty(tJobHunterQuery.getEndAge())){
            Calendar mycalendar= Calendar.getInstance();
            String year=String.valueOf(mycalendar.get(Calendar.YEAR));//获取年份
            int b=   Integer.parseInt(year)-tJobHunterQuery.getEndAge();
            tJobHunterQuery.setEndAge(b);
        }
        System.out.println( tJobHunterQuery.getEndAge());
       IPage<JobHunterDTO> iPage= jobhunterService.select(tJobHunterQuery);
        List<JobHunterDTO> records = iPage.getRecords();
        List<String> listId=new ArrayList<>(records.size());

        Set<String> strings=new HashSet<>(records.size());
        for (JobHunterDTO record : records) {
            listId.add(record.getResumeId());
            if(StringUtils.isEmpty(record.getSharePerson())){
                record.setSource(0);
            }else {
                if(StringUtils.isEmpty(record.getLoginName())){
                    record.setSource(2);
                }
                record.setSource(1);
                strings.add(record.getSharePerson());
            }
        }
       List<TJobhunterWorkRecord> list= jobhunterWorkRecordService.listIds(listId);
        if(list !=null && list.size()>0){
            for (JobHunterDTO record : records) {
                for (TJobhunterWorkRecord tJobhunterWorkRecord : list) {
                   if( record.getResumeId().equals(tJobhunterWorkRecord.getResumeId())){
                       record.setCompanyName(tJobhunterWorkRecord.getCompanyName());
                       record.setPositionName(tJobhunterWorkRecord.getPositionName());

                       continue;
                   }
                }
            }
        }
        if(strings !=null && strings.size()>0){
            List<TRecommend> tRecommends = tRecommendService.selectList(strings);
            if(tRecommends !=null && tRecommends.size()>0){
                for (JobHunterDTO record : records) {
                    for (TRecommend tRecommend : tRecommends) {
                        if(tRecommend.getId().equals(record.getSharePerson())){
                            record.setSharePersonName(tRecommend.getUsername());
                            record.setSharePersonAvatar(tRecommend.getHeadPath());
                            continue;
                        }
                    }
                }
            }
        }

        iPage.setRecords(records);
        return R.ok(iPage);
    }
}
