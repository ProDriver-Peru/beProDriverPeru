package pe.prodriverperu.beprodriverperu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.prodriverperu.beprodriverperu.entities.Notification;

public interface RepositoryNotification extends JpaRepository<Notification,Integer> {
}
