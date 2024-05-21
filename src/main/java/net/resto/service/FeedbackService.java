package net.resto.service;

import net.resto.entity.Feedback;
import net.resto.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    public void saveFeedback(Feedback feedback){
        feedbackRepository.save(feedback);
    }
}
