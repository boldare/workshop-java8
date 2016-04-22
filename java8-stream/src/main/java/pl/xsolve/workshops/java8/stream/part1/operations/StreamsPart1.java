package pl.xsolve.workshops.java8.stream.part1.operations;

import pl.xsolve.workshops.java8.stream.Partner;

import java.util.List;
import java.util.Optional;

public interface StreamsPart1 {
    List<Partner> findBlondes(List<Partner> potentialPartners);

    Optional<Partner> findSmartestBlonde(List<Partner> potentialPartners);

}
