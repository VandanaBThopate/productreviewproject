package com.product.review.dto;

import java.util.List;

import com.product.review.entity.Product;
import lombok.Builder;

import javax.validation.constraints.NotNull;
@Builder
public class FeedbackDTO {
    private int feedbackId;

    private double rating;
    @NotNull(message = "Feedback cant be null")
    private String feedback;
    private double avgRating;
//    @OneToMany(cascade = CascadeType.ALL)
    private Product products;


    public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }
}
