/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pariwisata_desktop_app;

import java.util.ArrayList;
import java.util.List;
import pariwisata_desktop_app.pojo.StoreResult;

/**
 *
 * @author danar
 */
public class StoreData {

    private static final List<Object[]> tables = new ArrayList<Object[]>();

    private StoreData() {
    }

    private static final StoreData instance = new StoreData();

    public static StoreData getInstance() {
        return instance;
    }

    /**
     * @return the tables
     */
    public static List<Object[]> getTables() {
        return tables;
    }
}
