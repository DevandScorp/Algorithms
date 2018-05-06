package Sortings;

import java.util.Comparator;

public class Comparator_Example {
    public static final Comparator<Comparator_Example> BY_NAME = new ByName();
    private static class ByName implements Comparator<Comparator_Example>{

        @Override
        public int compare(Comparator_Example o1, Comparator_Example o2) {
            return 0;
        }
    }
}
