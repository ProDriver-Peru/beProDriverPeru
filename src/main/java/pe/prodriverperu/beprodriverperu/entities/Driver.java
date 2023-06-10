package pe.prodriverperu.beprodriverperu.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @Column(name = "id_user", nullable = false)
    private Integer id;

    @MapsId //This annotation is used to indicate that the primary key of the associated entity should be used as the foreign key in the referencing entity
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @Column(name = "employed", nullable = false)
    private Boolean employed = false;

    @Column(name = "licensetype", nullable = false, length = 16)
    private String licensetype;

    @Column(name = "license", nullable = false, length = 16)
    private String license;


}
