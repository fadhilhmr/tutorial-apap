package apap.tutorial.traveloke.restcontroller;

import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.KamarRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class KamarRestController {
    @Autowired
    private KamarRestService kamarRestService;

    @PostMapping(value = "/kamar")
    private KamarModel createKamar(@Valid @RequestBody KamarModel kamar, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        }
        else {
            return kamarRestService.createKamar(kamar);
        }
    }

    @GetMapping(value = "/kamar/{idKamar}")
    private KamarModel retrieveKamar(@PathVariable("idKamar") Long idKamar){
        try {
            return kamarRestService.getKamarByIdKamar(idKamar);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID kamar"+String.valueOf(idKamar)+" Not Found"
            );
        }
    }

    @DeleteMapping(value = "/kamar/{idKamar}")
    private ResponseEntity<String> deleteKamar(@PathVariable("idKamar") Long idKamar){
        try{
            kamarRestService.deleteKamar(idKamar);
            return ResponseEntity.ok("kamar with ID " + String.valueOf(idKamar)+" Deleted!");
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "kamar with ID "+String.valueOf(idKamar)+" Not Found!");
        }catch (UnsupportedOperationException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "kamar still has kamar, please delete the kamar first!");
        }
    }

    @PutMapping(value = "/kamar/{idKamar}")
    private KamarModel updateKamar(
            @PathVariable (value = "idKamar") Long idKamar,
            @RequestBody KamarModel kamar
    ){
        try{
            return kamarRestService.changeKamar(idKamar, kamar);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "kamar with ID "+String.valueOf(idKamar)+" Not Found!");
        }
    }

    @GetMapping(value = "/kamar-all")
    private List<KamarModel> retrieveListKamar(){
        return kamarRestService.retrieveListKamar();
    }

//    @GetMapping(value= "/kamar/{idKamar}/status")
//    private Mono<String> getStatus(
//            @PathVariable Long idKamar
//    ){
//        return kamarRestService.getStatus(idKamar);
//    }
//
//    @GetMapping(value="/full")
//    private Mono<kamarDetail> postStatus(){
//        return kamarRestService.postStatus();
//    }
}