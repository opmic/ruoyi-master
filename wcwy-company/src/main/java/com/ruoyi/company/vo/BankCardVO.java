package com.ruoyi.company.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

/**
 * ClassName: BankCardDTO
 * Description:
 * date: 2023/8/18 9:53
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@ApiModel("审核实名认证")
@Data
public class BankCardVO {

    /**
     * 银行卡id
     */
    @ApiModelProperty("银行卡id")
    @NotBlank(message = "银行卡id不能为空！")
    private String id;
    /**
     * 审核状态(0:审核中 1:审核成功 2审核失败)
     */
    @ApiModelProperty("审核状态(0:审核中 1:审核成功 2审核失败)")
    @NotNull(message = "审核状态不能为空！")
    @Min(value =0,message = "选择状态不对！")
    @Max(value = 2,message ="选择状态不对!" )
    private Integer audit;

    /**
     * 审核原因
     */
    @ApiModelProperty("审核原因")
    @Size(message = "字符不能超过50",max = 50)
    private String auditCause;

}
