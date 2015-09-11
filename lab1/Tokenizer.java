package lab1;

import java.util.Scanner;

public class Tokenizer
{

    Scanner scan;
    String lexeme;

    public Tokenizer(String sentence)
    {
	lexeme = null;
	scan = new Scanner(sentence);
    }

    public Token getToken()
    {
	if (scan.hasNext())
	{
	    lexeme = scan.next();

	    Token token = new Token(lexeme);
	    return token;
	}
	else return new Token("\n");

    }

}