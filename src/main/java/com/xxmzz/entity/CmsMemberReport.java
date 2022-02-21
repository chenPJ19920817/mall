package com.xxmzz.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户举报表
 * </p>
 *
 * @author 微信搜一搜：贺贺学编程
 * @since 2022-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CmsMemberReport implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 举报类型：0->商品评价；1->话题内容；2->用户评论
     */
    private Integer reportType;

    /**
     * 举报人
     */
    private String reportMemberName;

    private Date createTime;

    private String reportObject;

    /**
     * 举报状态：0->未处理；1->已处理
     */
    private Integer reportStatus;

    /**
     * 处理结果：0->无效；1->有效；2->恶意
     */
    private Integer handleStatus;

    private String note;


}
