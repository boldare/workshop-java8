package pl.xsolve.workshops.java8.stream.part2.lazy;

import pl.xsolve.workshops.java8.stream.Partner;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PartnerAnalizerSolutions extends PartnerAnalizerLazy {

    public PartnerAnalizerSolutions(Collection<Partner> partners) {
        super(partners);
    }

    protected void incrementCounter(){
        if (processedEntriesCounter == null){
            processedEntriesCounter = 1;
        } else {
            processedEntriesCounter++;
        }
    }

    /**
     * Implement based on the Java7 version of this method.
     * Ensure that after execution, "processedEntriesCounter"
     * contains the number of tests of the "blonde" condition.
     */
    @Override
    public boolean areAllBlondes() {
        return partners.stream()
            .allMatch(p -> {
                incrementCounter();
                return p.isBlonde();
            });
    }

    /**
     * Implement based on the Java7 version of this method.
     * Ensure that after execution, "processedEntriesCounter"
     * contains the number of tests of the "gender" condition.
     */
    @Override
    public Optional<Partner> findAnyMaleBlondeSmarterThan(int thresholdIq) {
        return partners.stream()
                .filter(p -> {
                    incrementCounter();
                    return "M".equals(p.getGender());
                })
                .filter(Partner::isBlonde)
                .filter(p -> Integer.compare(thresholdIq, p.getIq()) <= 0 )
                .findAny();
    }

    /**
     * Implement based on the Java7 version of this method.
     * Ensure that after execution, "processedEntriesCounter"
     * contains the number of tests of the "gender" condition.
     */
    @Override
    public List<Partner> findMostIntelligentFemales(int howMany) {
        return partners.stream()
                .filter(p -> {
                    incrementCounter();
                    return "F".equals(p.getGender());
                })
                .sorted((p1, p2) -> p2.getIq().compareTo(p1.getIq()))
                .limit(howMany)
                .collect(Collectors.toList());
    }

}
