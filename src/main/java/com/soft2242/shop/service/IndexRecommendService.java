package com.soft2242.shop.service;

import com.soft2242.shop.VO.IndexRecommendVO;
import com.soft2242.shop.entity.IndexRecommend;
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
public interface IndexRecommendService extends IService<IndexRecommend> {

    List<IndexRecommendVO> getList();
}
