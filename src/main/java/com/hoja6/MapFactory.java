package com.hoja6;

import java.util.*;

public class MapFactory {

    public static Map<String, String> crearMapa(int opcion) {
        if (opcion == 1) {
            return new HashMap<>();
        } else if (opcion == 2) {
            return new TreeMap<>();
        } else {
            return new LinkedHashMap<>();
        }
    }
}