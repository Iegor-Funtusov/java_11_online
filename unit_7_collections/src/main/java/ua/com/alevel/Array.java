package ua.com.alevel;

public class Array<I> {

    private Object[] array = new Object[10];

    public void add(I o) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = o;
                break;
            }
        }
    }

    public Object[] getArray() {
        return array;
    }
}
