package pe.prodriverperu.beprodriverperu.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.prodriverperu.beprodriverperu.business.BusinessEmployer;
import pe.prodriverperu.beprodriverperu.dtos.EmployerDTO;
import pe.prodriverperu.beprodriverperu.entities.Employer;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = {"http://172.190.169.21"})
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
            employer = convertToEntityEmployer(employerDTO);
            employer = businessEmployer.insert(employer);
        } catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fue posible registrar");
        }
        return convertToDtoEmployer(employer);
    }


    /*EMPLOYER DTO*/
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
