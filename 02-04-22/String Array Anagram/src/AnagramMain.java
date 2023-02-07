public class AnagramMain {

    public static void main(String[] args) {

        /*
         * Given an array of words "all_words" and your waifu's name "waifu_name",
         * return the number of time "waifu_name" appears as an ANAGRAM inside
         * "all_words"
         */

        /*
         * An ANAGRAM is a word formed by rearranging the letters of a different word,
         * using all the original letters exactly once.
         */

        /* Example */
        String[] all_words = { "haruhi", "asuka", "aakus", "asuki", "asuka" };
        String waifu_name = "asuka";
        /* Expected output: 3 */

        /* Printing Title */
        System.out.println("\n\t\t[Anagram Counter]");

        /* Printing array */
        System.out.printf("\n%8s : [", "Array");
        for (int i = 0; i < all_words.length; i++) {
            if (i == all_words.length - 1) {
                System.out.print(all_words[i]);
            } else {
                System.out.print(all_words[i] + ", ");
            }
        }
        System.out.println("]");

        /* String that we will compare each String in array to */
        System.out.printf("\n%8s : %15s\n", "String", waifu_name);

        /* Counter for the number of anagrams in all_words */
        int anagram_counter = 0;

        /* Loops throug all_words array */
        for (int i = 0; i < all_words.length; i++) {

            /* int array that contains numbers as an alphabet historgram counter */
            int[] waifu_name_arr = new int[26];

            /* String that contains current iterated String */
            String current_waifu_string = all_words[i];

            /* adding each character to array */
            for (int j = 0; j < waifu_name.length(); j++) {
                int eachChar = waifu_name.charAt(j);
                eachChar -= 'a';
                ++waifu_name_arr[eachChar];
            }

            /* subtracting current String char values to alphabet char array */
            for (int k = 0; k < current_waifu_string.length(); k++) {
                int eachChar = current_waifu_string.charAt(k);
                eachChar -= 'a';
                --waifu_name_arr[eachChar];
            }

            /* boolean that is used as a basis to increase anagram_counter or not */
            boolean is_boolean = true;

            /* checking alphabet number array */
            for (int l = 0; l < waifu_name_arr.length; l++) {
                /* if any of the indexes are less than 0, it is not an anagram of our String */
                if (waifu_name_arr[l] < 0) {
                    is_boolean = false;
                    break; // stops the loop immediately
                }
            }

            /* Adding to anagram_counter & displaying results */
            if (is_boolean == true) {
                System.out.printf("\n%8s : %15s of %s\n", current_waifu_string, "IS an ANAGRAM", waifu_name);
                anagram_counter++;
            } else {
                System.out.printf("\n%8s : %15s of %s\n", current_waifu_string, "NOT an ANAGRAM", waifu_name);
            }
        }

        /* Print anagram_counter */
        System.out.printf("\n%8d : %24s\n\n", anagram_counter, "ANAGRAMS in Array");

    }

}
