package data;

public class City {
    private String cityName;
    private boolean isCityTraversed;
    private int kilometersRequired;

    public City(String cityName, boolean isCityTraversed, int kilometersRequired) {
        this.cityName = cityName;
        this.isCityTraversed = isCityTraversed;
        this.kilometersRequired = kilometersRequired;
    }
}
