package com.srpingboot.belajar_spring.repositories;

import com.srpingboot.belajar_spring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

/**
 * UserRepository.md adalah antarmuka yang digunakan untuk berinteraksi dengan entitas User dalam basis data.
 * Ini menggabungkan metode dasar CRUD (Create, Read, Update, Delete) yang disediakan oleh JpaRepository.
 */
public interface UserRepository extends JpaRepository<User, UUID> {
    /**
     * Mengembalikan daftar semua pengguna yang diurutkan berdasarkan kode pengguna secara ascending.
     * @return List<User> daftar pengguna yang diurutkan.
     */
    @Query(value = "SELECT * FROM User ORDER BY CAST(SUBSTRING(user_code, 5) AS UNSIGNED) ASC", nativeQuery = true)
    List<User> findAllOrderedByUserCodeAsc();

    /**
     * Mencari pengguna berdasarkan kode pengguna.
     * @param userCode Kode pengguna yang akan dicari.
     * @return User pengguna yang ditemukan.
     */
    @Query(value = "SELECT * FROM User WHERE user_code = ?1", nativeQuery = true)
    User findByUser_code(String userCode);
}
