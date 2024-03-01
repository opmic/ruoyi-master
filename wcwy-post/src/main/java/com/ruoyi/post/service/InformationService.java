package com.ruoyi.post.service;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.post.entity.Information;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【information(资讯)】的数据库操作Service
* @createDate 2023-04-26 11:57:03
*/

public interface InformationService extends IService<Information> {

    void del();
}
