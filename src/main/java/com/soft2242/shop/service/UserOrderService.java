package com.soft2242.shop.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft2242.shop.common.result.PageResult;
import com.soft2242.shop.entity.Goods;
import com.soft2242.shop.entity.UserOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soft2242.shop.query.CancelGoodsQuery;
import com.soft2242.shop.query.OrderPreQuery;
import com.soft2242.shop.VO.OrderDetailVO;
import com.soft2242.shop.VO.SubmitOrderVO;
import com.soft2242.shop.VO.UserOrderGoodsVO;
import com.soft2242.shop.VO.UserOrderVO;
import com.soft2242.shop.query.OrderQuery;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sunyu
 * @since 2023-11-08
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
    /**
     * 订单列表
     *
     * @param query
     * @return
     */
    PageResult<OrderDetailVO> getOrderList(OrderQuery query);
    /**
     * 取消订单
     *
     * @param query
     * @return
     */
    OrderDetailVO cancelOrder(CancelGoodsQuery query);
    /**
     * 删除订单
     *
     * @param ids
     */

    @Transactional(rollbackFor = Exception.class)
    void deleteOrder(List<Integer> ids, Integer userId);
    /**
     * 模拟发货
     *
     * @param id
     * @return
     */
    void consignOrder(Integer id);
    /**
     * 订单支付
     *
     * @param id
     */
    void payOrder(Integer id);
}
