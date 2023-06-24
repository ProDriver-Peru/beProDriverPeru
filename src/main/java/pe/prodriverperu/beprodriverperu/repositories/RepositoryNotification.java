package pe.prodriverperu.beprodriverperu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.prodriverperu.beprodriverperu.entities.Appliersperjoboffer;
import pe.prodriverperu.beprodriverperu.entities.Notification;

import java.util.List;
@Repository
public interface RepositoryNotification extends JpaRepository<Notification,Integer> {
    //List<Notification> findByIdUserEmployer(Integer idEmployer);

    @Query("SELECT n FROM Notification n WHERE n.idUserEmployer.id=:pk")
    List<Notification> findIdEmployer(@Param("pk") Integer pk);
}
