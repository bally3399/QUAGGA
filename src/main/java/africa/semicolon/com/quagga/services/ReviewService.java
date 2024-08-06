package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Review;
import africa.semicolon.com.quagga.dtos.request.SendReviewRequest;
import africa.semicolon.com.quagga.dtos.response.SendReviewResponse;

public interface ReviewService {
    SendReviewResponse sendReview(SendReviewRequest reviewRequest);
    Review findById(long id);
    void deleteById(long id);
}
