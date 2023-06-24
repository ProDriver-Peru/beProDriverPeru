package pe.prodriverperu.beprodriverperu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.prodriverperu.beprodriverperu.entities.Employer;

@Repository
public interface RepositoryEmployer extends JpaRepository<Employer, Integer> {
}
