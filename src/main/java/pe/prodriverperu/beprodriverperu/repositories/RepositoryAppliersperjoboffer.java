package pe.prodriverperu.beprodriverperu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.prodriverperu.beprodriverperu.entities.Appliersperjoboffer;
import pe.prodriverperu.beprodriverperu.entities.Joboffer;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface RepositoryAppliersperjoboffer extends JpaRepository<Appliersperjoboffer,Integer> {

    /*
    List<Appliersperjoboffer> findByIdJoboffer(Integer idJobOffer);
    List<Appliersperjoboffer> findByIdDriver(Integer idDriver);*/

    @Query("SELECT ap FROM Appliersperjoboffer ap WHERE ap.idJoboffer.id=:pk")
    List<Appliersperjoboffer> findIdJobOffer(@Param("pk") Integer pk);

    @Query("SELECT ap FROM Appliersperjoboffer ap WHERE ap.idDriver.id=:pk")
    List<Appliersperjoboffer> findIdDriver(@Param("pk") Integer pk);

}
