package pe.prodriverperu.beprodriverperu.dtos;

import pe.prodriverperu.beprodriverperu.entities.Role;

import java.util.List;

public class UsersDTO {
    private Integer id;

    private String username;

    private String password;
    private Boolean enabled;

    private List<Role> roles;


}
