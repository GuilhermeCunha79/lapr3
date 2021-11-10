package model;

import lapr.project.model.MMSITree;
import lapr.project.model.Ship;
import lapr.project.utils.DTO.ShipDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MMSITreeTest {

    @Test
    void compareTo() {
        ShipDTO dto = new ShipDTO(111111111, "VARAMO", "IMO3212345", "C4SQ2", 70, 1, 1, 9.5, "NA");
        MMSITree mmsiTree = new MMSITree(dto);
        Ship ship = new Ship(dto);
        Assertions.assertNotNull(mmsiTree.compareTo(ship));
    }

    @Test
    public void creatCorrectShip(){
        int mmssi=111111111;
        MMSITree mmsiTree=new MMSITree(mmssi);
    }

}