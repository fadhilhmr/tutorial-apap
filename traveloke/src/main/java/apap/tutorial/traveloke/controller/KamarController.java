package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class KamarController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/kamar/add/{idHotel}")
    private String addKamarFormPage(
            @PathVariable Long idHotel,
            Model model
    ){
        KamarModel kamar = new KamarModel();
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        kamar.setHotel(hotel);
        model.addAttribute("kamar", kamar);
        return "form-add-kamar";
    }

    @PostMapping("/kamar/add")
    private String addKamarSubmit(
            @ModelAttribute KamarModel kamar,
            Model model
    ){
        kamarService.addKamar(kamar);
        model.addAttribute("kamar", kamar);
        return "add-kamar";
    }

    @GetMapping("/kamar/change/{noKamar}")
    public String changeKamarFormPage(
            @PathVariable Long noKamar,
            Model model
    ){
        model.addAttribute("kamar", kamarService.getKamarByNoKamar(noKamar));
        return "form-update-kamar";
    }

    @PostMapping("/kamar/change")
    public String changeKamarFormSubmit(
            @ModelAttribute KamarModel kamar,
            Model model
    ){
        KamarModel kamarUpdated = kamarService.updateKamar(kamar);
        model.addAttribute("kamar",kamar);
        return "update-kamar";
    }

//    @GetMapping("/kamar/delete/{noKamar}/{idHotel}")
//    public String deleteKamar(
//            @PathVariable(value = "noKamar") Long noKamar,
//            @PathVariable(value = "idHotel") Long idHotel,
//            Model model
//    ){
//        KamarModel delKamar = kamarService.getKamarByNoKamar(noKamar);
//        kamarService.deleteKamar(delKamar);
//        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
//        List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
//        model.addAttribute("hotel",hotel);
//        model.addAttribute("listKamar", listKamar);
//        return "view-hotel";
//    }
        @PostMapping(path = "/kamar/delete")
        public String deleteKamarFormSubmit(
                @ModelAttribute HotelModel hotel,
                Model model
        ){
            model.addAttribute("kamarCount", hotel.getListKamar().size());

            for(KamarModel kamar : hotel.getListKamar()){
                kamarService.deleteKamar(kamar);
            }

            return "delete-kamar";
        }

}
