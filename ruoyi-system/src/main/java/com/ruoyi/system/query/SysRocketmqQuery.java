package com.ruoyi.system.query;

import com.ruoyi.common.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName: SysRocketmqQuery
 * Description:
 * date: 2023/6/27 19:34
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@Data
@ApiModel("mq日志查询")
public class SysRocketmqQuery extends PageQuery {
    @ApiModelProperty("操作状态（0正常 1异常）")
    private Integer status;
    @ApiModelProperty("模块标题")
    private String title;
    @ApiModelProperty("业务类型（0生产 1消费）")
    private Integer businessType;
  /*  @ApiModelProperty("开始时间")*/

}
