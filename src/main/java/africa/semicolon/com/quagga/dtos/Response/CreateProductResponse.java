package africa.semicolon.com.quagga.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
public class CreateProductResponse {
    private Long ProductId;
    @JsonProperty("media_url")
    private String url;
    @JsonProperty("media_description")
    private String description;
    private String message;
}
