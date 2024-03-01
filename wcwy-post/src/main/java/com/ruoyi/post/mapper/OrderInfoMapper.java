package com.ruoyi.post.mapper;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.post.entity.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【order_info(岗位订单表)】的数据库操作Mapper
* @createDate 2023-07-17 15:21:34
* @Entity com.ruoyi.post.entity.OrderInfo
*/
@Mapper
@DataSource(value ="slave")
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

}




