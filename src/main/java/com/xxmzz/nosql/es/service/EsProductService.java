package com.xxmzz.nosql.es.service;

import com.xxmzz.nosql.es.entity.EsProduct;

import java.util.List;

/**
 * @author CHEN-PJ
 * @title: EsProductService
 * @projectName mall
 * @description: TODO
 * @date 2022/2/815:26
 */
public interface EsProductService {
    /**
     * 从数据库中导入所有商品到ES
     */
    int importAll();

    /**
     *
     * @return
     */
    List<EsProduct> searchAll();


    List<EsProduct> search(String key);


    void deleteAll();

    /**
     * 根据id删除商品
     */
    void delete(Long id);

    /**
     * 根据id创建商品
     */
    EsProduct create(Long id);

    /**
     * 批量删除商品
     */
    void delete(List<Long> ids);



    /**
     * 根据关键字搜索名称或者副标题
     */
    //Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);
}
