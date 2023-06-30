package pe.prodriverperu.beprodriverperu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.prodriverperu.beprodriverperu.entities.Users;

@Repository
public interface RepositoryUsers extends JpaRepository<Users, Integer> {
    public Users findByUsername(String username);

    //BUSCAR POR NOMBRE
    @Query("select count(u.username) from Users u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);


    //INSERTAR ROLES
    @Modifying
    @Query(value = "INSERT INTO user_roles (users_id, role_id) VALUES (:user_id, :rol_id)", nativeQuery = true)
    public void insertUserRol(@Param("user_id") Integer user_id, @Param("rol_id") Integer rol_id);
}
