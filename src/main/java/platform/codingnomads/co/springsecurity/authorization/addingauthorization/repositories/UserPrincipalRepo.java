package platform.codingnomads.co.springsecurity.authorization.addingauthorization.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.models.Authority;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.models.UserMeta;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.models.UserPrincipal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserPrincipalRepo extends JpaRepository<UserPrincipal, Long> {
    Optional<UserPrincipal> findByUsername(String username);

    List<UserPrincipal> findByCredentialsNonExpiredIsFalse();
}
