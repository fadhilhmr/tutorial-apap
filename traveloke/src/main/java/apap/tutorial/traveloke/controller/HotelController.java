package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class HotelController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/hotel")
    private String home(){
        return "home";
    }

    @GetMapping("/hotel/add")
    private String addHotelFormPage(Model model){
        model.addAttribute("hotel", new HotelModel());
        return "form-add-hotel";
    }

    @PostMapping("/hotel/add")
    public String addHotelSubmit(
            @ModelAttribute HotelModel hotel,
            Model model){
        hotelService.addHotel(hotel);
        model.addAttribute("idHotel", hotel.getId());
        return "add-hotel";
    }



    @GetMapping("/hotel/change/{idHotel}")
    public String changeHotelFormPage(
            @PathVariable Long idHotel,
            Model model
    ){
        try {
            if (idHotel == null) {
                return "error-input";
            }
            HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
            model.addAttribute("hotel", hotel);
            return "form-update-hotel";
        }
        catch (NumberFormatException e){
            return "error-input";
        }
        catch (NoSuchElementException e){
            return "error-input";
        }
    }

    @PostMapping("/hotel/change")
    public String changeHotelFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        HotelModel hotelUpdated = hotelService.updateHotel(hotel);
        model.addAttribute("hotel",hotel);
        return "update-hotel";
    }



    @GetMapping("/hotel/view")
    public String viewDetailHotel(
            @RequestParam(value= "idHotel") Long idHotel,
            Model model
    ){
        try{
            if (idHotel == null) {
                return "error-input";
            }
            HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
            List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
            model.addAttribute("hotel",hotel);
            model.addAttribute("listKamar", listKamar);
            model.addAttribute("hasKamar", !listKamar.isEmpty());
            if(listKamar.size()== 0){
                model.addAttribute("status", "hotel belum memiliki daftar kamar");
            }else {
                model.addAttribute("status", "kamar tersedia");

            }
            return "view-hotel";
        }
        catch (NumberFormatException e){
            return "error-input";
        }
        catch (NoSuchElementException e){
            return "error-input";
        }
    }

    @GetMapping("/hotel/view/delete/{idHotel}")
    public String deleteHotel(
            @PathVariable(value= "idHotel") Long idHotel,
            Model model
    ){
        try {
            if (idHotel == null) {
                return "error-input";
            }
            HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
            List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
            if (listKamar.size() == 0) {
                hotelService.deleteHotel(hotel);
                return "home";
            }
            return "error-delete";
        }catch (NumberFormatException e){
            return "error-input";
        }
        catch (NoSuchElementException e){
            return "error-input";
        }
    }


    @GetMapping("/hotel/view-all")
    public String viewAll(Model model ){
        List<HotelModel> listSemuaHotel = hotelService.getHotelList();
        model.addAttribute("listSemuaHotel", listSemuaHotel);
        return "viewall-hotel";
    }


}
