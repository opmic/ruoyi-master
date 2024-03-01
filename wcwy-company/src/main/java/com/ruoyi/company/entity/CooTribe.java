package com.ruoyi.company.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @TableName coo_tribe
 */
@TableName(value ="coo_tribe",autoResultMap = true)
@Data
@ApiModel(value = "coo发帖")
public class CooTribe implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("id")
    private Long id;

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
    @ApiModelProperty("类型(0:文章 1:问答 2:心得 3回答)")
    private Integer type;

    /**
     * 父亲id
     */
    @TableField(value = "father")
    @ApiModelProperty("父亲id")
    private Long father;

    /**
     * 文案
     */
    @TableField(value = "copy_writer")
    @ApiModelProperty("文案")
    private String copyWriter;

    /**
     * 封面
     */
    @TableField(value = "cover")
    @ApiModelProperty("封面")
    private String cover;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
     * 在线(0:在线 1:下线)
     */
    @TableField(value = "on_line")
    @ApiModelProperty("在线(0:在线 1:下线)")
    private Integer onLine;

    /**
     * 审核(0:审核中 1:审核成功 2审核失败)
     */
    @TableField(value = "audit")
    @ApiModelProperty("审核(0:审核中 1:审核成功 2审核失败)")
    private Integer audit;

    /**
     * 失败原因
     */
    @TableField(value = "cause_of_failure")
    @ApiModelProperty("失败原因")
    private String causeOfFailure;

    /**
     * 创建人
     */
    @TableField(value = "user_id")
    @ApiModelProperty("创建人")
    private String userId;

    /**
     * 浏览量
     */
    @TableField(value = "browse")
    @ApiModelProperty("浏览量")
    private Long browse;

    /**
     * 点赞量
     */
    @TableField(value = "zan")
    @ApiModelProperty("点赞量")
    private Long zan;

    /**
     * 评论量
     */
    @TableField(value = "comment")
    @ApiModelProperty("评论量")
    private Long comment;

    /**
     * 分享量
     */
    @TableField(value = "share")
    @ApiModelProperty("分享量")
    private Long share;

    /**
     * 收藏量
     */
    @TableField(value = "collect")
    @ApiModelProperty("收藏量")
    private Long collect;

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
        CooTribe other = (CooTribe) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getFather() == null ? other.getFather() == null : this.getFather().equals(other.getFather()))
            && (this.getCopyWriter() == null ? other.getCopyWriter() == null : this.getCopyWriter().equals(other.getCopyWriter()))
            && (this.getCover() == null ? other.getCover() == null : this.getCover().equals(other.getCover()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getOnLine() == null ? other.getOnLine() == null : this.getOnLine().equals(other.getOnLine()))
            && (this.getAudit() == null ? other.getAudit() == null : this.getAudit().equals(other.getAudit()))
            && (this.getCauseOfFailure() == null ? other.getCauseOfFailure() == null : this.getCauseOfFailure().equals(other.getCauseOfFailure()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getBrowse() == null ? other.getBrowse() == null : this.getBrowse().equals(other.getBrowse()))
            && (this.getZan() == null ? other.getZan() == null : this.getZan().equals(other.getZan()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
            && (this.getShare() == null ? other.getShare() == null : this.getShare().equals(other.getShare()))
            && (this.getCollect() == null ? other.getCollect() == null : this.getCollect().equals(other.getCollect()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getFather() == null) ? 0 : getFather().hashCode());
        result = prime * result + ((getCopyWriter() == null) ? 0 : getCopyWriter().hashCode());
        result = prime * result + ((getCover() == null) ? 0 : getCover().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getOnLine() == null) ? 0 : getOnLine().hashCode());
        result = prime * result + ((getAudit() == null) ? 0 : getAudit().hashCode());
        result = prime * result + ((getCauseOfFailure() == null) ? 0 : getCauseOfFailure().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getBrowse() == null) ? 0 : getBrowse().hashCode());
        result = prime * result + ((getZan() == null) ? 0 : getZan().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getShare() == null) ? 0 : getShare().hashCode());
        result = prime * result + ((getCollect() == null) ? 0 : getCollect().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", province=").append(province);
        sb.append(", type=").append(type);
        sb.append(", father=").append(father);
        sb.append(", copyWriter=").append(copyWriter);
        sb.append(", cover=").append(cover);
        sb.append(", createTime=").append(createTime);
        sb.append(", onLine=").append(onLine);
        sb.append(", audit=").append(audit);
        sb.append(", causeOfFailure=").append(causeOfFailure);
        sb.append(", userId=").append(userId);
        sb.append(", browse=").append(browse);
        sb.append(", zan=").append(zan);
        sb.append(", comment=").append(comment);
        sb.append(", share=").append(share);
        sb.append(", collect=").append(collect);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}