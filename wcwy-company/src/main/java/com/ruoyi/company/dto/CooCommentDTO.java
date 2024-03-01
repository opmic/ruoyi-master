package com.ruoyi.company.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.company.entity.CooComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName: CooCommentDTO
 * Description:
 * date: 2024/1/30 11:51
 *
 * @author tangzhuo
 * @since JDK 1.8
 */

@Data
public class CooCommentDTO extends CooComment {

    @ApiModelProperty("姓名")
    private String username;
    @ApiModelProperty("头像地址")
    private String headPath;
}
