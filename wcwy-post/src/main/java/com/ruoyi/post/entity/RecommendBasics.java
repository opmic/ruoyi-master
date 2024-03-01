package com.ruoyi.post.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 推荐官基本信息
 * @TableName recommend_basics
 */
@TableName(value ="recommend_basics")
@Data
public class RecommendBasics implements Serializable {
    /**
     * 推荐官id
     */
    @TableId(value = "recommend_id")
    private String recommendId;

    /**
     * 姓名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 头像
     */
    @TableField(value = "head_path")
    private String headPath;

    /**
     * 性别:(1:男 2:女生)
     */
    @TableField(value = "sex")
    private Integer sex;

    /**
     * 电话号码
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 猎企认证(0:未认证 1:申请中 2:已认证)
     */
    @TableField(value = "administrator")
    private Integer administrator;

    /**
     * 企业名称
     */
    @TableField(value = "firm_name")
    private String firmName;

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
        RecommendBasics other = (RecommendBasics) that;
        return (this.getRecommendId() == null ? other.getRecommendId() == null : this.getRecommendId().equals(other.getRecommendId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getHeadPath() == null ? other.getHeadPath() == null : this.getHeadPath().equals(other.getHeadPath()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getAdministrator() == null ? other.getAdministrator() == null : this.getAdministrator().equals(other.getAdministrator()))
            && (this.getFirmName() == null ? other.getFirmName() == null : this.getFirmName().equals(other.getFirmName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRecommendId() == null) ? 0 : getRecommendId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getHeadPath() == null) ? 0 : getHeadPath().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getAdministrator() == null) ? 0 : getAdministrator().hashCode());
        result = prime * result + ((getFirmName() == null) ? 0 : getFirmName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recommendId=").append(recommendId);
        sb.append(", username=").append(username);
        sb.append(", headPath=").append(headPath);
        sb.append(", sex=").append(sex);
        sb.append(", phone=").append(phone);
        sb.append(", administrator=").append(administrator);
        sb.append(", firmName=").append(firmName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}