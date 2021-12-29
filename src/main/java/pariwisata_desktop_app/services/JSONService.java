/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pariwisata_desktop_app.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pariwisata_desktop_app.pojo.Kabupaten;
import pariwisata_desktop_app.pojo.Provinsi;

/**
 *
 * @author danar
 */
public class JSONService {

    private static final Gson gson = new Gson();
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
            // Infer type of List<Provinsi>
            Type provinsiType = new TypeToken<ArrayList<Provinsi>>() {
            }.getType();
            List<Provinsi> listJsonProvinsi = gson.fromJson(jsonResult, provinsiType);

            listJsonProvinsi.stream().forEachOrdered(result -> {
                getListProvinsi().add(new Provinsi(result.getId(), result.getNama()));
            });
        }

    }

    public static void getAllKabupaten(String fileIdName) {
        File provinsiFile = new File(file.getAbsolutePath() + "\\src\\main\\java\\pariwisata_desktop_app\\kabupaten\\" + fileIdName + ".json");

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

            // Infer type of List<Kabupaten>
            Type kabupatenType = new TypeToken<ArrayList<Kabupaten>>() {
            }.getType();
            List<Kabupaten> listJsonKabupaten = gson.fromJson(jsonResult, kabupatenType);

            // If List Kabupaten is existed
            if (!getListKabupaten().isEmpty()) {
                getListKabupaten().clear();
                
            }

            listJsonKabupaten.stream().forEachOrdered((Kabupaten result) -> {
                getListKabupaten().add(new Kabupaten(result.getId(), result.getNama()));
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
