package pl.xsolve.workshops.java8.stream.part1;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StreamsPart1Test {

    private static List<Partner> partners = Arrays.asList(
            new Partner(true, 100, 17),
            new Partner(false, 180, 30),
            new Partner(true, 160, 25),
            new Partner(false, 100, 10)
    );

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
}
