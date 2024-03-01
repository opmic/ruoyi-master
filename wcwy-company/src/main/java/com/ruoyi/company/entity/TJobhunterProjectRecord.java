package com.ruoyi.company.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 项目经历表
 * @TableName t_jobhunter_project_record
 */
@TableName(value ="t_jobhunter_project_record")
@Data
@ApiModel("项目经历表")
public class TJobhunterProjectRecord implements Serializable {
    /**
     * 主键Id
     */
    @ApiModelProperty("主键Id")
    @TableId(value = "project_id")
    private String projectId;

    /**
     * 简历id
     */
    @ApiModelProperty("简历id")
    @TableField(value = "resume_id")
    private String resumeId;

    /**
     * 项目名称
     */
    @ApiModelProperty("项目名称")
    @TableField(value = "project_name")
    private String projectName;

    /**
     * 项目角色
     */
    @ApiModelProperty("项目角色")
    @TableField(value = "project_role")
    private String projectRole;

    /**
     * 项目链接
     */
    @ApiModelProperty("项目链接")
    @TableField(value = "project_url")
    private String projectUrl;

    /**
     * 公司名称
     */
    @ApiModelProperty("公司名称")
    @TableField(value = "company_name")
    private String companyName;

    /**
     * 项目开始时间
     */
    @ApiModelProperty("项目开始时间")
    @TableField(value = "start_time")
    private String startTime;

    /**
     * 项目结束时间
     */
    @ApiModelProperty("项目结束时间")
    @TableField(value = "end_time")
    private String endTime;

    /**
     * 项目职责
     */
    @ApiModelProperty("项目职责")
    @TableField(value = "responsibility")
    private String responsibility;

    /**
     * 项目业绩
     */
    @ApiModelProperty("项目业绩")
    @TableField(value = "performance")
    private String performance;

    /**
     * 项目描述
     */
    @ApiModelProperty("项目描述")
    @TableField(value = "description")
    private String description;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TJobhunterProjectRecord other = (TJobhunterProjectRecord) that;
        return (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getResumeId() == null ? other.getResumeId() == null : this.getResumeId().equals(other.getResumeId()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getProjectRole() == null ? other.getProjectRole() == null : this.getProjectRole().equals(other.getProjectRole()))
            && (this.getProjectUrl() == null ? other.getProjectUrl() == null : this.getProjectUrl().equals(other.getProjectUrl()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getResponsibility() == null ? other.getResponsibility() == null : this.getResponsibility().equals(other.getResponsibility()))
            && (this.getPerformance() == null ? other.getPerformance() == null : this.getPerformance().equals(other.getPerformance()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getResumeId() == null) ? 0 : getResumeId().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getProjectRole() == null) ? 0 : getProjectRole().hashCode());
        result = prime * result + ((getProjectUrl() == null) ? 0 : getProjectUrl().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getResponsibility() == null) ? 0 : getResponsibility().hashCode());
        result = prime * result + ((getPerformance() == null) ? 0 : getPerformance().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", projectId=").append(projectId);
        sb.append(", resumeId=").append(resumeId);
        sb.append(", projectName=").append(projectName);
        sb.append(", projectRole=").append(projectRole);
        sb.append(", projectUrl=").append(projectUrl);
        sb.append(", companyName=").append(companyName);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", responsibility=").append(responsibility);
        sb.append(", performance=").append(performance);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}