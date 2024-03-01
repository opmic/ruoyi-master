package com.ruoyi.company.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * ClassName: ReportVO
 * Description:
 * date: 2023/9/22 9:26
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@ApiModel("举报处理")
@Data
public class ReportVO {
    @ApiModelProperty("举报id")
    @NotNull(message = "举报id不能为空！")
    private Long reportId;
    @ApiModelProperty("处理状态(0:待处理1:处理中2:处理结束)")
    @NotNull(message = "处理状态不能为空！")
    @Max(value = 2,message = "处理操作不正确！")
    @Min(value = 0,message = "处理操作不正确！")
    private Integer state;
    @ApiModelProperty("反馈信息")
    //@NotBlank(message = "举报id不能为空！")
    private String feedback;
}
