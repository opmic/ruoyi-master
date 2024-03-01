package com.ruoyi.web.controller.company;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.company.dto.BankCardDTO;
import com.ruoyi.company.entity.BankCard;
import com.ruoyi.company.query.BankCardQuery;
import com.ruoyi.company.service.BankCardService;
import com.ruoyi.company.vo.BankCardVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * ClassName: BankCardController
 * Description:
 * date: 2023/8/18 9:23
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@Api(tags = "实名认证接口")
@RestController
@RequestMapping("/CompanyContract")
@DataSource(value = "slave1")
public class BankCardController {

    @Autowired
    private BankCardService bankCardService;

    @PostMapping("/page")
    @ApiOperation("查询实名申请")
    @Log(title = "查询实名申请", businessType = BusinessType.OTHER)
    public R<BankCardDTO> page(@RequestBody BankCardQuery bankCardQuery){
      IPage<BankCardDTO> iPage= bankCardService.selectPage(bankCardQuery);
      return R.ok(iPage);
    }


    @PostMapping("/audit")
    @ApiOperation("审核接口")
    @Log(title = "审核接口", businessType = BusinessType.UPDATE)
    @DataSource(value = "slave1")
    public R audit(@Valid @RequestBody BankCardVO bankCardVO){
        if(bankCardVO.getAudit()==2 && StringUtils.isEmpty(bankCardVO.getAuditCause())){
            return R.fail("不通过原因必填！");
        }
        LambdaUpdateWrapper<BankCard> lambdaUpdateWrapper=new LambdaUpdateWrapper();
        lambdaUpdateWrapper.eq(BankCard::getId,bankCardVO.getId());
        lambdaUpdateWrapper.set(BankCard::getAudit,bankCardVO.getAudit());
        lambdaUpdateWrapper.set(BankCard::getAuditCause,bankCardVO.getAuditCause());
        boolean update = bankCardService.update(lambdaUpdateWrapper);
        if(update){
            return R.ok();
        }
        return R.fail();
    }
}
