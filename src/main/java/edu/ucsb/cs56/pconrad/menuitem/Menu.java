package edu.ucsb.cs56.pconrad.menuitem;
import java.util.*;

public class Menu {
	
    private ArrayList<MenuItem> menuitems;
    private static final String nl = System.lineSeparator();

    public Menu() {
        menuitems = new ArrayList<MenuItem>();
    }

    public void add(MenuItem mi) {
        this.menuitems.add(mi);
    }

    public String csv() {
        String tem = "";
        for (int i = 0; i < this.menuitems.size(); i++) {
            tem += this.menuitems.get(i);
            tem += Menu.nl;
        }
        return tem;
    }


    public String csvSortedByPriceThenName() {
        Comparator<MenuItem> compareByPriceThenName = new Comparator<MenuItem>() {
            public int compare(MenuItem s1, MenuItem s2) {
                if (s1.getPriceInCents() == s2.getPriceInCents()) {
                    return s1.getName().compareTo(s2.getName());
                } else {
                    return s1.getPriceInCents() - s2.getPriceInCents();
                }
            }
        };
        Collections.sort(menuitems, compareByPriceThenName);
        return csv();
    }

    public String csvSortedByName() {
        Collections.sort(menuitems, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        return csv();
    }

    public String csvSortedByCategoryThenName() {
        Comparator<MenuItem> compareByCategoryThenName = new Comparator<MenuItem>() {
            public int compare(MenuItem s1, MenuItem s2) {
                if (s1.getCategory().equals(s2.getCategory())) {
                    return s1.getName().compareTo(s2.getName());
                } else {
                    return s1.getCategory().compareTo(s2.getCategory());
                }
            }
        };
        Collections.sort(menuitems, compareByCategoryThenName);
        return csv();
    }

    public String csvSortedByCategoryThenPriceDescendingThenByName() {
        Comparator<MenuItem> compareByCategoryThenPriceDescendingThenByName = new Comparator<MenuItem>() {
            public int compare(MenuItem s1, MenuItem s2) {
                if (s1.getCategory().equals(s2.getCategory())) {
                    if (s1.getPriceInCents() == s2.getPriceInCents()) {
                        return s1.getName().compareTo(s2.getName());
                    } else {
                        return s2.getPriceInCents() - s1.getPriceInCents();
                    }
                } else {
                    return s1.getCategory().compareTo(s2.getCategory());
                }
            }
        };
        Collections.sort(menuitems, compareByCategoryThenPriceDescendingThenByName);
        return csv();
    }
}
