package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;

public interface KamarService {
    void addKamar(KamarModel kamar);

    List<KamarModel> findAllKamarByIdHotel(Long idHotel);

    KamarModel updateKamar(KamarModel kamar);

    KamarModel getKamarByNoKamar(Long noKamar);

    List<KamarModel> getKamarByNamaKamarDanKapasitas1(String namaKamar, Integer kapasitas);
    List<KamarModel> getKamarByNamaKamarDanKapasitas2(String namaKamar, Integer kapasitas,Long idHotel);

    void deleteKamar(KamarModel kamar);
}
