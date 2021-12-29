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

    public enum JenisWisata {
        WISATA_ALAMI,
        WISATA_BUATAN
    }

    public static String wisataAlamMapper(JenisWisata jenisWisata) {
        String result = "";
        switch (jenisWisata) {
            case WISATA_ALAMI:
                result = "Wisata Alami";
                break;
            case WISATA_BUATAN:
                result = "Wisata Buatan";
                break;
            default:

        }
        return result;

    }

}
