

import java.io.File;
import java.io.FileNotFoundException;
import java.security.Key;
import java.util.LinkedList;
import java.util.Scanner;

public class CDRC {
//-----------------------------------------------------
// Title: CDRC Class
// Author: Azerhan BAĞCI
// Description: This class writes a management system code in java using binary search trees for their captain's salary
// increase.
//-----------------------------------------------------
    public static void main(String[] args) throws FileNotFoundException {
        int id = 0, satisfaction;
        int[] a = new int[100];
        String captain;
        BST<Integer, Captain> bst = new BST<Integer, Captain>();

        Scanner sc = new Scanner(new File("input_Q2.txt"));
        while(sc.hasNext()) {
            String s = sc.next();
            switch (s) {
                case "Add_Captain" -> {
                    id = Integer.parseInt(sc.next());
                    captain = sc.next();
                    Captain c = new Captain();
                    c.setName(captain);
                    bst.put(id,c);
                    System.out.println("Add Captain: Add a new captain record in the System\n");
                    printCaptain(id, bst.get(id));
                    System.out.println("----------------------------------------------------------------");
                }
                case "Is_Available" -> {
                    id = Integer.parseInt(sc.next());
                    System.out.print("IsAvailable: ");
                    if(bst.get(id) == null)
                        System.out.println("Couldn't find any captain with ID number " + id + "\n");
                    else if (!bst.get(id).isAvailable())
                        System.out.println("The captain " + bst.get(id).getName() + " is not available. He is on another ride!\n");
                    else
                        System.out.println("Reserve a new Ride with captain " + id + "\n");
                    System.out.println("----------------------------------------------------------------");
                }
                case "Display_captain" -> {
                    id = Integer.parseInt(sc.next());
                    System.out.print("Display Captain:");
                    if(bst.get(id) == null)
                        System.out.println("Couldn't find any captain with ID number " + id + "\n");
                    else {
                        System.out.println();
                        printCaptain(id, bst.get(id));
                    }
                    System.out.println("----------------------------------------------------------------");
                }
                case "Finish" -> {
                    id = Integer.parseInt(sc.next());
                    satisfaction = Integer.parseInt(sc.next());
                    System.out.print("Finish: ");
                    if(bst.get(id) == null)
                        System.out.println("Couldn't find any captain with ID number");
                    else if(bst.get(id).isAvailable())
                        System.out.println("The captain " + bst.get(id).getName() + " is not in a ride!");
                    else {
                        if(satisfaction == 0)
                            bst.get(id).setRatingstar(bst.get(id).getRatingstar()-1);
                        else if(satisfaction == 1)
                            bst.get(id).setRatingstar(bst.get(id).getRatingstar()+1);
                        if(bst.get(id).getRatingstar() > 5)
                            bst.get(id).setRatingstar(5);
                        if(bst.get(id).getRatingstar() < 0)
                            bst.get(id).setRatingstar(0);
                        System.out.println("Finish ride with captain " + id + "\n");
                        printCaptain(id, bst.get(id));
                    }
                    System.out.println("----------------------------------------------------------------");
                }
                case "Delete_captain" -> {
                    id = Integer.parseInt(sc.next());
                    System.out.print("Delete Captain: ");
                    if(bst.get(id) == null)
                        System.out.println("Couldn't find any captain with ID number " + id);
                    else {
                        System.out.println("The captain " + bst.get(id).getName() + " left CCR");
                        bst.delete(id);
                    }
                    System.out.println("----------------------------------------------------------------");
                }
                case "Display_all_captains" -> {
                    System.out.println("Captains: \n");
                    printCaptains(bst);
                }
            }
        }
        System.out.println("Thank you for using CDRC, Good Bye!");
    }

    public static void printCaptain(int i, Captain c) {
    //--------------------------------------------------------
    // Summary: Prints information when given two values.
    // Precondition: i is int and c is Captain
    // Postcondition: Information printed.
    //--------------------------------------------------------
        System.out.println("ID: " + i);
        System.out.println(c.toString());
    }

    public static void printCaptains(BST<Integer, Captain> bst) {
        //--------------------------------------------------------
        // Summary: Calls printCaptain(a, b) where a is int and b is Captain in a loop when given a value.
        // Precondition: bst is a BST<Integer, Captain>
        // Postcondition: printCaptain(a, b) is called in a loop.
        //--------------------------------------------------------
        Queue<Integer> q = (Queue<Integer>) bst.keys();
        LinkedList<Integer> list = new LinkedList<Integer>();
        int n = q.size();
        for(int i = 0; i < n; i++) {
            list.add(q.dequeue());
        }
        System.out.println("----------ALL CAPTAINS----------");
        for(Integer i: list) {
            System.out.println("\n--CAPTAIN:\n");
            printCaptain(i, bst.get(i));
        }

    }
}
