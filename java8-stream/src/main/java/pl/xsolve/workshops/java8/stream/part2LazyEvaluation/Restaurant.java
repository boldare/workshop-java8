package pl.xsolve.workshops.java8.stream.part2LazyEvaluation;

public class Restaurant {

    private Integer storeNumber;
    private String storeType;
    private String address;
    private String city;
    private String state;
    private Boolean playPlace;
    private Boolean driveThrough;
    private Boolean freeWiFi;

    private Restaurant(){
    }

    public Integer getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(Integer storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getPlayPlace() {
        return playPlace;
    }

    public void setPlayPlace(Boolean playPlace) {
        this.playPlace = playPlace;
    }

    public Boolean getDriveThrough() {
        return driveThrough;
    }

    public void setDriveThrough(Boolean driveThrough) {
        this.driveThrough = driveThrough;
    }

    public Boolean getFreeWiFi() {
        return freeWiFi;
    }

    public void setFreeWiFi(Boolean freeWiFi) {
        this.freeWiFi = freeWiFi;
    }


    public static class Builder{
        Integer storeNumber;
        String storeType;
        String address;
        String city;
        String state;
        Boolean playPlace = Boolean.FALSE;
        Boolean driveThrough = Boolean.FALSE;
        Boolean freeWiFi = Boolean.FALSE;

        public Builder setStoreNumber(Integer storeNumber) {
            this.storeNumber = storeNumber;
            return this;
        }

        public Builder setStoreType(String storeType) {
            this.storeType = storeType;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setPlayPlace(Boolean playPlace) {
            this.playPlace = playPlace;
            return this;
        }

        public Builder setDriveThrough(Boolean driveThrough) {
            this.driveThrough = driveThrough;
            return this;
        }

        public Builder setFreeWiFi(Boolean freeWiFi) {
            this.freeWiFi = freeWiFi;
            return this;
        }

        public Restaurant build(){
            Restaurant restaurant = new Restaurant();

            restaurant.storeType = this.storeType;
            restaurant.address = this.address;
            restaurant.city = this.city;
            restaurant.state = this.state;
            restaurant.playPlace = this.playPlace;
            restaurant.driveThrough = this.driveThrough;
            restaurant.freeWiFi = this.freeWiFi;

            return restaurant;
        }
    }
}
