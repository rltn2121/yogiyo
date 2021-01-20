package practice.yogiyo.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Payment {
    private String card;
    private String cash;
    private String online;
}
