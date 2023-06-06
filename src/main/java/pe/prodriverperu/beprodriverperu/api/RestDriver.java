package pe.prodriverperu.beprodriverperu.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pe.prodriverperu.beprodriverperu.business.BusinessDriver;
import pe.prodriverperu.beprodriverperu.dtos.DriverDTO;
import pe.prodriverperu.beprodriverperu.entities.Driver;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RestDriver {
    @Autowired
    private BusinessDriver businessDriver;
    //INSERT
    @PostMapping("/driver")
    public DriverDTO insert(@RequestBody DriverDTO driverDTO){
        Driver driver;
        try{
            driver = convertToEntity(driverDTO);
            driver = businessDriver.insert(driver);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fue posible registrar");
        }
        return convertToDto(driver);
    }








    //---------DTO----------
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
