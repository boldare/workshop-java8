package pl.xsolve.workshops.java8.stream;

import java.util.function.Predicate;

public class Partner {

    private Boolean blonde;
    private Integer iq;
    private Integer age;
    private String gender;
    private String name;

    private Partner(){
    }

    public Boolean isBlonde() {
        return blonde;
    }

    public void setBlonde(Boolean blonde) {
        this.blonde = blonde;
    }

    public Integer getIq() {
        return iq;
    }

    public void setIq(Integer iq) {
        this.iq = iq;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBlonde() {
        return blonde;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Predicate<Partner> blondePredicate = Partner::isBlonde;

    public static class Builder{
        private Boolean blonde = false;
        private Integer iq = 100;
        private Integer age = 18;
        private String gender = "F";
        private String name;

        public Builder setBlonde(Boolean blonde) {
            this.blonde = blonde;
            return this;
        }

        public Builder setIq(Integer iq) {
            this.iq = iq;
            return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Partner build(){
            Partner partner = new Partner();
            partner.age = this.age;
            partner.iq = this.iq;
            partner.blonde = this.blonde;
            partner.gender = this.gender;
            partner.name = this.name;
            return partner;
        }
    }

    @Override
    public String toString() {
        return "Partner{" +
                "name=" + name +
                "gender=" + gender +
                "blonde=" + blonde +
                ", iq=" + iq +
                ", age=" + age +
                '}';
    }
}
