package se.trixzta.project;


import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se.trixzta.project.DB.AppUserRepository;
import se.trixzta.project.model.AppUser;


@Component
public class DataInitializer {
    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(AppUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;


    }

    @PostConstruct
    public void initialize() {
        if (userRepository.findByUserName("manager") == null) {
            AppUser appUser = new AppUser();
            appUser.setUserName("manager");
            appUser.setRole("MANAGER");
            appUser.setPassword(passwordEncoder.encode("password"));
            userRepository.save(appUser);
        }
        if (userRepository.findByUserName("admin") == null) {
            AppUser appUser = new AppUser();
            appUser.setUserName("admin");
            appUser.setRole("ADMIN");
            appUser.setPassword(passwordEncoder.encode("password"));
            userRepository.save(appUser);
        }
        if (userRepository.findByUserName("user") == null) {
            AppUser appUser = new AppUser();
            appUser.setUserName("user");
            appUser.setRole("USER");
            appUser.setPassword(passwordEncoder.encode("password"));
            userRepository.save(appUser);

        }
    }


}
