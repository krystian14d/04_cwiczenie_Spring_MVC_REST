package pl.javastart.equipy.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserResource {

    private UserService userService;

    @GetMapping("")
    List<UserDto> findAll() {
        return userService.findAll();
    }
}
