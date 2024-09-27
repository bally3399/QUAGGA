package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Review;
import africa.semicolon.com.quagga.data.models.User;
import africa.semicolon.com.quagga.data.repositories.ReviewRepository;
import africa.semicolon.com.quagga.dtos.Response.SendReviewResponse;
import africa.semicolon.com.quagga.dtos.request.SendReviewRequest;
import africa.semicolon.com.quagga.exceptions.ReviewNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final UserService userService;

    @Override
    public SendReviewResponse sendReview(SendReviewRequest reviewRequest) {
        Long senderId = reviewRequest.getSenderId();
        Long receiverId = reviewRequest.getReceiverId();
        User sender = userService.findUserById(senderId);
        User receiver = userService.findUserById(receiverId);

        Review newReview = new Review();
        newReview.setReviewSender(sender);
        newReview.setReviewReceiver(receiver);
        newReview.setRating(reviewRequest.getRating());
        newReview.setComment(reviewRequest.getComment());
        Review savedReview =reviewRepository.save(newReview);

        SendReviewResponse response = new SendReviewResponse();
        response.setMessage("Review sent successfully");
        response.setReview(savedReview);
        return response;
    }

    @Override
    public Review findById(long id) {
        return reviewRepository.findById(id)
                .orElseThrow(()-> new ReviewNotFoundException("Review not found"));
    }

    @Override
    public void deleteById(long id) {
        Review review = findById(id);
        reviewRepository.delete(review);
    }

    @Override
    public void deleteAll() {
        reviewRepository.deleteAll();
    }

}
