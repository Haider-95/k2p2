package se.trixzta.project.DB;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.trixzta.project.model.AppUser;

import java.util.List;


@Service
public class MyUserDetailsService implements UserDetailsService {
    private final AppUserRepository appUserRepository;

    public MyUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUserName(username);
        if (appUser == null) {
            throw new UsernameNotFoundException("user not found");
        }
        List<GrantedAuthority> authorities = List.of(
                new SimpleGrantedAuthority("ROLE_" + appUser.getRole()));

        return new org.springframework.security.core.userdetails.User(
                appUser.getUserName(),
                appUser.getPassword(),
                true,
                true,
                true,
                true,
                authorities
        );
    }
}