package pe.prodriverperu.beprodriverperu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.prodriverperu.beprodriverperu.entities.Users;
import pe.prodriverperu.beprodriverperu.repositories.RepositoryUsers;

import java.util.List;

@Service
public class BusinessUsers{
    @Autowired
    private RepositoryUsers repositoryUsers;

    public void insertar(Users users) {
        repositoryUsers.save(users);
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
}
