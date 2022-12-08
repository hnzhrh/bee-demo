package com.hnzhrh.bee.demo.api;

import com.hnzhrh.bee.demo.dto.UserDTO;

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
}
