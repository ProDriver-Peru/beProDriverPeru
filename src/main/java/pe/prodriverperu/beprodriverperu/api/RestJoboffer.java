package pe.prodriverperu.beprodriverperu.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.prodriverperu.beprodriverperu.business.BusinessJobOffer;
import pe.prodriverperu.beprodriverperu.dtos.DriverDTO;
import pe.prodriverperu.beprodriverperu.dtos.JobOfferDTO;
import pe.prodriverperu.beprodriverperu.entities.Driver;
import pe.prodriverperu.beprodriverperu.entities.Joboffer;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://18.119.164.9"})
//@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class RestJoboffer {
    @Autowired
    private BusinessJobOffer businessJobOffer;
    /*-----------------------------------------------------*/
    /*JOB OFFER*/

    //INSERT JOBOFFER
    @CrossOrigin(origins = {"http://localhost:4200"})
    @PostMapping("/jobOffer")
    public ResponseEntity<JobOfferDTO> insertJobOfferDTO(@RequestBody JobOfferDTO jobOfferDTO){
        Joboffer joboffer;
        try{
            joboffer=convertToEntityJobOffer(jobOfferDTO);
            joboffer=businessJobOffer.insertJobOffer(joboffer);
        }catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fue posible registrar Oferta de trabajo");
        }
        return new ResponseEntity<JobOfferDTO>(convertToDtoJobOffer(joboffer),HttpStatus.OK);
    }

    //LIST JOB OFFERS
    @GetMapping("/jobOffer")
    public ResponseEntity<List<JobOfferDTO>> listJobOffer(){
        List<Joboffer> listJobOffer;
        List<JobOfferDTO> listJobOfferDTO;
        try{
            listJobOffer = businessJobOffer.listJobOffer();
            listJobOfferDTO = convertToLisDtoJobOffer(listJobOffer);
        } catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha podido listar ofertas de trabajo");
        }
        return new ResponseEntity<List<JobOfferDTO>>(listJobOfferDTO,HttpStatus.OK);
    }

    //UPDATE JOBOFFER
    @PutMapping("/jobOffer/{id}")
    public ResponseEntity<JobOfferDTO> updateJobOffer(@PathVariable(value = "id")Integer id, @RequestBody JobOfferDTO jobOfferDTO){
        Joboffer joboffer;
        Joboffer jobofferUpdate;
        try {
            joboffer = convertToEntityJobOffer(jobOfferDTO);
            jobofferUpdate = businessJobOffer.updateJobOffer(id,joboffer);
            jobOfferDTO = convertToDtoJobOffer(jobofferUpdate);
        } catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fue posible actualizar oferta de trabajo");
        }
        return new ResponseEntity<JobOfferDTO>(jobOfferDTO, HttpStatus.OK);
    }
    //GET JOB OFFER BY ID
    @GetMapping("/jobOffer/{id}")
    public ResponseEntity<JobOfferDTO> getJobOfferById(@PathVariable(name = "id") Integer idJoboffer){
        Joboffer joboffer;
        JobOfferDTO jobOfferDTO;
        try{
            joboffer = businessJobOffer.getByIdJobOffer(idJoboffer);
            jobOfferDTO = convertToDtoJobOffer(joboffer);
        } catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fue posible encontrar datos de la oferta de trabajo");
        }
        return new ResponseEntity<JobOfferDTO>(jobOfferDTO,HttpStatus.OK);
    }

    //LIST JOB OFFERS BY ID EMPLOYER
    @GetMapping("/jobOffer/idEmployer/{idEmployer}")
    public ResponseEntity<List<JobOfferDTO>> listJobofferByIdEmployer(@PathVariable(name = "idEmployer")Integer idEmployer){
        List<Joboffer> joboffersList;
        List<JobOfferDTO> jobOfferDTOSList;
        try{
            joboffersList = businessJobOffer.listJobOfferByIdEmployer(idEmployer);
            jobOfferDTOSList = convertToLisDtoJobOffer(joboffersList);
        }catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha podido listar");
        }
        return new ResponseEntity<List<JobOfferDTO>>(jobOfferDTOSList, HttpStatus.OK);
    }

    //LIST USER BY ID EMPLOYER
    @GetMapping("/jobOffer/idJobOffer/{idEmployer}")
    public ResponseEntity<List<DriverDTO>> listJDriverByIdJobOffer(@PathVariable(name = "idEmployer")Integer idEmployer){
        List<Driver> driverList;
        List<DriverDTO> driverDTOList;
        try{
            driverList = businessJobOffer.listJDriverByIdJobOffer(idEmployer);
            driverDTOList = convertToLisDto(driverList);
        }catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha podido listar usuarios por idJoboffer");
        }
        return new ResponseEntity<List<DriverDTO>>(driverDTOList, HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/jobOffer/{id}")
    public void deleteId(@PathVariable(name = "id")Integer id){
        try{
            businessJobOffer.delete(id);
        } catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fue posible eliminar la oferta de trabajo");
        }
    }

    //-----------------------------------------------------DTO----------------------------------------------------------
    /*JOBOFFER DTO*/
    private JobOfferDTO convertToDtoJobOffer(Joboffer joboffer) {
        ModelMapper modelMapper = new ModelMapper();
        JobOfferDTO jobOfferDTO = modelMapper.map(joboffer, JobOfferDTO.class);
        return jobOfferDTO;
    }
    private Joboffer convertToEntityJobOffer(JobOfferDTO jobOfferDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Joboffer post = modelMapper.map(jobOfferDTO, Joboffer.class);
        return post;
    }
    private List<JobOfferDTO> convertToLisDtoJobOffer(List<Joboffer> list){
        return list.stream()
                .map(this::convertToDtoJobOffer)
                .collect(Collectors.toList());
    }

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
