package com.CRUD.wimnotifyservic.Controller;

import java.util.Collection;

import com.CRUD.wimnotifyservic.Config.Kafka.JsonKafkaProducer;
import com.CRUD.wimnotifyservic.Config.Kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.CRUD.wimnotifyservic.Model.Notification;
import com.CRUD.wimnotifyservic.Service.NotificationService;

@RestController()
@CrossOrigin("*")
public class NotificationController {
    @Autowired
    private NotificationService notificationservice;
    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;
    @PostMapping(value = "publish")
    public ResponseEntity<String> publishJson(@RequestBody Notification notification){
        jsonKafkaProducer.sendMessage(notification);
        return ResponseEntity.ok("Json message sent to the kafka topic");
    }
    @GetMapping(value = "publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
    kafkaProducer.sentMessage(message);
    return ResponseEntity.ok("message sent to the topic");
    }
    @GetMapping(value="CRUD_Notification")
    public Collection<Notification> List_Notification() {

        return notificationservice.findAll();

    }
    @RequestMapping(value = "CRUD_Notification",method= RequestMethod.POST)
    public Notification add_notification(@RequestBody Notification notification) {

        notificationservice.save(notification);
        publishJson(notification);

        System.out.println("notification add ");
        return notification;

    }
    @RequestMapping(value = "CRUD_Notification/{id}",method=RequestMethod.GET)
    public Notification findOne_NotificationById(@PathVariable int id) {
        return notificationservice.findone(id);

    }
    @RequestMapping(value = "CRUD_Notification/{id}",method=RequestMethod.PUT)
    public Notification Update_Notification(@PathVariable int id ,@RequestBody Notification notification) {
        Notification notifications=notificationservice.findone(id);
        notifications.setNotification(notification.getNotification());
        notificationservice.Update(notifications);
        return notifications;
    }

    @RequestMapping(value = "CRUD_Notification/{id}",method= RequestMethod.DELETE)
    public void Delete_Notification(@PathVariable int id) {
        notificationservice.delete(id);


    }

}
