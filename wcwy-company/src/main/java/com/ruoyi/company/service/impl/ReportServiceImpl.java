package com.ruoyi.company.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.company.entity.Report;
import com.ruoyi.company.service.ReportService;
import com.ruoyi.company.mapper.ReportMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【report(举报)】的数据库操作Service实现
* @createDate 2023-09-21 09:29:12
*/
@Service
@DataSource(value ="slave1")
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Report>
    implements ReportService{

}




