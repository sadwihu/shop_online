package com.soft2242.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft2242.shop.VO.GoodsVO;
import com.soft2242.shop.VO.IndexTabGoodsVO;
import com.soft2242.shop.VO.IndexTabRecommendVO;
import com.soft2242.shop.VO.RecommendGoodsVO;
import com.soft2242.shop.common.exception.ServerException;
import com.soft2242.shop.common.result.PageResult;
import com.soft2242.shop.convert.GoodsConvert;
import com.soft2242.shop.entity.*;
import com.soft2242.shop.mapper.*;
import com.soft2242.shop.query.Query;
import com.soft2242.shop.query.RecommendByTabGoodsQuery;
import com.soft2242.shop.service.GoodsService;
import com.soft2242.shop.VO.GoodsVO;
import com.soft2242.shop.VO.IndexTabGoodsVO;
import com.soft2242.shop.VO.IndexTabRecommendVO;
import com.soft2242.shop.VO.RecommendGoodsVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wg-233
 * @since 2023-11-07
 */
@Service
@AllArgsConstructor
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    private IndexRecommendMapper indexRecommendMapper;
    private IndexRecommendTabMapper indexRecommendTabMapper;
    private GoodsDetailMapper goodsDetailMapper;
    private GoodsSpecificationMapper goodsSpecificationMapper;
    private GoodsSpecificationDetailMapper goodsSpecificationDetailMapper;
    @Override
    public IndexTabRecommendVO getTabRecommendGoodsByTabId(RecommendByTabGoodsQuery query) {
        IndexRecommend indexRecommend = indexRecommendMapper.selectById(query.getSubType());
        if(indexRecommend == null){
            throw new ServerException("推荐分类不存在");
        }
        LambdaQueryWrapper<IndexRecommendTab> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(IndexRecommendTab::getRecommendId,indexRecommend.getId());
        List<IndexRecommendTab> tabList = indexRecommendTabMapper.selectList(wrapper);
        if (tabList.size() == 0){
            throw new ServerException("该分类下没有推荐商品");
        }
        ArrayList<IndexTabGoodsVO> list = new ArrayList<>();
        for (IndexRecommendTab item : tabList) {
            IndexTabGoodsVO tabGoods = new IndexTabGoodsVO();
            tabGoods.setId(item.getId());
            tabGoods.setName(item.getName());
            Page<Goods> page = new Page<>(query.getPage(), query.getPageSize());
            Page<Goods> goodsPage = baseMapper.selectPage(page, new LambdaQueryWrapper<Goods>().eq(Goods::getTabId, item.getId()));
            List<RecommendGoodsVO> goodsList = GoodsConvert.INSTANCE.convertToRecommendGoodsVOList(goodsPage.getRecords());
            PageResult<RecommendGoodsVO> result = new PageResult<>(page.getTotal(), query.getPageSize(), query.getPage(), page.getPages(), goodsList);
            tabGoods.setGoodsItems(result);
            list.add(tabGoods);
        }
        IndexTabRecommendVO recommendVO = new IndexTabRecommendVO();
        recommendVO.setId(indexRecommend.getId());
        recommendVO.setName(indexRecommend.getName());
        recommendVO.setCover(indexRecommend.getCover());
        recommendVO.setSubTypes(list);
        return recommendVO;
    }

    @Override
    public PageResult<RecommendGoodsVO> getRecommendGoodsByPage(Query query) {
        Page<Goods> page = new Page<>(query.getPage(), query.getPageSize());
        Page<Goods> goodsPage = baseMapper.selectPage(page, null);
        List<RecommendGoodsVO> result = GoodsConvert.INSTANCE.convertToRecommendGoodsVOList(goodsPage.getRecords());
        return new PageResult<>(page.getTotal(), query.getPageSize(), query.getPage(), page.getPages(), result);
    }

    @Override
    public GoodsVO getGoodsDetail(Integer id) {
        Goods goods = baseMapper.selectById(id);
        if (goods == null){
            throw new ServerException("商品不存在");
        }
        GoodsVO goodsVO = GoodsConvert.INSTANCE.convertToGoodsVO(goods);
        List<GoodsDetail> goodsDetails = goodsDetailMapper.selectList(new LambdaQueryWrapper<GoodsDetail>().eq(GoodsDetail::getGoodsId, goods.getId()));
        goodsVO.setProperties(goodsDetails);
        List<GoodsSpecification> specificationList = goodsSpecificationMapper.selectList(new LambdaQueryWrapper<GoodsSpecification>().eq(GoodsSpecification::getGoodsId, goods.getId()));
        goodsVO.setSpecs(specificationList);
        List<GoodsSpecificationDetail> goodsSpecificationDetails = goodsSpecificationDetailMapper.selectList(new LambdaQueryWrapper<GoodsSpecificationDetail>().eq(GoodsSpecificationDetail::getGoodsId, goods.getId()));
        goodsVO.setSkus(goodsSpecificationDetails);
        List<Goods> goodsList = baseMapper.selectList(new LambdaQueryWrapper<Goods>().eq(Goods::getId, goods.getId()).eq(Goods::getCategoryId, goods.getCategoryId()).ne(Goods::getId, goods.getId()));
        List<RecommendGoodsVO> goodsVOList = GoodsConvert.INSTANCE.convertToRecommendGoodsVOList(goodsList);
        goodsVO.setSimilarProducts(goodsVOList);
        return goodsVO;
    }
}