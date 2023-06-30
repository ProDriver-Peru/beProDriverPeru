package pe.prodriverperu.beprodriverperu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.prodriverperu.beprodriverperu.entities.Driver;
import pe.prodriverperu.beprodriverperu.repositories.RepositoryDriver;

import java.util.List;

@Service
public class BusinessDriver {
    @Autowired
    private RepositoryDriver repositoryDriver;
    //INSERT
    public Driver insertDriver(Driver driver){
        Driver driver1 = repositoryDriver.save(driver);
        return driver1;
    }
    //UPDATE
    public Driver updateDriver(Integer id, Driver driverUpdate){
        Driver driverOld = repositoryDriver.findById(id).get();
        driverUpdate.setId(id);
        return repositoryDriver.save(driverUpdate);
    }
    //LIST BY ID
    public Driver listByIdDriver(Integer id){
        Driver driver = repositoryDriver.findById(id).get();
        return driver;
    }

    //LIST BY LICENSE
    public List<Driver> listbyLicenseDriver(String license){
        return repositoryDriver.findByLicensetype(license);
    }

    //LIST DRIVERS
    public List<Driver> listDriver(){
        return repositoryDriver.findAll();
    }

}
