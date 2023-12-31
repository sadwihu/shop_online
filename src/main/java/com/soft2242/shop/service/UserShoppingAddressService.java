package com.soft2242.shop.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.soft2242.shop.VO.AddressVO;
import com.soft2242.shop.entity.UserShippingAddress;


import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *

 * @since 2023-11-07
 */
public interface UserShoppingAddressService extends IService<UserShippingAddress> {
    Integer saveShoppingAddress(AddressVO addressVO);
    Integer editShoppingAddress(AddressVO addressVO);
    List<AddressVO> getList(Integer userId);
    /**
     *收货地址详情
     *
     * @param id
     * @return
     */
    AddressVO getAddressInfo(Integer id);

    /**
     * 删除收货地址
     *
     * @param id
     */
    void removeShippingAddress(Integer id);
     //添加购物车

}