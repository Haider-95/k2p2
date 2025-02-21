package se.trixzta.project.DB;

import org.springframework.data.jpa.repository.JpaRepository;
import se.trixzta.project.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String username);
}
