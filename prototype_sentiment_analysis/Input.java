/*
* Input.java -- dedicated class for handling input.
* Eventually, this will be updated to handle color coding for the terminal. For now, I'm more concnerened with getting basic terminal output workin.
* @author James C. Fogg
* @2026.02.03
 */

import java.io.BufferedReader;
import java.io.IOException;

public class Input {

    //collection used for handling font colors. There will be 8 font colors to choose from for now.
    private static String[] colors = new String[8];

    /*
    * General method to get any input from the user.
    * @param BufferedReader stdin
    * @return String input
    * @throws IOException
     */
    public static String generalInput(BufferedReader stdin) throws IOException {
        System.out.print(getColor("cyan") + "Enter your input now: " + getColor("reset"));
        String input = stdin.readLine().trim();
        System.out.println(getColor("green") + input + getColor("reset"));
        return input;
    }

    /*
    * Supporting driver method to handle single character input.
    * @param BufferedReader stdin
    * @throws IOException
    * @return input
     */
    public static char characterInput(BufferedReader stdin) throws IOException {
        return generalInput(stdin).toLowerCase().charAt(0);
    }

    /*
    * Supporting method to handle getting 32 bit integer input from the user.
    * @param BufferedReader stdin
    * @return int input
    * @throws IOException
     */
    public static int intInput(BufferedReader stdin) throws IOException {
        return Integer.parseInt(generalInput(stdin));
    }

    /*
    * Handle numerical input for just a single byte.
    * @param BufferedReader stdin
    * @return byte input
    * @throws IOException
     */
    public static byte byteInput(BufferedReader stdin) throws IOException {
        return Byte.parseByte(generalInput(stdin));
    }

    /*
    * Handle font colors. TODO: Find a way to do this in compliance with the DAA style guide, like what I did before?
    * This algorithm is a bit convoluted. So, the indices for the resulting array of strings are as follows:
    * 0 - reset
    * 1 - black
    * 2 - green
    * 3 - yellow
    * 4 - blue
    * 5 - purple
    * 6 - cyan
    * 7 - white
    * This has been designed such that the size of the colors collection could be expanded with minimal modification. 
    * @param String[] colors
     */
    public static void loadColors() {
        //special case for the reset identifier at index 0. 
        colors[0] = "\u001B[0m";

        //add the rest of the font colors. 
        for (byte i = 1; i < colors.length; i++) {
            colors[i] = "\u001B[3" + i + "m";
        }
    }

    /*
   * Retrieve a color from the collection by inputting a string for what color you want. 
   * What is VS Code suggesting with the switch statement? Is this some new syntax I didn't know about?
   * @param String desired color
   * @return the desired index out of the colors array. 
     */
    public static String getColor(String desiredColor) {
        //sanity check in case something weird happens with the parameter
        return switch (desiredColor.trim().toLowerCase()) {
            case "reset" ->
                colors[0];
            case "black" ->
                colors[1];
            case "green" ->
                colors[2];
            case "yellow" ->
                colors[3];
            case "blue" ->
                colors[4];
            case "purple" ->
                colors[5];
            case "cyan" ->
                colors[6];
            case "white" ->
                colors[7];
            default ->
                "Invalid entry for font color selection.";
        };
    }
}
