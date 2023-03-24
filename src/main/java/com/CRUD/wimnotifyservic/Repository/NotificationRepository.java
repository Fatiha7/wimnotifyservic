package com.CRUD.wimnotifyservic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRUD.wimnotifyservic.Model.Notification;
@Repository("NotificationRepository")
public interface NotificationRepository extends JpaRepository<Notification,Integer> {

}
