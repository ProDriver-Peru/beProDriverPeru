package pe.prodriverperu.beprodriverperu.business;

import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.prodriverperu.beprodriverperu.entities.Role;
import pe.prodriverperu.beprodriverperu.entities.Users;
import pe.prodriverperu.beprodriverperu.repositories.RepositoryRole;
import pe.prodriverperu.beprodriverperu.repositories.RepositoryUsers;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BusinessUsers{
    @Autowired
    private RepositoryUsers repositoryUsers;
    @Autowired
    private RepositoryRole repositoryRole;

    public Integer insert(Users users) {
        int rpta = repositoryUsers.buscarUsername(users.getUsername());
        if (rpta==0){
            repositoryUsers.save(users);
        }
        return rpta;
    }

    public Integer buscarUser(String username){
        int rpta = repositoryUsers.buscarUsername(username);
        return rpta;
    }

    public void eliminar(int idUser) {
        repositoryUsers.deleteById(idUser);
    }

    public Users listarId(int idUser) {
        return repositoryUsers.findById(idUser).orElse(new Users());
    }

    public List<Users> listar() {
        return repositoryUsers.findAll();
    }

    /**
     * @param user_id De un usuario existente
     * @param rol_id  De un usuario existente
     * @return 1 exito
     */

    @Transactional
    public void insertUserRol(Integer user_id, Integer rol_id) {
        repositoryUsers.insertUserRol(user_id, rol_id);
    }

    /*
    @Transactional
    public Integer insertUserRol2(Integer user_id, Integer rol_id) {
        Integer result = 0;
        Users user = repositoryUsers.findById(user_id).get();
        Role role = repositoryRole.findById(rol_id).get();
        user.getRoles().add(role);
        repositoryUsers.save(user);
        repositoryRole.save(role);
        return 1;
    }*/

}
