package pe.prodriverperu.beprodriverperu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.prodriverperu.beprodriverperu.entities.Driver;
import pe.prodriverperu.beprodriverperu.repositories.RepositoryDriver;

@Service
public class BusinessDriver {
    @Autowired
    private RepositoryDriver repositoryDriver;
    //INSERT
    public Driver insert(Driver driver){
        Driver driver1 = repositoryDriver.save(driver);
        return driver1;
    }
}
