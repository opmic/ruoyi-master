
package com.ruoyi.web.controller.post;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.config.IDGenerator;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.post.entity.Information;
import com.ruoyi.post.service.InformationService;
import com.ruoyi.post.vo.InformationVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;


/**
 * ClassName: InformationController
 * Description:
 * date: 2023/4/26 11:34
 *
 * @author tangzhuo
 * @since JDK 1.8
 */

@RestController
@RequestMapping("information")
@Api(tags = "资讯接口")
@DataSource(value = "slave")
public class InformationController {
    @Autowired
    private InformationService informationService;
    @Autowired
    private IDGenerator idGenerator;
    @PostMapping("/add")
    @ApiOperation("资讯添加/更新")
    public AjaxResult add(@Valid @RequestBody InformationVO informationVO) {
        Information information = new Information();
        BeanUtils.copyProperties(informationVO, information);
        if(StringUtils.isEmpty(informationVO.getInformationId())){
            information.setInformationId(idGenerator.generateCode("IFM"));
        }
        information.setCreateTime(LocalDateTime.now());
        boolean save = informationService.saveOrUpdate(information);
        if (save) {
            return AjaxResult.success("添加成功!");
        }
        return AjaxResult.error("添加失败!");
    }
    @GetMapping("/delete")
    @ApiOperation("删除")
    @ApiImplicitParam(name = "informationId", required = true,value = "资讯id")
    public AjaxResult delete(@RequestParam("informationId") String informationId) {
        boolean b = informationService.removeById(informationId);
        if(b){
            return AjaxResult.success();
        }
        return AjaxResult.error("删除失败!");
    }
    @GetMapping("/select")
    @ApiOperation("查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "theme", required = false, value = "话题(0:全部 1数据增长动态 2:职场资讯 3:公司动态)"),
            @ApiImplicitParam(name = "pageSize", required = false),
            @ApiImplicitParam(name = "pageNo", required = false)
    })

    public R<Information> select(@RequestParam(value = "theme",required = false) Integer theme, @RequestParam(value = "pageSize",required = false) Integer pageSize, @RequestParam(value = "pageNo",required = false) Integer pageNo) {
        if(pageNo==null ){
            pageNo=1;
        }
        if(pageSize ==null){
            pageSize=10;
        }
        Page<Information> iPage=new Page(pageNo,pageSize);
        QueryWrapper<Information> queryWrapper=new QueryWrapper();
        if(theme !=null && theme !=0){
            queryWrapper.eq("theme",theme);
        }
        queryWrapper.eq("deleted",0);
        queryWrapper.orderByDesc("create_time");
        IPage<Information> page = informationService.page(iPage, queryWrapper);
        return R.ok(page);
    /*    List<Information> list = informationService.list();
        return AjaxResult.success(list);*/

    }

}
