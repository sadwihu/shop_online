package com.soft2242.shop.mapper;

import com.soft2242.shop.VO.CartGoodsVO;
import com.soft2242.shop.entity.UserShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ycshang
 * @since 2023-11-07
 */
public interface UserShoppingCartMapper extends BaseMapper<UserShoppingCart> {
    //查询购物车信息
    List<CartGoodsVO> getCartGoodsInfo(@Param("id") Integer id);

}
