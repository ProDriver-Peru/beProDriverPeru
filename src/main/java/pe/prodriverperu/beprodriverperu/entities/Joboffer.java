package pe.prodriverperu.beprodriverperu.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "joboffer")
public class Joboffer {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false, length = 256)
    private String description;

    @Column(name = "licensetyperequired", nullable = false, length = 16)
    private String licensetyperequired;

    @Column(name = "experienceyears", nullable = false)
    private Integer experienceyears;

    @Column(name = "appliers", nullable = false)
    private Integer appliers;

    @Column(name = "vehicle", nullable = false, length = 32)
    private String vehicle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_employer", nullable = false)
    private User idEmployer;
}
