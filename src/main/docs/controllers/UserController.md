# Dokumentasi untuk UserController.md

## Overview

Kelas `UserController` mengatur semua endpoint terkait pengguna dalam aplikasi. Ini menyediakan operasi dasar CRUD (Create, Read, Update, Delete) untuk entitas `User`.

## Struktur Kelas

### Package
- **com.srpingboot.belajar_spring.controllers**

### Dependencies
- **UserRepository**: Digunakan untuk mengakses dan memanipulasi data pengguna dalam basis data.

## Endpoint

### 1. Buat Pengguna Baru

- **Metode HTTP:** POST
- **Endpoint:** `/user`
- **Deskripsi:** Membuat pengguna baru.
- **Request Body:** Objek JSON yang mewakili pengguna baru.
- **Response:** Objek pengguna yang baru dibuat.

### 2. Unggah Pengguna Dari JSON

- **Metode HTTP:** POST
- **Endpoint:** `/users/json`
- **Deskripsi:** Mengunggah data pengguna dari file JSON.
- **Request Body:** Daftar objek pengguna dalam format JSON.
- **Response:** ResponseEntity dengan pesan keberhasilan atau kegagalan.

### 3. Unggah Pengguna Dari CSV

- **Metode HTTP:** POST
- **Endpoint:** `/users/csv`
- **Deskripsi:** Mengunggah data pengguna dari file CSV.
- **Request Parameters:**
  - `file`: MultipartFile yang berisi file CSV.
- **Response:** ResponseEntity dengan pesan keberhasilan atau kegagalan.

### 4. Baca Pengguna Dari CSV

- **Metode HTTP:** POST
- **Endpoint:** `/users/csv/read`
- **Deskripsi:** Membaca data pengguna dari file CSV.
- **Request Parameters:**
  - `file`: MultipartFile yang berisi file CSV.
- **Response:** ResponseEntity dengan data pengguna atau pesan kegagalan.

### 5. Edit Pengguna Dari CSV

- **Metode HTTP:** POST
- **Endpoint:** `/users/edit/csv`
- **Deskripsi:** Mengedit data pengguna dari file CSV.
- **Request Parameters:**
  - `file`: MultipartFile yang berisi file CSV.
- **Response:** ResponseEntity dengan pesan keberhasilan atau kegagalan.

### 6. Dapatkan Semua Pengguna

- **Metode HTTP:** GET
- **Endpoint:** `/users`
- **Deskripsi:** Mengambil semua pengguna.
- **Response:** Daftar semua pengguna.

### 7. Dapatkan Pengguna Berdasarkan ID

- **Metode HTTP:** GET
- **Endpoint:** `/user/{id}`
- **Deskripsi:** Mengambil pengguna berdasarkan ID mereka.
- **Path Variable:** `id` (UUID) - ID dari pengguna yang akan diambil.
- **Response:** Objek pengguna dengan ID yang spesifik.

### 8. Perbarui Pengguna

- **Metode HTTP:** PUT
- **Endpoint:** `/user/{id}`
- **Deskripsi:** Memperbarui informasi pengguna yang ada.
- **Path Variable:** `id` (UUID) - ID dari pengguna yang akan diperbarui.
- **Request Body:** Objek JSON yang berisi informasi pengguna yang diperbarui.
- **Response:** Objek pengguna yang telah diperbarui.

### 9. Hapus Pengguna Berdasarkan ID

- **Metode HTTP:** DELETE
- **Endpoint:** `/user/{id}`
- **Deskripsi:** Menghapus pengguna berdasarkan ID mereka.
- **Path Variable:** `id` (UUID) - ID dari pengguna yang akan dihapus.
- **Response:** Pesan sukses setelah penghapusan.

### 10. Hapus Semua Pengguna

- **Metode HTTP:** DELETE
- **Endpoint:** `/users`
- **Deskripsi:** Menghapus semua pengguna.
- **Response:** Pesan sukses setelah penghapusan.

## Metode Utilitas

- **isValidCSVHeader(header, expectedHeader):** Memeriksa apakah header file CSV valid.
- **generateUserCode():** Menghasilkan kode pengguna unik untuk pengguna baru.