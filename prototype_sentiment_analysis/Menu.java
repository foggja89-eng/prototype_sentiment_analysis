/*
* Menu.java -- this will be used to handle the work to get to the point that Analysis.pi can work on a file.
* Part of this will involve getting the user's input for what file they want to work on, and passing that off to the python code to work on.
* @author James C. Fogg
* @version 2026.02.06
*/

import java.io.IOException;
import java.io.BufferedReader;
import java .io.InputStream;
import java.io.InputStreamReader;

import java.lang.ProcessBuilder;
import java.lang.Process;
import java.lang.Thread;

public class Menu //Beginning of class Menu
{

    /*
    * Supporting method for the menu system to run.
    * @param BufferedReader stdin, all input is handled more efficiently this way.
    * @param Input input, a generic instance of a custom object to handle all input for this project.
    * @param Error error, a generic instance of a custom object to handle all error messaging for this project.
    * @throws IOException
    */
    public void menuSystem(BufferedReader stdin, Input input, Error error) throws IOException
    {
        start();
        byte choice;

        try
        {
            do
            {
                mainMenu();

                choice = input.byteInput(stdin);

                switch (choice)
                {
                case 0: //handling logic for quitting the program.
                    System.out.println("Are you sure you want to quit?[y/n]");

                    if (input.characterInput(stdin) == 'y')
                    {
                        choice = -2;
                    }
                    else
                    {
                        System.out.println("Returning to main menu...");
                    }

                    break;

                case 1: //main functionality
                    try
                    {
                        option1(input, error, stdin);
                    }
                    catch (Exception e)
                    {
                        error.invalidExit(input);
                    }
                    break;

                case 2:
                    introduction();
                    break;

                case 3:
                    information();
                    break;

                default:
                    error.invalidInput(input);

                }
            }
            while (choice != -2);
        }
        catch (Exception e)
        {
            error.invalidExit(input);
        }
        //If execution has broken out of the do-while loop, something has either gone wrong or the user indicated they want to quit.
        System.out.println("Program terminated... goodbye!");
    }

    /*
     * Supporting method for menu option 1: Grab a file to pass off to the python code for analysis.
     * TODO: part of good design is keeping things private. Figure out if this needs to be public for the python code to work with it?
     * The filePath variable created for this will be used as arg1 for the python script.
     * @param Input input
     * @param Error error
     * @param BufferedReader stdin
     * @throws IOException
     */
    public void option1(Input input, Error error, BufferedReader stdin) throws IOException
    {
        System.out.println("Now selecting a new file to work with. What is the file path?");

        //Set up a new process for the python script to run sentiment analysis. the last parameter will be the file path of the text to work on.
        ProcessBuilder processBuilder = new ProcessBuilder("python3", "Analysis.py", input.generalInput(stdin));
        Process process = processBuilder.start();
        System.out.println(input.getColor("green") + "=====START OF ANALYSIS=====" + input.getColor("reset"));

        //Putting this in a try-catch block because this might be null.
        try
        {
            //set up to grab output from the python program. Couldn't just use the already existing BufferedReader object, need one just for the process.
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line;

            //collect all output from the python thread.
            while ((line = reader.readLine()) != null)
            {
                builder.append(line);
            }

            //if the output from the python thread is empty, then something went wrong.
            if (builder.length() > 0)
            {
                System.out.println(input.getColor("yellow") + builder.toString() + input.getColor("reset"));
            }
            else
            {
                System.out.println(input.getColor("yellow")
                                   + "The provided file either doesn't have any text or does not exist in the directory."
                                   + input.getColor("reset"));
            }

            System.out.println(input.getColor("green") + "=====END OF ANALYSIS=====" + input.getColor("reset"));
        }
        catch (Exception e)
        {
            //error handling in case something goes wrong with the python code.
            Thread.currentThread().interrupt();
            System.err.println("Python code was stopped.");
        }
    }

    /*
    * Print out a basic introduction for the program.
    */
    private void introduction()
    {
        System.out.println("Welcome to the basic sentiment analysis demo.\n"
                           + "This project relies on a Java based menu system, coupled with Python to run sentiment analysis on a file.\n"
                           + "This is currently intended to run in the terminal, making this extensible through the use of scripting langauges like Bash.\n"
                           + "The menu options for this program are subject to change.\n");
    }

    /*
    * Print out basic information about the program.
    */
    private void information()
    {
        System.out.println("This program was created using Java SE 21 on VS Code.\n"
                           + "Author: James C. Fogg\n"
                           + "Version: 2026.02.06\n"
                          );
    }

    /*
    * print the main menu options for the user.
    */
    private void mainMenu()
    {
        System.out.println("Main menu:\n"
                           + "0. Quit\n"
                           + "1. Run sentiment analysis on a new file.\n"
                           + "2. Display program introduction.\n"
                           + "3. Display other program information.\n");
    }

    /*
    * Print out an introduction to the program and basic information about the program.
    * This specific combiantion of instructions should only run once per program.
    */
    private void start()
    {
        introduction();
        information();
    }

} //End of class Menu