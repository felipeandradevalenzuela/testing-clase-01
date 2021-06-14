package meli.testing.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class HouseResponseSquareFeetPerRoomDTO {
    private List<RoomSquareFeetDTO> roomsSquareFeet;

}
