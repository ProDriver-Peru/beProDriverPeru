package pe.prodriverperu.beprodriverperu.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.prodriverperu.beprodriverperu.entities.User;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {
    private Integer id;

    private User user;

    private Boolean employed = false;

    private String licensetype;

    private String license;

    private String sector;

    private Integer yearsExperience;
}
