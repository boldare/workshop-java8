package pl.xsolve.workshops.java8.stream.part1;

import java.util.ArrayList;
import java.util.List;

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
    public Partner findSmartestBlonde(final List<Partner> potentialPartners){
        List<Partner> blondes = findBlondes(potentialPartners);
        Partner smartestSoFar = potentialPartners.get(0);
        for (Partner partner : blondes){
            if (partner.getIq() > smartestSoFar.getIq()){
                smartestSoFar = partner;
            }
        }
        return smartestSoFar;
    }

    @Override
    public void addYears(int i, List<Partner> partners) {
        for (Partner partner : partners){
            partner.setAge(partner.getAge() + i);
        }
    }
}
