package practice.yogiyo;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing
@SpringBootApplication
public class YogiyoApplication {

	public static void main(String[] args) {
		SpringApplication.run(YogiyoApplication.class, args);
	}

	// createdBy, lastModifiedBy
	@Bean
	public AuditorAware<String> auditorProvider() {
		return ()-> Optional.of(UUID.randomUUID().toString());
	}

	@Bean
	JPAQueryFactory jpaQueryFactory(EntityManager em) {
		return new JPAQueryFactory(em);
	}
}
