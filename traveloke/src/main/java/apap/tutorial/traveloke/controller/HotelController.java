package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.model.HotelModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @RequestMapping("/hotel/add")
    public String addHotel(
            @RequestParam(value="idHotel", required = true) String idHotel,
            @RequestParam(value="namaHotel", required = true) String namaHotel,
            @RequestParam(value="alamat", required = true) String alamat,
            @RequestParam(value="noTelepon", required = true) String noTelepon,
            Model model
    ){
        HotelModel hotel = new HotelModel(idHotel, namaHotel, alamat, noTelepon);

        hotelService.addHotel(hotel);

        model.addAttribute( "idHotel", idHotel);

        return "add-hotel";
    }
    @RequestMapping("/hotel/viewall")
    public String listHotel(Model model){
        List<HotelModel> listHotel = hotelService.getHotelList();

        model.addAttribute("listHotel", listHotel);
        return "viewall-hotel";
    }
    @RequestMapping("/hotel/view")
    public String detailHotel(
            @RequestParam(value = "idHotel") String idHotel,
            Model model){

        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        if(hotel == null){
            return "error-page";
        }
        else{
            model.addAttribute("hotel", hotel);
            return "view-hotel";
        }

    }
    @GetMapping(value = "/hotel/view/id-hotel/{idHotel}")
    public String lihatHotel(
            @PathVariable(value = "idHotel") String idHotel,
            Model model){

        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        if(hotel == null){
            return "error-page";
        }
        else {
            model.addAttribute("hotel", hotel);
            return "view-hotel";
        }

    }
    @GetMapping(value = "/hotel/view/id-hotel/{idHotel}/no-telepon/{noTelepon}")
    public String gantiNoTelpHotel(
            @PathVariable(value = "idHotel") String idHotel,
            @PathVariable(value = "noTelepon") String noTelepon,
            Model model){

        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        if(hotel == null){
            return "error-page";
        }
        else{
            hotel.setNoTelepon(noTelepon);
            model.addAttribute("hotel", hotel);
            return "no-telepon-hotel";
        }

    }
    @GetMapping(value = "/hotel/delete/id-hotel/{idHotel}")
    public String hapusHotel(
            @PathVariable(value = "idHotel") String idHotel,
            Model model){

        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        if(hotel == null){
            return "error-page";
        }
        else{
            hotelService.deleteHotel(hotel);
            model.addAttribute("hotel", hotel);
            return "delete-hotel";
        }

    }
}
