package pl.xsolve.workshops.java8.stream.part2.lazy;

import pl.xsolve.workshops.java8.stream.Partner;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class PartnerAnalizer {

    protected Collection<Partner> partners;
    protected Integer processedEntriesCounter;

    public PartnerAnalizer(Collection<Partner> partners) {
        this.partners = partners;
    }

    public Integer getProcessedEntriesCounter() {
        return processedEntriesCounter;
    }

    public abstract boolean areAllBlondes();

    public abstract Optional<Partner> findAnyMaleBlondeSmarterThan(int thresholdIq);

    public abstract List<Partner> findMostIntelligentFemales(int howMany);

}
