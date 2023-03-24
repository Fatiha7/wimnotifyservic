package com.CRUD.wimnotifyservic.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRUD.wimnotifyservic.Model.Notification;
import com.CRUD.wimnotifyservic.Repository.NotificationRepository;
@Service("NotificationService")
public class NotificationService implements INotificationSservice{

    @Autowired
    private NotificationRepository notificationrepository;
    public Collection<Notification> findAll() {
        return notificationrepository.findAll();
    }

    public Notification findone(int ID) {
        return notificationrepository.findById(ID).orElse(null);
    }

    public Notification save(Notification notification) {
        return notificationrepository.save(notification);
    }

    public void delete(int ID) {
        notificationrepository.deleteById(ID);
    }

    public Notification Update(Notification notification) {
        return notificationrepository.save(notification);
    }

}
