package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author johnny
 */
public class Partner {

    private String name;
    private String address;
    private ArrayList<String> telefonok;

    public Partner(String name, String address, String... telefonok) {
        this.name = name;
        this.address = address;
        this.telefonok = new ArrayList<>(Arrays.asList(telefonok));
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<String> getTelefonok() {
        return telefonok;
    }

    @Override
    public String toString() {
        return  name + " " + address ;
    }

}
