package pe.prodriverperu.beprodriverperu.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.prodriverperu.beprodriverperu.entities.Employer;
import pe.prodriverperu.beprodriverperu.entities.User;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOfferDTO {
    private Integer id;
    private String description;
    private String licensetyperequired;
    private Integer experienceyears;
    private Integer appliers;
    private String vehicle;
    private Employer idEmployer;
}
