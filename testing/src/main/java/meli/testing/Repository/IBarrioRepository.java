package meli.testing.Repository;


import meli.testing.DTO.Barrio;

public interface IBarrioRepository {
    Barrio getBarrioPorNombre(String name) throws NoSuchFieldException;

}
