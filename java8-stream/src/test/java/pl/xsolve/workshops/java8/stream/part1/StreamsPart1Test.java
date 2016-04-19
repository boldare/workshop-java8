package pl.xsolve.workshops.java8.stream.part1;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsPart1Test {

    private List<Partner> partners = new ArrayList<>();

    @Before
    public void setup(){
        partners = Arrays.asList(
                new Partner(true, 100, 17),
                new Partner(false, 180, 30),
                new Partner(true, 160, 25),
                new Partner(false, 100, 31)
        );
    }

    @Test
    public void shouldFindAllBlondesOldJava(){
        List<Partner> blondes = new StreamsPart1OldJavaImpl().findBlondes(partners);

        Assert.assertArrayEquals(new Partner[]{partners.get(0), partners.get(2)}, blondes.toArray());
    }

    @Test
    public void shouldFindAllBlondesJava8(){
        List<Partner> blondes = new StreamsPart1Java8Impl().findBlondes(partners);

        Assert.assertArrayEquals(new Partner[]{partners.get(0), partners.get(2)}, blondes.toArray());
    }

    @Test
    public void shouldFindSmartestBlondeOldJava(){
        Partner smartestBlonde = new StreamsPart1OldJavaImpl().findSmartestBlonde(partners);
        Assert.assertEquals(partners.get(2), smartestBlonde);
    }

    @Test
    public void shouldFindSmartestBlondeJava8(){
        Partner smartestBlonde = new StreamsPart1Java8Impl().findSmartestBlonde(partners);
        Assert.assertEquals(partners.get(2), smartestBlonde);
    }

    @Test
    public void shouldAddYearsToAgeOldJava(){
        new StreamsPart1OldJavaImpl().addYears(1, partners);
        Assert.assertArrayEquals(new Integer[]{18, 31, 26, 32}, partners.stream().map(Partner::getAge).toArray());
    }

    @Test
    public void shouldAddYearsToAgeJava8(){
        new StreamsPart1Java8Impl().addYears(1, partners);
        Assert.assertArrayEquals(new Integer[]{18, 31, 26, 32}, partners.stream().map(Partner::getAge).toArray());
    }

    @Test
    public void parallelStreamShouldBeFasterThanOldJava(){
        List<Partner> manyPartners = new ArrayList<>();
        for (int i=0; i<10000; i++){
            manyPartners.addAll(partners);
        }

        long startOldJava = System.nanoTime();
        new StreamsPart1OldJavaImpl().addYears(1, manyPartners);
        long oldJavaDuration = System.nanoTime() - startOldJava;

        long startParallel = System.nanoTime();
        new StreamsPart1Java8Impl().addYears(1, manyPartners);
        long java8Duration = System.nanoTime() - startParallel;

        Assert.assertTrue("old Java: " + oldJavaDuration + ", Java8: " + java8Duration, java8Duration < oldJavaDuration);
    }

}
