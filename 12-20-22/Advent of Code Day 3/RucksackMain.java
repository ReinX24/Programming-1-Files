import java.util.ArrayList;
import java.util.HashSet;

public class RucksackMain {

    public static void main(String[] args) {

        /*
         * --- Day 3: Rucksack Reorganization ---
         * 
         * One Elf has the important job of loading all of the rucksacks with supplies
         * for the jungle journey. Unfortunately, that Elf didn't quite follow the
         * packing instructions, and so a few items now need to be rearranged.
         * 
         * Each rucksack has two large compartments. All items of a given type are meant
         * to go into exactly one of the two compartments. The Elf that did the packing
         * failed to follow this rule for exactly one item type per rucksack.
         * 
         * The Elves have made a list of all of the items currently in each rucksack
         * (your puzzle input), but they need your help finding the errors. Every item
         * type is identified by a single lowercase or uppercase letter (that is, a and
         * A refer to different types of items).
         * 
         * The list of items for each rucksack is given as characters all on a single
         * line. A given rucksack always has the same number of items in each of its two
         * compartments, so the first half of the characters represent items in the
         * first compartment, while the second half of the characters represent items in
         * the second compartment.
         * 
         * For example, suppose you have the following list of contents from six
         * rucksacks:
         * 
         * vJrwpWtwJgWrhcsFMMfFFhFp
         * jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
         * PmmdzqPrVvPwwTWBwg
         * wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
         * ttgJtRGJQctTZtZT
         * CrZsJsPPZsGzwwsLwLmpwMDw
         * 
         * The first rucksack contains the items vJrwpWtwJgWrhcsFMMfFFhFp, which means
         * its first compartment contains the items vJrwpWtwJgWr, while the second
         * compartment contains the items hcsFMMfFFhFp. The only item type that appears
         * in both compartments is lowercase p.
         * The second rucksack's compartments contain jqHRNqRjqzjGDLGL and
         * rsFMfFZSrLrFZsSL. The only item type that appears in both compartments is
         * uppercase L.
         * The third rucksack's compartments contain PmmdzqPrV and vPwwTWBwg; the only
         * common item type is uppercase P.
         * The fourth rucksack's compartments only share item type v.
         * The fifth rucksack's compartments only share item type t.
         * The sixth rucksack's compartments only share item type s.
         * 
         * To help prioritize item rearrangement, every item type can be converted to a
         * priority:
         * 
         * Lowercase item types a through z have priorities 1 through 26.
         * Uppercase item types A through Z have priorities 27 through 52.
         * 
         * In the above example, the priority of the item type that appears in both
         * compartments of each rucksack is 16 (p), 38 (L), 42 (P), 22 (v), 20 (t), and
         * 19 (s); the sum of these is 157.
         * 
         * Find the item type that appears in both compartments of each rucksack. What
         * is the sum of the priorities of those item types?
         * 
         */

        // Store Strings in an array
        String[] strArr = { "vJrwpWtwJgWrhcsFMMfFFhFp", "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg",
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", "ttgJtRGJQctTZtZT", "CrZsJsPPZsGzwwsLwLmpwMDw" };

        HashSet<Character> charSet = new HashSet<>(); // storing similar characters, removes duplicates

        // For loop that iterates through the array
        for (int i = 0; i < strArr.length; i++) {
            String currentString = strArr[i];
            String strOne = currentString.substring(0, currentString.length() / 2); // first half of String
            char[] charArrOne = strOne.toCharArray(); // turns String into a char array

            String strTwo = currentString.substring(currentString.length() / 2, currentString.length()); // second half
            char[] charArrTwo = strTwo.toCharArray();

            for (int j = 0; j < charArrOne.length; j++) {
                for (int k = 0; k < charArrTwo.length; k++) {
                    if (charArrOne[j] == charArrTwo[k]) {
                        charSet.add(charArrOne[j]); // adds element
                    }
                }
            }

        }

        ArrayList<Character> charList = new ArrayList<>(charSet); // converting set to list to access elements
        int charSumValue = 0; // sum of values of all characters

        for (int i = 0; i < charList.size(); i++) {
            char currentChar = charList.get(i);
            int charValue = 0;

            if (Character.isLowerCase(currentChar)) {
                charValue = currentChar - 96; // to get proper decimal value in ascii table
            } else {
                charValue = currentChar - 38;
            }
            charSumValue += charValue;
        }

        System.out.println(charSumValue);
        // Java ASCII Table: https://www.javatpoint.com/java-ascii-table

    }

}