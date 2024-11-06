package org.example.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class UserDto {
    private String username;

    private String email;

    List<Role> roles;
    private Boolean isEmailVerified;

    public static  UserDto getUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());
        userDto.setIsEmailVerified(user.getIsEmailVerified());
        return userDto;
    }

}

