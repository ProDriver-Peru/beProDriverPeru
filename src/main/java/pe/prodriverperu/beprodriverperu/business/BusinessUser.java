package pe.prodriverperu.beprodriverperu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.prodriverperu.beprodriverperu.entities.User;
import pe.prodriverperu.beprodriverperu.repositories.RepositoryUser;

import javax.transaction.Transactional;

@Service
public class BusinessUser {
    @Autowired
    private RepositoryUser repositoryUser;

    @Transactional
    public User insert(User user){
        return repositoryUser.save(user);
    }

    public User signin(String email, String password){
        return repositoryUser.findByEmailAndPassword(email,password);
    }

}
