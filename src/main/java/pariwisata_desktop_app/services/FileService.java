/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pariwisata_desktop_app.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pariwisata_desktop_app.StoreData;
import pariwisata_desktop_app.pojo.Kabupaten;
import pariwisata_desktop_app.pojo.StoreResult;

/**
 *
 * @author danar
 */
public class FileService {

    private static final List<StoreResult> listStoreResult = new ArrayList<>();
    private static final Gson gson = new Gson();

    private FileService() {
    }

    public static void savedDataToFileJSON(String savedFileLocationPath) {

        String jsonBody = gson.toJson(listStoreResult);
        System.out.println("JSON RESULT : " + jsonBody);
        try {
            FileWriter fileWriter = new FileWriter(savedFileLocationPath, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
//            BufferedWriter bufferedWriter = new BufferedWriter(printWriter);

            printWriter.append(jsonBody);

            // Don't forget to flush to saving data
            printWriter.flush();

            JOptionPane.showMessageDialog(null, "SUKSES SIMPAN KE " + savedFileLocationPath);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "GAGAL SIMPAN DATA. HARAP PERIKSA FILE ANDA", "PERINGATAN", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void saveDataToList(StoreResult result) {
        listStoreResult.add(result);
    }

    public static int totalSavedData() {
        return listStoreResult.size();
    }
}
