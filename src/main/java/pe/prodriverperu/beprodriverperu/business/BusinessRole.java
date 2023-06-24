package pe.prodriverperu.beprodriverperu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.prodriverperu.beprodriverperu.entities.Role;
import pe.prodriverperu.beprodriverperu.repositories.RepositoryRole;

import java.util.List;

@Service
public class BusinessRole {
    @Autowired
    private RepositoryRole repositoryRole;

    public void insert(Role role){
        repositoryRole.save(role);
    }

    public List<Role> list(){
        // TODO Auto-generated method stub
        return repositoryRole.findAll();
    }

}
