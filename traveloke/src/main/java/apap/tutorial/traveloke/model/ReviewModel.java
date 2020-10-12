package apap.tutorial.traveloke.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="review")
public class ReviewModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=10)
    @Column(name="nama_reviewer", nullable = false)
    private String nama_reviewer;

    @NotNull
    @Size(max=50)
    @Column(name="isi_review", nullable = false)
    private String isi_review;

    @Size(max=50)
    @Column(name="saran", nullable = false)
    private String saran;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "no_kamar", referencedColumnName = "noKamar", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private KamarModel kamar;

    public Long getId() {
        return id;
    }

    public String getNama_reviewer() {
        return nama_reviewer;
    }

    public String getIsi_review() {
        return isi_review;
    }

    public String getSaran() {
        return saran;
    }

    public KamarModel getKamar() {
        return kamar;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNama_reviewer(String nama_reviewer) {
        this.nama_reviewer = nama_reviewer;
    }

    public void setIsi_review(String isi_review) {
        this.isi_review = isi_review;
    }

    public void setSaran(String saran) {
        this.saran = saran;
    }

    public void setKamar(KamarModel kamar) {
        this.kamar = kamar;
    }
}
//public class HotelModel {
//    private String idHotel;
//    private String namaHotel;
//    private String alamat;
//    private String noTelepon;
//
//    public HotelModel(String idHotel, String namaHotel, String alamat, String noTelepon) {
//        this.idHotel = idHotel;
//        this.namaHotel = namaHotel;
//        this.alamat = alamat;
//        this.noTelepon = noTelepon;
//    }
//
//    public String getIdHotel() {
//        return idHotel;
//    }
//
//    public String getNamaHotel() {
//        return namaHotel;
//    }
//
//    public String getAlamat() {
//        return alamat;
//    }
//
//    public String getNoTelepon() {
//        return noTelepon;
//    }
//
//    public void setIdHotel(String idHotel) {
//        this.idHotel = idHotel;
//    }
//
//    public void setNamaHotel(String namaHotel) {
//        this.namaHotel = namaHotel;
//    }
//
//    public void setAlamat(String alamat) {
//        this.alamat = alamat;
//    }
//
//    public void setNoTelepon(String noTelepon) {
//        this.noTelepon = noTelepon;
//    }
//}

