package pe.prodriverperu.beprodriverperu.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appliersperjoboffer")
public class Appliersperjoboffer {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_joboffer", nullable = false)
    private Joboffer idJoboffer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_driver", nullable = false)
    private User idDriver;

    @Column(name = "status", nullable = false, length = 10)
    private String status;

    @Column(name = "\"timestamp\"", nullable = false)
    private Instant timestamp;
}
