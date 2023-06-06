package pe.prodriverperu.beprodriverperu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.prodriverperu.beprodriverperu.entities.Joboffer;

public interface RepositoryJobOffer extends JpaRepository<Joboffer,Integer> {
}
