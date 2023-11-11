package com.soft2242.shop.service;

import com.soft2242.shop.VO.CategoryVO;
import com.soft2242.shop.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ycshang
 * @since 2023-11-07
 */
public interface CategoryService extends IService<Category> {

    List<Category> getIndexCategoryList();

    List<CategoryVO> getCategoryList();
}
