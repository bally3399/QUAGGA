package africa.semicolon.com.quagga.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Table(name = "reviews")
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;
    @ManyToOne(fetch = FetchType.LAZY)
    private User reviewSender;
    @ManyToOne(fetch = FetchType.LAZY)
    private User reviewReceiver;
    private int rating;
    private String comment;

}
