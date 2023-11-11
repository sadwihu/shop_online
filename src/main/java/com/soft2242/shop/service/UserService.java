package com.soft2242.shop.service;

import com.soft2242.shop.VO.LoginResultVO;
import com.soft2242.shop.VO.UserVO;
import com.soft2242.shop.common.exception.ServerException;
import com.soft2242.shop.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soft2242.shop.query.UserLoginQuery;
import com.soft2242.shop.VO.LoginResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sunyu
 * @since 2023-11-08
 */
public interface UserService extends IService<User> {
    LoginResultVO login(UserLoginQuery query);

    //    根据用户id 获取用户信息
//    @paran userId
//    @return
    User getUserInfo(Integer userId);

    UserVO editUserInfo(UserVO userVO);


//    @Override
//    public User getUserInfo(Integer userId) {
//        User user=baseMapper.selectById(userId);
//        if (user==null){
//            throw new ServerException("用户不存在");
//        }
//        return user;
//    }

}
