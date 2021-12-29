
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import org.junit.*;

import pariwisata_desktop_app.pojo.Kabupaten;
import pariwisata_desktop_app.pojo.Provinsi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author danar
 */
public class DataIndonesiaTest {

    private final File file = new File(System.getProperty("user.dir"));

    private final String exactName = "KAB. ACEH SELATAN";

    @Test
    public void testCurrentDirectory() {
        Assert.assertEquals("C:\\Users\\danar\\Documents\\NetBeansProjects\\pariwisata_desktop_app", file.getAbsolutePath());
    }

    @Test
    public void testKabupatenDirectory() {
        String kabupatenDirectory = file.getAbsolutePath() + "\\src\\main\\java\\pariwisata_desktop_app\\kabupaten";
        Assert.assertEquals("C:\\Users\\danar\\Documents\\NetBeansProjects\\pariwisata_desktop_app\\src\\main\\java\\pariwisata_desktop_app\\kabupaten", kabupatenDirectory);
    }

    @Test
    public void testKabupatenJson() throws FileNotFoundException, IOException {
        String kabupatenDirectory = file.getAbsolutePath() + "\\src\\main\\java\\pariwisata_desktop_app\\kabupaten";
        String singleKabupatenFile = kabupatenDirectory + "\\11.json";
        File singleFile = new File(singleKabupatenFile);

        // Test if file is exist        
        Assert.assertTrue(singleFile.exists());

        // Parse File content to JSON Array
        InputStream inputStream = new FileInputStream(singleFile);
        byte[] arrBytes = inputStream.readAllBytes();
        String jsonResult = new String(arrBytes);

//        System.out.println(jsonResult);
        Gson gson = new Gson();
        Type kabupatenType = new TypeToken<ArrayList<Kabupaten>>() {
        }.getType();
        List<Kabupaten> kabupaten = gson.fromJson(jsonResult, kabupatenType);

        Assert.assertNotNull(kabupaten);

        // GET SINGLE KABUPATEN NAME
        Assert.assertEquals(exactName, kabupaten.get(0).getNama());

    }
}
