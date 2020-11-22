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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public boolean isCityTraversed() {
        return isCityTraversed;
    }

    public void setCityTraversed(boolean cityTraversed) {
        isCityTraversed = cityTraversed;
    }

    public int getKilometersRequired() {
        return kilometersRequired;
    }

    public void setKilometersRequired(int kilometersRequired) {
        this.kilometersRequired = kilometersRequired;
    }
}
