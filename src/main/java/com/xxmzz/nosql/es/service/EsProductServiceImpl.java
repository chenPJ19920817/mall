package com.xxmzz.nosql.es.service;

import cn.hutool.core.util.PageUtil;
import com.alibaba.druid.sql.PagerUtils;
import com.xxmzz.entity.PmsProduct;
import com.xxmzz.nosql.es.entity.EsProduct;
import com.xxmzz.nosql.es.repository.EsProductRepository;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author CHEN-PJ
 * @title: EsProductServiceImpl
 * @projectName mall
 * @description: TODO
 * @date 2022/2/815:27
 */
@Service
public class EsProductServiceImpl implements EsProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EsProductServiceImpl.class);

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private EsProductRepository esProductRepository;

    /**
     * 从数据库中导入所有商品到ES
     */
    @Override
    public int importAll() {
        List<PmsProduct> pmsProducts = new PmsProduct().selectAll();
        List<EsProduct> esProducts = new ArrayList<>();
        pmsProducts.forEach(obj->{
            EsProduct esProduct = new EsProduct();
            BeanUtils.copyProperties(obj,esProduct);
            esProducts.add(esProduct);
        });
        esProductRepository.saveAll(esProducts);
        return pmsProducts.size();
    }

    /**
     * @return
     */
    @Override
    public List<EsProduct> searchAll() {
        Iterable<EsProduct> all = esProductRepository.findAll();
        Iterator<EsProduct> iterator = all.iterator();
        List<EsProduct> esProductList = new ArrayList<>();
        while (iterator.hasNext()) {
            esProductList.add(iterator.next());
        }
        return esProductList;
    }

    @Override
    public List<EsProduct> search(String key) {
        //Pageable pageable = PageRequest.of(1, 10);

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //精确匹配
        //boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("name",key));
        //分词匹配
        boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("name",key));

        SortBuilder sortBuilder = SortBuilders.fieldSort("sort");
        sortBuilder.order(SortOrder.ASC);
        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                //.withSort(sortBuilder)
                //.addAggregation(builder)
                //.withPageable(pageable)
                .build();

        SearchHits<EsProduct> search = elasticsearchRestTemplate.search(build, EsProduct.class);
        Iterator<SearchHit<EsProduct>> iterator = search.getSearchHits().iterator();
        List<EsProduct> result = new ArrayList<>(search.getSearchHits().size());
        while (iterator.hasNext()) {
            SearchHit<EsProduct> next = iterator.next();
            EsProduct content = next.getContent();
            result.add(content);
        }
        return result;
    }

    @Override
    public void deleteAll() {
        esProductRepository.deleteAll();
    }

    /**
     * 根据id删除商品
     *
     * @param id
     */
    @Override
    public void delete(Long id) {

    }

    /**
     * 根据id创建商品
     *
     * @param id
     */
    @Override
    public EsProduct create(Long id) {
        return null;
    }

    /**
     * 批量删除商品
     *
     * @param ids
     */
    @Override
    public void delete(List<Long> ids) {

    }


}
