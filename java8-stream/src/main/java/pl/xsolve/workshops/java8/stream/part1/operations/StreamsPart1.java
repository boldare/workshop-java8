package pl.xsolve.workshops.java8.stream.part1.operations;

import pl.xsolve.workshops.java8.stream.Partner;

import java.util.List;

public interface StreamsPart1 {
    List<Partner> findBlondes(List<Partner> potentialPartners);

    Partner findSmartestBlonde(List<Partner> potentialPartners);

}
