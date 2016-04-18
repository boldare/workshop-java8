package pl.xsolve.workshops.java8.stream.part1.operations;

import pl.xsolve.workshops.java8.stream.Partner;

import java.util.*;
import java.util.function.ToIntFunction;

public class PartnerAnalizerJava8Impl extends PartnerAnalizerBasic {

    public PartnerAnalizerJava8Impl(Collection<Partner> partners) {
        super(partners);
    }

    // TODO: Implement based on the Java7 version of this method.
    @Override
    public List<Partner> findBlondes(){
        return new ArrayList<>();
    }

    // TODO: Implement based on the Java7 version of this method.
    @Override
    public Optional<Partner> findSmartestBlonde(){
        return Optional.empty();
    }

    // TODO: Implement based on the Java7 version of this method.
    @Override
    public Optional<Integer> getAvgIq() {
       return Optional.empty();
    }

    //TODO: Implement based on the Java7 version of this method.
    @Override
    public Optional<Integer> getAvgAge() {
        return Optional.empty();
    }

    //TODO: Implement a universal method of counting an average of any Integer field of Partner class
    protected Optional<Integer> getAverage(ToIntFunction<Partner> function) {
        return Optional.empty();
    }
}
