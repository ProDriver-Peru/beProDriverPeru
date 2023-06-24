package pe.prodriverperu.beprodriverperu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.prodriverperu.beprodriverperu.entities.Joboffer;

import java.util.List;

@Repository
public interface RepositoryJobOffer extends JpaRepository<Joboffer,Integer> {
    //List<Joboffer> findByIdEmployer(Integer idEmployer);

    @Query("SELECT jo FROM Joboffer jo WHERE jo.idEmployer.id=:pk")
    List<Joboffer> findEmployer(@Param("pk") Integer pk);

}
