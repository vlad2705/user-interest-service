package cz.csob.userinterestservice.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.csob.userinterestservice.users.dto.UsersDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class UserClient {
    private final ObjectMapper objectMapper;
    private final RestClient restClient;

    public UsersDto getUsers() {
        String uri = "https://raw.githubusercontent.com/sustacek/java_spring_interview_assignment/refs/heads/main/server/get-users.json";
        try {
            var response = restClient.get()
                .uri(uri)
                .retrieve()
                .body(String.class);
            return objectMapper.readValue(response, UsersDto.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
