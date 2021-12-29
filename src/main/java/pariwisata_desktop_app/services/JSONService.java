/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pariwisata_desktop_app.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONTokener;
import pariwisata_desktop_app.pojo.Kabupaten;
import pariwisata_desktop_app.pojo.Provinsi;

/**
 *
 * @author danar
 */
public class JSONService {

    private static final File file = new File(System.getProperty("user.dir"));
    private static final List<Kabupaten> listKabupaten = new ArrayList<Kabupaten>();
    private static final List<Provinsi> listProvinsi = new ArrayList<Provinsi>();

    private static final JSONService instance = new JSONService();

    private JSONService() {
    }

    public static JSONService getInstance() {
        return instance;
    }

    public static void getAllProvinsi() {
        File provinsiFile = new File(file.getAbsolutePath() + "\\src\\main\\java\\pariwisata_desktop_app\\provinsi\\Provinsi.json");

        InputStream inputStream;
        byte[] arrBytes = null;
        try {
            inputStream = new FileInputStream(provinsiFile);
            arrBytes = inputStream.readAllBytes();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSONService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSONService.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (arrBytes != null) {
            String jsonResult = new String(arrBytes);
            System.out.println(jsonResult);
            JSONTokener jsonToken = new JSONTokener(jsonResult);
            JSONArray jsonArray = new JSONArray(jsonToken);

            jsonArray.toList().stream().map(data -> (HashMap<String, Object>) data).forEachOrdered(result -> {
                getListProvinsi().add(new Provinsi((String) result.get("id"), (String) result.get("nama")));
            });

        }

    }

    public static void getAllKabupaten(String name) {
        File provinsiFile = new File(file.getAbsolutePath() + "\\src\\main\\java\\pariwisata_desktop_app\\kabupaten\\" + name + ".json");

        InputStream inputStream;
        byte[] arrBytes = null;
        try {
            inputStream = new FileInputStream(provinsiFile);
            arrBytes = inputStream.readAllBytes();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSONService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JSONService.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (arrBytes != null) {
            String jsonResult = new String(arrBytes);
            System.out.println(jsonResult);
            JSONTokener jsonToken = new JSONTokener(jsonResult);
            JSONArray jsonArray = new JSONArray(jsonToken);

            // If List Kabupaten is existed
            if (!getListKabupaten().isEmpty()) {
                getListKabupaten().clear();
                System.out.println("CLEARED");
            }

            jsonArray.toList().stream().map(data -> (HashMap<String, Object>) data).forEachOrdered(result -> {
                getListKabupaten().add(new Kabupaten((String) result.get("id"), (String) result.get("nama")));
            });
        }
    }

    /**
     * @return the listKabupaten
     */
    public static List<Kabupaten> getListKabupaten() {
        return listKabupaten;
    }

    /**
     * @return the listProvinsi
     */
    public static List<Provinsi> getListProvinsi() {
        return listProvinsi;
    }
}
