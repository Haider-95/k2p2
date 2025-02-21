package se.trixzta.project.Controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.trixzta.project.DB.AppUserRepository;
import se.trixzta.project.model.AppUser;

@Controller
@RequestMapping
public class RegisterController {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterController(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/registerSubmit")
    public String registerSubmit(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("role") String role) {
        if (appUserRepository.findByUserName(username) == null) {
            String encodedPassword = passwordEncoder.encode(password);
            AppUser appUser = new AppUser(username, encodedPassword, role);
            appUserRepository.save(appUser);

            return ("/");
        }
    return ("/");
    }

}
