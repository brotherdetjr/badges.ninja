package badges.ninja;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Put;

@Controller("/user/{user}/kids")
public final class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Put
    public void addKid(String user, @Body String kid) {
        userService.addKid(user, kid);
    }
}
