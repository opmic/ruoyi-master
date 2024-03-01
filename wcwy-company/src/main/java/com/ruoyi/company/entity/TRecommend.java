package com.ruoyi.company.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;

import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ruoyi.company.po.ProvincesCitiesPO;
import com.ruoyi.company.po.TIndustryAndTypePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 推荐官
 * @TableName t_recommend
 */
@TableName(value ="t_recommend",autoResultMap = true)
@Data
@ApiModel(value = "推荐官基本信息")
public class TRecommend implements Serializable {
    /**
     * 推荐官id
     */
    @ApiModelProperty("推荐官id")
    @TableId(value = "id")
    private String id;

    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    @TableField(value = "username")
    private String username;

    /**
     * 登录名(使用电话号码)
     */
    @ApiModelProperty("登录名(使用电话号码)")
    @TableField(value = "login_name")
    private String loginName;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @TableField(value = "password")
    private String password;

    /**
     * 企业logo
     */
    @ApiModelProperty("企业logo")
    @TableField(value = "logo")
    private String logo;

    /**
     * 出生年月日
     */
    @ApiModelProperty("出生年月日")
    @TableField(value = "birth")
    private LocalDateTime birth;

    /**
     * 年龄 暂时不用
     */
    @ApiModelProperty("年龄 暂时不用")
    @TableField(value = "age")
    private Integer age;

    /**
     * 头像地址
     */
    @ApiModelProperty("头像地址")
    @TableField(value = "head_path")
    private String headPath;

    /**
     * 学历
     */
    @ApiModelProperty("学历")
    @TableField(value = "education")
    private String education;

    /**
     * 性别:(1:男 2:女生)
     */
    @ApiModelProperty("性别:(1:男 2:女生)")
    @TableField(value = "sex")
    private Integer sex;

    /**
     * 电话号码
     */
    @ApiModelProperty("电话号码")
    @TableField(value = "phone")
    private String phone;

    /**
     * 身份证
     */
    @ApiModelProperty("身份证")
    @TableField(value = "card")
    private String card;

    /**
     * 微信号
     */
    @ApiModelProperty("微信号")
    @TableField(value = "wechat_id")
    private String wechatId;

    /**
     * 身份证正面
     */
    @ApiModelProperty("身份证正面")
    @TableField(value = "card_front")
    private String cardFront;

    /**
     * 身份证反面
     */
    @ApiModelProperty("身份证反面")
    @TableField(value = "card_verso")
    private String cardVerso;

    /**
     * 无忧币
     */
    @ApiModelProperty("无忧币")
    @TableField(value = "currency_count")
    private BigDecimal currencyCount;

    /**
     * 推荐城市
     */
    @ApiModelProperty("推荐城市")
    @TableField(value = "recommended_city", typeHandler = JacksonTypeHandler.class)
    private List<ProvincesCitiesPO> recommendedCity;


    /**
     * 擅长行业
     */
    @TableField(value = "industry",typeHandler = JacksonTypeHandler.class)
    @ApiModelProperty(value = "擅长行业")
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,property = "mytype", include=JsonTypeInfo.As.PROPERTY)
    @JsonSubTypes({ //设置对应子类的识别码值
            @JsonSubTypes.Type(value = LinkedHashMap.class, name = "TIndustryAndTypePO"),
            @JsonSubTypes.Type(value = TIndustryAndTypePO.class, name = "TIndustryAndTypePO")
    })
    private List<TIndustryAndTypePO> industry;
    /**
     * 自我介绍
     */
    @ApiModelProperty("自我介绍")
    @TableField(value = "man_message")
    private String manMessage;

    /**
     * 院校名称
     */
    @ApiModelProperty("院校名称")
    @TableField(value = "academy")
    private String academy;

    /**
     * 专业
     */
    @ApiModelProperty("专业")
    @TableField(value = "career_id")
    private String careerId;

    /**
     * 入学时间
     */
    @ApiModelProperty("入学时间")
    @TableField(value = "entrance_time")
    private LocalDateTime entranceTime;

    /**
     *  毕业时间
     */
    @ApiModelProperty("毕业时间")
    @TableField(value = "graduate_time")
    private LocalDateTime graduateTime;

    /**
     * 是否统招(0:统招 1:非统招)
     */
    @ApiModelProperty("是否统招(0:统招 1:非统招)")
    @TableField(value = "recruitment")
    private Integer recruitment;

    /**
     * 身份(1:职场人 0：在校生)
     */
    @ApiModelProperty("身份(1:职场人 0：在校生)")
    @TableField(value = "identity")
    private Integer identity;

    /**
     * 企业名称
     */
    @ApiModelProperty("企业名称")
    @TableField(value = "company_name")
    private String companyName;

    /**
     * 职位
     */
    @ApiModelProperty("职位")
    @TableField(value = "position")
    private String position;

    /**
     * 等级
     */
    @ApiModelProperty("等级")
    @TableField(value = "grade_id")
    private String gradeId;

    /**
     * 经验值
     */
    @ApiModelProperty("经验值")
    @TableField(value = "empirical_value")
    private Long empiricalValue;

    /**
     * 等级证书
     */
    @ApiModelProperty("等级证书")
    @TableField(value = "certificate")
    private String certificate;

    /**
     * 链接分享人
     */
    @ApiModelProperty("链接分享人")
    @TableField(value = "share_person")
    private String sharePerson;

    /**
     * 审核状态(0待审核1审核中2通过3未通过)
     */
    @ApiModelProperty("审核状态(0待审核1审核中2通过3未通过)")
    @TableField(value = "examine_status")
    private Integer examineStatus;

    /**
     * 审核建议
     */
    @ApiModelProperty("审核建议")
    @TableField(value = "examine_result")
    private String examineResult;

    /**
     * 账号状态(0正常1停用)
     */
    @ApiModelProperty("账号状态(0正常1停用)")
    @TableField(value = "status")
    private Integer status;

    /**
     * 猎企认证(0:未认证 1:申请中 2:已认证)
     */
    @ApiModelProperty("猎企认证(0:未认证 1:申请中 2:已认证)")
    @TableField(value = "administrator")
    private Integer administrator;

    /**
     * 父账号Id
     */
    @ApiModelProperty("父账号Id")
    @TableField(value = "parent_id")
    private String parentId;

    /**
     * 是否为子公司(0否1是)
     */
    @ApiModelProperty("是否为子公司(0否1是)")
    @TableField(value = "subsidiary")
    private String subsidiary;

    /**
     * 注册时间
     */
    @ApiModelProperty("注册时间")
    @TableField(value = "registrant_time")
    private LocalDateTime registrantTime;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 修改人
     */
    @ApiModelProperty("修改人")
    @TableField(value = "update_id")
    private String updateId;

    /**
     * 退出时间
     */
    @ApiModelProperty("退出时间")
    @TableField(value = "logout_time")
    private LocalDateTime logoutTime;

    /**
     * 登录时间
     */
    @ApiModelProperty("登录时间")
    @TableField(value = "login_time")
    private LocalDateTime loginTime;

    /**
     * 微信openid
     */
    @ApiModelProperty("微信openid")
    @TableField(value = "wx_openid")
    private String wxOpenid;

    /**
     * 逻辑删除
     */
    @ApiModelProperty("逻辑删除")
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
        TRecommend other = (TRecommend) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getLogo() == null ? other.getLogo() == null : this.getLogo().equals(other.getLogo()))
            && (this.getBirth() == null ? other.getBirth() == null : this.getBirth().equals(other.getBirth()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getHeadPath() == null ? other.getHeadPath() == null : this.getHeadPath().equals(other.getHeadPath()))
            && (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getCard() == null ? other.getCard() == null : this.getCard().equals(other.getCard()))
            && (this.getWechatId() == null ? other.getWechatId() == null : this.getWechatId().equals(other.getWechatId()))
            && (this.getCardFront() == null ? other.getCardFront() == null : this.getCardFront().equals(other.getCardFront()))
            && (this.getCardVerso() == null ? other.getCardVerso() == null : this.getCardVerso().equals(other.getCardVerso()))
            && (this.getCurrencyCount() == null ? other.getCurrencyCount() == null : this.getCurrencyCount().equals(other.getCurrencyCount()))
            && (this.getRecommendedCity() == null ? other.getRecommendedCity() == null : this.getRecommendedCity().equals(other.getRecommendedCity()))
            && (this.getIndustry() == null ? other.getIndustry() == null : this.getIndustry().equals(other.getIndustry()))
            && (this.getManMessage() == null ? other.getManMessage() == null : this.getManMessage().equals(other.getManMessage()))
            && (this.getAcademy() == null ? other.getAcademy() == null : this.getAcademy().equals(other.getAcademy()))
            && (this.getCareerId() == null ? other.getCareerId() == null : this.getCareerId().equals(other.getCareerId()))
            && (this.getEntranceTime() == null ? other.getEntranceTime() == null : this.getEntranceTime().equals(other.getEntranceTime()))
            && (this.getGraduateTime() == null ? other.getGraduateTime() == null : this.getGraduateTime().equals(other.getGraduateTime()))
            && (this.getRecruitment() == null ? other.getRecruitment() == null : this.getRecruitment().equals(other.getRecruitment()))
            && (this.getIdentity() == null ? other.getIdentity() == null : this.getIdentity().equals(other.getIdentity()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getGradeId() == null ? other.getGradeId() == null : this.getGradeId().equals(other.getGradeId()))
            && (this.getEmpiricalValue() == null ? other.getEmpiricalValue() == null : this.getEmpiricalValue().equals(other.getEmpiricalValue()))
            && (this.getCertificate() == null ? other.getCertificate() == null : this.getCertificate().equals(other.getCertificate()))
            && (this.getSharePerson() == null ? other.getSharePerson() == null : this.getSharePerson().equals(other.getSharePerson()))
            && (this.getExamineStatus() == null ? other.getExamineStatus() == null : this.getExamineStatus().equals(other.getExamineStatus()))
            && (this.getExamineResult() == null ? other.getExamineResult() == null : this.getExamineResult().equals(other.getExamineResult()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAdministrator() == null ? other.getAdministrator() == null : this.getAdministrator().equals(other.getAdministrator()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getSubsidiary() == null ? other.getSubsidiary() == null : this.getSubsidiary().equals(other.getSubsidiary()))
            && (this.getRegistrantTime() == null ? other.getRegistrantTime() == null : this.getRegistrantTime().equals(other.getRegistrantTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateId() == null ? other.getUpdateId() == null : this.getUpdateId().equals(other.getUpdateId()))
            && (this.getLogoutTime() == null ? other.getLogoutTime() == null : this.getLogoutTime().equals(other.getLogoutTime()))
            && (this.getLoginTime() == null ? other.getLoginTime() == null : this.getLoginTime().equals(other.getLoginTime()))
            && (this.getWxOpenid() == null ? other.getWxOpenid() == null : this.getWxOpenid().equals(other.getWxOpenid()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getLogo() == null) ? 0 : getLogo().hashCode());
        result = prime * result + ((getBirth() == null) ? 0 : getBirth().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getHeadPath() == null) ? 0 : getHeadPath().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getCard() == null) ? 0 : getCard().hashCode());
        result = prime * result + ((getWechatId() == null) ? 0 : getWechatId().hashCode());
        result = prime * result + ((getCardFront() == null) ? 0 : getCardFront().hashCode());
        result = prime * result + ((getCardVerso() == null) ? 0 : getCardVerso().hashCode());
        result = prime * result + ((getCurrencyCount() == null) ? 0 : getCurrencyCount().hashCode());
        result = prime * result + ((getRecommendedCity() == null) ? 0 : getRecommendedCity().hashCode());
        result = prime * result + ((getIndustry() == null) ? 0 : getIndustry().hashCode());
        result = prime * result + ((getManMessage() == null) ? 0 : getManMessage().hashCode());
        result = prime * result + ((getAcademy() == null) ? 0 : getAcademy().hashCode());
        result = prime * result + ((getCareerId() == null) ? 0 : getCareerId().hashCode());
        result = prime * result + ((getEntranceTime() == null) ? 0 : getEntranceTime().hashCode());
        result = prime * result + ((getGraduateTime() == null) ? 0 : getGraduateTime().hashCode());
        result = prime * result + ((getRecruitment() == null) ? 0 : getRecruitment().hashCode());
        result = prime * result + ((getIdentity() == null) ? 0 : getIdentity().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getGradeId() == null) ? 0 : getGradeId().hashCode());
        result = prime * result + ((getEmpiricalValue() == null) ? 0 : getEmpiricalValue().hashCode());
        result = prime * result + ((getCertificate() == null) ? 0 : getCertificate().hashCode());
        result = prime * result + ((getSharePerson() == null) ? 0 : getSharePerson().hashCode());
        result = prime * result + ((getExamineStatus() == null) ? 0 : getExamineStatus().hashCode());
        result = prime * result + ((getExamineResult() == null) ? 0 : getExamineResult().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAdministrator() == null) ? 0 : getAdministrator().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getSubsidiary() == null) ? 0 : getSubsidiary().hashCode());
        result = prime * result + ((getRegistrantTime() == null) ? 0 : getRegistrantTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateId() == null) ? 0 : getUpdateId().hashCode());
        result = prime * result + ((getLogoutTime() == null) ? 0 : getLogoutTime().hashCode());
        result = prime * result + ((getLoginTime() == null) ? 0 : getLoginTime().hashCode());
        result = prime * result + ((getWxOpenid() == null) ? 0 : getWxOpenid().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", loginName=").append(loginName);
        sb.append(", password=").append(password);
        sb.append(", logo=").append(logo);
        sb.append(", birth=").append(birth);
        sb.append(", age=").append(age);
        sb.append(", headPath=").append(headPath);
        sb.append(", education=").append(education);
        sb.append(", sex=").append(sex);
        sb.append(", phone=").append(phone);
        sb.append(", card=").append(card);
        sb.append(", wechatId=").append(wechatId);
        sb.append(", cardFront=").append(cardFront);
        sb.append(", cardVerso=").append(cardVerso);
        sb.append(", currencyCount=").append(currencyCount);
        sb.append(", recommendedCity=").append(recommendedCity);
        sb.append(", industry=").append(industry);
        sb.append(", manMessage=").append(manMessage);
        sb.append(", academy=").append(academy);
        sb.append(", careerId=").append(careerId);
        sb.append(", entranceTime=").append(entranceTime);
        sb.append(", graduateTime=").append(graduateTime);
        sb.append(", recruitment=").append(recruitment);
        sb.append(", identity=").append(identity);
        sb.append(", companyName=").append(companyName);
        sb.append(", position=").append(position);
        sb.append(", gradeId=").append(gradeId);
        sb.append(", empiricalValue=").append(empiricalValue);
        sb.append(", certificate=").append(certificate);
        sb.append(", sharePerson=").append(sharePerson);
        sb.append(", examineStatus=").append(examineStatus);
        sb.append(", examineResult=").append(examineResult);
        sb.append(", status=").append(status);
        sb.append(", administrator=").append(administrator);
        sb.append(", parentId=").append(parentId);
        sb.append(", subsidiary=").append(subsidiary);
        sb.append(", registrantTime=").append(registrantTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateId=").append(updateId);
        sb.append(", logoutTime=").append(logoutTime);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", wxOpenid=").append(wxOpenid);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}