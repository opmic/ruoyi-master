package com.ruoyi.company.query;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * ClassName: ReportQuery
 * Description:
 * date: 2023/9/21 9:46
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@Data
@ApiModel("举报查询")
public class ReportQuery extends PageQuery {
    @ApiModelProperty("开始时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @ApiModelProperty("结束时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    /**
     * 类型(0:岗位1:求职者)
     */
    @ApiModelProperty("类型(0:岗位1:求职者)")
    private Integer type;


    @ApiModelProperty("举报身份(0:企业1:推荐官2:求职者)")
    private Integer identity;
    @ApiModelProperty("关键字")
    private String keyword;
}
