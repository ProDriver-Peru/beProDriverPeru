package pe.prodriverperu.beprodriverperu.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    private String plan;
}
