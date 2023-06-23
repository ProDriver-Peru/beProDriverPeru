package pe.prodriverperu.beprodriverperu.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.prodriverperu.beprodriverperu.entities.User;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDTO {
    private Integer id;
    private User user;
    private String ruc;
    private String imageCompany;
    private String companyName;
    private String companyDescription;
}
