package com.srpingboot.belajar_spring.controllers;

import com.srpingboot.belajar_spring.exception.UserNotFoundException;
import com.srpingboot.belajar_spring.models.User;
import com.srpingboot.belajar_spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * UserController adalah kelas yang mengatur semua endpoint terkait pengguna (user) dalam aplikasi.
 * Ini menyediakan operasi dasar seperti membuat, membaca, memperbarui, dan menghapus (CRUD)
 * untuk entitas User.
 */
@RestController
public class UserController {

    /**
     * UserRepository.md digunakan untuk mengakses dan memanipulasi data pengguna dalam basis data.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Endpoint untuk membuat pengguna baru.
     * @param newUser Objek User baru yang akan dibuat.
     * @return Objek User yang baru dibuat.
     */
    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    /**
     * Endpoint untuk mendapatkan semua pengguna yang ada.
     * @return Daftar semua pengguna dalam bentuk List<User>.
     */
    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Endpoint untuk mendapatkan pengguna berdasarkan ID.
     * @param id UUID dari pengguna yang akan dicari.
     * @return Objek User yang sesuai dengan ID yang diberikan.
     * @throws UserNotFoundException Jika pengguna dengan ID yang diberikan tidak ditemukan.
     */
    @GetMapping("/user/{id}")
    User getUser(@PathVariable UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * Endpoint untuk memperbarui informasi pengguna yang ada.
     * @param id UUID dari pengguna yang akan diperbarui.
     * @param newUser Objek User yang berisi informasi baru yang akan diperbarui.
     * @return Objek User yang telah diperbarui.
     * @throws UserNotFoundException Jika pengguna dengan ID yang diberikan tidak ditemukan.
     */
    @PutMapping("/user/{id}")
    User updateUser(@PathVariable UUID id, @RequestBody User newUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * Endpoint untuk menghapus pengguna berdasarkan ID.
     * @param id UUID dari pengguna yang akan dihapus.
     * @return Pesan sukses setelah pengguna berhasil dihapus.
     * @throws UserNotFoundException Jika pengguna dengan ID yang diberikan tidak ditemukan.
     */
    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable UUID id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id : " + id + " has been deleted successfully!";
    }

    /**
     * Endpoint untuk menghapus semua pengguna.
     * @return Pesan sukses setelah semua pengguna berhasil dihapus.
     */
    @DeleteMapping("/users")
    String deleteAllUsers() {
        userRepository.deleteAll();
        return "All users have been deleted successfully!";
    }
}