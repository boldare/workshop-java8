package pl.xsolve.workshops.java8.stream.part1.operations;

import pl.xsolve.workshops.java8.stream.Partner;
import pl.xsolve.workshops.java8.stream.PartnerAnalizer;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class PartnerAnalizerBasic extends PartnerAnalizer {

    public PartnerAnalizerBasic(Collection<Partner> partners) {
        super(partners);
    }

    public abstract List<Partner> findBlondes();

    public abstract Optional<Partner>  findSmartestBlonde();

    public abstract Optional<Integer> getAvgIq();

    public abstract Optional<Integer> getAvgAge();
}
