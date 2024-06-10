package com.srpingboot.belajar_spring.utils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FileUploadResponse {
    public static Object createResponse(String status, String message, String fileName, int amount) {
        return new Object() {
            public final String Status = status;
            public final String Message = message;
            public final String FileName = fileName;
            public final int Amount = amount;
        };
    }

    public static Object createResponse(String status, String message, List<String> fileNames, int amount) {
        Map<String, String> filesMap = new LinkedHashMap<>();
        for (int i = 0; i < fileNames.size(); i++) {
            filesMap.put("File " + (i + 1), fileNames.get(i));
        }

        return new Object() {
            public final String Status = status;
            public final String Message = message;
            public final Map<String, String> FileNames = filesMap;
            public final int Amount = amount;
        };
    }

}
