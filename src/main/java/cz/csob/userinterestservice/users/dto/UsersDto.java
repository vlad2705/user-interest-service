package cz.csob.userinterestservice.users.dto;

import java.util.List;

public record UsersDto(
    List<UserDto> users
) {
}

