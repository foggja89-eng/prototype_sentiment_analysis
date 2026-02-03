/*
* Input.java -- dedicated class for handling input. 
* Eventually, this will be updated to handle color coding for the terminal. For now, I'm more concnerened with getting basic terminal output workin. 
* @author James C. Fogg
* @2026.02.03
*/

import java.io.BufferedReader;
import java.io.IOException;

public class Input
{
    /*
 * General method to get any input from the user. 
 * @param BufferedReader stdin
 * @return String input
 * @throws IOException
 */
public static String generalInput(BufferedReader stdin) throws IOException
{
    System.out.println("Enter your input now: ");
    String input = stdin.readLine().trim();
    System.out.println(input);
    return input;
}

/*
* Supporting driver method to handle single character input. 
* @param BufferedReader stdin
* @throws IOException
* @return input
*/
public static char characterInput(BufferedReader stdin) throws IOException
{
    return generalInput(stdin).toUpperCase().charAt(0);
}

/*
* Supporting method to handle getting 32 bit integer input from the user. 
* @param BufferedReader stdin
* @return int input
* @throws IOException
*/
public static int intInput(BufferedReader stdin) throws IOException
{
    return Integer.parseInt(generalInput(stdin));
}

/*
* Handle numerical input for just a single byte. 
* @param BufferedReader stdin
* @return byte input
* @throws IOException
 */
public static byte byteInput(BufferedReader stdin)
{
    return Byte.parseByte(generalInput(stdin));
}
}