/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pariwisata_desktop_app.pojo;

/**
 *
 * @author danar
 */
public class Provinsi {

    private final String id;
    private final String namaProvinsi;

    public Provinsi(String id, String namaProvinsi) {
        this.id = id;
        this.namaProvinsi = namaProvinsi;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the namaProvinsi
     */
    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    @Override
    public String toString() {
        return "Provinsi{" + "id=" + id + ", namaProvinsi=" + namaProvinsi + '}';
    }
}
