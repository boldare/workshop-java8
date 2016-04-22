package pl.xsolve.workshops.java8.stream.part1.operations;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.xsolve.workshops.java8.stream.Partner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartnerAnalizerBasicTest {

    private List<Partner> partners = new ArrayList<>();

    @Before
    public void setup(){
        partners = Arrays.asList(
                new Partner.Builder().setName("Roberta").setBlonde(true).setIq(100).setAge(17).build(),
                new Partner.Builder().setName("Elfriede").setBlonde(false).setIq(180).setAge(30).build(),
                new Partner.Builder().setName("Conan").setBlonde(true).setIq(160).setAge(25).build(),
                new Partner.Builder().setName("Bruce").setBlonde(false).setIq(100).setAge(31).build()
        );
    }

    @Test
    public void shouldFindAllBlondesOldJava(){
        List<Partner> blondes = new PartnerAnalizerOldJavaImpl(partners).findBlondes();
        Assert.assertArrayEquals(new String[]{"Roberta", "Conan"},
                blondes.stream().map(Partner::getName).toArray());
    }

    @Test
    public void shouldFindAllBlondesJava8(){
        List<Partner> blondes = new PartnerAnalizerOldJavaImpl(partners).findBlondes();
        Assert.assertArrayEquals(new String[]{"Roberta", "Conan"},
                blondes.stream().map(Partner::getName).toArray());
    }

    @Test
    public void shouldFindSmartestBlondeOldJava(){
        Partner smartestBlonde = new PartnerAnalizerOldJavaImpl(partners).findSmartestBlonde().get();
        Assert.assertEquals("Conan", smartestBlonde.getName());
    }

    @Test
    public void shouldFindSmartestBlondeJava8(){
        Partner smartestBlonde = new PartnerAnalizerJava8Impl(partners).findSmartestBlonde().get();
        Assert.assertEquals("Conan", smartestBlonde.getName());
    }

    @Test
    public void shouldCalculateAverageAgeOldJava(){
        int averageAge = new PartnerAnalizerJava8Impl(partners).getAvgAge().get();
        Assert.assertEquals(25, averageAge);
    }

    @Test
    public void shouldCalculateAverageAgeJava8(){
        int averageAge = new PartnerAnalizerOldJavaImpl(partners).getAvgAge().get();
        Assert.assertEquals(25, averageAge);
    }

    @Test
    public void shouldCalculateAverageIqOldJava(){
        int averageIq = new PartnerAnalizerJava8Impl(partners).getAvgIq().get();
        Assert.assertEquals(135, averageIq);
    }

    @Test
    public void shouldCalculateAverageIqJava8(){
        int averageIq = new PartnerAnalizerOldJavaImpl(partners).getAvgIq().get();
        Assert.assertEquals(135, averageIq);
    }
}
