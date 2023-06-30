package pe.prodriverperu.beprodriverperu.dtos;

import pe.prodriverperu.beprodriverperu.entities.Users;

public class RoleDTO {
    private Long id;

    private String rol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
