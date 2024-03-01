package com.ruoyi.post.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.post.entity.Information;
import com.ruoyi.post.service.InformationService;
import com.ruoyi.post.mapper.InformationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author Administrator
* @description 针对表【information(资讯)】的数据库操作Service实现
* @createDate 2023-04-26 11:57:03
*/
@Service
@DataSource("slave")
public class InformationServiceImpl extends ServiceImpl<InformationMapper, Information>
    implements InformationService{

    @Override
    @Transactional(rollbackFor = Exception.class)
    @DataSource("slave")
    public void del() {
        List<Information> list = this.list();
        Information information = list.get(0);
        this.removeById(information.getInformationId());

    }
}




