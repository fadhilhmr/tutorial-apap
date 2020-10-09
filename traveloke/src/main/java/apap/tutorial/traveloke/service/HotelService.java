package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;

import java.util.List;

public interface HotelService {

    void addHotel(HotelModel hotel);

    List<HotelModel> getHotelList();

    HotelModel getHotelByIdHotel(Long idHotel);

    HotelModel updateHotel(HotelModel hotel);

    void deleteHotel(HotelModel hotel);


}
