package pe.prodriverperu.beprodriverperu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.prodriverperu.beprodriverperu.entities.Driver;

import java.util.List;

public interface RepositoryDriver extends JpaRepository<Driver, Integer> {
    List<Driver> findByLicensetype(String licenseType);
}
