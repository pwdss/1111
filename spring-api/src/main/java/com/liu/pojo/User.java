package com.liu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @Description: 用户实体(面向页面和后台和数据库)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
        private  Integer id;
        private  String username;
        private  String userPwd;
        private String usercode;
}
