package meli.testing;

import meli.testing.DTO.*;
import meli.testing.Repository.BarrioRepository;
import meli.testing.Repository.IBarrioRepository;
import meli.testing.Service.CalculateServiceImpl;
import meli.testing.Service.ICalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
class CalculadoraMetrosCuadradosApplicationTests {

	//@MockBean
	private IBarrioRepository barrioRepo =
			Mockito.mock(IBarrioRepository.class);

	//@InjectMocks
	private CalculateServiceImpl calculateService =
			new CalculateServiceImpl(barrioRepo);


	/*CalculadoraMetrosCuadradosApplicationTests() {
		this.calculateService = new CalculateServiceImpl(this.barrioRepo);
	}*/

	@Test
	void testCalculatePricePositiveOk() throws Exception {

		//Arrange
		HouseDTO house = new HouseDTO(
				"Casa",
				"Constitucion 230",
				Arrays.asList(
						new RoomDTO(
								"patio",
								3,
								3
						),
						new RoomDTO(
								"living",
								2,
								1
						)
				),
				"belgrano");

		Barrio barrio = new Barrio(
				"belgrano",
				8.0
		);
		HouseResponseValueDTO expectedResponse = new HouseResponseValueDTO(
				88.0 // ( (3 * 3) + (2 * 1) ) * 8
		);

		when( barrioRepo.getBarrioPorNombre( house.getBarrio() ) ).thenReturn( barrio );


		//Act
		HouseResponseValueDTO response = calculateService.calculatePrice(house);

		//Assert

		verify(barrioRepo, atLeast(1)).getBarrioPorNombre(house.getBarrio());

		Assertions.assertEquals(expectedResponse, response);

	}

	@Test
	void testCalculatePriceNegativeWidth() throws Exception {

		//Arrange
		HouseDTO house = new HouseDTO(
				"Casa",
				"Constitucion 230",
				Arrays.asList(
						new RoomDTO(
								"patio",
								-3, // a negative value
								3
						),
						new RoomDTO(
								"living",
								2,
								1
						)
				),
				"belgrano");

		Barrio barrio = new Barrio(
				"belgrano",
				8.0
		);

		when( barrioRepo.getBarrioPorNombre( house.getBarrio() ) ).thenReturn( barrio );


		//Act
		//Assert

		Assertions.assertThrows(Exception.class, ()-> calculateService.calculatePrice(house) );

	}

}
