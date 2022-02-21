package com.xxmzz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 专题商品关系表
 * </p>
 *
 * @author 微信搜一搜：贺贺学编程
 * @since 2022-02-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CmsSubjectProductRelation implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long subjectId;

    private Long productId;


}
