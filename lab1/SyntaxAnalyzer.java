package lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SyntaxAnalyzer
{

    public static void main(String[] args) throws IOException
    {
	Scanner scan = new Scanner(System.in);

	String line = requestInput(scan);
	while (!line.equals("q"))
	{
	    Parser p = new Parser(line);
	    p.parse();
	    if (p.getErrorCount() == 0)
	    {
		System.out.println("Correct syntax.");
	    }
	    else
	    {
		System.out.println("Incorrect syntax.");
	    }
	    System.out.println();
	    
	    line = requestInput(scan);
	}
    }

    public static String requestInput(Scanner scan)
    {
	System.out.println("Enter expression (q to quit):");
	return scan.nextLine();
    }
}