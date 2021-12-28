/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pariwisata_desktop_app.utils;

/**
 *
 * @author danar
 */
public class WisataAlam {

    enum JenisWisata {
        WISATA_ALAMI,
        WISATA_BUATAN
    }

    public static JenisWisata wisataAlamMapper(String jenisWisataString) {
        switch (jenisWisataString) {
            case "Wisata Alami":
                return JenisWisata.WISATA_ALAMI;
            case "Wisata Buatan":
                return JenisWisata.WISATA_BUATAN;
            default:
                return null;
        }        
    }
}
