package practice.yogiyo.entity.Menu;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "options")
public class Option {
    @Id
    @GeneratedValue
    @Column(name = "option_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_category_id")
    private OptionCategory optionCategory;

    private String name;
    private Integer price;
}
