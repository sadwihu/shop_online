package com.soft2242.shop.service;

import com.soft2242.shop.VO.OrderDetailVO;
import com.soft2242.shop.VO.SubmitOrderVO;
import com.soft2242.shop.VO.UserOrderVO;
import com.soft2242.shop.entity.UserOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soft2242.shop.query.OrderPreQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ycshang
 * @since 2023-11-07
 */
public interface UserOrderService extends IService<UserOrder> {
    /**
     * 提交订单
     *
     * @return
     */
    Integer addGoodsOrder(UserOrderVO orderVO);
    /**
     * 订单详情
     *
     * @param id
     * @return
     */
    OrderDetailVO getOrderDetail(Integer id);
    /**
     * 填写订单 - 获取预付订单
     *
     * @param userId
     * @return
     */
    SubmitOrderVO getPreOrderDetail(Integer userId);
    /**
     * 填写订单 - 获取立即购买订单
     *
     * @param query
     * @return
     */
    SubmitOrderVO getPreNowOrderDetail(OrderPreQuery query);
    /**
     * 填写订单 - 获取再次购买订单
     *
     * @param id
     * @return
     */
    SubmitOrderVO getRepurchaseOrderDetail(Integer id);
}
