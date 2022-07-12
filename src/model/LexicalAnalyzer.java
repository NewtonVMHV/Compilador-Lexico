/* The following code was generated by JFlex 1.7.0 */
package model;
import java_cup.runtime.*;
import model.Analyse;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file 
 */
public class LexicalAnalyzer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\1\1\52\1\52\1\1\22\0\1\1\7\0\1\11"+
    "\1\12\1\22\1\17\1\6\1\20\1\0\1\21\1\5\11\4\1\16"+
    "\1\15\1\23\1\24\1\25\2\0\32\2\1\13\1\0\1\14\1\0"+
    "\1\2\1\0\1\32\1\44\1\34\1\36\1\35\1\47\1\31\1\51"+
    "\1\41\2\2\1\45\1\33\1\42\1\30\1\26\1\2\1\27\1\50"+
    "\1\43\1\37\1\40\1\46\3\2\1\7\1\3\1\10\7\0\1\52"+
    "\u1fa2\0\1\52\1\52\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\2\2\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\15\3\3\0\1\24"+
    "\1\25\1\24\1\26\1\27\1\30\2\3\1\31\3\3"+
    "\1\32\3\3\1\33\10\3\1\34\2\3\1\35\1\36"+
    "\1\3\1\37\1\40\1\41\1\42\11\3\1\43\1\44"+
    "\1\45\1\46\10\3\1\47\1\50\1\51\1\52\3\3"+
    "\1\53\1\3\1\54\1\3\1\55";

  private static int [] zzUnpackAction() {
    int [] result = new int[106];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\53\0\53\0\126\0\126\0\201\0\254\0\53"+
    "\0\327\0\53\0\53\0\53\0\53\0\53\0\53\0\u0102"+
    "\0\53\0\53\0\u012d\0\53\0\u0158\0\u0183\0\u01ae\0\u01d9"+
    "\0\u0204\0\u022f\0\u025a\0\u0285\0\u02b0\0\u02db\0\u0306\0\u0331"+
    "\0\u035c\0\u0387\0\u03b2\0\u03dd\0\254\0\327\0\53\0\53"+
    "\0\u0408\0\53\0\53\0\53\0\u0433\0\u045e\0\126\0\u0489"+
    "\0\u04b4\0\u04df\0\126\0\u050a\0\u0535\0\u0560\0\126\0\u058b"+
    "\0\u05b6\0\u05e1\0\u060c\0\u0637\0\u0662\0\u068d\0\u06b8\0\u03dd"+
    "\0\u06e3\0\u070e\0\126\0\126\0\u0739\0\126\0\126\0\126"+
    "\0\126\0\u0764\0\u078f\0\u07ba\0\u07e5\0\u0810\0\u083b\0\u0866"+
    "\0\u0891\0\u08bc\0\126\0\126\0\126\0\126\0\u08e7\0\u0912"+
    "\0\u093d\0\u0968\0\u0993\0\u09be\0\u09e9\0\u0a14\0\126\0\126"+
    "\0\126\0\126\0\u0a3f\0\u0a6a\0\u0a95\0\126\0\u0ac0\0\126"+
    "\0\u0aeb\0\126";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[106];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21"+
    "\1\22\1\23\1\24\1\25\1\2\1\26\1\27\1\30"+
    "\1\31\1\4\1\32\2\4\1\33\1\34\1\4\1\35"+
    "\1\36\1\37\1\40\1\41\1\4\1\42\1\43\2\4"+
    "\56\0\4\4\20\0\24\4\5\0\2\6\1\44\50\0"+
    "\2\45\1\44\44\0\10\46\1\47\42\46\24\0\1\50"+
    "\47\0\1\51\55\0\1\52\1\53\51\0\1\54\30\0"+
    "\4\4\20\0\1\4\1\55\22\4\3\0\4\4\20\0"+
    "\7\4\1\56\14\4\3\0\4\4\20\0\1\4\1\57"+
    "\22\4\3\0\4\4\20\0\14\4\1\60\7\4\3\0"+
    "\4\4\20\0\14\4\1\61\2\4\1\62\4\4\3\0"+
    "\4\4\20\0\2\4\1\63\10\4\1\64\10\4\3\0"+
    "\4\4\20\0\4\4\1\65\17\4\3\0\4\4\20\0"+
    "\14\4\1\66\4\4\1\67\2\4\3\0\4\4\20\0"+
    "\2\4\1\70\21\4\3\0\4\4\20\0\1\4\1\71"+
    "\21\4\1\72\3\0\4\4\20\0\2\4\1\73\4\4"+
    "\1\74\14\4\3\0\4\4\20\0\1\4\1\75\21\4"+
    "\1\76\3\0\4\4\20\0\4\4\1\77\17\4\5\0"+
    "\2\100\45\0\10\51\1\0\42\51\2\0\4\4\20\0"+
    "\2\4\1\101\21\4\3\0\4\4\20\0\4\4\1\102"+
    "\17\4\3\0\4\4\20\0\10\4\1\103\13\4\3\0"+
    "\4\4\20\0\10\4\1\104\13\4\3\0\4\4\20\0"+
    "\22\4\1\105\1\4\3\0\4\4\20\0\12\4\1\106"+
    "\11\4\3\0\4\4\20\0\1\4\1\107\22\4\3\0"+
    "\4\4\20\0\15\4\1\110\6\4\3\0\4\4\20\0"+
    "\15\4\1\111\6\4\3\0\4\4\20\0\11\4\1\112"+
    "\12\4\3\0\4\4\20\0\7\4\1\113\14\4\3\0"+
    "\4\4\20\0\2\4\1\114\21\4\3\0\4\4\20\0"+
    "\3\4\1\115\20\4\3\0\4\4\20\0\13\4\1\116"+
    "\10\4\3\0\4\4\20\0\13\4\1\117\10\4\3\0"+
    "\4\4\20\0\17\4\1\120\4\4\3\0\4\4\20\0"+
    "\3\4\1\121\2\4\1\122\15\4\3\0\4\4\20\0"+
    "\10\4\1\123\13\4\3\0\4\4\20\0\7\4\1\124"+
    "\14\4\3\0\4\4\20\0\7\4\1\125\14\4\3\0"+
    "\4\4\20\0\14\4\1\126\7\4\3\0\4\4\20\0"+
    "\17\4\1\127\4\4\3\0\4\4\20\0\13\4\1\130"+
    "\10\4\3\0\4\4\20\0\15\4\1\131\6\4\3\0"+
    "\4\4\20\0\17\4\1\132\4\4\3\0\4\4\20\0"+
    "\22\4\1\133\1\4\3\0\4\4\20\0\1\4\1\134"+
    "\22\4\3\0\4\4\20\0\7\4\1\135\14\4\3\0"+
    "\4\4\20\0\7\4\1\136\14\4\3\0\4\4\20\0"+
    "\14\4\1\137\7\4\3\0\4\4\20\0\7\4\1\140"+
    "\14\4\3\0\4\4\20\0\7\4\1\141\14\4\3\0"+
    "\4\4\20\0\7\4\1\142\14\4\3\0\4\4\20\0"+
    "\4\4\1\143\17\4\3\0\4\4\20\0\10\4\1\144"+
    "\13\4\3\0\4\4\20\0\4\4\1\145\17\4\3\0"+
    "\4\4\20\0\5\4\1\146\16\4\3\0\4\4\20\0"+
    "\11\4\1\147\12\4\3\0\4\4\20\0\14\4\1\150"+
    "\7\4\3\0\4\4\20\0\1\4\1\151\22\4\3\0"+
    "\4\4\20\0\7\4\1\152\14\4\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2838];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\4\1\1\11\1\1\6\11\1\1\2\11"+
    "\1\1\1\11\17\1\3\0\2\11\1\1\3\11\76\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[106];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */

private Analyse createAnalyse(String lexeme, String token, int line, int iniCol, int endCol) {
    return (new Analyse(lexeme, token, String.valueOf(line), String.valueOf(iniCol), String.valueOf(yylength() + endCol), ""));
}



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public LexicalAnalyzer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 160) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    //throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Analyse yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return createAnalyse(yytext(), "Caracter_Invalido", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 46: break;
          case 2: 
            { /* */
            } 
            // fall through
          case 47: break;
          case 3: 
            { return createAnalyse(yytext(), "Identificador", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 48: break;
          case 4: 
            { return createAnalyse(yytext(), "Entero", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 49: break;
          case 5: 
            { return createAnalyse(yytext(), "Coma", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 50: break;
          case 6: 
            { return createAnalyse(yytext(), "Llaves_abiertas", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 51: break;
          case 7: 
            { return createAnalyse(yytext(), "Cerrar llaves", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 52: break;
          case 8: 
            { return createAnalyse(yytext(), "Parentesis_abiertos", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 53: break;
          case 9: 
            { return createAnalyse(yytext(), "Cerrar_parentesis", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 54: break;
          case 10: 
            { return createAnalyse(yytext(), "Corchetes_abiertos", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 55: break;
          case 11: 
            { return createAnalyse(yytext(), "Cerrar_corchetes", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 56: break;
          case 12: 
            { return createAnalyse(yytext(), "Punto_coma", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 57: break;
          case 13: 
            { return createAnalyse(yytext(), "Operador_Dos_Puntos", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 58: break;
          case 14: 
            { return createAnalyse(yytext(), "Operador_Suma", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 59: break;
          case 15: 
            { return createAnalyse(yytext(), "Operador_Sustraccion", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 60: break;
          case 16: 
            { return createAnalyse(yytext(), "Operador_Division", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 61: break;
          case 17: 
            { return createAnalyse(yytext(), "Operador_Multiplicacion", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 62: break;
          case 18: 
            { return createAnalyse(yytext(), "Operador_Menor", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 63: break;
          case 19: 
            { return createAnalyse(yytext(), "Operador_Mayor", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 64: break;
          case 20: 
            { /* Ignore Comments */
            } 
            // fall through
          case 65: break;
          case 21: 
            { return createAnalyse(yytext(), "Operador_Igual", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 66: break;
          case 22: 
            { return createAnalyse(yytext(), "Operador_Menor_Igual", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 67: break;
          case 23: 
            { return createAnalyse(yytext(), "Operador_Diferente", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 68: break;
          case 24: 
            { return createAnalyse(yytext(), "Operador_Mayor_Igual", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 69: break;
          case 25: 
            { return createAnalyse(yytext(), "Palabra_Reservada_Or", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 70: break;
          case 26: 
            { return createAnalyse(yytext(), "Palabra_Reservada_Do", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 71: break;
          case 27: 
            { return createAnalyse(yytext(), "Palavbra_Reservada_If", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 72: break;
          case 28: 
            { return createAnalyse(yytext(), "Real", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 73: break;
          case 29: 
            { return createAnalyse(yytext(), "Palabra_Reservada_And", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 74: break;
          case 30: 
            { return createAnalyse(yytext(), "Palabra_Reservada_End", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 75: break;
          case 31: 
            { return createAnalyse(yytext(), "Palabra_Reservada_Div", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 76: break;
          case 32: 
            { return createAnalyse(yytext(), "Palabra_Reservada_Var", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 77: break;
          case 33: 
            { return createAnalyse(yytext(), "Palabra_Reservada_Int", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 78: break;
          case 34: 
            { return createAnalyse(yytext(), "Palabra_Reservada_Not", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 79: break;
          case 35: 
            { return createAnalyse(yytext(), "Palabra_Reservada_Read", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 80: break;
          case 36: 
            { return createAnalyse(yytext(), "Palabra_Reservada_Else", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 81: break;
          case 37: 
            { return createAnalyse(yytext(), "Palabra_Reservada_True", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 82: break;
          case 38: 
            { return createAnalyse(yytext(), "Palabra_Reservada_Then", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 83: break;
          case 39: 
            { return createAnalyse(yytext(), "Palabra_Reservada_Begin", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 84: break;
          case 40: 
            { return createAnalyse(yytext(), "Palabra_Reservada_Write", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 85: break;
          case 41: 
            { return createAnalyse(yytext(), "Palabra_Reservada_While", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 86: break;
          case 42: 
            { return createAnalyse(yytext(), "Palabra_Reservada_False", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 87: break;
          case 43: 
            { return createAnalyse(yytext(), "Palabra_Reservada_Program", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 88: break;
          case 44: 
            { return createAnalyse(yytext(), "Palabra_Reservada_Boolean", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 89: break;
          case 45: 
            { return createAnalyse(yytext(), "Palabra_Reservada_Procedure", yyline, yycolumn, yycolumn);
            } 
            // fall through
          case 90: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
