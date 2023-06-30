package pe.prodriverperu.beprodriverperu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.prodriverperu.beprodriverperu.entities.Appliersperjoboffer;
import pe.prodriverperu.beprodriverperu.entities.Driver;
import pe.prodriverperu.beprodriverperu.entities.Joboffer;
import pe.prodriverperu.beprodriverperu.repositories.RepositoryAppliersperjoboffer;
import pe.prodriverperu.beprodriverperu.repositories.RepositoryJobOffer;

import java.util.List;

@Service
public class BusinessAppliersperjoboffer {
    @Autowired
    private RepositoryAppliersperjoboffer repositoryAppliersperjoboffer;
    @Autowired
    private RepositoryJobOffer repositoryJobOffer;

    //INSERT
    public Appliersperjoboffer insertApplierperjoboffer(Appliersperjoboffer appliersperjoboffer) {
        Appliersperjoboffer appliersperjoboffer1 = repositoryAppliersperjoboffer.save(appliersperjoboffer);

        Joboffer joboffer = repositoryJobOffer.findById(appliersperjoboffer.getId()).orElseThrow();
        joboffer.setAppliers(joboffer.getAppliers()+1);

        repositoryJobOffer.save(joboffer);

        return appliersperjoboffer1;
    }
    //UPDATE
    public Appliersperjoboffer updateAppliersperjoboffer(Integer id, Appliersperjoboffer appliersperjobofferUpdate){
        Appliersperjoboffer appliersperjobofferOld = repositoryAppliersperjoboffer.findById(id).get();
        appliersperjobofferUpdate.setId(id);
        return repositoryAppliersperjoboffer.save(appliersperjobofferUpdate);
    }
    //GET BY ID
    public Appliersperjoboffer listByIdApplierperjoboffer(Integer id){
        Appliersperjoboffer appliersperjoboffer = repositoryAppliersperjoboffer.findById(id).get();
        return appliersperjoboffer;
    }
    //LIST APPLIER BY ID OFERTA DE TRABAJO
    public List<Appliersperjoboffer> listAppliersperJobOfferByIdJobOffer(Integer id){
        return repositoryAppliersperjoboffer.findIdJobOffer(id);
    }

    //LIST APPLIERS BY ID DRIVER
    public List<Appliersperjoboffer> listAppliersperjobofferByIdDrivr(Integer id){
        return repositoryAppliersperjoboffer.findIdDriver(id);
    }

}
