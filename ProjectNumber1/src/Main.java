public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s){
        int count = 0;
        //loop looks at each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //if character is a vowel, count increases by 1
            if (ch == 'a'|| ch == 'e'|| ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        //prints out total number of vowels in string s in the end
        System.out.println("Number of vowels: "+ count);

        return count;
    }

    //Code you problem number two here
    static int problemTwo(String s){
        String str = "bob";
        int count = 0, fromIndex = 0;
        /*while loop finds substring and assigns index of next occurrence
        to fromIndex to check if return value is greater than -1*/
        while ((fromIndex = s.indexOf(str, fromIndex)) != -1 ){
            //count increases and fromIndex increases to find next occurrence of substring 'bob'
            count++;
            fromIndex++;
        }
        //prints number of times 'bob' occurs in string s
        System.out.println("Number of times bob occurs is: " + count);

        return count;
    }
    //Code your solution to problem number 3 here
    static String problemThree(String s){
        int length = 1;
        String str = s.substring(0, 1);
        int stringLength = s.length();
        char[] charArray = s.toCharArray();
        //loop checks if characters follow order of alphabet
        for (int i = 0; i < stringLength - 1; i++) {
            if (charArray[i] <= charArray[i+1]) {
                length++;
            }
            //if 'i' is greater than 'i+1', they don't follow alphabetic order and length returns to 1
            else{
                length = 1;
            }
            //loop looks for the longest substring
            if (length > str.length()){
                str = s.substring(i - length + 2, i + 2);
            }
        }
        System.out.println("Longest substring in alphabetical order is: " + str);

        return str;

    }
    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        The tests will put your method through several and different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */

        //testing if output is correct
        String s = "ababcbcd";
        int length = 1;
        String str = s.substring(0, 1);
        int stringLength = s.length();
        char[] charArray = s.toCharArray();
 
        for (int i = 0; i < stringLength - 1; i++) {
            if (charArray[i] <= charArray[i+1]) {
                length++;
                System.out.println("when i = " + i +  " then length = " + length);
            }
            else{
                length = 1;
            }
            if (length > str.length()){
                str = s.substring(i - length + 2, i + 2);
                System.out.println("str = "+str);
            }
        }
        System.out.println(str);
    }
}
