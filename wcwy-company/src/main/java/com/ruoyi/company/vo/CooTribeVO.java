package com.ruoyi.company.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName: CooTribeVO
 * Description:
 * date: 2024/1/30 8:41
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@ApiModel("审核帖子")
@Data
public class CooTribeVO {

    @ApiModelProperty("发帖id")
    @NotNull(message = "发帖id不能为空！")
    private Long id;

    @ApiModelProperty("审核(0:审核中 1:审核成功 2审核失败)")
    @NotNull(message = "审核不能为空！")
    private Integer audit;

    @ApiModelProperty("失败原因")
    private String causeOfFailure;
}
