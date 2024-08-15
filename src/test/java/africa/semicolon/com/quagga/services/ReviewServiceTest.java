package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Category;
import africa.semicolon.com.quagga.data.models.Review;
import africa.semicolon.com.quagga.data.models.Role;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.dtos.request.RegisterRequest;
import africa.semicolon.com.quagga.dtos.request.SendReviewRequest;
import africa.semicolon.com.quagga.dtos.request.UpdateReviewRequest;
import africa.semicolon.com.quagga.dtos.response.RegisterResponse;
import africa.semicolon.com.quagga.dtos.response.SendReviewResponse;
import africa.semicolon.com.quagga.exceptions.ReviewNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
//@Sql(scripts = {"/db/data.sql"})
public class ReviewServiceTest {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private SpecialistService specialistService;

    @Autowired
    private UserService userService;
    private SendReviewResponse response;
    private User client;
    private User specialist;

    private RegisterResponse clientsResponse;
    private RegisterResponse specialistResponse;
    private Review review;


    @BeforeEach
    public void setUp() {
        reviewService.deleteAll();
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Paul");
        request.setLastName("Bond");
        request.setPassword("911");
        request.setEmail("paul@gmail.com");
        request.setAddress("No 30, Helen Street, Idumota, Lagos");
        request.setPhoneNumber("08133856789");
        request.setRole(Role.CLIENT);
        request.setCategory(Category.STRUCTURAL);
        request.setLGA("Sabo");
        request.setState("Lagos");

        clientsResponse = userService.register(request);
        client = clientsResponse.getUser();

        RegisterRequest request2 = new RegisterRequest();
        request2.setFirstName("Seun");
        request2.setLastName("Bond");
        request2.setPassword("9111");
        request2.setEmail("seun@gmail.com");
        request2.setAddress("No 30, Helena Street, Idumota, Lagos");
        request2.setPhoneNumber("08134856789");
        request2.setRole(Role.SPECIALIST);
        request2.setCategory(Category.STRUCTURAL);
        request2.setLGA("Sabo");
        request2.setState("Lagos");

        specialistResponse = userService.register(request2);
        specialist = specialistResponse.getUser();

        SendReviewRequest reviewRequest = new SendReviewRequest();
        reviewRequest.setRating(4);
        reviewRequest.setComment("The service was good");
        reviewRequest.setReceiverId(specialist.getId());
        reviewRequest.setSenderId(client.getId());
        response = reviewService.sendReview(reviewRequest);
        review = response.getReview();
    }

    @Test
    public void sendReview(){

        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Review sent successfully");
        reviewService.deleteAll();
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
    }

    @Test
    public void testFindReview(){
        Review foundReview = reviewService.findById(review.getReviewId());
        assertThat(foundReview).isNotNull();
        assertThat(foundReview.getComment()).isEqualTo("The service was good");
        reviewService.deleteAll();
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
    }

    @Test
    public void testDeleteReview(){
        Review foundReview = reviewService.findById(review.getReviewId());
        assertThat(foundReview).isNotNull();
        reviewService.deleteById(foundReview.getReviewId());
        assertThrows(ReviewNotFoundException.class, ()->reviewService.findById(foundReview.getReviewId()));
        reviewService.deleteAll();
        clientService.deleteAll();
        specialistService.deleteAll();
        supplierService.deleteAll();
        userService.deleteAll();
    }


}
