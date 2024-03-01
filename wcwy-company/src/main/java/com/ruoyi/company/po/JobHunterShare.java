package com.ruoyi.company.po;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ClassName: JobHunterShare
 * Description:
 * date: 2023/4/10 15:40
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@Data
@ApiModel(value = "分享管理求职者")
public class JobHunterShare {
    /**
     * 用户ID
     */
    @ApiModelProperty(value ="用户ID")
    private String userId;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value ="用户姓名" )
    private String userName;

    /**
     * 头像路径
     */
    @ApiModelProperty(value ="头像路径" )
    private String avatar;

    /**
     * 用户性别（0男 1女 2未知）
     */
    @ApiModelProperty(value ="用户性别（0男 1女 2未知）" )
    private Integer sex;

    /**
     * 学历
     */
    @ApiModelProperty(value ="学历" )
    private String education;

    /**
     * 创建时间
     */
    @ApiModelProperty(value ="创建时间" )
    private LocalDateTime createTime;

    @ApiModelProperty(value ="生日" )
    private LocalDate birthday;

    @ApiModelProperty(value ="参加工作时间" )
    private LocalDate workTime;

    @ApiModelProperty(value = "下载次数")
    private Long download;

    @ApiModelProperty(value = "下载总费用")
    private BigDecimal costs;
    @ApiModelProperty(value = "收益")
    private BigDecimal earnings;

}
