/*
* Driver.java -- the main driver for the prototype sentiment analysis project. This is essentially the launchpad for the whole thing.
* This will be used to launch Menu.java, which will in turn handle most of the preprocessing work needed to send off a file to Analysis.pi
* My thinking is that this provides the safety of automatic memory management that is still much more efficient than doing the whole thing in Python.
* The main method is intentionally kept simple for good code design.
* Things got a little messy with output all over the place. Basically every file (except the driver) ended up printing output of some kind.
* @author James C. fogg
* @version 2026.02.03
*/

import java.io.bufferedreader;

public class Driver //Beginning of class Driver
{
    public static void main (String[] args) //Beginning of main method
    {
        //Setting up objects that will be needed for the menu system.
        Input input = new Input();
        Error error = new Error();

        //Preparing font colors to be used throughout the project. 
        input.loadColors();

        //Create a new instance of a BufferedReader object to handle input, and put everything together to run the menu system. 
        new Menu().menuSystem(new BufferedReader(new InputStreamReader(System.in), input, error));
    } //End of main method
} //End of class Driver