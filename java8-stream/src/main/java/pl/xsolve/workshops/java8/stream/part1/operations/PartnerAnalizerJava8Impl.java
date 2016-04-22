package pl.xsolve.workshops.java8.stream.part1.operations;

import pl.xsolve.workshops.java8.stream.Partner;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class PartnerAnalizerJava8Impl extends PartnerAnalizerBasic {

    public PartnerAnalizerJava8Impl(Collection<Partner> partners) {
        super(partners);
    }

    /**
     * Implement based on the Java7 version of this method.
     */
    @Override
    //TODO: leave unimplemented
    public List<Partner> findBlondes(){
        return partners.stream()
                .filter(Partner::isBlonde)
                .collect(Collectors.toList());
    }

    /**
     * Implement based on the Java7 version of this method.
     */
    @Override
    public Optional<Partner> findSmartestBlonde(){
        //TODO: leave unimplemented
        return findBlondes().stream()
                .max((Partner p1, Partner p2) -> p1.getIq().compareTo(p2.getIq()));
    }

    //TODO: leave unimplemented
    /**
     * Implement based on the Java7 version of this method.
     */
    @Override
    public Optional<Integer> getAvgIq() {
       return getAverage(Partner::getIq);
    }

    //TODO: leave unimplemented
    /**
     * Implement based on the Java7 version of this method.
     */
    @Override
    public Optional<Integer> getAvgAge() {
        return getAverage(Partner::getAge);
    }

    protected Optional<Integer> getAverage(ToIntFunction<Partner> function) {
        OptionalDouble avarage = partners.stream().mapToInt(function).average();
        if (avarage.isPresent()){
            return Optional.of((int)(avarage.getAsDouble()));
        } else {
            return Optional.empty();
        }
    }
}
