package com.ruoyi.company.query;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.query.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName: TJobhunterQuery
 * Description:
 * date: 2023/7/19 16:08
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@Data
@ApiModel("求职者查询")
public class TJobHunterQuery extends PageQuery {
    /**
     * 用户ID
     */
/*    @TableId(value = "user_id")
    private String userId;*/

    /**
     * 登录账号
     */
    @ApiModelProperty("关键字")
    private String keyword;

    @ApiModelProperty("所在企业")
    private String company;
    /**
     * 用户性别（0男 1女 2未知）
     */
    @ApiModelProperty("用户性别（0男 1女 2未知）")
    private Integer sex;

    @ApiModelProperty("注册开始时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date registerStartDate;

    @ApiModelProperty("注册结束时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date registerEndDate;

    @ApiModelProperty("职位类别")
    private String position;

    @ApiModelProperty("工作开始时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date workStartDate;

    @ApiModelProperty("工作结束时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date workEndDate;

    @ApiModelProperty("开始目前薪资")
    private Integer tartAnnualSalary;
    @ApiModelProperty("结束目前薪资")
    private Integer endAnnualSalary;


    @ApiModelProperty("所在行业")
    private String industry;
    @ApiModelProperty("现在所在城市")
    private String city;

    @ApiModelProperty("期望工作地")
    private String expectationCity;
    @ApiModelProperty("开始期望薪资")
    private Integer tartExpectationAnnualSalary;
    @ApiModelProperty("结束期望薪资")
    private Integer endExpectationAnnualSalary;
    /**
     * 政治面貌(1:中共党员 2中共预备党员 3:共青团员 4:群众 5 民主党派)
     */
/*
    @ApiModelProperty("政治面貌(1:中共党员 2中共预备党员 3:共青团员 4:群众 5 民主党派)")
    private Integer politicsStatus;
*/

    /**
     * 求职状态(1:实习 2:应届生 3:在职暂无跳槽 4:在职急求机会 5:在职看机会 6:离职看机会)
     */
    @ApiModelProperty("求职状态(1:实习 2:应届生 3:在职暂无跳槽 4:在职急求机会 5:在职看机会 6:离职看机会)")
    private Integer jobStatus;


    /**
     * 学历
     */
    @ApiModelProperty("学历(传数字)0:不限 1:初中及以下2:中专/中技3:高中4:大专5:本科6:硕士7:博士")
    private Integer education;
    /**
     * 年龄
     */
    @ApiModelProperty("开始年龄")
    private Integer beginAge;
    @ApiModelProperty("结束年龄")
    private Integer endAge;

/*    private Date beginAgeDate;

    private Date endAgeDate;*/
    /**
     * 帐号状态（0正常 1停用）
     */
    @ApiModelProperty("帐号状态（0正常 1停用）")
    private String status;

    /**
     * 审核状态(0待审核1审核通过2审核不通过)
     */
    @ApiModelProperty("审核状态(0待审核1审核通过2审核不通过 3异常简历)")
    private Integer examineStatus;

    @ApiModelProperty("分享来源(0自主注册1邀请注册)")
    private Integer source;
}
