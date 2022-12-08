package com.hnzhrh.bee.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserDTO {
    @ApiModelProperty("用户姓名")
    private String userName;

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("电话")
    private String phone;
}
