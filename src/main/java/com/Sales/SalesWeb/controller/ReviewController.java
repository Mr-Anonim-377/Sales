package com.Sales.SalesWeb.controller;

import com.Sales.SalesWeb.controller.requestDto.ReviewRequest.ProductReviewRequest;
import com.Sales.SalesWeb.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "review/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReviewController extends AbstractController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping(value = "product",produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity createProductReview(@RequestBody ProductReviewRequest productReviewRequest){
            reviewService.createProductReview(productReviewRequest);
            return new ResponseEntity<>(HttpStatus.OK);
    }

}