package com.ruoyi.company.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 期望职位表
 * @TableName t_jobhunter_expect_position
 */
@TableName(value ="t_jobhunter_expect_position",autoResultMap = true)
@Data
@ApiModel("期望职位表")
public class TJobhunterExpectPosition implements Serializable {
    /**
     * 主键Id
     */
    @TableId(value = "postion_id")
    @ApiModelProperty("主键Id")
    private String postionId;
    /**
     * 简历id
     */
    @TableField(value = "resume_id")
    @ApiModelProperty("简历id")
    private String resumeId;

    /**
     * 期望职位
     */
    @TableField(value = "position_name",typeHandler = JacksonTypeHandler.class)
    @ApiModelProperty(value = "期望职位")
    private List<String> positionName;

    /**
     * 工作城市
     */
    @TableField(value = "work_city",typeHandler = JacksonTypeHandler.class)
    @ApiModelProperty(value = "工作城市")
    private List<String> workCity;

    /**
     * 目前年薪
     */
    @ApiModelProperty("目前年薪")
    @TableField(value = "current_salary")
    private BigDecimal currentSalary;

    /**
     * 期望行业
     */
    @TableField(value = "desired_industry",typeHandler = JacksonTypeHandler.class)
    @ApiModelProperty(value = "期望行业")
    private List<String> desiredIndustry;

    /**
     * 期望年薪
     */
    @ApiModelProperty("期望年薪")
    @TableField(value = "expect_salary")
    private BigDecimal expectSalary;

    /**
     * 最快到岗时间
     */
    @ApiModelProperty("期望年薪")
    @TableField(value = "arrival_time")
    private Integer arrivalTime;

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
        TJobhunterExpectPosition other = (TJobhunterExpectPosition) that;
        return (this.getPostionId() == null ? other.getPostionId() == null : this.getPostionId().equals(other.getPostionId()))
            && (this.getResumeId() == null ? other.getResumeId() == null : this.getResumeId().equals(other.getResumeId()))
            && (this.getPositionName() == null ? other.getPositionName() == null : this.getPositionName().equals(other.getPositionName()))
            && (this.getWorkCity() == null ? other.getWorkCity() == null : this.getWorkCity().equals(other.getWorkCity()))
            && (this.getCurrentSalary() == null ? other.getCurrentSalary() == null : this.getCurrentSalary().equals(other.getCurrentSalary()))
            && (this.getDesiredIndustry() == null ? other.getDesiredIndustry() == null : this.getDesiredIndustry().equals(other.getDesiredIndustry()))
            && (this.getExpectSalary() == null ? other.getExpectSalary() == null : this.getExpectSalary().equals(other.getExpectSalary()))
            && (this.getArrivalTime() == null ? other.getArrivalTime() == null : this.getArrivalTime().equals(other.getArrivalTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPostionId() == null) ? 0 : getPostionId().hashCode());
        result = prime * result + ((getResumeId() == null) ? 0 : getResumeId().hashCode());
        result = prime * result + ((getPositionName() == null) ? 0 : getPositionName().hashCode());
        result = prime * result + ((getWorkCity() == null) ? 0 : getWorkCity().hashCode());
        result = prime * result + ((getCurrentSalary() == null) ? 0 : getCurrentSalary().hashCode());
        result = prime * result + ((getDesiredIndustry() == null) ? 0 : getDesiredIndustry().hashCode());
        result = prime * result + ((getExpectSalary() == null) ? 0 : getExpectSalary().hashCode());
        result = prime * result + ((getArrivalTime() == null) ? 0 : getArrivalTime().hashCode());
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
        sb.append(", postionId=").append(postionId);
        sb.append(", resumeId=").append(resumeId);
        sb.append(", positionName=").append(positionName);
        sb.append(", workCity=").append(workCity);
        sb.append(", currentSalary=").append(currentSalary);
        sb.append(", desiredIndustry=").append(desiredIndustry);
        sb.append(", expectSalary=").append(expectSalary);
        sb.append(", arrivalTime=").append(arrivalTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}