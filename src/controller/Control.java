/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Analyse;
import model.Code;
import model.LexicalAnalyzer;
import model.Error;
import model.Stack;
import model.Symbol;

/**
 *
 * @author victor
 */
public class Control {
    int MAX = 15;
    ArrayList<Analyse> tokens;
    ArrayList<Error> list;
    int count;
    ArrayList<Symbol> globalList; 
    ArrayList<Symbol> localList;
    
    public void Control() {}
    
    // Do the analyse lexic
    public ArrayList<Analyse> analyseLexic(String textEdit)
    {
        int i = 1;
        boolean ignore = false;
        ArrayList<Analyse> list = new ArrayList<>();
        Scanner scanner = new Scanner(textEdit);
        Analyse token = new Analyse();
        
        while ( scanner.hasNextLine() )
        {
            String line = (scanner.nextLine()).toString();
            LexicalAnalyzer lexic = new LexicalAnalyzer(new StringReader(line));
            
            try {
                while ( (token = lexic.yylex()) != null )
                {
                    token.setLine(String.valueOf(i));
                    
                    if ( token.getToken().equals("Identificador") || token.getToken().equals("Entero") || token.getToken().equals("Real") )
                    {
                        int length = Integer.parseInt(token.getEndCol()) - Integer.parseInt(token.getIniCol());
                        
                        if ( length > MAX )
                            token.setError("Error ! Tamaño máximo excedido (15) !\n");
                    }
                    
                    if ( token.getLexeme().equals("{") )
                        ignore = true;
                    else if ( token.getLexeme().equals("}") )
                    {
                        ignore = false;
                        continue;
                    }
                    
                    if (!ignore)
                        list.add(token);
                }
                
            i++;
                    
            } catch (IOException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        if ( ignore )
            JOptionPane.showMessageDialog(null, "Error ! You miss close the comment !");
       
        return list;
    }
    
    
    // ######################### --- Help Methods to do sintatic analyse --- ###################################

    // Compare specific Token
    public boolean accept(String token) {
        if ( tokens.get(count).getToken().equalsIgnoreCase(token) )
            return true;   
        
        return false;
    }
    
    // Compare the next token
    public boolean expect(String token) {
        nextToken();
        
        if ( accept(token) )
            return true;
        
        return false;
    }
    
    // Compare if the previous token is accept
    public boolean acceptPreviousToken(String token) {
        --count;
        
        if ( accept(token) ) {
            ++count;
            return true;
        }
        
        ++count;
        return false;
    }
    
    // Increment to the next token
    public void nextToken() {
        int MAX = tokens.size() - 1;
        
        if ( count < MAX)
            ++count;
    }
    
    // Decrement previous token
    public int previousToken() {
        if ( count > 0 )
            --count;
        
        return count;
    }
    
    public void block() {
        if ( accept("Palabra_Reservada_Int") || accept("Palabra_Reservada_Boolean") )
            partVarDeclaration();
        
        if ( accept("Palabra_Reservada_Procedure") )
            procedurePart();
        
        if ( accept("Palabra_Reservada_Begin") ) {
            compCondition();
        }
            
        else {
            if ( !accept("Punto_coma") ) {
                list.add(new Error( tokens.get(count).getLine(), "Error ! Palabra reservada esperada 'begin'/'procedure'/'int'/'boolean' !") );
                list.add(new Error( tokens.get(count).getLine(), "¡Manejo de errores realizado! Ignora los tokens hasta que encuentres';' !") );

                while( !accept("PUNTO_COMA") ) {
                    nextToken();
                    
                    if ( count == tokens.size() - 1 )
                        break;
                }
            }
        }
    }
    
    public void partVarDeclaration() {
        varDeclaration();
        
        while ( accept("Punto_coma") ) {
            nextToken();
            varDeclaration();
        }
        
        previousToken();
        
        if ( !accept("Punto_coma") ) {
            list.add(new Error( tokens.get(count).getLine(), "Error ! Símbolo esperado ';' !") ); 
            nextToken();
        }
        
        nextToken();
    }
    
    public void varDeclaration() {
        if ( accept("Palabra_Reservada_Int") || accept("Palabra_Reservada_Boolean") ) {
            nextToken();
            identList();
        }   
    }
    
    public void identList() {
        if ( accept("Identificador") ) {
            nextToken();
            
            while( accept("Coma") ) {
                nextToken();
                identList();
            }
        } else {
            list.add(new Error( tokens.get(count).getLine(), "Error ! Esperaba un 'Identificador' !") );
            list.add(new Error( tokens.get(count).getLine(), "Manejo de errores realizado! Ignora los tokens hasta que encuentres ';' | ':' !") );
            
            while ( !accept("Punto_coma") || !accept("DOS_PUNTOS") ) {
                nextToken();
             
                if ( count == tokens.size() - 1 )
                      break;
            }
        }   
    }
    
    public void procedurePart() {
        while( accept("Palabra_Reservada_Procedure") ) {
            procedureDeclaration();
            
            if ( !accept("Punto_coma") && !accept("Palabra_Reservada_End") && !accept("Palabra_Reservada_Begin") ) {
                list.add(new Error( tokens.get(count).getLine(), "Error ! Símbolo esperado ';' !") );
                nextToken();
            }
        }
    }
    
    public void procedureDeclaration() {
        if ( accept("Palabra_Reservada_Procedure") ) {
            if ( expect("Identificador") ) {
                if ( expect("Parentesis_abiertos") ) {
                    formalParam();
                    
                    if ( expect("Punto_coma") ) {
                        nextToken();
                        block();
                    } else {
                        list.add(new Error( tokens.get(count).getLine(), "Error ! Símbolo esperado ';' !") );
                        nextToken();
                    } 
                }
                
                if ( expect("Ponto_coma") ) {
                    nextToken();
                    block();
                } else {
                    list.add(new Error( tokens.get(count).getLine(), "Error ! Símbolo esperado ';' !") );
                    nextToken();
                } 
            }
        }
    }
    
    public void formalParam() {
        if ( accept("Parentesis_abiertos") ) {
            nextToken();
            formalSectionParam();
            
            while( expect("Punto_coma") ) {
                nextToken();
                formalSectionParam();
            }
            
            if ( !accept("Cerrar_parentesis") ) {
                list.add(new Error( tokens.get(count).getLine(), "Error ! Símbolo esperado ')' !") ); 
                list.add(new Error( tokens.get(count).getLine(), "Manejo de errores realizado! Ignora los tokens hasta que encuentres ';'!") );
                
                while ( !accept("Punto_coma") ) {
                    nextToken();
                    
                    if ( count == tokens.size() - 1 )
                        break;
                }
            } 
        }
    }
    
    public void formalSectionParam() {
        if ( accept("Palabra_Reservada_Var") ) {
            nextToken();
            identList();
            
            if ( accept("Operador_Dos_Puntos")) {
                nextToken();
                
                if ( !accept("Palabra_Reservada_Int") && !accept("Palabra_Reservada_Boolean")  ) {
                    list.add(new Error( tokens.get(count).getLine(), "Error !'Identificador' esperado !") );
                    list.add(new Error( tokens.get(count).getLine(), "Manejo de errores realizado! Ignora los tokens hasta que encuentres ';'!") );
                
                    while ( !accept("Ponto_Virgula") ) {
                        nextToken();
                        
                        if ( count == tokens.size() - 1 )
                            break;
                    }
                }
                
            } else {
                list.add(new Error( tokens.get(count).getLine(), "Error ! Símbolo esperado ':' !") );
                list.add(new Error( tokens.get(count).getLine(), "Manejo de errores realizado! Ignora los tokens hasta que encuentres ';' !") );
                
                while ( !accept("Punto_coma") ) {
                    nextToken();
                    
                    if ( count == tokens.size() - 1 )
                        break;
                }
            }                    
            
        } else {
            identList();
            
            if ( accept("Operador_Dos_Puntos")) {
                nextToken();
                
                if ( !accept("Identificador") ) {
                    list.add(new Error( tokens.get(count).getLine(), "Error ! 'Identificador' esperado !") );
                    list.add(new Error( tokens.get(count).getLine(), "Manejo de errores realizado! Ignora los tokens hasta que encuentres ';'!") );
                
                    while ( !accept("Punto_coma") ) {
                        nextToken();
                        
                        if ( count == tokens.size() - 1 )
                            break;
                    }
                }
            
            } else {
                list.add(new Error( tokens.get(count).getLine(), "Error ! Símbolo esperado ':' !") );
                list.add(new Error( tokens.get(count).getLine(), "Manejo de errores realizado! Ignora los tokens hasta que encuentres ';'!") );
                
                    while ( !accept("Punto_coma") ) {
                        nextToken();
                        
                        if ( count == tokens.size() - 1 )
                            break;
                    }
            }
        }
    }
    
    public void compCondition() {
        if ( accept("Palavra_Reservada_Begin") ) {
            nextToken();
            condition();
            
            while ( accept("Ponto_Virgula") ) {
                nextToken();
                condition();
                
                if ( !accept("Palabra_Reservada_End") && !accept("Punto_coma") && !accept("Palabra_Reservada_Begin")) {
                    list.add(new Error( tokens.get(count).getLine(), "Error ! Palabra reservada esperada 'end' !") );
                    list.add(new Error( tokens.get(count).getLine(), "Manejo de errores realizado! Ignora los tokens hasta que encuentres ';'!") );
                
                    while ( !accept("Punto_coma") ) {
                        nextToken();
                        
                        if ( count == tokens.size() - 1 )
                            break;
                    }
                }
            }
        } else {
            list.add(new Error( tokens.get(count).getLine(), "Error ! Palabra reservada esperada 'begin' !") );
            list.add(new Error( tokens.get(count).getLine(), "Manejo de errores realizado! Ignora los tokens hasta que encuentres ';'!") );
                
            while ( !accept("Punto_coma") ) {
                nextToken();

                if ( count == tokens.size() - 1 )
                    break;
            }
        }
    }
    
    public void condition() {
        if ( accept("Identificador") || accept("Palabra_Reservada_Write") || accept("Palabra_Reservada_Read") ) {
           attribution();
        
        } else if ( accept("Palabra_Reservada_Begin") ) {
           compCondition();
        
        } else if ( accept("Palabra_Reservada_If") ) {
            conditionIf();
        
        } else if ( accept("Palabra_Reservada_While") ) {
            conditionLoop();
        
        } else {
            list.add(new Error( tokens.get(count).getLine(), "Error ! Esperaba algunos 'comandos' !") );
            list.add(new Error( tokens.get(count).getLine(), "Manejo de errores realizado! Ignora los tokens hasta que encuentres ';' | 'end' | 'else'!") );
                
            while ( !accept("Punto_coma") || !accept("Palabra_Reservada_End") || !accept("Palabra_Reservada_Else") ) {
                nextToken();
                
                if ( count == tokens.size() - 1 )
                    break;
            }
        }
    }
    
    public void attribution() {
        variable();
        
        if ( accept("Operador_Igual") ) {
            nextToken();
            expression();
        
        } else if ( accept("Parentesis_abiertos") && (acceptPreviousToken("Palabra_Reservada_Write") || acceptPreviousToken("Palabra_Reservada_Read")) ) {
            nextToken();
            expression();
        }
        
        else {
            list.add(new Error( tokens.get(count).getLine(), "Error ! Operador esperado ':=' !") );
            list.add(new Error( tokens.get(count).getLine(), "Manejo de errores realizado! Ignora los tokens hasta que encuentres ';' | 'end' | 'else'!") );
                
            while ( !accept("Punto_coma") || !accept("Palabra_Reservada_End") || !accept("Palabra_Reservada_Else") ) {
                nextToken();
                
                if ( count == tokens.size() - 1 )
                    break;
            }
        }
    }
    
    public void procedureCall() {
        if ( accept("Identificador") ) {
            if ( expect("Parentesis_abiertos") ) {
                nextToken();
                listExpression();
                
                if ( !expect("Cerrar_parentesis") ) {
                    list.add(new Error( tokens.get(count).getLine(), "Error ! Esperado ')' !") );
                    list.add(new Error( tokens.get(count).getLine(), "Manejo de errores realizado! Ignora los tokens hasta que encuentres ';' | 'end' | 'else'!") );
                
                    while ( !accept("Punto_coma") || !accept("Palabra_Reservada_End") || !accept("Palabra_Reservada_Else") ) {
                        nextToken();
                        
                        if ( count == tokens.size() - 1 )
                            break;
                    }
                }
                
            } else{
                list.add(new Error( tokens.get(count).getLine(), "Error ! Se esperaba un '(' !") );
                list.add(new Error( tokens.get(count).getLine(), "Manejo de errores realizado! Ignora los tokens hasta que encuentres ';' | 'end' | 'else'!") );
                
                while ( !accept("Punto_coma") || !accept("Palabra_Reservada_End") || !accept("Palabra_Reservada_Else") ) {
                    nextToken();
                    
                    if ( count == tokens.size() - 1 )
                        break;
                }
            }
            
        } else {
            list.add(new Error( tokens.get(count).getLine(), "Error ! Se esperaba un 'Identificador' !") );
            list.add(new Error( tokens.get(count).getLine(), "Manejo de errores realizado! Ignora los tokens hasta que encuentres ';' | 'end' | 'else'!") );
                
            while ( !accept("Punto_coma") || !accept("Palabra_Reservada_End") || !accept("Palabra_Reservada_Else") ) {
                nextToken();
                
                if ( count == tokens.size() - 1 )
                    break;
            }
        }
    }
    
    // Parse the conditionIF
    public void conditionIf() {
        if ( accept("Palabra_Reservada_If") ) {
            nextToken();
            expression();
            
            if ( expect("Palabra_Reservada_Then") ) {
                nextToken();
                condition();
                
                if ( accept("Palabra_Reservada_Else") ) {
                    nextToken();
                    condition();
                } 
                
            } else if ( acceptPreviousToken("Palabra_Reservada_Then") ) {
                condition();
                
                if ( accept("Palabra_Reservada_Else") ) {
                    nextToken();
                    condition();
                } 
            } else {
                list.add(new Error( tokens.get(count).getLine(), "Error ! Palabra reservada esperada 'then' !") );
                list.add(new Error( tokens.get(count).getLine(), "Manejo de errores realizado! Ignora los tokens hasta que encuentres ';' | 'end' | 'else'!") );
                
                while ( !accept("Punto_coma") || !accept("Palabra_Reservada_End") || !accept("Palabra_Reservada_Else") ) {
                    nextToken();
                    
                    if ( count == tokens.size() - 1 )
                        break;
                }
            }
            
        } else {
            list.add(new Error( tokens.get(count).getLine(), "Error ! Palabra reservada esperada 'if' !") );
            list.add(new Error( tokens.get(count).getLine(), "Manejo de errores realizado! Ignora los tokens hasta que encuentres ';' | 'end' | 'else'!") );
                
            while ( !accept("Punto_coma") || !accept("Palabra_Reservada_End") || !accept("Palabra_Reservada_Else") ) {
                nextToken();
                
                if ( count == tokens.size() - 1 )
                    break;
            }
        }
    }
    
    // Parse the condition
    public void conditionLoop() {
        if ( accept("Palabra_Reservada_While") ) {
            nextToken();
            expression();
            
            if ( accept("Palabra_Reservada_Do") ) {
                nextToken();
                condition();
            } 
            
            if ( accept("Cerrar_parentesis") )
                nextToken();
            
        } else {
            list.add(new Error( tokens.get(count).getLine(), "Error ! Palabra reservada esperada 'while' !") );
            list.add(new Error( tokens.get(count).getLine(), "Manejo de errores realizado! Ignora los tokens hasta que encuentres ';' | 'end' | 'else'!") );
                
            while ( !accept("Punto_coma") || !accept("Palabra_Reservada_End") || !accept("Palabra_Reservada_Else") ) {
                nextToken();
                
                if ( count == tokens.size() - 1 )
                    break;
            }
        }
    }
    
    // Parse the expression
    public void expression() {
        simpleExpression();
        
        if ( accept("Operador_Menor") || accept("Operador_Igual") || accept("Operador_Mayor") || accept("Operador_Menor_Igual") ||
            accept("Operador_Mayor_Igual") || accept("Operador_Diferente") ) {
            nextToken();
            
            simpleExpression();
        }
    }
    
    // Parse the Simple Expression
    public void simpleExpression() {
        if ( accept("Operador_Suma") || accept("Operador_Subtracion") ) {
            nextToken();
        }
        
        term();
        
        while( accept("Operador_Suma") || accept("Operador_Subtracion") || accept("Palabra_Reservada_Or") || accept("Operador_Multiplicacion")) {
            nextToken();
            term();
        }
    }
    
    // Parse the term
    public void term() {
        factor();
        
        while ( accept("Operador_Multiplicacion") || accept("Palabra_Reservada_Div") || accept("Palabra_Reservada_And") || accept("Operador_Division") ) {
            nextToken();
            factor();
            
            if ( accept("Palabra_Reservada_End") )
                nextToken();
        }
    }
    
    // Parse the factor
    public void factor() {
        if ( accept("Identificador") || accept("Palabra_Reservada_True") || accept("Palabra_Reservada_False") || accept("Palabra_Reservada_Write") || accept("Palabra_Reservada_Read") ) {
            nextToken();
            variable();
        } else if ( accept("Entero") || accept("Real") ) {
            nextToken();
        } else if ( accept("Parentesis_abiertos") ) {
            nextToken();
            expression();
            
            if ( !accept("Cerrar_parentesis") && !accept("Palabra_Reservada_Begin") && !accept("Palabra_Reservada_Then") ) {
                list.add(new Error( tokens.get(count).getLine(), "Error ! Se esperaba un ')' !") );
                list.add(new Error( tokens.get(count).getLine(), "Manejo de errores realizado! Ignora los tokens hasta que encuentres ';'!") );
                
                while ( !accept("Punto_coma") || !accept("Palabra_Reservada_End") || !accept("Palabra_Reservada_Else") ) {
                    nextToken();
                    
                    if ( count == tokens.size() - 1 )
                        break;
                }
            }
            
        } else if ( accept("Palabra_Reservada_Not") ) {
            nextToken();
            factor();
            
        } else {
            list.add(new Error( tokens.get(count).getLine(), "Error ! Se esperaba un factor !") );
            list.add(new Error( tokens.get(count).getLine(), "Manejo de errores realizado! Ignora los tokens hasta que encuentres ';'!") );
                
            while ( !accept("Ponto_Virgula") || !accept("Palavra_Reservada_End") || !accept("Palavra_Reservada_Else") ) {
                nextToken();
                
                if ( count == tokens.size() - 1 )
                    break;
            }
        } 
    }
    
    // Parse the variable
    public void variable() {
        if ( accept("Identificador") || accept("Palabra_Reservada_True") || accept("Palabra_Reservada_False") || accept("Palabra_Reservada_Write") || accept("Palabra_Reservada_Read") ) {
            
            nextToken();
            if ( accept("Operador_Suma") || accept("Operador_Subtracion") )
                expression();
            
           
        } else if ( accept("Cerrar_parentesis") )
            nextToken();
        
    } 
    // Parse list of expression
    public void listExpression() {
        expression();
        
        while ( expect("Coma") ) {
            nextToken();
            expression();
        }
    }
    public ArrayList<Error> isNeverUsedError(int level) {
        ArrayList<Error> errorList = new ArrayList<>();
        ArrayList<Symbol> temp;
        int i = 0;
        
        if ( level == 0 )
            temp = globalList;
        else
            temp = localList;
        
        for ( Symbol s: temp ) {
            if ( (level == 0 && searchSymbol(s.getLexeme(), 1) == null) && s.getIsUsed().equals("N") && !temp.get(i-1).getLexeme().equals("program") && !temp.get(i-1).getLexeme().equals("procedure") && !temp.get(i-1).getLexeme().equals("var") )
                errorList.add(new Error(s.getLine(), "Error ! Variable nunca utilizada: " + s.getLexeme() + " ! ") );
        
            i++;
        }
        
        return errorList;
    }
    
    // Verify if the variable is declared   
    public boolean isDeclared(Symbol symbol) {
        int position = Integer.parseInt(symbol.getPosition());
        String oldLine = tokens.get(position).getLine();
        
        while ( position > 0 && tokens.get(position).getLine().equals(oldLine) ) {
            if ( tokens.get(position).getToken().equals("Palabra_Reservada_Int") || tokens.get(position).getToken().equals("Palabra_Reservada_Boolean") )
                return true;

            position--;
        }
        
        return false;
    }
    
    // Search for a existent symbol in the table
    public Symbol searchSymbol(String lexeme, int level) {
        ArrayList<Symbol> temp = new ArrayList<>();
        
        if ( level == 0 )
            temp = globalList;
        else
            temp = localList;
       
        if ( temp != null )
            for( Symbol s: temp )
                if ( s.getLexeme().equals(lexeme) )
                    return s;
        
        return null;
    }
    
    // Insert a Symbol in the table
    public boolean insertSymbol(Symbol symbol, String line, int level) {
        ArrayList<Symbol> temp = new ArrayList<>();
        
        if ( level == 0 )
            temp = globalList;
        else
            temp = localList;
        
        if ( searchSymbol(symbol.getLexeme(),  level) == null ) {
            temp.add(symbol);
            return true;
        } 
        
        return false;
    }
    
    // Remove a Symbol in the table
    public boolean removeSymbol(String lexeme, int level) {
        ArrayList<Symbol> temp = new ArrayList<>();
        
        if ( level == 0 )
           temp = globalList;
        else
           temp = localList;
        
        for( Symbol s: temp )
            if ( s.getLexeme().equals(lexeme) ) {
                temp.remove(s);
                
                return true;
            } 
        
        return false;
    }
    
    public String setCategory(String token) {
        switch(token) {
            case "Palabra_Reservada_Program":
                return "Palabra que inicia el programa";
               
            case "Identificador":
                return "Variable";
                
            case "Palabra_Reservada_Procedure":
                return "Funcion del programa";
                
            case "Palabra_Reservada_Begin":
                return "Inicio de un bloque";
                
            case "Palabra_Reservada_End":
                return "Final de un bloque";
                
            case "Palabra_Reservada_If":
                return "Condicional";
                
            case "Palabra_Reservada_Read":
                return "Lector";
                
            case "Palabra_Reservada_Write":
                return "Escrita";
                
            case "Palabra_Reservada_While":
                return "Bucle de repeticion";
                
            case "Palabra_Reservada_Int":
            case "Palabra_Reservada_Boolean":
                return "Tipo variable";
                
            default:
                return "--------------";
        }
    }
    
    public String setType(int count, String line) {  
        for ( int i = count; i > 0; i-- ) {
            if ( tokens.get(i).getLine().equals(line) ) {
                if ( tokens.get(i).getToken().equals("Palabra_Reservada_Int") )
                    return "Entero";
                else if ( tokens.get(i).getToken().equals("Palabra_Reservada_Boolean") )
                    return "Booleano";
            }
            
            else
                break;
        }
        
        return "";
    }
    
    public String setScope(String lexeme, int level) {
        if ( lexeme.equals("procedure") )
            return "Procedimiento";
        else if ( lexeme.equals("a1") )
            return "Parametro";
        else if ( level == 0 )
            return "Global";
        else
            return "Local";
    }
    public boolean isDeclaring(ArrayList<Analyse> tokens, int position) {
        String oldLine = tokens.get(position).getLine();
        
        if ( position > 0)
            while ( position > 0 && tokens.get(position).getLine().equals(oldLine) ) {
                if ( tokens.get(position).getLexeme().equals("var") )
                    return true;

                position--;
            }
        
        return false;
    }
    
    public int getPosition(ArrayList<Code> codeList, String lexeme, int position) {
        while ( --position > 0 && position < codeList.size()) {
            if ( codeList.get(position).getLexeme().equals(lexeme) )
                return position-1;
        }
        
        return -1;
    }
}

class Sortybyroll implements Comparator<Error>
{
    public int compare(Error a, Error b)
    {
        int linea = Integer.parseInt(a.getLine());
        int lineb = Integer.parseInt(b.getLine());

        return linea - lineb;
    }
}
 