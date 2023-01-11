package com.furkancosgun.code.Util;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CodeUtil {
    public static String compile(String command){
        String output = "";
        StringBuilder stringBuilder = new StringBuilder();
        try {

            Process process = Runtime.getRuntime().exec(command);

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(process.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(process.getErrorStream()));

            while ((output = stdInput.readLine()) != null) {
                stringBuilder.append('\n').append(output);
            }

            while ((output = stdError.readLine()) != null) {
                stringBuilder.append('\n').append(output);
            }

            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ERROR";
    }
}
