package com.srpingboot.belajar_spring.exception;

import java.util.UUID;

/**
 * UserNotFoundException adalah pengecualian khusus yang dilemparkan ketika pengguna (user) tidak ditemukan.
 */
public class UserNotFoundException extends RuntimeException {

    /**
     * Konstruktor untuk membuat objek UserNotFoundException dengan pesan kesalahan yang sesuai.
     * @param id ID UUID dari pengguna yang tidak ditemukan.
     */
    public UserNotFoundException(UUID id) {
        super("User not found: " + id);
    }
}