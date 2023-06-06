package pe.prodriverperu.beprodriverperu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.prodriverperu.beprodriverperu.entities.Employer;

public interface RepositoryEmployer extends JpaRepository<Employer, Integer> {
}
