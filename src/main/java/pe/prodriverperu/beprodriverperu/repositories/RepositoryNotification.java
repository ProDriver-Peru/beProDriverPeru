package pe.prodriverperu.beprodriverperu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.prodriverperu.beprodriverperu.entities.Notification;

import java.util.List;

public interface RepositoryNotification extends JpaRepository<Notification,Integer> {
    List<Notification> findByIdUserEmployer(Integer idEmployer);
}
