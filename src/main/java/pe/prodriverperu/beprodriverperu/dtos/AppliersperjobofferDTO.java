package pe.prodriverperu.beprodriverperu.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.prodriverperu.beprodriverperu.entities.Joboffer;
import pe.prodriverperu.beprodriverperu.entities.User;

import javax.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppliersperjobofferDTO {
    private Integer id;
    private Joboffer idJoboffer;
    private User idDriver;
    private String status;
    private Instant timestamp;
}
