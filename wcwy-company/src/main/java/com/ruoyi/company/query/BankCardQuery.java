package com.ruoyi.company.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ClassName: BankCardQuery
 * Description:
 * date: 2023/8/18 10:03
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@Data
@ApiModel("实名认证查询")
public class BankCardQuery extends PageQuery {
    @ApiModelProperty("审核状态(0:审核中 1:审核成功 2审核失败)")
    private Integer audit;
    @ApiModelProperty("开始时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @ApiModelProperty("结束时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @ApiModelProperty("身份证姓名")
    private String realName;
}
