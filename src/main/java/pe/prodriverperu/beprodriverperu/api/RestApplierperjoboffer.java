package pe.prodriverperu.beprodriverperu.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.prodriverperu.beprodriverperu.business.BusinessAppliersperjoboffer;
import pe.prodriverperu.beprodriverperu.dtos.AppliersperjobofferDTO;
import pe.prodriverperu.beprodriverperu.dtos.DriverDTO;
import pe.prodriverperu.beprodriverperu.entities.Appliersperjoboffer;
import pe.prodriverperu.beprodriverperu.entities.Driver;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://172.190.169.21"})
@RestController
@RequestMapping("/api")
public class RestApplierperjoboffer {
    @Autowired
    private BusinessAppliersperjoboffer businessAppliersperjoboffer;

    //INSERT
    @PostMapping("/applierperjoboffer")
    public AppliersperjobofferDTO insertApplierperjoboffer(@RequestBody AppliersperjobofferDTO appliersperjobofferDTO){
        Appliersperjoboffer appliersperjoboffer;
        try{
            appliersperjoboffer = convertToEntityAppliersperjoboffer(appliersperjobofferDTO);
            appliersperjoboffer = businessAppliersperjoboffer.inserApplierperjoboffer(appliersperjoboffer);
        } catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fue posible registrar");
        }
        return convertToDtoAppliersperJobOffer(appliersperjoboffer);
    }

    //UPDATE
    @PutMapping("/applierperjoboffer/{id}")
    public ResponseEntity<AppliersperjobofferDTO> updateAppliersperjoboffer(@PathVariable(value = "id") Integer id, @RequestBody AppliersperjobofferDTO appliersperjobofferDTO){
        Appliersperjoboffer appliersperjoboffer;
        Appliersperjoboffer appliersperjobofferUpdate;
        try {
            appliersperjoboffer = convertToEntityAppliersperjoboffer(appliersperjobofferDTO);
            appliersperjobofferUpdate = businessAppliersperjoboffer.updateAppliersperjoboffer(id, appliersperjoboffer);
            appliersperjobofferDTO = convertToDtoAppliersperJobOffer(appliersperjobofferUpdate);
        }catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fue posible actualizar");
        }
        return new ResponseEntity<AppliersperjobofferDTO>(appliersperjobofferDTO, HttpStatus.OK);
    }

    //GET BY ID
    @GetMapping("/applierperjoboffer/{id}")
    public ResponseEntity<AppliersperjobofferDTO> listByIdAppliersperjoboffer(@PathVariable(value = "id") Integer id){
        Appliersperjoboffer appliersperjoboffer;
        AppliersperjobofferDTO appliersperjobofferDTO;
        try{
            appliersperjoboffer = businessAppliersperjoboffer.listByIdApplierperjoboffer(id);
            appliersperjobofferDTO = convertToDtoAppliersperJobOffer(appliersperjoboffer);
        } catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fue posible encontrar sus datos");
        }
        return new ResponseEntity<AppliersperjobofferDTO>(appliersperjobofferDTO,HttpStatus.OK);
    }

    //LIST APPLIER BY ID OFERTA DE TRABAJO
    @GetMapping("/applierperjoboffer/joboffer/{idjoboffer}")
    public ResponseEntity<List<AppliersperjobofferDTO>> listByIdJobOfferAppliers(@PathVariable(value = "idjoboffer") Integer idJobOffer){
        List<Appliersperjoboffer> listAppliersperjoboffer;
        List<AppliersperjobofferDTO> listAppliersperjobofferDTO;
        try{
            listAppliersperjoboffer = businessAppliersperjoboffer.listAppliersperJobOfferByIdJobOffer(idJobOffer);
            listAppliersperjobofferDTO = convertToLisDtoAppliersperJobOffer(listAppliersperjoboffer);
        }catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha podido listar");
        }
        return new ResponseEntity<List<AppliersperjobofferDTO>>(listAppliersperjobofferDTO,HttpStatus.OK);
    }

    //LIST APPLIERS BY ID DRIVER
    @GetMapping("/applierperjoboffer/idDriver/{idDriver}")
    public ResponseEntity<List<AppliersperjobofferDTO>> listByIdDriverAppliers(@PathVariable(value = "idDriver") Integer idDriver){
        List<Appliersperjoboffer> listAppliersperjoboffer;
        List<AppliersperjobofferDTO> listAppliersperjobofferDTO;
        try{
            listAppliersperjoboffer = businessAppliersperjoboffer.listAppliersperjobofferByIdDrivr(idDriver);
            listAppliersperjobofferDTO = convertToLisDtoAppliersperJobOffer(listAppliersperjoboffer);
        }catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha podido listar");
        }
        return new ResponseEntity<List<AppliersperjobofferDTO>>(listAppliersperjobofferDTO,HttpStatus.OK);
    }

    /*-------------------------------------------DTO------------------------------------------------------------------*/
    /*AppliersperJobOffer*/
    private AppliersperjobofferDTO convertToDtoAppliersperJobOffer(Appliersperjoboffer appliersperjoboffer) {
        ModelMapper modelMapper = new ModelMapper();
        AppliersperjobofferDTO appliersperjobofferDTO = modelMapper.map(appliersperjoboffer, AppliersperjobofferDTO.class);
        return appliersperjobofferDTO;
    }
    private Appliersperjoboffer convertToEntityAppliersperjoboffer(AppliersperjobofferDTO appliersperjobofferDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Appliersperjoboffer post = modelMapper.map(appliersperjobofferDTO, Appliersperjoboffer.class);
        return post;
    }
    private List<AppliersperjobofferDTO> convertToLisDtoAppliersperJobOffer(List<Appliersperjoboffer> list){
        return list.stream()
                .map(this::convertToDtoAppliersperJobOffer)
                .collect(Collectors.toList());
    }

}
