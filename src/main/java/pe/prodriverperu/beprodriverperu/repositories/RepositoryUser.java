package pe.prodriverperu.beprodriverperu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.prodriverperu.beprodriverperu.entities.User;
@Repository
public interface RepositoryUser extends JpaRepository<User,Integer> {
}
