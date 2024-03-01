package com.ruoyi.company.query;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ClassName: CooTribeQuery
 * Description:
 * date: 2024/1/30 8:21
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@Data
@ApiModel("实名认证查询")
public class CooTribeQuery extends PageQuery {

    /**
     * 标题
     */
    @TableField(value = "title")
    @ApiModelProperty("标题")
    private String title;

    /**
     * 省
     */
    @TableField(value = "province")
    @ApiModelProperty("省")
    private String province;

    /**
     * 类型(0:文章 1:问答 2:心得 3回答)
     */
    @TableField(value = "type")
    @ApiModelProperty(" 类型(0:文章 1:问答 2:心得 3回答)")
    private Integer type;

    /**
     * 在线(0:在线 1:下线)
     */
    @TableField(value = "on_line")
    @ApiModelProperty("在线(0:在线 1:下线)")
    private Integer onLine;

    /**
     * 审核(0:审核中 1:审核成功 2审核失败)
     */
    @ApiModelProperty("审核(0:审核中 1:审核成功 2审核失败)")
    private Integer audit;


    @ApiModelProperty("开始时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startTime;

    @ApiModelProperty("开始时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endTime;
}
