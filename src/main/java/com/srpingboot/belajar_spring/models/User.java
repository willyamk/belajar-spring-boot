package com.srpingboot.belajar_spring.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

/**
 * User adalah entitas yang merepresentasikan pengguna dalam aplikasi.
 * Ini digunakan untuk menyimpan informasi pengguna seperti nama pengguna, email, dan kata sandi.
 */
@Entity
public class User {
    /**
     * ID unik untuk setiap pengguna.
     */
    @Id
    @GeneratedValue
    private UUID id;

    /**
     * Nama pengguna dari pengguna.
     */
    private String username;

    /**
     * Alamat email dari pengguna.
     */
    private String email;

    /**
     * Kata sandi dari pengguna.
     */
    private String password;

    /**
     * Mengembalikan ID dari pengguna.
     * @return ID pengguna.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Mengatur ID untuk pengguna.
     * @param id ID yang akan diatur.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Mengembalikan nama pengguna dari pengguna.
     * @return Nama pengguna.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Mengatur nama pengguna untuk pengguna.
     * @param username Nama pengguna yang akan diatur.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Mengembalikan alamat email dari pengguna.
     * @return Alamat email pengguna.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Mengatur alamat email untuk pengguna.
     * @param email Alamat email yang akan diatur.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Mengembalikan kata sandi dari pengguna.
     * @return Kata sandi pengguna.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Mengatur kata sandi untuk pengguna. Metode ini akan mengenkripsi kata sandi menggunakan BCryptPasswordEncoder.
     * @param password Kata sandi yang akan diatur.
     */
    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }
}