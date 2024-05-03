package ua.com.alevel;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AServiceSet implements AService {

    private Set<A> aSet = new HashSet<>();

    @Override
    public void createA(A a) {
        aSet.add(a);
    }

    @Override
    public Collection<A> findAll() {
        return aSet;
    }
}
