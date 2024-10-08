package cnu.moksoriro.domain.member.repo;

import cnu.moksoriro.domain.member.Role;
import cnu.moksoriro.domain.member.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleName name);
}
