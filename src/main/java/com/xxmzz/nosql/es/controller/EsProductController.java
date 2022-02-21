package com.xxmzz.nosql.es.controller;

import com.xxmzz.common.CommonResult;
import com.xxmzz.entity.PmsProduct;
import com.xxmzz.nosql.es.entity.EsProduct;
import com.xxmzz.nosql.es.service.EsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author CHEN-PJ
 * @title: EsProductController
 * @projectName mall
 * @description: TODO
 * @date 2022/2/815:32
 */
@RestController
@RequestMapping("/es/product")
public class EsProductController {

    @Autowired
    private EsProductService esProductService;

    @RequestMapping(value = "/importAll", method = RequestMethod.GET)
    public CommonResult<Integer> importAllList() {
        int count = esProductService.importAll();
        return CommonResult.success(count);
    }

    @RequestMapping(value = "/searchAll", method = RequestMethod.GET)
    public CommonResult<List<EsProduct>> searchAll() {
        return CommonResult.success(esProductService.searchAll());
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public CommonResult<List<EsProduct>> search(@RequestParam("key") String key) {
        return CommonResult.success(esProductService.search(key));
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    public void deleteAll() {
        esProductService.deleteAll();
    }
}
