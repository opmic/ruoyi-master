package com.ruoyi.web.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;

import com.alibaba.fastjson2.JSONObject;
import com.jthinking.common.util.ip.IPInfo;
import com.jthinking.common.util.ip.IPInfoUtils;
import com.ruoyi.common.utils.ip.IpUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.lionsoul.ip2region.xdb.Searcher;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ClassName: Test
 * Description:
 * date: 2023/8/7 8:59
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
public class Test {
    /**
     * 字符常量0
     */
    private static final String ZERO="0";
    public static void main(String[] args) throws UnknownHostException {
        String ip = "240e:3b4:d0d1:7e0:d0cb:da09:da41:c707";
        String ip4="14.219.241.123";
        for (int i = 0; i < 1000; i++) {
            IPInfo ipInfo = IPInfoUtils.getIpInfo(ip4);
            System.out.println(ipInfo.getCountry()); // 国家中文名称
            System.out.println(ipInfo.getProvince()); // 中国省份中文名称
            System.out.println(ipInfo.getAddress()); // 详细地址
            System.out.println(ipInfo.getIsp()); // 互联网服务提供商
            System.out.println(ipInfo.isOverseas()); // 是否是国外
            System.out.println(ipInfo.getLat()); // 纬度
            System.out.println(ipInfo.getLng()); // 经度
        }


    }


/*    public static void main(String[] args) {
        String ip="240e:3b4:d0d1:7e0:d0cb:da09:da41:c707";
        System.out.println(ip.substring(0, ip.length()-1));
        IpLocation location = getLocation(ip);
        System.out.println(location);
    }*/
    public static IpLocation getLocation(String ip) {
        IpLocation location = new IpLocation();
        location.setIp(ip);
        try (InputStream inputStream = IpUtils.class.getResourceAsStream("/ip2region.xdb");) {
            byte[] bytes = IoUtil.readBytes(inputStream);
            Searcher searcher = Searcher.newWithBuffer(bytes);
            String region = searcher.search(ip);
            if (StrUtil.isAllNotBlank(region)) {
                // xdb返回格式 国家|区域|省份|城市|ISP，
                // 只有中国的数据绝大部分精确到了城市，其他国家部分数据只能定位到国家，后前的选项全部是0
                String[] result = region.split("\\|");
                location.setCountry(ZERO.equals(result[0])?StrUtil.EMPTY:result[0]);
                location.setProvince(ZERO.equals(result[2])?StrUtil.EMPTY:result[2]);
                location.setCity(ZERO.equals(result[3])?StrUtil.EMPTY:result[3]);
                location.setIsp(ZERO.equals(result[4])?StrUtil.EMPTY:result[4]);
            }
            searcher.close();
        } catch (Exception e) {
            /*log.error("ip地址解析异常,error:{}",e);*/
            System.out.println(e);
            return location;
        }
        return location;
    }

}
