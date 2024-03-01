package com.ruoyi.company.dto;

import com.ruoyi.company.entity.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: 文君
 * @Date: 2023-07-04-11:26
 * @Description:
 */
@ApiModel("求职者简历信息")
@Data
public class TJobhunterDto{
    @ApiModelProperty("求职者用户")
    private TJobhunter tJobhunterList;
    @ApiModelProperty("求职者附件")
    private List<TJobHunterAttachment> attachmentList;

    @ApiModelProperty("教育经历")
    private List<TJobhunterEducationRecord> educationRecordList;

    @ApiModelProperty("期望职位")
    private List<TJobhunterExpectPosition> expectPositionList;

    @ApiModelProperty("项目经历")
    private List<TJobhunterProjectRecord> projectRecordList;

    @ApiModelProperty("求职者简历")
    private TJobhunterResume resumeList;

    @ApiModelProperty("工作经历")
    private List<TJobhunterWorkRecord> tJobhunterWorkRecords;
}
