/**
 * Hello
 */
public class Hello {

    public static void main(String[] args) {
        // final/constant means variable cannot change
        String myString = "This is my string";
        int myInt = 7;
        char myChar = 'm';
        float myFloat = 5.99f;
        boolean myBool = false;
        System.out.println("Hello World");
        System.out.println(myString);
        System.out.println(myInt);
        System.out.println(myChar);
        System.out.println(myBool);
        System.out.println(myFloat);

        // If ... Else statements
        if (myBool) {
            System.out.println("Condition 1 was true");
        } else if (!myBool && myChar == 'm') {
            System.out.println("Condition 2 was true.");
        } else {
            System.out.println("Conditions not met");
        }

        // Ternary operator
        String myTernary = (myBool) ? "myBool was true" : "myBool was false";
        System.out.println(myTernary);

        // Switch statements
        switch (myInt) {
            case 1:
                // code block
                break;
            case 2:
                // code block
                break;
            default:
                // code block
                // does not need break if last block in switch statement
        }

        // while loop, can also do do-while
        boolean condition = true;
        while (condition) {
            // execute code block
            condition = false;
        }

        // for loop
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // for-each loop
        int[] nums = { 1, 2, 3, 4 };
        for (int num : nums) {
            System.out.println(num);
        }

        
    }
}