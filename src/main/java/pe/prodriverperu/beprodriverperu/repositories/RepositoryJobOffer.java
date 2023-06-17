package pe.prodriverperu.beprodriverperu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.prodriverperu.beprodriverperu.entities.Joboffer;

import java.util.List;

public interface RepositoryJobOffer extends JpaRepository<Joboffer,Integer> {
    List<Joboffer> findByIdEmployerEquals(Integer idEmployer);
        /*
    @Query("SELECT jo FROM Joboffer jo WHERE jo.idEmployer=:pk")
    List<Joboffer> findEmployer(@Param("pk") Integer pk);
     */
}
