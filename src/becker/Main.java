/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package becker;
import becker.robots.*;
/**
 *
 * @author Estudiante
 */
public class Main {
    public static void main(String[] args){
        Futbol futbol = new Futbol();
        futbol.advance();
        futbol.advanceRight();
        futbol.advanceRight();
        futbol.advanceLeft();
        
    }
}
