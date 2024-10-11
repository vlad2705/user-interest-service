package cz.csob.userinterestservice.controller;

import cz.csob.userinterestservice.dto.UserInterestDto;
import cz.csob.userinterestservice.service.UserInterestService;
import jakarta.validation.constraints.NotEmpty;
import java.util.Map;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interests-of-users")
@Validated
@RequiredArgsConstructor
public class UserInterestController {
    private final UserInterestService userInterestService;

    @GetMapping
    ResponseEntity<Map<String, Set<UserInterestDto>>> getUserInterests(@RequestParam @NotEmpty Set<String> interests) {
        return ResponseEntity.ok(userInterestService.getUserInterests(interests));
    }
}
