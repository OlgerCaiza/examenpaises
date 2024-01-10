package com.example.myapppaises;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class lPaises {
    String Name, iso2;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public lPaises(String countryCode, JSONObject countryData) throws JSONException {
        Name = countryData.getString("Name").toString();
        iso2 = "http://www.geognos.com/api/en/countries/flag/" + countryCode +".png";
    }

    public static ArrayList<lPaises> JsonObjectsBuild(JSONObject datos) throws JSONException {
        ArrayList<lPaises> pais = new ArrayList<>();

        Iterator<String> keys = datos.keys();
        while (keys.hasNext()) {
            String countryCode = keys.next();
            JSONObject countryData = datos.getJSONObject(countryCode);
            pais.add(new lPaises(countryCode, countryData));
        }
        return pais;
    }

}
