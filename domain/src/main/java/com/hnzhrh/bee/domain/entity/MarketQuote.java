package com.hnzhrh.bee.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author erpang
 * @since 2022-12-08
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("market_quote")
public class MarketQuote implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String curveName;

    private String instrumentType;

    private String instrumentName;

    private String tenor;

    private String quote;

    private String maturityDate;

    private String mHPerDate;

    /**
     * 逻辑删除 1-已删除 0-未删除
     */
    private Integer isDeleted;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreated;

    private LocalDateTime gmtModified;


}
