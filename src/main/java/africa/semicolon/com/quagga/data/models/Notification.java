package africa.semicolon.com.quagga.data.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Setter
@Getter
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime timeCreated;
    private boolean read;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;
    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private User receiver;

    @PrePersist
    private void setTimeCreated(){
        this.timeCreated = now();
    }
}
