package com.ruoyi.post.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 岗位订单表
 * @TableName order_info
 */
@TableName(value ="order_info")
@Data
@ApiModel(value = "岗位订单表")
public class OrderInfo implements Serializable {
    /**
     * 订单
     */
    @TableId(value = "order_id")
    @ApiModelProperty("订单")
    private String orderId;

    /**
     * 订单标题
     */
    @TableField(value = "title")
    @ApiModelProperty("订单标题")
    private String title;

    /**
     * 商户订单编号
     */
    @TableField(value = "order_on")
    @ApiModelProperty("商户订单编号")
    private String orderOn;

    /**
     * 岗位id
     */
    @TableField(value = "post_id")
    @ApiModelProperty("岗位id")
    private String postId;

    /**
     * 支付方式（1：支付宝 2：微信 3无忧币 4.金币）
     */
    @TableField(value = "payment_type")
    @ApiModelProperty("支付方式（1：支付宝 2：微信 3无忧币 4.金币）")
    private String paymentType;

    /**
     * 投简id
     */
    @TableField(value = "put_in_resume_id")
    @ApiModelProperty("投简id")
    private String putInResumeId;

    /**
     * 交易状态(1:交易中 2:交易成功 3：交易超时已关闭 4:用户已取消 5 退款中 6 已退款 7退款异常,8异常取消)
     */
    @TableField(value = "state")
    @ApiModelProperty("交易状态(1:交易中 2:交易成功 3：交易超时已关闭 4:用户已取消 5 退款中 6 已退款 7退款异常,8异常取消)")
    private Integer state;

    /**
     * 关闭及失败原因
     */
    @TableField(value = "state_cause")
    @ApiModelProperty("关闭及失败原因")
    private String stateCause;

    /**
     * 求职者id（支付产品id）
     */
    @TableField(value = "jobhunter_id")
    @ApiModelProperty("求职者id（支付产品id）")
    private String jobhunterId;

    /**
     *  订单二维码链接
     */
    @TableField(value = "code_url")
    @ApiModelProperty(" 订单二维码链接")
    private String codeUrl;

    /**
     *  推荐官id
     */
    @TableField(value = "recommend_id")
    @ApiModelProperty(" 推荐官id")
    private String recommendId;

    /**
     * 金额（订单金额 元）
     */
    @TableField(value = "money")
    @ApiModelProperty(" 金额（订单金额 元）")
    private BigDecimal money;

    /**
     * 待支付时间
     */
    @TableField(value = "no_payment_time")
    @ApiModelProperty("待支付时间")
    private LocalDate noPaymentTime;

    /**
     * 支付金额
     */
    @TableField(value = "payment_amount")
    @ApiModelProperty("支付金额")
    private BigDecimal paymentAmount;

    /**
     * 推荐人id或邀请求职者推荐官id
     */
    @TableField(value = "referrer_id")
    @ApiModelProperty("推荐人id或邀请求职者推荐官id")
    private String referrerId;

    /**
     * 发票
     */
    @TableField(value = "invoice")
    @ApiModelProperty("发票")
    private String invoice;

    /**
     * 标识(1:下载简历 2：入职付 ：3满月付,4充值,5到面付)
     */
    @TableField(value = "identification")
    @ApiModelProperty("标识(1:下载简历 2：入职付 ：3满月付,4充值,5到面付)")
    private Integer identification;

    /**
     * 推荐官分成或邀请求职者推荐官
     */
    @TableField(value = "referrer_money")
    @ApiModelProperty("推荐官分成或邀请求职者推荐官")
    private BigDecimal referrerMoney;

    /**
     * 推荐官邀请人id
     */
    @TableField(value = "share_user_id")
    @ApiModelProperty(" 推荐官邀请人id")
    private String shareUserId;

    /**
     * 推荐官邀请人分成
     */
    @TableField(value = "share_money")
    @ApiModelProperty(" 推荐官邀请人分成")
    private BigDecimal shareMoney;

    /**
     * 企业邀请的推荐官id
     */
    @TableField(value = "inviter_company")
    @ApiModelProperty(" 推荐官邀请人分成")
    private String inviterCompany;

    /**
     * 企业邀请的推荐官分成
     */
    @TableField(value = "inviter_company_money")
    @ApiModelProperty(" 企业邀请的推荐官分成")
    private BigDecimal inviterCompanyMoney;

    /**
     * 邀请企业的推荐官的推荐官id
     */
    @TableField(value = "inviter_company_recommend")
    @ApiModelProperty(" 邀请企业的推荐官的推荐官id")
    private String inviterCompanyRecommend;

    /**
     * 邀请企业的推荐官的推荐官分成
     */
    @TableField(value = "inviter_company_recommend_money")
    @ApiModelProperty(" 邀请企业的推荐官的推荐官分成")
    private BigDecimal inviterCompanyRecommendMoney;

    /**
     * 平台分成
     */
    @TableField(value = "platform_money")
    @ApiModelProperty(" 平台分成")
    private BigDecimal platformMoney;

    /**
     * 是否分成(0:未分成 1:已分成 2待入账 3:已入账 )
     */
    @TableField(value = "divide_into_if")
    @ApiModelProperty(" 是否分成(0:未分成 1:已分成 2待入账 3:已入账 )")
    private Integer divideIntoIf;

    /**
     * 订单详情数据
     */
    @TableField(value = "particulars")
    @ApiModelProperty("订单详情数据")
    private String particulars;

    /**
     * 创建人
     */
    @TableField(value = "create_id")
    @ApiModelProperty("创建人")
    private String createId;

    /**
     * 创建人姓名
     */
    @TableField(value = "create_name")
    @ApiModelProperty("创建人姓名")
    private String createName;

    /**
     * 支付人
     */
    @TableField(value = "payer")
    @ApiModelProperty("支付人")
    private String payer;

    /**
     * 支付时间
     */
    @TableField(value = "payer_time")
    @ApiModelProperty("支付时间")
    private LocalDateTime payerTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    @TableField(value = "update_id")
    @ApiModelProperty("修改人")
    private String updateId;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

    /**
     *
     */
    @TableField(value = "deleted")
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OrderInfo other = (OrderInfo) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getOrderOn() == null ? other.getOrderOn() == null : this.getOrderOn().equals(other.getOrderOn()))
            && (this.getPostId() == null ? other.getPostId() == null : this.getPostId().equals(other.getPostId()))
            && (this.getPaymentType() == null ? other.getPaymentType() == null : this.getPaymentType().equals(other.getPaymentType()))
            && (this.getPutInResumeId() == null ? other.getPutInResumeId() == null : this.getPutInResumeId().equals(other.getPutInResumeId()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getStateCause() == null ? other.getStateCause() == null : this.getStateCause().equals(other.getStateCause()))
            && (this.getJobhunterId() == null ? other.getJobhunterId() == null : this.getJobhunterId().equals(other.getJobhunterId()))
            && (this.getCodeUrl() == null ? other.getCodeUrl() == null : this.getCodeUrl().equals(other.getCodeUrl()))
            && (this.getRecommendId() == null ? other.getRecommendId() == null : this.getRecommendId().equals(other.getRecommendId()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getNoPaymentTime() == null ? other.getNoPaymentTime() == null : this.getNoPaymentTime().equals(other.getNoPaymentTime()))
            && (this.getPaymentAmount() == null ? other.getPaymentAmount() == null : this.getPaymentAmount().equals(other.getPaymentAmount()))
            && (this.getReferrerId() == null ? other.getReferrerId() == null : this.getReferrerId().equals(other.getReferrerId()))
            && (this.getInvoice() == null ? other.getInvoice() == null : this.getInvoice().equals(other.getInvoice()))
            && (this.getIdentification() == null ? other.getIdentification() == null : this.getIdentification().equals(other.getIdentification()))
            && (this.getReferrerMoney() == null ? other.getReferrerMoney() == null : this.getReferrerMoney().equals(other.getReferrerMoney()))
            && (this.getShareUserId() == null ? other.getShareUserId() == null : this.getShareUserId().equals(other.getShareUserId()))
            && (this.getShareMoney() == null ? other.getShareMoney() == null : this.getShareMoney().equals(other.getShareMoney()))
            && (this.getInviterCompany() == null ? other.getInviterCompany() == null : this.getInviterCompany().equals(other.getInviterCompany()))
            && (this.getInviterCompanyMoney() == null ? other.getInviterCompanyMoney() == null : this.getInviterCompanyMoney().equals(other.getInviterCompanyMoney()))
            && (this.getInviterCompanyRecommend() == null ? other.getInviterCompanyRecommend() == null : this.getInviterCompanyRecommend().equals(other.getInviterCompanyRecommend()))
            && (this.getInviterCompanyRecommendMoney() == null ? other.getInviterCompanyRecommendMoney() == null : this.getInviterCompanyRecommendMoney().equals(other.getInviterCompanyRecommendMoney()))
            && (this.getPlatformMoney() == null ? other.getPlatformMoney() == null : this.getPlatformMoney().equals(other.getPlatformMoney()))
            && (this.getDivideIntoIf() == null ? other.getDivideIntoIf() == null : this.getDivideIntoIf().equals(other.getDivideIntoIf()))
            && (this.getParticulars() == null ? other.getParticulars() == null : this.getParticulars().equals(other.getParticulars()))
            && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
            && (this.getCreateName() == null ? other.getCreateName() == null : this.getCreateName().equals(other.getCreateName()))
            && (this.getPayer() == null ? other.getPayer() == null : this.getPayer().equals(other.getPayer()))
            && (this.getPayerTime() == null ? other.getPayerTime() == null : this.getPayerTime().equals(other.getPayerTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getOrderOn() == null) ? 0 : getOrderOn().hashCode());
        result = prime * result + ((getPostId() == null) ? 0 : getPostId().hashCode());
        result = prime * result + ((getPaymentType() == null) ? 0 : getPaymentType().hashCode());
        result = prime * result + ((getPutInResumeId() == null) ? 0 : getPutInResumeId().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getStateCause() == null) ? 0 : getStateCause().hashCode());
        result = prime * result + ((getJobhunterId() == null) ? 0 : getJobhunterId().hashCode());
        result = prime * result + ((getCodeUrl() == null) ? 0 : getCodeUrl().hashCode());
        result = prime * result + ((getRecommendId() == null) ? 0 : getRecommendId().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getNoPaymentTime() == null) ? 0 : getNoPaymentTime().hashCode());
        result = prime * result + ((getPaymentAmount() == null) ? 0 : getPaymentAmount().hashCode());
        result = prime * result + ((getReferrerId() == null) ? 0 : getReferrerId().hashCode());
        result = prime * result + ((getInvoice() == null) ? 0 : getInvoice().hashCode());
        result = prime * result + ((getIdentification() == null) ? 0 : getIdentification().hashCode());
        result = prime * result + ((getReferrerMoney() == null) ? 0 : getReferrerMoney().hashCode());
        result = prime * result + ((getShareUserId() == null) ? 0 : getShareUserId().hashCode());
        result = prime * result + ((getShareMoney() == null) ? 0 : getShareMoney().hashCode());
        result = prime * result + ((getInviterCompany() == null) ? 0 : getInviterCompany().hashCode());
        result = prime * result + ((getInviterCompanyMoney() == null) ? 0 : getInviterCompanyMoney().hashCode());
        result = prime * result + ((getInviterCompanyRecommend() == null) ? 0 : getInviterCompanyRecommend().hashCode());
        result = prime * result + ((getInviterCompanyRecommendMoney() == null) ? 0 : getInviterCompanyRecommendMoney().hashCode());
        result = prime * result + ((getPlatformMoney() == null) ? 0 : getPlatformMoney().hashCode());
        result = prime * result + ((getDivideIntoIf() == null) ? 0 : getDivideIntoIf().hashCode());
        result = prime * result + ((getParticulars() == null) ? 0 : getParticulars().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getCreateName() == null) ? 0 : getCreateName().hashCode());
        result = prime * result + ((getPayer() == null) ? 0 : getPayer().hashCode());
        result = prime * result + ((getPayerTime() == null) ? 0 : getPayerTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", title=").append(title);
        sb.append(", orderOn=").append(orderOn);
        sb.append(", postId=").append(postId);
        sb.append(", paymentType=").append(paymentType);
        sb.append(", putInResumeId=").append(putInResumeId);
        sb.append(", state=").append(state);
        sb.append(", stateCause=").append(stateCause);
        sb.append(", jobhunterId=").append(jobhunterId);
        sb.append(", codeUrl=").append(codeUrl);
        sb.append(", recommendId=").append(recommendId);
        sb.append(", money=").append(money);
        sb.append(", noPaymentTime=").append(noPaymentTime);
        sb.append(", paymentAmount=").append(paymentAmount);
        sb.append(", referrerId=").append(referrerId);
        sb.append(", invoice=").append(invoice);
        sb.append(", identification=").append(identification);
        sb.append(", referrerMoney=").append(referrerMoney);
        sb.append(", shareUserId=").append(shareUserId);
        sb.append(", shareMoney=").append(shareMoney);
        sb.append(", inviterCompany=").append(inviterCompany);
        sb.append(", inviterCompanyMoney=").append(inviterCompanyMoney);
        sb.append(", inviterCompanyRecommend=").append(inviterCompanyRecommend);
        sb.append(", inviterCompanyRecommendMoney=").append(inviterCompanyRecommendMoney);
        sb.append(", platformMoney=").append(platformMoney);
        sb.append(", divideIntoIf=").append(divideIntoIf);
        sb.append(", particulars=").append(particulars);
        sb.append(", createId=").append(createId);
        sb.append(", createName=").append(createName);
        sb.append(", payer=").append(payer);
        sb.append(", payerTime=").append(payerTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}