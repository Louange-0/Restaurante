package net.resto.controller;

import net.resto.entity.Feedback;
import net.resto.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public String submitFeedback(@RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String message) {
        Feedback feedback = new Feedback();
        feedback.setName(name);
        feedback.setEmail(email);
        feedback.setMessage(message);

        feedbackService.saveFeedback(feedback);

        // Redirect to the thanks page after successful submission
        return "redirect:/thanks";
    }
}
