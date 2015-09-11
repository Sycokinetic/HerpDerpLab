package lab1;

public class Token {

    public static final int EOI = -1;
    public static final int UNKNOWN = 0;
    public static final int LOW_OPER = 1;
    public static final int RIGHT_PAREN = 1;
    public static final int LEFT_PAREN = 2;
    public static final int MINUS= 5;
    public static final int PLUS = 6;
    public static final int MULT=7;
    public static final int DIV=8;
    public static final int EQUALS=10;
    public static final int HIGH_OPER=10;
    public static final int IDENT=11;            // Refine to two constants of INT_LIT and IDENT
  
    
    private int code;
    private String lexeme;
    
    public Token(String lexeme)
    {
    	this.lexeme = lexeme;
    	this.code = convert(lexeme);
    	
    }
    
    public String toString()
    {
    	return "lexeme: " + lexeme + " code: " + code;
    }
    
    public int getCode()
    {
    	return code;
    }
    
    public String getLexeme()
    {
    	return lexeme;
    }
    

    public int convert(String lexeme)
    {
    	int code;
    	char ch = lexeme.charAt(0);
    	
    	switch(ch)
    	{
    	case  '*' : code = MULT; break;
    	case  '/' : code = DIV; break;
    	case  '+' : code = PLUS; break;
    	case  '-' : code = MINUS; break;
    	case  '(' : code = LEFT_PAREN; break;
    	case  ')' : code = RIGHT_PAREN; break;
    	case  '=' : code = EQUALS; break;
    	case  '\n' : code = EOI; break;
    	   	
    	default: code = IDENT;
    	} // end switch
    	
    	return code;
    } // end getCode
   
}
