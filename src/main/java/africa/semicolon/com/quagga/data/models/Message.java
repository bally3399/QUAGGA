package africa.semicolon.com.quagga.data.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Setter
@Getter
@Table(name = "messages")
public class Message {
    private Long id;
    private Long senderId;
    private Long receiverId;
    private String content;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDateTime date;

    @PrePersist
    private void setDate() {
        this.date = now();
    }
}
