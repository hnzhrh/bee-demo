package com.hnzhrh.bee.demo.dto;

import com.hnzhrh.bee.common.dto.Query;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryRequest extends Query {
    private String userId;
}
