package com.ruoyi.post.dto;

import com.ruoyi.post.entity.TCompanyPost;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

/**
 * @Author: 文君
 * @Date: 2023-06-28-16:03
 * @Description:
 */
@Data
@ApiModel("data")
public class CompanyInfoDto extends TCompanyPost {

    @ApiModelProperty("联系人")
    private String contactName;
    @ApiModelProperty("联系方式")
    private String contactPhone;
    @ApiModelProperty("头像路径")
    private String avatar;
    @ApiModelProperty("职务")
    private String jobTitle;
}
