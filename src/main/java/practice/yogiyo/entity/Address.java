package practice.yogiyo.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private String region;
}
