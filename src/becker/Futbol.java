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
public class Futbol {
    private Robot k;
    private City un;
    private Thing balon;
    
    public Futbol(){
        this.un = new City(10,10);
        this.balon = new Thing(this.un, 9,9);
        this.k = new Robot (un, 9,9, Direction.WEST);
    }
    
    public void advance(){
        k.pickThing();
        for (int i = 0; i < 2; i++){
        k.move();
        }
        k.putThing();
    }
    public void advanceLeft (){
        k.pickThing();
        k.turnLeft();
        k.move();
        k.putThing();
        k.pickThing();
        for (int i = 0; i < 3; i++){
        k.turnLeft();
        }
        k.move();
        k.move();
        k.putThing();
    }
    public void advanceRight(){
        k.pickThing();
        for (int i=0; i <3; i++){
        k.turnLeft();    
        }
        k.move();
        k.putThing();
        k.pickThing();
        k.turnLeft();
        k.move();
        k.move();
        k.putThing();
    }
    
}
