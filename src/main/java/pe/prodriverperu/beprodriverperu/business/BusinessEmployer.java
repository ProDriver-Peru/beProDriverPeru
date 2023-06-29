package pe.prodriverperu.beprodriverperu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.prodriverperu.beprodriverperu.entities.Employer;
import pe.prodriverperu.beprodriverperu.repositories.RepositoryEmployer;

import java.util.List;

@Service
public class BusinessEmployer {
    @Autowired
    private RepositoryEmployer repositoryEmployer;

    //INSERT
    public Employer insert(Employer employer) {
        Employer employer1 = repositoryEmployer.save(employer);
        return employer1;
    }

    //UPDATE
    public Employer updateEmployer(Integer id, Employer employerUpdate){
        Employer employerOld = repositoryEmployer.findById(id).get();
        employerUpdate.setId(id);
        return repositoryEmployer.save(employerUpdate);
    }
    //LIST BY ID
    public Employer listByIdEmployer(Integer id){
        Employer employer = repositoryEmployer.findById(id).get();
        return employer;
    }

    //LIST BY LICENSE
    public List<Employer> listbyLicenseEmployer(String license){
        return repositoryEmployer.findByLicensetype(license);
    }
}