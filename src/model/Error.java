/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author victor
 */

public class Error {
    private String line, error;
    
    public Error() {}

    public Error(String line, String error) {
        this.line = line;
        this.error = error;
    }

    Error(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
