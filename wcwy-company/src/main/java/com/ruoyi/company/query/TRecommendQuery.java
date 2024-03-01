package com.ruoyi.company.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName: TRecommendQuery
 * Description:
 * date: 2023/10/23 15:53
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@Data
@ApiModel("推荐官查询")
public class TRecommendQuery extends PageQuery {

    @ApiModelProperty("关键字")
    private String keyword;

    @ApiModelProperty("开始时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;

    @ApiModelProperty("结束时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;
    @ApiModelProperty("审核状态(0待审核1审核中2通过3未通过)")
    private Integer examineStatus;

}
