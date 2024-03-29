package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.repository.HotelDb;
import apap.tutorial.traveloke.rest.HotelDetail;
import apap.tutorial.traveloke.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class HotelRestServiceImpl implements HotelRestService{
    private final WebClient webClient;

    private final WebClient hotelClient;
    
    @Autowired
    private HotelDb hotelDb;

    public HotelRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.hotelUrl).build();
        this.hotelClient = webClientBuilder
                .defaultHeader("x-rapidapi-key","0762bf3d9cmsh61323b4f3c31daep1f7152jsn1600dd890934")
                .defaultHeader("x-rapidapi-host","hotels-com-free.p.rapidapi.com")
                .defaultHeader("useQueryString","true")
                .baseUrl(Setting.hotelAPIUrl).build();
    }

    @Override
    public HotelModel createHotel(HotelModel hotel){
        return hotelDb.save(hotel);
    }

    @Override
    public List<HotelModel> retrieveListHotel(){
        return hotelDb.findAll();
    }

    @Override
    public HotelModel getHotelByIdHotel(Long idHotel){
        Optional<HotelModel> hotel = hotelDb.findById(idHotel);
        if(hotel.isPresent()){
            return hotel.get();
        }else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public HotelModel changeHotel(Long idHotel, HotelModel hotelUpdate){
        HotelModel hotel = getHotelByIdHotel(idHotel);
        hotel.setNamaHotel(hotelUpdate.getNamaHotel());
        hotel.setAlamat(hotelUpdate.getAlamat());
        hotel.setNomorTelepon(hotelUpdate.getNomorTelepon());
        return hotelDb.save(hotel);
    }

    @Override
    public void deleteHotel(Long idHotel){
        HotelModel hotel = getHotelByIdHotel(idHotel);
        if(hotel.getListKamar().size() == 0){
            hotelDb.delete(hotel);
        }else{
            throw new UnsupportedOperationException();
        }
    }
    
    @Override
    public Mono<String> getStatus(Long idHotel){
        return this.webClient.get().uri("/rest/hotel/"+idHotel+"/status/").retrieve().bodyToMono(String.class);
    }

    @Override
    public Mono<String> findHotelByKota(String namaKota){
        return this.hotelClient.get().uri(uriBuilder -> uriBuilder.queryParam("query",namaKota).queryParam("locale","en_US").build()).retrieve().bodyToMono(String.class);
    }
    
    @Override
    public Mono<HotelDetail> postStatus(){
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("alamat","Jl. X");
        data.add("nomorTelepon", "08111112");
        return this.webClient.post().uri("/rest/hotel/full")
                .syncBody(data)
                .retrieve()
                .bodyToMono(HotelDetail.class);
    }
}

