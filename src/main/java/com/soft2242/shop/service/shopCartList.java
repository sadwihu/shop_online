package com.soft2242.shop.service;

import com.soft2242.shop.VO.CartGoodsVO;
import com.soft2242.shop.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static com.soft2242.shop.common.utils.ObtainUserIdUtils.getUserId;

public interface shopCartList {
    List<CartGoodsVO> shopcartList(Integer userId);
    @Operation(summary = "获取购物车列表")
    @GetMapping("list")
    public default Result<List<CartGoodsVO>> shopCartList(HttpServletRequest request) {
        Integer userId = getUserId(request);
        List<CartGoodsVO> list = userShoppingCartService.shopCartList(userId);
        return Result.ok(list);
    }

}
