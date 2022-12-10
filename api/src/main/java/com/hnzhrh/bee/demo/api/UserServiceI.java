package com.hnzhrh.bee.demo.api;

import com.hnzhrh.bee.common.dto.Response;
import com.hnzhrh.bee.common.dto.SingleResponse;
import com.hnzhrh.bee.demo.dto.UserDTO;
import com.hnzhrh.bee.demo.dto.UserQueryRequest;

public interface UserServiceI {
    /**
     * Query user by user id.
     * @param userId user id
     * @return The user DTO.
     */
    UserDTO query(String userId);

    /**
     * Delete user by user id.
     * @param userId user id
     * @return The deleted user id.
     */
    String delete(String userId);

    void batchInsert();

    SingleResponse<UserDTO> query(UserQueryRequest request);

    Response testException();
}
