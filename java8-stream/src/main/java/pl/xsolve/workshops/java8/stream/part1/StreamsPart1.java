package pl.xsolve.workshops.java8.stream.part1;

import java.util.List;

public interface StreamsPart1 {
    List<Partner> findBlondes(List<Partner> potentialPartners);

    Partner findSmartestBlonde(List<Partner> potentialPartners);
}
