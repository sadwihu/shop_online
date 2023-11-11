package com.soft2242.shop.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author wg-233
 * @since 2023-11-07
 */
@Getter
@Setter
@TableName("t_category")
@ApiModel(value = "Category对象", description = "")
public class Category {

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("分类名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("分类图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty("父级id")
    @TableField("parent_id")
    private Integer parentId;

    @ApiModelProperty("是否推荐(0-全推荐，1-推荐首页，2-推荐商品分类页)")
    @TableField("is_recommend")
    private Integer isRecommend;

    @ApiModelProperty("逻辑删除(0-未删除，1-已删除)")
    @TableField("delete_flag")
    @TableLogic
    @JsonIgnore
    private Integer deleteFlag;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonIgnore
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    @JsonIgnore
    private LocalDateTime updateTime;
}