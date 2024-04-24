/**
 * @author Nicolas Gugliemo
 * @date 04/12/2023
 * This program uses the mergeSort alg to split an array list into single elements,
 * then compare each element and merge them back together in a sort of tree looking
 * format to create one array once more.
 */

import java.util.ArrayList;
import java.util.*;

class Main {
    public static int j = 1;

    public static void main(String[] args) {
        ArrayList<Integer> nick = new ArrayList<>(List.of(3,5,7,0,3,7,8,3,5,9,10,100,55)); //Size 13
        Collections.copy(nick, mergeSort(nick)); // Copy over sorted list to old list
        System.out.println(nick);    //Print new list
    }
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> nick) {

        if (nick.size() ==1) {
            return nick; //Recursive end condition
        }

        ArrayList<Integer> split1 = new ArrayList<>();
        ArrayList<Integer> split2 = new ArrayList<>();

        int midpoint= nick.size()/2; //Find midpoint of list
        int i =0;

        while (i<midpoint) {
            split1.add(nick.get(i));  //Split first half of list
            i++;
        }
        while (i<nick.size()) {
            split2.add(nick.get(i));  //Split second half of list
            i++;
        }

        System.out.println("Split " +j);  // Can ignore, just shows process of splits
        System.out.println(split1);
        System.out.println(split2);
        j++;

        split1 = mergeSort(split1);      // calls mergeSort to recursively split until single elements left
        split2 = mergeSort(split2);

        return mergeList(split1,split2);  // calls MergeList to compare single elements and stitch them back together
    }
    public static ArrayList<Integer> mergeList (ArrayList<Integer> split1, ArrayList<Integer> split2){

        ArrayList<Integer> split3 = new ArrayList<>(); //Arraylist that is returned

        while (!split1.isEmpty() && !split2.isEmpty()) {  // While there are elements, check to see which element is smaller,
            if (split1.get(0) > split2.get(0)) {          // place the smaller of the two into the third list we are building.
                split3.add(split2.get(0));
                split2.remove(0);
            } else {                                      // If second list is larger, put the first list's element into the third list
                split3.add(split1.get(0));
                split1.remove(0);
            }
        }
        while (!split1.isEmpty()) {                       // If one of the lists emptys before the other, these two while loops cleans up the rest
            split3.add(split1.get(0));                    //List should be in order from least to greatest
            split1.remove(0);
        }
        while (!split2.isEmpty()) {
            split3.add(split2.get(0));
            split2.remove(0);
        }
        return split3;  // Returns the new list
    }
}