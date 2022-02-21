package com.xxmzz.nosql.es.repository;

import com.xxmzz.nosql.es.entity.EsProduct;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 商品ES操作类
 * @author CHEN-PJ
 * @title: EsProductRepository
 * @projectName mall
 * @description: TODO
 * @date 2022/2/817:34
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long> {

}
