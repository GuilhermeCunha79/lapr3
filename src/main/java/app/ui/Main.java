package app.ui;

import app.controller.ImportShipsController;
import app.domain.model.Position;
import app.domain.model.Ship;
import app.domain.utils.BST.BST;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
class Main {

    /**
     * Logger class.
     */
    private static final Logger LOGGER = Logger.getLogger("MainLog");

    /**
     * Private constructor to hide implicit public one.
     */
    private Main() {

    }

    /**
     * Application main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
        ImportShipsUI uii= new ImportShipsUI();
        ImportShipsController ctrl=new ImportShipsController();
        BST <Ship> bst = new BST<>();
        BST <Position> bst1 = new BST<>();
        bst=uii.importShipsUI();
        bst1=ctrl.importShipsPosition("sships.csv");

        FindShipUI ui=new FindShipUI();
        ShipMessagesUI ul=new ShipMessagesUI();
        //ImportShipsUI.importShipsUI("sships.csv");
        ui.findShipUI();
        ul.shipMessagesUi();


        if (LOGGER.isLoggable(Level.INFO)) {
            //LOGGER.log(Level.INFO, bst1.toString());
        }
    }
}

