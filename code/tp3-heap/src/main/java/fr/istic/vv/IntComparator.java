package fr.istic.vv;

import java.util.Comparator;

public class IntComparator implements Comparator<Integer>{

    public int compare(Integer o1,Integer o2){
        return o1 - o2;
    }
}