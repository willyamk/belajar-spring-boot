package com.srpingboot.belajar_spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * UserNotFoundAdvice.md adalah kelas penanganan pengecualian khusus untuk kasus ketika pengguna (user) tidak ditemukan.
 * Ini akan menangani pengecualian UserNotFoundException dan memberikan respons HTTP NOT_FOUND.
 */
@ControllerAdvice
public class UserNotFoundAdvice {

    /**
     * Metode exceptionHandler menangani pengecualian UserNotFoundException dan mengembalikan pesan kesalahan dalam format yang ditentukan.
     * @param exception Pengecualian UserNotFoundException yang terjadi.
     * @return Map yang berisi pesan kesalahan.
     */
    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> exceptionHandler(UserNotFoundException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error message", exception.getMessage());
        return errorMap;
    }
}
