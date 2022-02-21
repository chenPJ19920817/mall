package com.xxmzz.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 运费模版
 * </p>
 *
 * @author 微信搜一搜：贺贺学编程
 * @since 2022-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsFeightTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    /**
     * 计费类型:0->按重量；1->按件数
     */
    private Integer chargeType;

    /**
     * 首重kg
     */
    private BigDecimal firstWeight;

    /**
     * 首费（元）
     */
    private BigDecimal firstFee;

    private BigDecimal continueWeight;

    private BigDecimal continmeFee;

    /**
     * 目的地（省、市）
     */
    private String dest;


}
