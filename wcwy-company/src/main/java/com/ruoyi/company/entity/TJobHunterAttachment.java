package com.ruoyi.company.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;


import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 求职者附件
 * @TableName t_job_hunter_attachment
 */
@TableName(value ="t_job_hunter_attachment")
@Data
@ApiModel("求职者附件")
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TJobHunterAttachment implements Serializable {
    /**
     * 附件id
     */
    @ApiModelProperty("附件id")
    @TableId(value = "attachment_id")
    private String attachmentId;

    /**
     * 求职者id
     */
    @ApiModelProperty(value = "求职者id",required = true)
    @TableField(value = "t_job_hunter_id")
    private String tJobHunterId;

    /**
     * 附件地址
     */
    @ApiModelProperty("附件地址")
    @TableField(value = "path")
    private String path;

    /**
     * 上传时间
     */
    @ApiModelProperty("上传时间")
    @TableField(value = "create_date",fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    /**
     * 是否置顶(0:置顶 1:不置顶)
     */
    @ApiModelProperty("是否置顶(0:置顶 1:不置顶)")
    @TableField(value = "top")
    private Integer top;

}