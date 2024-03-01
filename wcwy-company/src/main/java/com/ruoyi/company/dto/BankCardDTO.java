package com.ruoyi.company.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * ClassName: BankCardDTO
 * Description:
 * date: 2023/8/18 9:53
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@ApiModel("实名认证查询")
@Data
public class BankCardDTO {

    /**
     * 银行卡id
     */
    @ApiModelProperty("银行卡id")
    private String id;

    /**
     * 持卡人姓名
     */
    @ApiModelProperty("持卡人姓名")
    private String userName;

    /**
     * 预留手机号
     */
    @ApiModelProperty("预留手机号")
    private String userTel;

    /**
     * 开户支行
     */
    @ApiModelProperty("开户支行")
    private String bankSubName;

    /**
     * 开户银行
     */
    @ApiModelProperty("开户银行")
    private String bankName;

    /**
     * 申请人账户
     */
    @ApiModelProperty("申请人账户")
    private String bankNum;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private String userId;

    /**
     * 身份证姓名
     */
    @ApiModelProperty("身份证姓名")
    private String realName;

    /**
     * 身份证号
     */
    @ApiModelProperty("身份证号")
    private String card;

    /**
     * 身份证正面
     */
    @ApiModelProperty("身份证正面")
    private String cardFront;

    /**
     * 身份证反面
     */

    @ApiModelProperty("身份证反面")
    private String cardVerso;

    /**
     * 审核状态(0:审核中 1:审核成功 2审核失败)
     */
    @ApiModelProperty("审核状态(0:审核中 1:审核成功 2审核失败)")
    private Integer audit;

    /**
     * 审核原因
     */
    @ApiModelProperty("审核原因")
    private String auditCause;

    /**
     * 审核时间
     */
    @ApiModelProperty("审核时间")
    private LocalDateTime auditTime;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
     * 头像地址
     */
    @ApiModelProperty("头像")
    private String headPath;

    @ApiModelProperty("账号姓名")
    private String accountNumberName;
}
