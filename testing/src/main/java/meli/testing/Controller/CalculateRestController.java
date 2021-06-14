package meli.testing.Controller;

import meli.testing.DTO.*;
import meli.testing.Service.CalculateServiceImpl;
import meli.testing.Service.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletResponse;

/*public class LinkAlreadyCreatedException extends LinkTrackerException {
  public LinkAlreadyCreatedException(String link){
    super("EL link ya existe", HttpStatus.BAD_REQUEST);
  }
}*/


@RestController
public class CalculateRestController {

    private ICalculateService calculateService;

    @Autowired
    CalculateRestController( @Qualifier("CalculateService") ICalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @PostMapping("/calculateTotalSquareFeet")
    public HouseResponseTotalSquareFeetDTO calculateTotalSquareFeet(@RequestBody HouseDTO house){
        return calculateService.calculateTotalSquareFeet(house);
    }

    @GetMapping("/google")
    public RedirectView google(){
        return new RedirectView("http://www.google.com");
    }

    @GetMapping("/google2")
    public String google2(){
        return "redirect:" + "www.google.com";
    }
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public void method(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Location", "www.google.com");
        httpServletResponse.setStatus(302);
    }




    @PostMapping("/calculatePrice")
    public HouseResponseValueDTO calculatePrice(@RequestBody HouseDTO house){
        //CalculateServiceImpl calculateService = new CalculateServiceImpl();
        return calculateService.calculatePrice(house);
    }

    @PostMapping("/getBiggestRoom")
    public RoomDTO getBiggestRoom(@RequestBody HouseDTO house){
        //CalculateServiceImpl calculateService = new CalculateServiceImpl();
        return calculateService.getBiggestRoom(house);
    }

    @PostMapping("/calculateSquareFeetPerRoom")
    public HouseResponseSquareFeetPerRoomDTO calculateSquareFeetPerRoom(@RequestBody HouseDTO house){
        //CalculateServiceImpl calculateService = new CalculateServiceImpl();
        return calculateService.calculateSquareFeetPerRoom(house);
    }

}
