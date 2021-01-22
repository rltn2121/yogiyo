package practice.yogiyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.yogiyo.entity.Member.Member;
import practice.yogiyo.entity.Review.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
