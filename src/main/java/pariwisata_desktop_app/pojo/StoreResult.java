/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pariwisata_desktop_app.pojo;

/**
 *
 * @author danar
 */
public class StoreResult {

    private final String nama;
    private final String deskripsi;
    private final String jenisWisata;
    private final int hargaTiket;
    private final String urlGambar;
    private final String lokasi;

    public StoreResult(String nama, String deskripsi, String jenisWisata, int hargaTiket, String urlGambar, String lokasi) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.jenisWisata = jenisWisata;
        this.hargaTiket = hargaTiket;
        this.urlGambar = urlGambar;
        this.lokasi = lokasi;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @return the deskripsi
     */
    public String getDeskripsi() {
        return deskripsi;
    }

    /**
     * @return the jenisWisata
     */
    public String getJenisWisata() {
        return jenisWisata;
    }

    /**
     * @return the hargaTiket
     */
    public int getHargaTiket() {
        return hargaTiket;
    }

    /**
     * @return the urlGambar
     */
    public String getUrlGambar() {
        return urlGambar;
    }

    /**
     * @return the lokasi
     */
    public String getLokasi() {
        return lokasi;
    }

    @Override
    public String toString() {
        return "StoreResult{" + "nama=" + nama + ", deskripsi=" + deskripsi + ", jenisWisata=" + jenisWisata + ", hargaTiket=" + hargaTiket + ", urlGambar=" + urlGambar + ", lokasi=" + lokasi + '}';
    }

}
