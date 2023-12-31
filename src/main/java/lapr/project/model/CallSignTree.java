package lapr.project.model;

import lapr.project.utils.DTO.ShipDTO;

public class CallSignTree extends Ship {

    public CallSignTree(ShipDTO dto) {
        super(dto);
    }


    @Override
    public int compareTo(Ship o) {
        return super.getCallSign().compareTo(o.getCallSign());
    }

}
