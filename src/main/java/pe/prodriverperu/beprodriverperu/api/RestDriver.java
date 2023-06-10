package pe.prodriverperu.beprodriverperu.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.prodriverperu.beprodriverperu.business.BusinessDriver;
import pe.prodriverperu.beprodriverperu.dtos.*;
import pe.prodriverperu.beprodriverperu.entities.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RestDriver {
    @Autowired
    private BusinessDriver businessDriver;

    /*DRIVER*/
    //INSERT
    @PostMapping("/driver")
    public DriverDTO insertDriver(@RequestBody DriverDTO driverDTO){
        Driver driver;
        try{
            driver = convertToEntity(driverDTO);
            driver = businessDriver.insertDriver(driver);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fue posible registrar");
        }
        return convertToDto(driver);
    }

    //UPDATE
    @PutMapping("/driver/{id}")
    public ResponseEntity<DriverDTO> updateDriver(@PathVariable(value = "id") Integer id, @RequestBody DriverDTO driverDTO){
        Driver driver;
        Driver driverUpdate;
        try {
            driver = convertToEntity(driverDTO);
            driverUpdate = businessDriver.updateDriver(id, driver);
            driverDTO = convertToDto(driverUpdate);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fue posible actualizar");
        }
        return new ResponseEntity<DriverDTO>(driverDTO, HttpStatus.OK);
    }

    //LIST BY ID
    @GetMapping("/driver/{id}")
    public ResponseEntity<DriverDTO> listByIdDriver(@PathVariable(value = "id") Integer id){
        Driver driver;
        DriverDTO driverDTO;
        try{
            driver = businessDriver.listByIdDriver(id);
            driverDTO = convertToDto(driver);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fue posible encontrar sus datos");
        }
        return new ResponseEntity<DriverDTO>(driverDTO,HttpStatus.OK);
    }

    //LIST BY LICENSE
    @GetMapping("/driver/licenseType/{licenseType}")
    public ResponseEntity<List<DriverDTO>> listByLicenseTypeDriver(@PathVariable(value = "licenseType") String license){
        List<Driver>listDriver;
        List<DriverDTO> listDriverDTO;
        try{
            listDriver=businessDriver.listbyLicenseDriver(license);
            listDriverDTO=convertToLisDto(listDriver);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha podido listar");
        }
        return new ResponseEntity<List<DriverDTO>>(listDriverDTO,HttpStatus.OK);
    }

    /*-----------------------------------------------------*/
    /*EMPLOYER*/


    //-----------------------------------------------------DTO----------------------------------------------------------
    /*DRIVER DTO*/
    private DriverDTO convertToDto(Driver driver) {
        ModelMapper modelMapper = new ModelMapper();
        DriverDTO driverDTO = modelMapper.map(driver, DriverDTO.class);
        return driverDTO;
    }
    private Driver convertToEntity(DriverDTO driverDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Driver post = modelMapper.map(driverDTO, Driver.class);
        return post;
    }
    private List<DriverDTO> convertToLisDto(List<Driver> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

}
