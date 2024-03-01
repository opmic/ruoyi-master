package com.ruoyi.post.query;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;


/**
 * ClassName: OrderInfoQuery
 * Description:
 * date: 2023/7/18 9:28
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@ApiModel(value = "订单查询")
@Data
public class OrderInfoQuery extends PageQuery {
    /**
     * 订单
     */
    @ApiModelProperty("订单")
    private String orderId;

    /**
     * 订单标题
     */
    @ApiModelProperty("订单标题")
    private String title;

    /**
     * 商户订单编号
     */
    @ApiModelProperty("商户订单编号")
    private String orderOn;

    /**
     * 岗位id
     */
    @ApiModelProperty("岗位id")
    private String postId;

    /**
     * 支付方式（1：支付宝 2：微信 3无忧币 4.金币）
     */
    @ApiModelProperty("支付方式（1：支付宝 2：微信 3无忧币 4.金币）")
    private String paymentType;

    /**
     * 投简id
     */
    @ApiModelProperty("投简id")
    private String putInResumeId;

    /**
     * 交易状态(1:交易中 2:交易成功 3：交易超时已关闭 4:用户已取消 5 退款中 6 已退款 7退款异常,8异常取消)
     */
    @ApiModelProperty("交易状态(1:交易中 2:交易成功 3：交易超时已关闭 4:用户已取消 5 退款中 6 已退款 7退款异常,8异常取消)")
    private Integer state;


    /**
     * 求职者id（支付产品id）
     */
    @ApiModelProperty("求职者id（支付产品id）")
    private String jobhunterId;


    /**
     *  推荐官id
     */
    @ApiModelProperty(" 推荐官id")
    private String recommendId;



    @ApiModelProperty(" 是否分成(0:未分成 1:已分成 2待入账 3:已入账 )")
    private Integer divideIntoIf;



    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String createId;


    /**
     * 支付人
     */
    @TableField(value = "payer")
    @ApiModelProperty("支付人")
    private String payer;

    @ApiModelProperty("开始时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate beginTime;


    @ApiModelProperty("结束时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endTime;


}
