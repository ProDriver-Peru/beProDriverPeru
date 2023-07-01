package pe.prodriverperu.beprodriverperu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.prodriverperu.beprodriverperu.entities.Driver;
import pe.prodriverperu.beprodriverperu.entities.Joboffer;

import java.util.List;

public interface RepositoryJobOffer extends JpaRepository<Joboffer,Integer> {

    @Query("SELECT jo FROM Joboffer jo WHERE jo.idEmployer.id=:pk")
    List<Joboffer> findEmployer(@Param("pk") Integer pk);

    @Query("SELECT d FROM Joboffer jo INNER JOIN Appliersperjoboffer ajo ON ajo.idJoboffer.idEmployer = jo.idEmployer INNER JOIN Driver d ON ajo.idDriver.id = d.id WHERE jo.id=:pk")
    List<Driver> findUsers(@Param("pk") Integer pk);

}
