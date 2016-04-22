package pl.xsolve.workshops.java8.stream.part1.operations;

import pl.xsolve.workshops.java8.stream.Partner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class PartnerAnalizerOldJavaImpl extends PartnerAnalizerBasic {

    public PartnerAnalizerOldJavaImpl(Collection<Partner> partners) {
        super(partners);
    }

    @Override
    public List<Partner> findBlondes(){
        List<Partner> blondes = new ArrayList<>();
        for (Partner partner : partners){
            if (partner.isBlonde()){
                blondes.add(partner);
            }
        }
        return blondes;
    }

    @Override
    public Optional<Partner> findSmartestBlonde(){
        List<Partner> blondes = findBlondes();
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

    @Override
    public Optional<Integer> getAvgIq() {
        if (partners.isEmpty()){
            return Optional.empty();
        }
        int sum=0;
        for (Partner partner : partners){
            sum += partner.getIq();
        }
        return Optional.of(sum/partners.size());
    }

    @Override
    public Optional<Integer> getAvgAge() {
        if (partners.isEmpty()){
            return Optional.empty();
        }
        int sum=0;
        for (Partner partner : partners){
            sum += partner.getAge();
        }
        return Optional.of(sum/partners.size());
    }
}
