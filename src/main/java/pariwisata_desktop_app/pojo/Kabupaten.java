/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pariwisata_desktop_app.pojo;

/**
 *
 * @author danar
 */
public class Kabupaten {

    private String id;
    private String namaKabupaten;

    public Kabupaten(String id, String namaKabupaten) {
        this.id = id;
        this.namaKabupaten = namaKabupaten;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the namaKabupaten
     */
    public String getNamaKabupaten() {
        return namaKabupaten;
    }

    @Override
    public String toString() {
        return "Kabupaten{" + "id=" + id + ", namaKabupaten=" + namaKabupaten + '}';
    }

}
