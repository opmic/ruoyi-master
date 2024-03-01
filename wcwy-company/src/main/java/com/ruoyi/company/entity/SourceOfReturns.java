package com.ruoyi.company.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分享收益来源详情
 * @TableName source_of_returns
 */
@TableName(value ="source_of_returns")
@Data
public class SourceOfReturns implements Serializable {
    /**
     * 收益来源id
     */
    @TableId(value = "source_of_returns_id")
    private String sourceOfReturnsId;

    /**
     * 总金额
     */
    @TableField(value = "aggregate_amount")
    private BigDecimal aggregateAmount;

    /**
     * 来源身份(0企业 1推荐官 2求职者)
     */
    @TableField(value = "identity")
    private Integer identity;

    /**
     * 来源(0:分享 1:岗位)
     */
    @TableField(value = "type")
    private Integer type;
    @TableField(value = "payer")
    @ApiModelProperty("支付人")
    private String payer;
    /**
     * 来源订单
     */
    @TableField(value = "order_id")
    private String orderId;

    /**
     * 来源于用户
     */
    @TableField(value = "source_user")
    private String sourceUser;

    /**
     * 收益金额
     */
    @TableField(value = "earnings")
    private BigDecimal earnings;

    /**
     * 订单完成时间
     */
    @TableField(value = "order_time")
    private LocalDateTime orderTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @TableField(value = "create_id")
    private String createId;

    /**
     * 收益后总金额
     */
    @TableField(value = "deposit")
    private BigDecimal deposit;

    /**
     * 收益人
     */
    @TableField(value = "earning_user")
    private String earningUser;

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
        SourceOfReturns other = (SourceOfReturns) that;
        return (this.getSourceOfReturnsId() == null ? other.getSourceOfReturnsId() == null : this.getSourceOfReturnsId().equals(other.getSourceOfReturnsId()))
            && (this.getAggregateAmount() == null ? other.getAggregateAmount() == null : this.getAggregateAmount().equals(other.getAggregateAmount()))
            && (this.getIdentity() == null ? other.getIdentity() == null : this.getIdentity().equals(other.getIdentity()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getSourceUser() == null ? other.getSourceUser() == null : this.getSourceUser().equals(other.getSourceUser()))
            && (this.getEarnings() == null ? other.getEarnings() == null : this.getEarnings().equals(other.getEarnings()))
            && (this.getOrderTime() == null ? other.getOrderTime() == null : this.getOrderTime().equals(other.getOrderTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
            && (this.getDeposit() == null ? other.getDeposit() == null : this.getDeposit().equals(other.getDeposit()))
            && (this.getEarningUser() == null ? other.getEarningUser() == null : this.getEarningUser().equals(other.getEarningUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSourceOfReturnsId() == null) ? 0 : getSourceOfReturnsId().hashCode());
        result = prime * result + ((getAggregateAmount() == null) ? 0 : getAggregateAmount().hashCode());
        result = prime * result + ((getIdentity() == null) ? 0 : getIdentity().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getSourceUser() == null) ? 0 : getSourceUser().hashCode());
        result = prime * result + ((getEarnings() == null) ? 0 : getEarnings().hashCode());
        result = prime * result + ((getOrderTime() == null) ? 0 : getOrderTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getDeposit() == null) ? 0 : getDeposit().hashCode());
        result = prime * result + ((getEarningUser() == null) ? 0 : getEarningUser().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sourceOfReturnsId=").append(sourceOfReturnsId);
        sb.append(", aggregateAmount=").append(aggregateAmount);
        sb.append(", identity=").append(identity);
        sb.append(", order=").append(orderId);
        sb.append(", sourceUser=").append(sourceUser);
        sb.append(", earnings=").append(earnings);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", deposit=").append(deposit);
        sb.append(", earningUser=").append(earningUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}