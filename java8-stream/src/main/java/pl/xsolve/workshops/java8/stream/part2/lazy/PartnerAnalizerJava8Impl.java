package pl.xsolve.workshops.java8.stream.part2.lazy;

import pl.xsolve.workshops.java8.stream.Partner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class PartnerAnalizerJava8Impl extends PartnerAnalizerLazy {

    public PartnerAnalizerJava8Impl(Collection<Partner> partners) {
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
     * //TODO: Implement based on the Java7 version of this method.
     * Ensure that after execution, "processedEntriesCounter"
     * contains the number of tests of the "blonde" condition.
     */
    @Override
    public boolean areAllBlondes() {
        return true;
    }

    /**
     * //TODO: Implement based on the Java7 version of this method.
     * Ensure that after execution, "processedEntriesCounter"
     * contains the number of tests of the "gender" condition.
     */
    @Override
    public Optional<Partner> findAnyMaleBlondeSmarterThan(int thresholdIq) {
        return Optional.empty();
    }

    /**
     * //TODO: Implement based on the Java7 version of this method.
     * Ensure that after execution, "processedEntriesCounter"
     * contains the number of tests of the "gender" condition.
     */
    @Override
    public List<Partner> findMostIntelligentFemales(int howMany) {
        return new ArrayList<>();
    }

}
