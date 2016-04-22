package pl.xsolve.workshops.java8.stream.part2.lazy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.xsolve.workshops.java8.stream.Partner;
import pl.xsolve.workshops.java8.stream.PartnerAnalizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PartnerAnalizerLazyTest {

    protected static final String F = "F";
    protected static final String M = "M";
    protected List<Partner> partners = new ArrayList<>();

    @Before
    public void setup(){
        partners = Arrays.asList(
                new Partner.Builder().setName("Laura").setGender(F).setBlonde(true).setIq(100).setAge(17).build(),
                new Partner.Builder().setName("Bob").setGender(M).setBlonde(true).setIq(200).setAge(20).build(),
                new Partner.Builder().setName("Sonia").setGender(F).setBlonde(false).setIq(180).setAge(30).build(),
                new Partner.Builder().setName("May").setGender(F).setBlonde(true).setIq(160).setAge(25).build(),
                new Partner.Builder().setName("Hanna").setGender(F).setBlonde(false).setIq(100).setAge(31).build(),
                new Partner.Builder().setName("Steven").setGender(M).setBlonde(false).setIq(150).setAge(36).build(),
                new Partner.Builder().setName("Sandra").setGender(F).setBlonde(true).setIq(255).setAge(38).build(),
                new Partner.Builder().setName("Rick").setGender(M).setBlonde(true).setIq(80).setAge(30).build(),
                new Partner.Builder().setName("Evan").setGender(M).setBlonde(false).setIq(175).setAge(20).build()
        );
    }

    @Test
    public void areAllBlondesShouldReturnFalseOldJava(){
        PartnerAnalizerLazy analizer = new PartnerAnalizerOldJavaImpl(partners);
        Assert.assertFalse(analizer.areAllBlondes());
    }

    @Test
    public void areAllBlondesShouldReturnFalseJava8(){
        PartnerAnalizerLazy analizer = new PartnerAnalizerJava8Impl(partners);
        Assert.assertFalse(analizer.areAllBlondes());
    }

    @Test
    public void areAllBlondesShouldBeLazy(){
        PartnerAnalizerLazy analizer = new PartnerAnalizerJava8Impl(partners);
        analizer.areAllBlondes();
        Assert.assertEquals(new Integer(3), analizer.getProcessedEntriesCounter());
    }


    @Test
    public void findAnyMaleBlondeSmarterThan200OldJava(){
        PartnerAnalizerLazy analizer = new PartnerAnalizerOldJavaImpl(partners);
        Optional<Partner> found = analizer.findAnyMaleBlondeSmarterThan(200);
        Assert.assertEquals("actual: " + found.get().getName(), "Bob", found.get().getName());
    }

    @Test
    public void findAnyMaleBlondeSmarterThan200Java8(){
        PartnerAnalizerLazy analizer = new PartnerAnalizerJava8Impl(partners);
        Optional<Partner> found = analizer.findAnyMaleBlondeSmarterThan(200);
        Assert.assertEquals("actual: " + found.get().getName(), "Bob", found.get().getName());
    }

    @Test
    public void findAnyMaleBlondeSmarterThan200ShouldBeLazy(){
        PartnerAnalizerLazy analizer = new PartnerAnalizerJava8Impl(partners);
        analizer.findAnyMaleBlondeSmarterThan(200);
        Assert.assertEquals(new Integer(2), analizer.getProcessedEntriesCounter());
    }

    @Test
    public void find2MostIntelligentFemalesOldJava(){
        PartnerAnalizerLazy analizer = new PartnerAnalizerOldJavaImpl(partners);
        List<Partner> found = analizer.findMostIntelligentFemales(2);
        Assert.assertArrayEquals(new String[]{"Sandra", "Sonia"}, found.stream().map(Partner::getName).toArray());
    }

    @Test
    public void find2MostIntelligentFemalesJava8(){
        PartnerAnalizerLazy analizer = new PartnerAnalizerJava8Impl(partners);
        List<Partner> found = analizer.findMostIntelligentFemales(2);
        Assert.assertArrayEquals(new String[]{"Sandra", "Sonia"}, found.stream().map(Partner::getName).toArray());
    }

    @Test
    public void whenSortingTheresNoWayToGetLazy(){
        PartnerAnalizerLazy analizer = new PartnerAnalizerJava8Impl(partners);
        analizer.findMostIntelligentFemales(2);
        Assert.assertEquals(new Integer(partners.size()), analizer.getProcessedEntriesCounter());
    }

}
