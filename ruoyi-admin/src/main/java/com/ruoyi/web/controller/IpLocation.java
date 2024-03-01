package com.ruoyi.web.controller;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: IpLocation
 * Description:
 * date: 2023/8/7 8:59
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@Data
public class IpLocation implements Serializable {

    @ApiModelProperty("ip地址")
    private String ip;

    @ApiModelProperty("国家")
    private String country;

    @ApiModelProperty("省")
    private String province;

    @ApiModelProperty("省")
    private String city;

    @ApiModelProperty("服务商")
    private String isp;
}

