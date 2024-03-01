package com.ruoyi.common.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

/**
 * ClassName: PageQuery
 * Description:
 * date: 2023/6/27 19:38
 *
 * @author tangzhuo
 * @since JDK 1.8
 */
@Data
public class PageQuery  {

    private Long pageSize = 10L;

    private Long pageNum = 1L;

    public IPage createPage() {
        return new Page(this.pageNum, this.pageSize);
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ApiModelProperty("请求参数")
    private Map<String, Object> params;
}
