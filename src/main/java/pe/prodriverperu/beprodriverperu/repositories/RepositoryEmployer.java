package pe.prodriverperu.beprodriverperu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.prodriverperu.beprodriverperu.entities.Employer;

import java.util.List;

public interface RepositoryEmployer extends JpaRepository<Employer, Integer> {

}