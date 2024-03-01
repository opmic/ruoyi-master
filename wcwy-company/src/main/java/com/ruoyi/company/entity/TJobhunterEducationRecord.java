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
 * 教育经历表
 * @TableName t_jobhunter_education_record
 */
@TableName(value ="t_jobhunter_education_record")
@Data
@ApiModel("教育经历表")
public class TJobhunterEducationRecord implements Serializable {
    /**
     * 主键Id
     */
    @TableId(value = "edu_id")
    @ApiModelProperty("主键Id")
    private String eduId;

    /**
     * 简历id
     */
    @TableField(value = "resume_id")
    @ApiModelProperty("简历id")
    private String resumeId;

    /**
     * 学校名称
     */
    @TableField(value = "shcool_name")
    @ApiModelProperty("学校名称")
    private String shcoolName;

    /**
     * 学制类型(0其他1全日制2非全日制)
     */
    @TableField(value = "edul_type")
    @ApiModelProperty("学制类型(0其他1全日制2非全日制)")
    private Integer edulType;

    /**
     * 学历
     */
    @TableField(value = "education")
    @ApiModelProperty("学历")
    private String education;

    /**
     * 专业
     */
    @TableField(value = "major")
    @ApiModelProperty("专业")
    private String major;

    /**
     * 开始时间
     */
    @TableField(value = "start_time")
    @ApiModelProperty("开始时间")
    private String startTime;

    /**
     * 结束时间
     */
    @TableField(value = "end_time")
    @ApiModelProperty("结束时间")
    private String endTime;

    /**
     * 在校经历
     */
    @TableField(value = "description")
    @ApiModelProperty("在校经历")
    private String description;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty("更新时间")
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
        TJobhunterEducationRecord other = (TJobhunterEducationRecord) that;
        return (this.getEduId() == null ? other.getEduId() == null : this.getEduId().equals(other.getEduId()))
            && (this.getResumeId() == null ? other.getResumeId() == null : this.getResumeId().equals(other.getResumeId()))
            && (this.getShcoolName() == null ? other.getShcoolName() == null : this.getShcoolName().equals(other.getShcoolName()))
            && (this.getEdulType() == null ? other.getEdulType() == null : this.getEdulType().equals(other.getEdulType()))
            && (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()))
            && (this.getMajor() == null ? other.getMajor() == null : this.getMajor().equals(other.getMajor()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEduId() == null) ? 0 : getEduId().hashCode());
        result = prime * result + ((getResumeId() == null) ? 0 : getResumeId().hashCode());
        result = prime * result + ((getShcoolName() == null) ? 0 : getShcoolName().hashCode());
        result = prime * result + ((getEdulType() == null) ? 0 : getEdulType().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        result = prime * result + ((getMajor() == null) ? 0 : getMajor().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
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
        sb.append(", eduId=").append(eduId);
        sb.append(", resumeId=").append(resumeId);
        sb.append(", shcoolName=").append(shcoolName);
        sb.append(", edulType=").append(edulType);
        sb.append(", education=").append(education);
        sb.append(", major=").append(major);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}