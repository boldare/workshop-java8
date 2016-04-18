package pl.xsolve.workshops.java8.stream.part1;

import java.util.function.Predicate;

public class Partner {

    private Boolean blonde;
    private Integer iq;
    private Integer age;

    public Partner(Boolean blonde, Integer iq, Integer age) {
        this.blonde = blonde;
        this.iq = iq;
        this.age = age;
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

    public Predicate<Partner> blondePredicate = Partner::isBlonde;


    @Override
    public String toString() {
        return "Partner{" +
                "blonde=" + blonde +
                ", iq=" + iq +
                ", age=" + age +
                '}';
    }
}
