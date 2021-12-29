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
    private final String nama;

    public Provinsi(String id, String nama) {
        this.id = id;
        this.nama = nama;
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
    public String getNama() {
        return nama;
    }

    @Override
    public String toString() {
        return "Provinsi{" + "id=" + id + ", namaProvinsi=" + nama + '}';
    }
}
