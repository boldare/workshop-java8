package pl.xsolve.workshops.java8.stream.part1;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsPart1Java8Impl implements StreamsPart1 {

    @Override
    public List<Partner> findBlondes(final List<Partner> potentialPartners){
        //TODO: leave unimplemented
        return potentialPartners.stream().filter(Partner::isBlonde).collect(Collectors.toList());
    }

    @Override
    public Partner findSmartestBlonde(final List<Partner> potentialPartners){
        //TODO: leave unimplemented
        return findBlondes(potentialPartners).stream().max((p1, p2) -> p1.getAge().compareTo(p2.getAge())).orElse(potentialPartners.get(0));
    }

    @Override
    public void addYears(int i, List<Partner> partners) {
        partners.parallelStream()
                .forEach(p -> p.setAge(p.getAge() + i));

    }
}
