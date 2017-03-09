package becker;

import becker.robots.*;

public class Parqueadero {

    private Seccion[] secciones;
    private City parqueadero;
    private Robot ballet;
    private Wall paredes;

    public Parqueadero() {
        this.secciones = new Seccion[3];
        this.secciones[0] = new Seccion(1);
        this.secciones[1] = new Seccion(2);
        this.secciones[2] = new Seccion(3);
        this.parqueadero = new City(15, 15);
        this.ballet = new Robot(parqueadero, 11, 5, Direction.WEST, 5);
        muro(11, 1, 1, parqueadero);
        muro(10, 1, 2, parqueadero);
        muro(10, 1, 3, parqueadero);
        muro(10, 1, 4, parqueadero);
        pared(3, 2, 1, parqueadero);
        pared(5, 2, 12, parqueadero);
        pared(2, 5, 11, parqueadero);

    }

    public static void pared(int y, int x, int h, City b) {
        Wall o[] = new Wall[y];
        for (int i = 0; i < y; i++) {

            o[i] = new Wall(b, h, i + x, Direction.NORTH);
        }
    }

    public static void muro(int y, int x, int h, City b) {
        Wall o[] = new Wall[y];
        for (int i = 0; i < y; i++) {

            o[i] = new Wall(b, x + i, h, Direction.EAST);
        }
    }

    public void addCarro(Vehiculo v) {
        int l = 0;
        if (secciones[0].getnCarros() > secciones[1].getnCarros()) {
           if(secciones[0].getnCarros() > secciones[2].getnCarros()) 
               l = 1;
        } else if(secciones[1].getnCarros() > secciones[2].getnCarros())
            l = 2;
        else
            l = 3;
        for (int i = 0; i < l; i++) {
            ballet.move();
        }
        ballet.turnLeft();
        ballet.turnLeft();
        ballet.turnLeft();
        ballet.move();
        while (ballet.canPickThing() == false && ballet.frontIsClear() == true) {
            ballet.move();
        }
        if (ballet.frontIsClear() == false) {
            ballet.putThing();
            ballet.turnLeft();
            ballet.turnLeft();
        } else {
            ballet.turnLeft();
            ballet.turnLeft();
            ballet.move();
            ballet.putThing();
        }

        while (ballet.frontIsClear() == true) {
            ballet.move();

        }

        ballet.turnLeft();
        for (int i = 0; i < l; i++) {
            ballet.move();
        }
        secciones[l-1].addVehiculo(v);
    }

}
