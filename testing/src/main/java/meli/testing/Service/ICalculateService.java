package meli.testing.Service;

import meli.testing.DTO.*;


public interface ICalculateService {
    HouseResponseTotalSquareFeetDTO calculateTotalSquareFeet(HouseDTO house);
    HouseResponseValueDTO calculatePrice(HouseDTO house);
    RoomDTO getBiggestRoom(HouseDTO house);
    HouseResponseSquareFeetPerRoomDTO calculateSquareFeetPerRoom(HouseDTO house);
}
