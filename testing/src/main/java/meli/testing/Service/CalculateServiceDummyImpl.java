package meli.testing.Service;

import meli.testing.DTO.*;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("CalculateDummy")
@Primary
public class CalculateServiceDummyImpl implements ICalculateService{
    @Override
    public HouseResponseTotalSquareFeetDTO calculateTotalSquareFeet(HouseDTO house) {
        return null;
    }

    @Override
    public HouseResponseValueDTO calculatePrice(HouseDTO house) {
        return null;
    }

    @Override
    public RoomDTO getBiggestRoom(HouseDTO house) {
        return null;
    }

    @Override
    public HouseResponseSquareFeetPerRoomDTO calculateSquareFeetPerRoom(HouseDTO house) {
        return null;
    }
}
