package org.gcp.pubsub.sender.controller;

import org.gcp.pubsub.sender.dto.NotificationWithAttachment;
import org.gcp.pubsub.sender.service.StringService;
import org.gcp.pubsub.sender.service.PojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private StringService messageService;

    @Autowired
    private PojoService pojoService;

    @PostMapping("/sendMessage")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        messageService.publish(message);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/sendPojo")
    public ResponseEntity<?> publish(@RequestBody NotificationWithAttachment notificationWithAttachment) {
        pojoService.publish(notificationWithAttachment);
        return ResponseEntity.ok(notificationWithAttachment);
    }
}    

