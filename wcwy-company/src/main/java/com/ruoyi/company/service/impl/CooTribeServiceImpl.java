package com.ruoyi.company.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.CooTribe;
import com.ruoyi.company.service.CooTribeService;
import com.ruoyi.company.mapper.CooTribeMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【coo_tribe】的数据库操作Service实现
* @createDate 2024-01-30 08:10:14
*/
@Service
@DataSource(value = "slave1")
public class CooTribeServiceImpl extends ServiceImpl<CooTribeMapper, CooTribe>
    implements CooTribeService{

}




