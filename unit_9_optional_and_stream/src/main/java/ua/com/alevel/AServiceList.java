package ua.com.alevel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AServiceList implements AService {

    private List<A> aList = new ArrayList<>();

    @Override
    public void createA(A a) {
        aList.add(a);
    }

    @Override
    public Collection<A> findAll() {
        return aList;
    }
}
