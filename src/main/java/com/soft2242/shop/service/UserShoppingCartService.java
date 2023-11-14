package com.soft2242.shop.service;

import com.soft2242.shop.VO.CartGoodsVO;
import com.soft2242.shop.entity.UserShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soft2242.shop.query.CartQuery;
import com.soft2242.shop.query.EditCartQuery;

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
    CartGoodsVO addShopCart(CartQuery query);


    List<CartGoodsVO> shopCartList(Integer userId);

    CartGoodsVO editCart(EditCartQuery query);

    //删除/清空购物车单品
    void removeCartGoods( Integer userId,List<Integer> ids);
    //购物车全选/取消全选

    void editCartSelected(Boolean selected, Integer userId);
}
