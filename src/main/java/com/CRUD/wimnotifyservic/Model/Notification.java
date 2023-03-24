package com.CRUD.wimnotifyservic.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int ID ;
    @Column(name="Notification", length=512)
    private String Notification;

}
