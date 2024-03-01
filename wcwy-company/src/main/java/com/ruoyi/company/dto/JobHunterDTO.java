package com.ruoyi.company.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.ruoyi.company.po.CityPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 求职者用户表
 * @TableName t_jobhunter
 */

@Data
@ApiModel("求职者用户表")
public class JobHunterDTO implements Serializable {
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private String userId;
    @ApiModelProperty("简历id")
    private String resumeId;
    /**
     * 登录账号
     */
    @ApiModelProperty("登录账号")
    private String loginName;


    /**
     * 用户姓名
     */
    @ApiModelProperty("用户姓名")
    private String userName;


    /**
     * 头像路径
     */
    @ApiModelProperty("头像路径")
    private String avatar;

    /**
     * 用户性别（0男 1女 2未知）
     */
    @ApiModelProperty("用户性别（0男 1女 2未知）")
    private Integer sex;


    /**
     * 学历
     */
    @ApiModelProperty("学历")
    private String education;



    /**
     * 目前年薪
     */
    @ApiModelProperty("目前年薪")
    private BigDecimal currentSalary;



    /**
     * 联系电话
     */
    @ApiModelProperty("联系电话")
    private String phone;

    /**
     * 生日
     */
    @ApiModelProperty("生日")
    private LocalDate birthday;

    /**
     * 参加工作时间
     */
    @ApiModelProperty("参加工作时间")
    private LocalDate workTime;



    /**
     * 帐号状态（0正常 1停用）
     */
    @ApiModelProperty("帐号状态（0正常 1停用）")
    private String status;







    /**
     * 简历审核状态(0待审核1审核通过2审核不通过)
     */
    @ApiModelProperty("简历审核状态(0待审核1审核通过2审核不通过)")
    private Integer resumeExamineStatus;

    /**
     * 审核意见
     */
    @ApiModelProperty("审核意见")
    private String resumeExamineResult;

    /**
     * 分享注册人
     */
    @ApiModelProperty("推荐官id")
    private String sharePerson;
    @ApiModelProperty("推荐官姓名")
    private String sharePersonName;
    @ApiModelProperty("推荐官头像")
    private String sharePersonAvatar;

    @ApiModelProperty(value ="公司名称")
    private String companyName;
    /**
     * 职位名称
     */
    @ApiModelProperty(value ="职位名称")
    private String positionName;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("来源(0平台 1分享注册 2新增人才 )")
    private Integer source;
}