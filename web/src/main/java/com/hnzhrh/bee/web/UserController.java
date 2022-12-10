package com.hnzhrh.bee.web;

import com.hnzhrh.bee.common.dto.Response;
import com.hnzhrh.bee.common.dto.SingleResponse;
import com.hnzhrh.bee.demo.api.UserServiceI;
import com.hnzhrh.bee.demo.dto.UserDTO;
import com.hnzhrh.bee.demo.dto.UserQueryRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
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

    @ApiOperation("POST查询用户")
    @PostMapping("/v1/query")
    public SingleResponse<UserDTO> query(@RequestBody UserQueryRequest request) {
        return userServiceI.query(request);
    }

    @ApiOperation(("测试异常抛出和捕获"))
    @GetMapping("/v1/testException")
    Response testException() {
        userServiceI.testException();
        return Response.buildSuccess();
    }
}
