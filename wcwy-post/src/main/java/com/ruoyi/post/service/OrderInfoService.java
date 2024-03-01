package com.ruoyi.post.service;

import com.ruoyi.post.entity.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【order_info(岗位订单表)】的数据库操作Service
* @createDate 2023-07-17 15:21:34
*/
public interface OrderInfoService extends IService<OrderInfo> {

    OrderInfo getId(String orderId);

    boolean updateId(OrderInfo byId);
}
