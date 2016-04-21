package pl.xsolve.workshops.java8.stream.part1.operations;

import pl.xsolve.workshops.java8.stream.Partner;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsPart1Java8Impl implements StreamsPart1 {

    /**
     * Implement based on the Java7 version of this method.
     */
    @Override
    //TODO: leave unimplemented
    public List<Partner> findBlondes(final List<Partner> potentialPartners){
        return potentialPartners.stream()
                .filter(Partner::isBlonde)
                .collect(Collectors.toList());
    }


    /**
     * Implement based on the Java7 version of this method.
     */
    @Override
    public Partner findSmartestBlonde(final List<Partner> potentialPartners){
        //TODO: leave unimplemented
        return findBlondes(potentialPartners).stream()
                .max((p1, p2) -> p1.getAge().compareTo(p2.getAge()))
                .orElse(potentialPartners.get(0));
    }

}
