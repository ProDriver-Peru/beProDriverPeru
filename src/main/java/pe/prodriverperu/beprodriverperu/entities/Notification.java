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
@Table(name = "notification")
public class Notification {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "content", nullable = false, length = 256)
    private String content;

    @Column(name = "\"timestamp\"", nullable = false)
    private Instant timestamp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user_driver", nullable = false)
    private Driver idUserDriver;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user_employer", nullable = false)
    private Employer idUserEmployer;
}
