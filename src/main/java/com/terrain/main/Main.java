package com.terrain.main;

import com.terrain.utilitaire.IOJson;

public class Main {
  
    public static void main(String[] args){
        String path = "./json/";
        String input= "terrain.json";
        String output= "resultat.json";
        IOJson.writeJSONToFile(path+input, path+output);
    }
}
