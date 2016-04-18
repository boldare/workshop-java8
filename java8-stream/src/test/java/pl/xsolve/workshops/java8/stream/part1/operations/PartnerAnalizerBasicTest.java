package pl.xsolve.workshops.java8.stream.part1.operations;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.xsolve.workshops.java8.stream.Partner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        List<Partner> blondes = new PartnerAnalizerJava8Impl(partners).findBlondes();
        Assert.assertArrayEquals(new String[]{"Roberta", "Conan"},
                blondes.stream().map(Partner::getName).toArray());
    }

    @Test
    public void shouldFindSmartestBlondeOldJava(){
        Optional<Partner> smartestBlonde = new PartnerAnalizerOldJavaImpl(partners).findSmartestBlonde();
        Assert.assertTrue(smartestBlonde.isPresent());
        Assert.assertEquals("Conan", smartestBlonde.get().getName());
    }

    @Test
    public void shouldFindSmartestBlondeJava8(){
        Optional<Partner> smartestBlonde = new PartnerAnalizerJava8Impl(partners).findSmartestBlonde();
        Assert.assertTrue(smartestBlonde.isPresent());
        Assert.assertEquals("Conan", smartestBlonde.get().getName());
    }

    @Test
    public void shouldCalculateAverageAgeOldJava(){
        Optional<Integer> averageAge =  new PartnerAnalizerOldJavaImpl(partners).getAvgAge();
        Assert.assertTrue(averageAge.isPresent());
        Assert.assertEquals(new Integer(25), averageAge.get());
    }

    @Test
    public void shouldCalculateAverageAgeJava8(){
        Optional<Integer> averageAge = new PartnerAnalizerJava8Impl(partners).getAvgAge();
        Assert.assertTrue(averageAge.isPresent());
        Assert.assertEquals(new Integer(25), averageAge.get());
    }

    @Test
    public void shouldCalculateAverageIqOldJava(){
        Optional<Integer> averageIq = new PartnerAnalizerOldJavaImpl(partners).getAvgIq();
        Assert.assertTrue(averageIq.isPresent());
        Assert.assertEquals(new Integer(135), averageIq.get());
    }

    @Test
    public void shouldCalculateAverageIqJava8(){
        Optional<Integer> averageIq = new PartnerAnalizerJava8Impl(partners).getAvgIq();
        Assert.assertTrue(averageIq.isPresent());
        Assert.assertEquals(new Integer(135), averageIq.get());
    }
}
