package data;

import java.util.Locale;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return isCityTraversed == city.isCityTraversed &&
                kilometersRequired == city.kilometersRequired &&
                Objects.equals(cityName, city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName, isCityTraversed, kilometersRequired);
    }

    @Override
    public String toString() {
        return String.format(
                Locale.ENGLISH,
                "%-30s | %-30s | %-30s",
                "City Name: " + this.getCityName(),
                "Visited: " + (this.isCityTraversed() ? "Yes" : "No"),
                "Kilometers Required: " + this.getKilometersRequired() + " kms"
        );
    }
}
