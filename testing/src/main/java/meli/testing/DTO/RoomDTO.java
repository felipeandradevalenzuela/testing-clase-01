package meli.testing.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomDTO {
    private String name;
    private Integer width;
    private Integer length;
}

