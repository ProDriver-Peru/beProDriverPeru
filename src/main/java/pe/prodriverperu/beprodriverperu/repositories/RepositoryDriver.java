package pe.prodriverperu.beprodriverperu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.prodriverperu.beprodriverperu.entities.Driver;

import java.util.List;

@Repository
public interface RepositoryDriver extends JpaRepository<Driver, Integer> {
    List<Driver> findByLicensetype(String licenseType);
}
