package com.ruoyi.company.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.CooComment;
import com.ruoyi.company.service.CooCommentService;
import com.ruoyi.company.mapper.CooCommentMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【coo_comment】的数据库操作Service实现
* @createDate 2024-01-30 08:10:20
*/
@Service
@DataSource(value = "slave1")
public class CooCommentServiceImpl extends ServiceImpl<CooCommentMapper, CooComment>
    implements CooCommentService{

}



