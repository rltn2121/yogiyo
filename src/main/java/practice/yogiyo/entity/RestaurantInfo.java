package practice.yogiyo.entity;

import javax.persistence.Embeddable;

@Embeddable
public class RestaurantInfo {
    private String notice;
    private String businessHours;
    private String businessRegistrationNumber;
    private String phone;
    private String origin;
    private String isDeliver;
    private String isYogiyoPlus;
    private String isSuperRedWeek;
    private String isOurVillagePlus;
    private String isBest;
    private String isCesco;
}
