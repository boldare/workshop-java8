package pl.xsolve.workshops.java8.stream;

import java.util.Collection;

public abstract class PartnerAnalizer {

    protected Collection<Partner> partners;

    public PartnerAnalizer(Collection<Partner> partners) {
        this.partners = partners;
    }

}
