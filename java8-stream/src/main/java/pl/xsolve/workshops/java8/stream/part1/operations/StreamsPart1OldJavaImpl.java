package pl.xsolve.workshops.java8.stream.part1.operations;

import pl.xsolve.workshops.java8.stream.Partner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamsPart1OldJavaImpl implements StreamsPart1 {

    @Override
    public List<Partner> findBlondes(final List<Partner> potentialPartners){
        List<Partner> blondes = new ArrayList<>();
        for (Partner partner : potentialPartners){
            if (partner.isBlonde()){
                blondes.add(partner);
            }
        }
        return blondes;
    }

    @Override
    public Optional<Partner> findSmartestBlonde(final List<Partner> potentialPartners){
        List<Partner> blondes = findBlondes(potentialPartners);
        if (blondes.isEmpty()){
            return Optional.empty();
        }
        Optional<Partner> smartestSoFar = Optional.of(blondes.get(0));
        for (Partner partner : blondes){
            if (partner.getIq() > smartestSoFar.get().getIq()) {
                smartestSoFar = Optional.of(partner);
            }
        }
        return smartestSoFar;
    }
}
