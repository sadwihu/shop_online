package com.soft2242.shop.service;

import com.soft2242.shop.VO.OrderDetailVO;
import com.soft2242.shop.VO.UserOrderVO;
import com.soft2242.shop.entity.UserOrder;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
