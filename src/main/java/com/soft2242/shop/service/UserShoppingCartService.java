package com.soft2242.shop.service;

import com.soft2242.shop.VO.CartGoodsVO;
import com.soft2242.shop.entity.UserShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soft2242.shop.query.CartQuery;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ycshang
 * @since 2023-11-07
 */
public interface UserShoppingCartService extends IService<UserShoppingCart> {
    CartGoodsVO addshopcart(CartQuery query);

    CartGoodsVO addshopCart(CartQuery query);

    List<CartGoodsVO> shopCartList(Integer userId);
}
