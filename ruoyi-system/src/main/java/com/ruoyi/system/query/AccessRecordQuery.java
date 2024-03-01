package com.ruoyi.system.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * ClassName: AccessRecordQuery
 * Description:
 * date: 2023/8/2 9:45
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@Data
@ApiModel(value = "总数据分析查询")
public class AccessRecordQuery {

    @ApiModelProperty("开始时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate beginTime;


    @ApiModelProperty("结束时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endTime;


    @ApiModelProperty("地区")
    private String region;

}
