package com.hnzhrh.bee.web;

import com.hnzhrh.bee.demo.api.UserServiceI;
import com.hnzhrh.bee.demo.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "用户服务")
@RestController("/users")
public class UserController {
    @Resource
    private UserServiceI userServiceI;

    @ApiOperation(("根据UserId查询用户"))
    @GetMapping("/v1/query/{userId}")
    public UserDTO query(@PathVariable String userId){
        return userServiceI.query(userId);
    }

    @ApiOperation(("根据UserId删除用户"))
    @GetMapping("/v1/delete/{userId}")
    public String delete(@PathVariable String userId) {
        return userServiceI.delete(userId);
    }

    @ApiOperation(("批量插入"))
    @GetMapping("/v1/batch")
    public void batchInsert() {
        userServiceI.batchInsert();
    }
}
