package meli.testing.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class HouseDTO {
    private String name;
    private String address;
    private List<RoomDTO> rooms;
    private String barrio;

}
