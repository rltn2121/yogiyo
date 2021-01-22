package practice.yogiyo.entity.Review;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.yogiyo.entity.BaseTimeEntity;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewReply extends BaseTimeEntity {
   @Id @GeneratedValue
   @Column(name = "review_reply_id")
   private Long id;

   private String contents;

   @OneToOne
   @JoinColumn(name = "review_id")
   private Review review;

}
