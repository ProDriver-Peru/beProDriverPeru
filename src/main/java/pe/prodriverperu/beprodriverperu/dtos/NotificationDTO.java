package pe.prodriverperu.beprodriverperu.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.prodriverperu.beprodriverperu.entities.Driver;
import pe.prodriverperu.beprodriverperu.entities.Employer;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
    private Integer id;
    private String content;
    private Instant timestamp;
    private Driver idUserDriver;
    private Employer idUserEmployer;
}
