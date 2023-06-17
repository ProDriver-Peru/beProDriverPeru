package pe.prodriverperu.beprodriverperu.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.prodriverperu.beprodriverperu.business.BusinessNotification;
import pe.prodriverperu.beprodriverperu.dtos.NotificationDTO;
import pe.prodriverperu.beprodriverperu.entities.Notification;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RestNotification {
    @Autowired
    private BusinessNotification businessNotification;
    /*-----------------------------------------------------*/
    /*NOTIFICATION*/

    //INSERT NOTIFICATION
    @PostMapping("/notification")
    public ResponseEntity<NotificationDTO> insertNotification(@RequestBody NotificationDTO notificationDTO){
        Notification notification;
        try{
            notification = convertToEntityNotification(notificationDTO);
            notification = businessNotification.insertNotification(notification);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fue posible registrar notificación");
        }
        return new ResponseEntity<NotificationDTO>(convertToDtoNotification(notification),HttpStatus.OK);
    }

    //NOTIFICATION BY ID
    @GetMapping("/notification/{id}")
    public ResponseEntity<NotificationDTO> getNotificationById(@PathVariable(name = "id") Integer idNotification){
        Notification notification;
        NotificationDTO notificationDTO;
        try{
            notification = businessNotification.listNotificationById(idNotification);
            notificationDTO = convertToDtoNotification(notification);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fue posible encontrar datos de la notificación");
        }
        return new ResponseEntity<NotificationDTO>(notificationDTO, HttpStatus.OK);
    }

    //NOTIFICATION BY IdEmployer
    @GetMapping("/notification/idEmployer/{idEmployer}")
    public ResponseEntity<List<NotificationDTO>> listNotificationByIdEmployer(@PathVariable(name = "idEmployer")Integer idEmployer){
        List<Notification> notificationList;
        List<NotificationDTO> notificationDTOS;
        try{
            notificationList = businessNotification.notificationList(idEmployer);
            notificationDTOS = convertToLisDtoNotification(notificationList);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha podido listar");
        }
        return new ResponseEntity<List<NotificationDTO>>(notificationDTOS, HttpStatus.OK);
    }

    //-----------------------------------------------------DTO----------------------------------------------------------
    /*NOTIFICATION DTO*/
    private NotificationDTO convertToDtoNotification(Notification notification) {
        ModelMapper modelMapper = new ModelMapper();
        NotificationDTO notificationDTO = modelMapper.map(notification, NotificationDTO.class);
        return notificationDTO;
    }
    private Notification convertToEntityNotification(NotificationDTO notificationDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Notification post = modelMapper.map(notificationDTO, Notification.class);
        return post;
    }
    private List<NotificationDTO> convertToLisDtoNotification(List<Notification> list){
        return list.stream()
                .map(this::convertToDtoNotification)
                .collect(Collectors.toList());
    }
}
