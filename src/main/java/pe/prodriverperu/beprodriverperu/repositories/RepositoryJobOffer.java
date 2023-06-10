package pe.prodriverperu.beprodriverperu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.prodriverperu.beprodriverperu.entities.Joboffer;

import java.util.List;

public interface RepositoryJobOffer extends JpaRepository<Joboffer,Integer> {
    List<Joboffer> findByIdEmployer(Integer idEmployer);
}
