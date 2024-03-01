package com.ruoyi.company.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.ruoyi.company.entity.TCompanyContract;
import com.ruoyi.company.entity.TCompanyContractAudit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: 文君
 * @Date: 2023-07-04-9:08
 * @Description:
 */
@ApiModel("企业审核信息")
@Data

public class TCompanyContractDto extends  TCompanyContract {
    /**
     * 企业名称
     */
    @TableField(value = "company_name")
    @ApiModelProperty(value = "企业名称")
    private String companyName;
    /**
     * 营业执照
     */
    @TableField(value = "business_license")
    @ApiModelProperty(value = "营业执照")
    private String businessLicense;
    @ApiModelProperty(value = "企业属性(0招聘企业 1猎头企业)")
    private Integer companyType;
    /**
     * 企业LOGO
     */
    @TableField(value = "logo_path")
    @ApiModelProperty(value = "企业LOGO")
    private String logoPath;
    @TableField(value = "custom_logo")
    @ApiModelProperty(value = "企业自定义logo")
    private String customLogo;
    /**
     * 联系人
     */
    @TableField(value = "contact_name")
    @ApiModelProperty(value = "联系人")
    private String contactName;
    /**
     * 联系方式
     */
    @TableField(value = "contact_phone")
    @ApiModelProperty(value = "联系方式")
    private String contactPhone;
    /**
     * 性别
     */
    @TableField(value = "sex")
    @ApiModelProperty(value = "性别(0:未知 1:男 2:女生)")
    private Integer sex;



    @ApiModelProperty(value = "审核记录")
    private List<TCompanyContractAudit> tCompanyContractAuditList;
}
