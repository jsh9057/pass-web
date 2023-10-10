package com.jsh.pass.passweb.service.user;

import com.jsh.pass.passweb.repository.user.UserStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String userId;
    private String userName;
    private UserStatus status;

}
