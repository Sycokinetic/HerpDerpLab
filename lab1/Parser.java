package lab1;

public class Parser
{
    private Token token;
    private int errorCount;
    private Tokenizer tex;
    private boolean debug = true;
    
    public Parser(String sentence)
    {
	token = null;
	errorCount = 0;
	if (sentence == null || sentence.length() == 0) throw new RuntimeException("empty sentence...");
	tex = new Tokenizer(sentence);
    }
    
    public int getErrorCount()
    {
	return this.errorCount;
    }

    public int parse()
    {
	token = tex.getToken();
	assign();
	if (token.getCode() != Token.EOI)
	{
	    errorCount++;
	    debug("Error: symbol after end of expression.");

	}
	return errorCount;

    } // end parse

    private void assign()
    {
	debug("<assign>");

	if (token.getCode() == Token.IDENT) // good so far
	{
	    token = tex.getToken(); // get the next token
	    if (token.getCode() == Token.EQUALS) // good so far
	    {
		token = tex.getToken(); // get the next token
		expression(); // check for expression now
	    }
	    else
	    {
		errorCount++;
		debug("Error: equals expected.");
	    }
	}
	else
	{
	    errorCount++;
	    debug("Error: identifier expected.");
	}
    } // end assign

    private void expression()
    {
	debug("<expression>");

	term(); // check for term
	while (token.getCode() == Token.PLUS || token.getCode() == Token.MINUS) // okay
	{
	    token = tex.getToken();// get next token

	    term(); // check for term
	}

    } // end expression

    private void term()
    {
	debug("<term>");

	factor(); // check for factor
	while (token.getCode() == Token.MULT || token.getCode() == Token.DIV) // okay
	{
	    token = tex.getToken(); // get next token

	    factor(); // check for factor
	}

    } // end term

    private void factor()
    {
	debug("<factor>");
	debug(token);
	
	if (token.getCode() == Token.IDENT) // okay
	{
	    token = tex.getToken(); // go to next token
	}
	else if (token.getCode() == Token.LEFT_PAREN) // okay
	{
	    token = tex.getToken(); // go to next token
	    expression(); // check for expression;
	    
	    if (token.getCode() == Token.RIGHT_PAREN) // okay
	    {
		token = tex.getToken(); // go to next token
	    }
	    else
	    {
		debug("Error: right parenthesis expected");
		errorCount++;
	    }
	}
	else
	{
	    debug("Error: left parenthesis expected");
	    errorCount++;
	}

    }// end factor
    
    private void debug(Object msg)
    {
	if (this.debug) System.out.println(msg);
    }
}