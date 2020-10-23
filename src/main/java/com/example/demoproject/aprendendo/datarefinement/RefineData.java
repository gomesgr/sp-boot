package com.example.demoproject.aprendendo.datarefinement;

import java.util.regex.Pattern;

public class RefineData {
    public static boolean emailCorreto(String email) {
        Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");
        return emailPattern.matcher(email).matches();
    }
}
