package com.ruoyi.company.query;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * ClassName: CommentQuery
 * Description:
 * date: 2024/1/30 11:23
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@Data
@ApiModel("评论查询1")
public class CommentQuery extends PageQuery {
    /**
     * 帖子id
     */
    @ApiModelProperty("帖子id")
    @NotNull(message = "帖子id不能为空!")
    private Long cooTribeId;

    /**
     * 回答
     */
    @ApiModelProperty("回答")
    private String answer;

    @ApiModelProperty("开始时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startTime;

    @ApiModelProperty("开始时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endTime;
}
