package pe.prodriverperu.beprodriverperu.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.prodriverperu.beprodriverperu.entities.Users;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String rol;
    private String dni;
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private String plan;
    private String description;
    private String imageProfile;
    private Users users;
}
