package com.hnzhrh.bee.domain.mapper;

import com.hnzhrh.bee.domain.entity.MarketQuote;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Collection;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author erpang
 * @since 2022-12-08
 */
public interface MarketQuoteMapper extends BaseMapper<MarketQuote> {
    /**
     * 批量插入
     * @param entities 插入的数据
     * @return 成功插入的数据
     */
    Integer insertBatchSomeColumn(Collection<MarketQuote> entities);
}
