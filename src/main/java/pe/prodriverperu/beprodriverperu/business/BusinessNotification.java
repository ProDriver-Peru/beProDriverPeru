package pe.prodriverperu.beprodriverperu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.prodriverperu.beprodriverperu.entities.Notification;
import pe.prodriverperu.beprodriverperu.repositories.RepositoryNotification;

import java.util.List;

@Service
public class BusinessNotification {
    @Autowired
    RepositoryNotification repositoryNotification;

    //INSERT
    public Notification insertNotification (Notification notification){
        return repositoryNotification.save(notification);
    }

    //LIST BY ID
    public Notification listNotificationById(Integer id){
        Notification notification = repositoryNotification.findById(id).get();
        return notification;
    }

    //LIST BY ID EMPLOYER
    public List<Notification> notificationList(Integer idEmployer){
        return repositoryNotification.findIdEmployer(idEmployer);
    }

}
