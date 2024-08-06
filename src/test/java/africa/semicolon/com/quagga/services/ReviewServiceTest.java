package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.dtos.request.SendReviewRequest;
import africa.semicolon.com.quagga.dtos.response.SendReviewResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Sql(scripts = {"/db/data.sql"})
public class ReviewServiceTest {

    @Autowired
    private ReviewService reviewService;

    @Test
    public void sendReview(){
        SendReviewRequest reviewRequest = new SendReviewRequest();
        reviewRequest.setRating(4);
        reviewRequest.setComment("The service was good");
        reviewRequest.setReceiverId(105L);
        reviewRequest.setSenderId(100L);
        SendReviewResponse response = reviewService.sendReview(reviewRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Review sent successfully");
    }

    @Test
    public void findReview(){

    }
}
