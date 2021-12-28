
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import org.junit.*;
import org.json.*;
import pariwisata_desktop_app.pojo.Kabupaten;

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
    // JSON TEMPLATE
    // {"id":"1101","nama":"KAB. ACEH SELATAN"}
    // {"id":"1102","nama": "KAB. ACEH TENGGARA"}
    private final Kabupaten[] kabupatenArr = new Kabupaten[]{new Kabupaten("1101", "KAB. ACEH SELATAN"), new Kabupaten("1102", "KAB. ACEH TENGGARA")};
    private final List<Kabupaten> kabupaten = Arrays.asList(kabupatenArr);

    private final List<Kabupaten> listKabupatens = new ArrayList<>();

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
        JSONTokener jsonToken = new JSONTokener(jsonResult);
        JSONArray jsonArray = new JSONArray(jsonToken);
//        System.out.println(jsonArray.getJSONObject(0).get("nama"));

        // Test single Object in JSONArray
        Assert.assertEquals("KAB. ACEH SELATAN", jsonArray.getJSONObject(0).get("nama"));

        // Test JSONArray match ArrayList<Kabupaten>
        jsonArray.toList().stream().map(data -> (HashMap<String, Object>) data).forEachOrdered(new Consumer<HashMap<String, Object>>() {
            @Override
            public void accept(HashMap<String, Object> result) {
                listKabupatens.add(new Kabupaten((String) result.get("id"), (String) result.get("nama")));
            }
        });

    }
}
