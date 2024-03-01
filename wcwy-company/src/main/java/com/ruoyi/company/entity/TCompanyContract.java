package com.ruoyi.company.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 企业合同
 * @TableName t_company_contract
 */
@TableName(value ="t_company_contract",autoResultMap = true)
@Data
@ApiModel(value = "合同审核信息")
public class TCompanyContract implements Serializable {
    /**
     * 合同id
     */
    @ApiModelProperty(value = "合同id",required = true)
    @TableId(value = "contract_id")
    private String contractId;

    /**
     * 签约合同
     */
    @TableField(value = "sign_contract", typeHandler = JacksonTypeHandler.class)
    @ApiModelProperty("签约合同")
    private List<String> signContract;

    /**
     * 合同有效期
     */
    @ApiModelProperty(value = "合同有效期")
    @TableField(value = "contract_date")
    private LocalDate contractDate;

    /**
     * 岗位类型(1:入职付 2:满月付)
     */
    @ApiModelProperty(value = "申请状态(0:有效 1:已过期)")
    @TableField(value = "state")
    private Integer state;

    /**
     * 审核状态(0:审核中 1:审核成功 2:审核失败)
     */
    @ApiModelProperty(value = "审核状态(0:审核中 1:审核成功 2:审核失败)")
    @TableField(value = "audit_contract")
    private Integer auditContract;

    /**
     * 审核时间
     */
    @TableField(value = "audit_time")
    @ApiModelProperty("审核通过时间")
    private LocalDateTime auditTime;

    /**
     * 失败原因
     */
    @ApiModelProperty(value = "失败原因")
    @TableField(value = "audit_cause")
    private String auditCause;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    @TableField(value = "create_id")
    private String createId;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 逻辑删除
     */
    @ApiModelProperty(value = "逻辑删除")
    @TableField(value = "deleted")
    private Integer deleted;




}