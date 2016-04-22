package pl.xsolve.workshops.java8.stream.part2.lazy;

import pl.xsolve.workshops.java8.stream.Partner;

import java.util.*;

public class PartnerAnalizerOldJavaImpl extends PartnerAnalizerLazy {

    public PartnerAnalizerOldJavaImpl(Collection<Partner> partners) {
        super(partners);
    }

    @Override
    public boolean areAllBlondes() {
        for (Partner p : partners){
            if (! p.getBlonde())
                return false;
        }
        return true;
    }

    @Override
    public Optional<Partner> findAnyMaleBlondeSmarterThan(int thresholdIq) {
        for (Partner p : partners){
            if (p.getBlonde() && "M".equals(p.getGender()) && thresholdIq <= p.getIq()){
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Partner> findMostIntelligentFemales(int howMany) {
        List<Partner> females = new ArrayList<>();
        for (Partner p : partners){
            if ("F".equals(p.getGender())){
                females.add(p);
            }
        }

        females.sort(new Comparator<Partner>() {
            @Override
            public int compare(Partner o1, Partner o2) {
                return o2.getIq().compareTo(o1.getIq());
            }
        });

        List<Partner> resultList = new ArrayList<>();
        for (int i = 0; i<howMany; i++){
            resultList.add(females.get(i));
        }
        return resultList;
    }
}
