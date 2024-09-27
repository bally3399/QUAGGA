package africa.semicolon.com.quagga.services;

import africa.semicolon.com.quagga.data.models.Review;
import africa.semicolon.com.quagga.dtos.Response.SendReviewResponse;
import africa.semicolon.com.quagga.dtos.request.SendReviewRequest;

public interface ReviewService {
    SendReviewResponse sendReview(SendReviewRequest reviewRequest);
    Review findById(long id);
    void deleteById(long id);

    void deleteAll();
}
