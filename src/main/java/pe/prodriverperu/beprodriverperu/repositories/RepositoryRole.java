package pe.prodriverperu.beprodriverperu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.prodriverperu.beprodriverperu.entities.Role;

@Repository
public interface RepositoryRole extends JpaRepository<Role, Integer> {
    Role findRoleByRol(String rol);
}
