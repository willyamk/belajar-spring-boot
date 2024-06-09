package com.srpingboot.belajar_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * BelajarSpringApplication adalah kelas utama untuk menjalankan aplikasi Spring Boot.
 * Ini menggunakan anotasi @SpringBootApplication untuk mengonfigurasi aplikasi Spring secara otomatis.
 */
@SpringBootApplication
public class BelajarSpringApplication {

	/**
	 * Metode main untuk menjalankan aplikasi Spring Boot.
	 * @param args Argumen baris perintah yang mungkin diberikan saat menjalankan aplikasi.
	 */
	public static void main(String[] args) {
		// Menjalankan aplikasi Spring dan mendapatkan konteks aplikasi
		ConfigurableApplicationContext context = SpringApplication.run(BelajarSpringApplication.class, args);

		// Mendapatkan DataSource dari konteks aplikasi
		DataSource dataSource = context.getBean(DataSource.class);

		// Mengecek koneksi database
		try (Connection connection = dataSource.getConnection()) {
			// Jika koneksi berhasil, tampilkan pesan sukses
			System.out.println("Database connected successfully!");
		} catch (SQLException e) {
			// Jika terjadi kesalahan, tampilkan pesan error
			System.err.println("Failed to connect to the database: " + e.getMessage());
		}
	}

}
