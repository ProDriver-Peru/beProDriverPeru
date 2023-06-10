package pe.prodriverperu.beprodriverperu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.prodriverperu.beprodriverperu.entities.Appliersperjoboffer;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface RepositoryAppliersperjoboffer extends JpaRepository<Appliersperjoboffer,Integer> {

    List<Appliersperjoboffer> findByIdJoboffer(Integer idJobOffer);
    List<Appliersperjoboffer> findByIdDriver(Integer idDriver);


}
