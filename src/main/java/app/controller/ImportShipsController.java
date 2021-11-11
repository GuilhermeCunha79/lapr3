package app.controller;

import app.domain.model.*;
import app.domain.store.PositionStore;
import app.domain.store.ShipStore;
import app.domain.utils.BST.BST;
import app.domain.utils.DTO.PositionDTO;
import app.domain.utils.DTO.ShipDTO;

import java.io.File;
import java.io.IOException;

import java.util.Scanner;

public class ImportShipsController extends BST<Ship> {
    DetailsShipController ctrl = new DetailsShipController();
    PositionalMessagesController ctrl1=new PositionalMessagesController();
    private final ShipStore shipStore ;
    private final PositionStore positionStore;
    private Ship ship;

    public ImportShipsController() {
        this(App.getInstance().getCompany());
    }

    public ImportShipsController(Company company) {
        this.shipStore = company.getShipStore();
        this.positionStore=company.getPositionStore();
        this.ship = null;
    }

    public BST<Ship> importShips(String file, String type) throws IOException {
        BST<Ship> bst = new BST<>();
        File ficheiro = new File(file);
        try {
            Scanner scan = new Scanner(ficheiro);
            String line = scan.nextLine();

            while (scan.hasNextLine()) {
                String buff[] = scan.nextLine().trim().split(",");
                ShipDTO shipDTO = new ShipDTO(Integer.parseInt(buff[0]), buff[7], buff[8], buff[9], Integer.parseInt(buff[10]), Integer.parseInt(buff[11]), Integer.parseInt(buff[12]), Double.parseDouble(buff[13]), buff[14]);
                Ship ship = this.shipStore.newShip(shipDTO);
                switch (type) {
                    case ("MMSI"):
                        this.ctrl.newShip(shipDTO);
                        this.shipStore.saveShipMmsi(ship, "MMSI");
                        bst.insert(ship);
                        break;
                    case ("Call Sign"):
                        CallSignTree callSignTree = new CallSignTree(shipDTO);
                        this.ctrl.newShip(shipDTO);
                        this.shipStore.saveShipCallSign(callSignTree);
                        bst.insert(callSignTree);
                        break;
                    case ("IMO"):
                        IMOTree imoTree = new IMOTree(shipDTO);
                        this.ctrl.newShip(shipDTO);
                        this.shipStore.saveShipImo(imoTree);
                        bst.insert(imoTree);
                        break;
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("File not found");
        }
        return bst;
    }

    public  BST<Position> importShipsPosition(String file) {
        BST<Position> bst1 = new BST<>();
        File ficheiro = new File(file);
        try {
            Scanner scan = new Scanner(ficheiro);
            String line = scan.nextLine();

            while (scan.hasNextLine()) {
                String buff[] = scan.nextLine().trim().split(",");
                PositionDTO positionDTO = new PositionDTO(Integer.parseInt(buff[0]), buff[1], Double.parseDouble(buff[2]), Double.parseDouble(buff[3]), Float.parseFloat(buff[4]), Float.parseFloat(buff[5]), Integer.parseInt(buff[6]), buff[15]);
                Position position = new Position(positionDTO);
                this.ctrl1.newPosition(positionDTO);
                this.positionStore.savePosition(position);
                bst1.insert(position);
                ctrl1.savePosition();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("File not found");
        }
        return bst1;
    }

    public BST<Ship> getShipTree() {
        return App.getInstance().getCompany().getShipStore().getShipTree();
    }


}