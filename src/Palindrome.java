import java.util.Scanner;

public class Palindrome
{
    Stack stack;
    Queue queue;

    public static void main(String[] args)
    {
        Palindrome palindrome = new Palindrome();
        String input = getInput();
        String processedString = processString(input);
        System.out.println(processedString);
        palindrome.populateDataStuctures(processedString);
        palindrome.isPalindrome(processedString);

    }

    public static String getInput()
    {
        String pstring;
        System.out.println("Enter a string to test!");
        Scanner userinput = new Scanner(System.in);
        pstring = userinput.nextLine(); // Need to use this rather than .next to parse 
        userinput.close();
        return pstring;
    }

    public static String processString(String str)
    {
        String processedString;
        str = str.toLowerCase();
        processedString = str.replaceAll("\\s", ""); // gets rid of all white space chars and repalces them with empty chars. 
        return processedString;
    }

    public void populateDataStuctures(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            char a_char = str.charAt(i);
            stack.push(new Node(a_char)); //push a new node initialized to the entered character 
            queue.enqueue(new Node(a_char));
        }
    }

    public boolean isPalindrome(String str)
    {

        for (int i = 0; i < str.length(); i++)
        {
            if (stack.pop() != queue.dequeue())
            {
                System.out.println("The inputed string is not a palindrome!");
                return false;
            }
        }
        return true;
    }
}
