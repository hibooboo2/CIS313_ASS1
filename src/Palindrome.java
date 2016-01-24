import java.util.Scanner;

public class Palindrome
{
    Stack stack;
    Queue queue;

    public static void main(String[] args)
    {
        String input = getInput();
        System.out.println(input + " is palindrome: " + new Palindrome().isPalindrome(input));

    }

    public static String getInput()
    {
        Scanner userInput = null;
        try {
            System.out.println("Enter string to test if it is a palindrome: ");
            userInput = new Scanner(System.in);
            return  userInput.nextLine(); // Need to use this rather than .next to parse
        } finally {
            if (userInput != null) userInput.close();
        }
    }

    public static String processString(String str)
    {
        return str.replaceAll("\\s", "").toLowerCase(); // gets rid of all white space chars and replaces them with empty chars.
    }

    private void populateDataStructures(String str)
    {
        queue = new Queue();
        stack = new Stack();
        for (char c:str.toCharArray()) {
            stack.push(new Node(c)); //push a new node initialized to the entered character
            queue.enqueue(new Node(c));
        }
    }

    public boolean isPalindrome(String str)
    {
        str = processString(str);
        populateDataStructures(str);
        for (char ignored : str.toCharArray())
        {
            if (stack.pop().data != queue.dequeue().data) {
                return false;
            }
        }
        return true;
    }
}
