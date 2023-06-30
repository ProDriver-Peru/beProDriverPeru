package pe.prodriverperu.beprodriverperu.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.prodriverperu.beprodriverperu.business.BusinessEmployer;
import pe.prodriverperu.beprodriverperu.dtos.EmployerDTO;
import pe.prodriverperu.beprodriverperu.entities.Employer;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RestEmployer {
    @Autowired
    private BusinessEmployer businessEmployer;

    //INSERT
    @PostMapping("/employer")
    public EmployerDTO insert(@RequestBody EmployerDTO employerDTO){
        Employer employer;
        try{
            employer = convertToEntity(employerDTO);
            employer = businessEmployer.insert(employer);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fue posible registrar");
        }
        return convertToDto(employer);
    }

    //UPDATE
    @PutMapping("/employer/{id}")
    public ResponseEntity<EmployerDTO> updateEmployer(@PathVariable(value = "id") Integer id, @RequestBody EmployerDTO employerDTO){
        Employer employer;
        Employer employerUpdate;
        try {
            employer = convertToEntity(employerDTO);
            employerUpdate = businessEmployer.updateEmployer(id, employer);
            employerDTO = convertToDto(employerUpdate);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fue posible actualizar");
        }
        return new ResponseEntity<EmployerDTO>(employerDTO, HttpStatus.OK);
    }

    //LIST BY ID
    @GetMapping("/employer/{id}")
    public ResponseEntity<EmployerDTO> listByIdEmployer(@PathVariable(value = "id") Integer id){
        Employer employer;
        EmployerDTO employerDTO;
        try{
            employer = businessEmployer.listByIdEmployer(id);
            employerDTO = convertToDto(employer);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fue posible encontrar sus datos");
        }
        return new ResponseEntity<EmployerDTO>(employerDTO,HttpStatus.OK);
    }

    //LIST BY LICENSE
    @GetMapping("/employer/licenseType/{licenseType}")
    public ResponseEntity<List<EmployerDTO>> listByLicenseTypeEmployer(@PathVariable(value = "licenseType") String license){
        List<Employer>listEmployer;
        List<EmployerDTO> listEmployerDTO;
        try{
            listEmployer=businessEmployer.listbyLicenseEmployer(license);
            listEmployerDTO=convertToLisDto(listEmployer);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha podido listar");
        }
        return new ResponseEntity<List<EmployerDTO>>(listEmployerDTO,HttpStatus.OK);
    }




    //---------DTO----------
    private EmployerDTO convertToDto(Employer employer) {
        ModelMapper modelMapper = new ModelMapper();
        EmployerDTO employerDTO = modelMapper.map(employer, EmployerDTO.class);
        return employerDTO;
    }
    private Employer convertToEntity(EmployerDTO employerDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Employer post = modelMapper.map(employerDTO, Employer.class);
        return post;
    }
    private List<EmployerDTO> convertToLisDto(List<Employer> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}