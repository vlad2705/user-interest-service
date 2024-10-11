package cz.csob.userinterestservice.service;

import cz.csob.userinterestservice.dto.UserInterestDto;
import cz.csob.userinterestservice.users.UserClient;
import jakarta.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class UserInterestService {
    private final UserClient userClient;

    public Map<String, Set<UserInterestDto>> getUserInterests(@NotEmpty Set<String> interests) {
        var users = userClient.getUsers().users();
        var userInterestMap = new HashMap<String, Set<UserInterestDto>>();
        interests.forEach(interest -> {
            var usersWithInterest = users.stream().filter(user ->
                user.interests().contains(interest)
            ).map(user ->
                new UserInterestDto(user.user_id(), user.getFullName())
            ).collect(Collectors.toSet());
            userInterestMap.put(interest, usersWithInterest);
        });
        return userInterestMap;
    }
}
