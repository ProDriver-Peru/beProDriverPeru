package pe.prodriverperu.beprodriverperu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.prodriverperu.beprodriverperu.entities.Driver;
import pe.prodriverperu.beprodriverperu.entities.Joboffer;
import pe.prodriverperu.beprodriverperu.repositories.RepositoryJobOffer;

import java.util.List;

@Service
public class BusinessJobOffer {
    @Autowired
    RepositoryJobOffer repositoryJobOffer;

    //INSERT
    public Joboffer insertJobOffer(Joboffer joboffer){
        return repositoryJobOffer.save(joboffer);
    }
    //UPDATE
    public Joboffer updateJobOffer(Integer id, Joboffer jobofferUpdate){
        Joboffer jobofferOld = repositoryJobOffer.findById(id).get();
        jobofferUpdate.setId(id);
        return repositoryJobOffer.save(jobofferUpdate);
    }

    //LIST
    public List<Joboffer> listJobOffer(){
        return repositoryJobOffer.findAll();
    }

    //LIST BY ID
    public Joboffer getByIdJobOffer(Integer id){
        Joboffer joboffer = repositoryJobOffer.findById(id).get();
        return joboffer;
    }

    //LIST BY ID EMPLOYER
    public List<Joboffer> listJobOfferByIdEmployer(Integer idEmployer){
        return repositoryJobOffer.findEmployer(idEmployer);
    }

    //LIST USER BY ID EMPLOYER
    public List<Driver> listJDriverByIdJobOffer(Integer idJobOffer){
        return repositoryJobOffer.findUsers(idJobOffer);
    }

    //DELETE
    public void delete(Integer id){
        repositoryJobOffer.deleteById(id);
    }
}
