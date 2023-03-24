package com.CRUD.wimnotifyservic.Service;

import java.util.Collection;

import com.CRUD.wimnotifyservic.Model.Notification;

public interface INotificationSservice {
    public Collection<Notification> findAll();
    public Notification findone(int ID);
    public Notification save(Notification emprunt);
    public void delete(int ID);
    public Notification Update(Notification notification);
}
