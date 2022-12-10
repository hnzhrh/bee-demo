package com.hnzhrh.bee.demo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hnzhrh.bee.common.dto.Response;
import com.hnzhrh.bee.common.dto.SingleResponse;
import com.hnzhrh.bee.common.exception.BizException;
import com.hnzhrh.bee.demo.api.UserServiceI;
import com.hnzhrh.bee.demo.dto.UserDTO;
import com.hnzhrh.bee.demo.dto.UserQueryRequest;
import com.hnzhrh.bee.domain.entity.Users;
import com.hnzhrh.bee.domain.mapper.UsersMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserServiceI {
    @Resource
    private UsersMapper usersMapper;

    @Override
    public UserDTO query(String userId) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Users::getUserId, userId);
        Users users = usersMapper.selectOne(queryWrapper);
        if (!Objects.isNull(users)) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(String.valueOf(users.getUserId()));
            userDTO.setUserName(users.getUserName());
            userDTO.setPhone(users.getPhone());
            return userDTO;
        }
        return null;
    }

    @Override
    public String delete(String userId) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Users::getUserId, userId);
        usersMapper.delete(queryWrapper);
        return userId;
    }

    @Override
    public void batchInsert() {
        List<Users> users = new ArrayList<>();
        Users users1 = new Users();
        users1.setUserId(23434L);
        users1.setUserName("erpang1");
        users1.setPhone("124324");
        users1.setGmtCreated(LocalDateTime.now());
        users1.setGmtModified(LocalDateTime.now());
        users1.setIsDeleted(0);

        Users users2 = new Users();
        users2.setUserId(56343L);
        users2.setUserName("erpang2");
        users2.setPhone("124324");
        users2.setGmtCreated(LocalDateTime.now());
        users2.setGmtModified(LocalDateTime.now());
        users2.setIsDeleted(0);


        users.add(users1);
        users.add(users2);

        usersMapper.insertBatchSomeColumn(users);
    }

    @Override
    public SingleResponse<UserDTO> query(UserQueryRequest request) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Users::getUserId, request.getUserId());
        Users users = usersMapper.selectOne(queryWrapper);
        if (!Objects.isNull(users)) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(String.valueOf(users.getUserId()));
            userDTO.setUserName(users.getUserName());
            userDTO.setPhone(users.getPhone());
            return SingleResponse.of(userDTO);
        }
        return SingleResponse.of(null);
    }

    @Override
    public Response testException() {
        throw new BizException("业务异常抛出测试！");
    }
}
