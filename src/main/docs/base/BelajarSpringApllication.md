# Dokumentasi BelajarSpringApplication

`BelajarSpringApplication` adalah kelas utama untuk menjalankan aplikasi Spring Boot. Ini menggunakan anotasi `@SpringBootApplication` untuk mengonfigurasi aplikasi Spring secara otomatis.

## Metode

### 1. main(String[] args)
- **Deskripsi:** Metode main untuk menjalankan aplikasi Spring Boot.
- **Parameter:**
    - `args` (String[]): Argumen baris perintah yang mungkin diberikan saat menjalankan aplikasi.
- **Langkah-langkah:**
    1. Menjalankan aplikasi Spring dan mendapatkan konteks aplikasi.
    2. Mendapatkan `DataSource` dari konteks aplikasi.
    3. Mengecek koneksi database.
    4. Jika koneksi berhasil, tampilkan pesan sukses. Jika terjadi kesalahan, tampilkan pesan error.