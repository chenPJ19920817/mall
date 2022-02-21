package com.xxmzz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 优惠券使用、领取历史表
 * </p>
 *
 * @author 微信搜一搜：贺贺学编程
 * @since 2022-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SmsCouponHistory implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long couponId;

    private Long memberId;

    private String couponCode;

    /**
     * 领取人昵称
     */
    private String memberNickname;

    /**
     * 获取类型：0->后台赠送；1->主动获取
     */
    private Integer getType;

    private Date createTime;

    /**
     * 使用状态：0->未使用；1->已使用；2->已过期
     */
    private Integer useStatus;

    /**
     * 使用时间
     */
    private Date useTime;

    /**
     * 订单编号
     */
    private Long orderId;

    /**
     * 订单号码
     */
    private String orderSn;


}
