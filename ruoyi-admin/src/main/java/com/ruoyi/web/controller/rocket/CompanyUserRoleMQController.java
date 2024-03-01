package com.ruoyi.web.controller.rocket;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.mq.CompanyUserRoleMQ;
import com.ruoyi.framework.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: CompanyUserRoleMQController
 * Description:
 * date: 2023/4/28 11:25
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/companyUserRoleMQ")
@Api(tags ="企业权限mq检查接口")
public class CompanyUserRoleMQController {
    @Resource
    private RedisUtils redisUtils;

    @GetMapping("/select")
    @ApiOperation("获取权限未消费的值")
    public R<Set> selectConsumer(){
        Set<Object> objects = redisUtils.acceptSet(CompanyUserRoleMQ.GROUP);
        return R.ok(objects);
    }
    @GetMapping("/selectProduce")
    @ApiOperation("获取权限未消费的值")
    public R<Set> selectProduce(){
        Set<Object> objects = redisUtils.sendSet(CompanyUserRoleMQ.TOPIC);
        return R.ok(objects);
    }
}
