package lapr.project.controller;

import lapr.project.model.Ship;
import lapr.project.utils.BST.BST;
import lapr.project.utils.DTO.ShipDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportShipsController {

    public static BST<Ship> importShips(String file) throws FileNotFoundException {
        BST<Ship> bst = new BST<>();
        File ficheiro = new File(file);

        Scanner scan = new Scanner(ficheiro);
        String line = scan.nextLine();

        while(scan.hasNextLine()){
            String buff[] = scan.nextLine().trim().split(",");
            ShipDTO shipDTO=new ShipDTO(Integer.parseInt(buff[0]),buff[1],Double.parseDouble(buff[2]),Double.parseDouble(buff[3]), Float.parseFloat(buff[4]),Float.parseFloat(buff[5]),Integer.parseInt(buff[6]),buff[7],buff[8],buff[9],Integer.parseInt(buff[10]),Integer.parseInt(buff[11]),Integer.parseInt(buff[12]),Double.parseDouble(buff[13]),buff[14],buff[15]);
            Ship ship = new Ship(shipDTO);
            bst.insert(ship);
        }
        return bst;
    }
}