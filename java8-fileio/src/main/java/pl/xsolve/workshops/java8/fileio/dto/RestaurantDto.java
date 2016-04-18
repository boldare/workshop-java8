package pl.xsolve.workshops.java8.fileio.dto;

import java.math.BigDecimal;

public class RestaurantDto {

    public static final String DEFAULT_SEPARATOR = ";";

    protected BigDecimal lat;
    protected BigDecimal lon;

    protected String city;
    protected String zipCode;
    protected String address;

    public RestaurantDto(String line) {
        try {
            String[] splitted = line.split(DEFAULT_SEPARATOR);

            this.lat = new BigDecimal(splitted[0]);
            this.lon = new BigDecimal(splitted[1]);

            this.city = splitted[2];
            this.zipCode = splitted[3];
            this.address = splitted[4];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BigDecimal getLat() {
        return lat;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestaurantDto that = (RestaurantDto) o;

        if (lat != null ? !lat.equals(that.lat) : that.lat != null) return false;
        if (lon != null ? !lon.equals(that.lon) : that.lon != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (zipCode != null ? !zipCode.equals(that.zipCode) : that.zipCode != null) return false;
        return !(address != null ? !address.equals(that.address) : that.address != null);

    }

    @Override
    public int hashCode() {
        int result = lat != null ? lat.hashCode() : 0;
        result = 31 * result + (lon != null ? lon.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
