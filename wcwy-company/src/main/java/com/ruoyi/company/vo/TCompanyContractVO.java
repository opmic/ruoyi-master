package com.ruoyi.company.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ClassName: TCompanyContractVO
 * Description:
 * date: 2023/9/13 16:43
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@ApiModel("合同审核")
@Data
public class TCompanyContractVO {

    /**
     * 合同id
     */
    @ApiModelProperty(value = "合同id")
    @NotBlank(message = "合同id不能为空！")
    private String contractId;

    @ApiModelProperty(value = "审核状态(0:审核通过 1:审核不通过)")
    @NotNull(message = "审核状态不能为空！")
    @Min(value = 0,message = "操作错误！")
    @Max(value = 1,message = "操作错误！")
    private Integer auditContract;

    /**
     * 审核原因
     */
    @ApiModelProperty(value = "失败原因",required = true)
   // @NotBlank(message = "合同id不能为空！")
    @Size(max = 100,message = "不能超过100字符!")
    private String auditCause;

    /**
     * 客服电话
     */
    @ApiModelProperty(value = "客服电话",required = true)
   // @NotBlank(message = "客服电话不能为空！")
    private String phone;

    @ApiModelProperty(value = "合同有效期")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate contractDate;
}
