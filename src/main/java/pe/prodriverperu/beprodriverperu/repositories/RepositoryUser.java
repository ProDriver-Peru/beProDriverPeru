package pe.prodriverperu.beprodriverperu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.prodriverperu.beprodriverperu.entities.User;

public interface RepositoryUser extends JpaRepository<User,Integer> {
    public User findByEmailAndPassword(String email, String password);
}
