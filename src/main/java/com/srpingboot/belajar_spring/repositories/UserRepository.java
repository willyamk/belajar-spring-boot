package com.srpingboot.belajar_spring.repositories;

import com.srpingboot.belajar_spring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * UserRepository.md adalah antarmuka yang digunakan untuk berinteraksi dengan entitas User dalam basis data.
 * Ini menggabungkan metode dasar CRUD (Create, Read, Update, Delete) yang disediakan oleh JpaRepository.
 */
public interface UserRepository extends JpaRepository<User, UUID> {
}
