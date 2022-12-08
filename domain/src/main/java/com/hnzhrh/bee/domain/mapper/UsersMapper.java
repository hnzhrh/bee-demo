package com.hnzhrh.bee.domain.mapper;

import com.hnzhrh.bee.domain.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author erpang
 * @since 2022-12-07
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {
    Integer insertBatchSomeColumn(Collection<Users> entities);
}
