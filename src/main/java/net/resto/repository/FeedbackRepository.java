package net.resto.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import net.resto.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}
