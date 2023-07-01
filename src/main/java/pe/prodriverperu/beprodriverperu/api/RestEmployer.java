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

//@CrossOrigin(origins = {"http://18.119.164.9"})
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class RestEmployer {
    @Autowired
    private BusinessEmployer businessEmployer;

    //INSERT
    @PostMapping("/employer")
    public EmployerDTO insertEmployer(@RequestBody EmployerDTO employerDTO){
        Employer employer;
        try{
            employer = convertToEntityEmployer(employerDTO);
            employer = businessEmployer.insertEmployer(employer);
        } catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fue posible registrar");
        }
        return convertToDtoEmployer(employer);
    }

    //UPDATE
    @PutMapping("/employer/{id}")
    public ResponseEntity<EmployerDTO> updateEmployer(@PathVariable(value = "id") Integer id, @RequestBody EmployerDTO employerDTO){
        Employer employer;
        Employer employerUpdate;
        try {
            employer = convertToEntityEmployer(employerDTO);
            employerUpdate = businessEmployer.updateEmployer(id, employer);
            employerDTO = convertToDtoEmployer(employerUpdate);
        }catch (Exception e){
            e.printStackTrace();
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
            employerDTO = convertToDtoEmployer(employer);
        } catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fue posible encontrar sus datos");
        }
        return new ResponseEntity<EmployerDTO>(employerDTO,HttpStatus.OK);
    }


    //---------DTO----------
    private EmployerDTO convertToDtoEmployer(Employer employer) {
        ModelMapper modelMapper = new ModelMapper();
        EmployerDTO employerDTO = modelMapper.map(employer, EmployerDTO.class);
        return employerDTO;
    }
    private Employer convertToEntityEmployer(EmployerDTO employerDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Employer post = modelMapper.map(employerDTO, Employer.class);
        return post;
    }
    private List<EmployerDTO> convertToLisDtoEmployer(List<Employer> list){
        return list.stream()
                .map(this::convertToDtoEmployer)
                .collect(Collectors.toList());
    }
}