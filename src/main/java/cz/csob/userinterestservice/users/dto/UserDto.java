package cz.csob.userinterestservice.users.dto;

import java.util.Set;

public record UserDto(
    String user_id,
    String first_name,
    String last_name,
    Set<String> interests
) {
    public String getFullName() {
        return first_name + " " + last_name;
    }
}
