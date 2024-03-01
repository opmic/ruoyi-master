package com.ruoyi.post.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.post.entity.OrderInfo;
import com.ruoyi.post.service.OrderInfoService;
import com.ruoyi.post.mapper.OrderInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【order_info(岗位订单表)】的数据库操作Service实现
* @createDate 2023-07-17 15:21:34
*/
@Service
@DataSource("slave")
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo>
    implements OrderInfoService{

    @Override
    public OrderInfo getId(String orderId) {
        return this.getById(orderId);
    }

    @Override
    public boolean updateId(OrderInfo byId) {
        return this.updateById(byId);
    }
}




