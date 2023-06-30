package pe.prodriverperu.beprodriverperu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.prodriverperu.beprodriverperu.entities.Role;
import pe.prodriverperu.beprodriverperu.repositories.RepositoryRole;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BusinessRole {
    @Autowired
    private RepositoryRole repositoryRole;

    @Transactional
    public Integer insertRol(Role role){
        if (repositoryRole.findRoleByRol(role.getRol())==null){
            repositoryRole.save(role);
            return 1;
        }
        return 0;
    }

    public List<Role> list(){
        // TODO Auto-generated method stub
        return repositoryRole.findAll();
    }

}
