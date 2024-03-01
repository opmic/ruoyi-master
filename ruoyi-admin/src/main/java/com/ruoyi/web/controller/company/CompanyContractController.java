package com.ruoyi.web.controller.company;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.annotation.TransactionMulti;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.company.entity.TCompany;
import com.ruoyi.company.entity.TCompanyContract;
import com.ruoyi.company.entity.TCompanyContractAudit;
import com.ruoyi.company.service.TCompanyContractAuditService;
import com.ruoyi.company.service.TCompanyContractService;
import com.ruoyi.company.service.impl.TCompanyServiceImpl;
import com.ruoyi.company.vo.TCompanyContractVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.company.dto.TCompanyContractDto;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: 文君
 * @Date: 2023-07-03-14:33
 * @Description:岗位合同审核
 */
@Api(tags = "岗位合同审核")
@RestController
@RequestMapping("/CompanyContract")
@DataSource(value = "slave1")
public class CompanyContractController {
    @Autowired
    private TCompanyContractService tCompanyContractService;
    @Autowired
    private TCompanyServiceImpl tCompanyService;
    @Autowired
    private TCompanyContractAuditService tCompanyContractAuditService;

    //查询企业岗位发布审核信息
    @GetMapping
    @ApiOperation(value="人才推荐服务审核",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page", value="请求页数", required = true, dataType="Integer", paramType="query"),
            @ApiImplicitParam(name="pageSize", value="数据条数", required = true, dataType="Integer", paramType="query"),
            @ApiImplicitParam(name="audit", value="审核状态(0:审核中 1:审核成功 2:审核失败)", required = false, dataType="Integer", paramType="query"),
            @ApiImplicitParam(name="type", value="企业属性(0招聘企业 1猎头企业)", required = false, dataType="Integer", paramType="query"),
            @ApiImplicitParam(name="keyword", value="关键字", required = false)
    })
    @DataSource(value = "slave1")
    public R<TCompanyContractDto> getCompany(@RequestParam("page") int page,@RequestParam("pageSize") int pageSize,@RequestParam(value = "audit",required = false) Integer audit,@RequestParam(value = "type",required = false) Integer type,@RequestParam(value = "keyword",required = false) String keyword){

      IPage<TCompanyContractDto> tCompanyContractDtoIPage= tCompanyContractService.select( new Page(page, pageSize),audit,type,keyword);
        return R.ok(tCompanyContractDtoIPage);
/*        Page<TCompanyContract> pages = tCompanyContractService.pageInfo(page,pageSize,audit);
        Page<TCompanyContractDto> dtoPage=new Page<>();
        BeanUtils.copyProperties(pages,dtoPage,"records");
        List<TCompanyContract> records=pages.getRecords();
        List<TCompanyContractDto> list=records.stream().map((item)->{
            TCompanyContractDto dto=new TCompanyContractDto();
            BeanUtils.copyProperties(item,dto);
            TCompany tCompany = tCompanyService.listOne(item.getCreateId());
            if (tCompany !=null) {
                dto.setCompanyName(tCompany.getCompanyName());
                dto.setBusinessLicense(tCompany.getBusinessLicense());
                dto.setContactPhone(tCompany.getContactPhone());
                dto.setCustomLogo(tCompany.getCustomLogo());
                dto.setLogoPath(tCompany.getLogoPath());
                dto.setContactName(tCompany.getContactName());
                dto.setSex(tCompany.getSex());
            }
            return dto;
        }).collect(Collectors.toList());
        dtoPage.setRecords(list);
        return R.ok(dtoPage);
        */

    }


    @GetMapping("/selectId")
    @ApiOperation("通过合同id获取合同信息")
    @ApiImplicitParam(name="contractId", value="合同id", required = true)
    public R<TCompanyContractDto>  selectId(@RequestParam("contractId") String contractId){
        TCompanyContract byId = tCompanyContractService.getById(contractId);
        if(byId ==null){
            return R.fail("该合同不存在!");
        }
        TCompanyContractDto dto=new TCompanyContractDto();
        BeanUtils.copyProperties(byId,dto);
        TCompany byId1 = tCompanyService.getById(byId.getCreateId());

        BeanUtils.copyProperties(byId1,dto);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("contract_id",contractId);
        List list = tCompanyContractAuditService.list(queryWrapper);
        if(list.size()>0){
            dto.setTCompanyContractAuditList(list);
        }
        return R.ok(dto);
    }


    //修改企业岗位发布审核信息
    @PostMapping("/UpdatePost")
    @ApiOperation("修改企业岗位发布审核信息")
    @DataSource(value = "slave1")
    public R<TCompanyContractDto> UpdatePost(@RequestBody TCompanyContractDto tCompanyContractDto){
        LambdaUpdateWrapper<TCompany> wrapper=new LambdaUpdateWrapper<>();
        wrapper.eq(TCompany::getCompanyId,tCompanyContractDto.getCreateId());
        wrapper.set(TCompany::getCompanyName,tCompanyContractDto.getCompanyName());
        wrapper.set(TCompany::getBusinessLicense,tCompanyContractDto.getBusinessLicense());
        wrapper.set(TCompany::getContactPhone,tCompanyContractDto.getContactPhone());
        wrapper.set(TCompany::getCustomLogo,tCompanyContractDto.getCustomLogo());
        wrapper.set(TCompany::getLogoPath,tCompanyContractDto.getLogoPath());
        wrapper.set(TCompany::getContactName,tCompanyContractDto.getContactName());
        wrapper.set(TCompany::getSex,tCompanyContractDto.getSex());
        if (!StringUtils.isEmpty(tCompanyContractDto.getCreateId() )){
            tCompanyService.update(wrapper);
            boolean b = tCompanyContractService.updateById(tCompanyContractDto);
            if (b){
                return R.ok();
            }else {
                return R.fail("操作失败");
            }
        }else {
            return R.fail("创建id不能为空");
        }
    }


    @PostMapping("/auditContract")
    @ApiOperation("审核合同")
    @DataSource(value = "slave1")
    @TransactionMulti(value = {"slave1"})
    public R auditContract(@Valid @RequestBody TCompanyContractVO tCompanyContractVO){
       if( tCompanyContractVO.getAuditContract()==1){
           if(StringUtils.isEmpty(tCompanyContractVO.getAuditCause())){
               return R.fail("请填写不通过原因！");
           }
       }
        TCompanyContract byId = tCompanyContractService.getById(tCompanyContractVO.getContractId());
        if(byId==null){
            return R.fail("该合同不存在！");
        }
        UpdateWrapper updateWrapper=new UpdateWrapper();
        updateWrapper.eq("contract_id",tCompanyContractVO.getContractId());
        if( tCompanyContractVO.getAuditContract()==1){
            updateWrapper.set("audit_contract",2);
        }else {
            if(tCompanyContractVO.getContractDate()==null){
                return R.fail("合同有效期不能为空！");
            }
            updateWrapper.set("audit_contract",1);
            updateWrapper.set("audit_time",LocalDateTime.now());
            updateWrapper.set("contract_date",tCompanyContractVO.getContractDate());
            // updateWrapper.set("audit_cause",tCompanyContractVO.getAuditCause());
        }
        boolean update = tCompanyContractService.update(updateWrapper);
        if(update){
            if( tCompanyContractVO.getAuditContract()==1){
                TCompanyContractAudit tCompanyContractAudit=new TCompanyContractAudit();
                tCompanyContractAudit.setAuditCause(tCompanyContractVO.getAuditCause());
                tCompanyContractAudit.setAuditTime(LocalDateTime.now());
                tCompanyContractAudit.setContractId(tCompanyContractVO.getContractId());
                tCompanyContractAudit.setPhone(tCompanyContractVO.getPhone());
                tCompanyContractAudit.setAuditContract(tCompanyContractVO.getAuditContract());
                boolean save = tCompanyContractAuditService.save(tCompanyContractAudit);
                if(save){
                    return R.ok("操作成功！");
                }
            }
            return R.ok("操作成功！");
        }
        return R.fail("操作失败!");
    }

}
