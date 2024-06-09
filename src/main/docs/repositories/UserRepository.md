# Dokumentasi UserRepository

Antarmuka `UserRepository` digunakan untuk berinteraksi dengan entitas User dalam basis data. Ini menggabungkan metode dasar CRUD (Create, Read, Update, Delete) yang disediakan oleh JpaRepository.

## Metode yang Disediakan

### 1. save(User user)
- **Deskripsi:** Menyimpan atau memperbarui pengguna ke dalam basis data.
- **Parameter:**
    - `user` (User): Objek pengguna yang akan disimpan atau diperbarui.
- **Return Type:** User: Objek pengguna yang telah disimpan atau diperbarui.

### 2. findAll()
- **Deskripsi:** Mengambil daftar semua pengguna yang ada dalam basis data.
- **Return Type:** List<User>: Daftar semua pengguna dalam bentuk List.

### 3. findById(UUID id)
- **Deskripsi:** Mencari pengguna berdasarkan ID.
- **Parameter:**
    - `id` (UUID): ID dari pengguna yang akan dicari.
- **Return Type:** Optional<User>: Objek pengguna yang sesuai dengan ID yang diberikan.

### 4. existsById(UUID id)
- **Deskripsi:** Memeriksa apakah pengguna dengan ID yang diberikan ada dalam basis data.
- **Parameter:**
    - `id` (UUID): ID dari pengguna yang akan diperiksa.
- **Return Type:** boolean: true jika pengguna dengan ID yang diberikan ada, false jika tidak.

### 5. deleteById(UUID id)
- **Deskripsi:** Menghapus pengguna berdasarkan ID.
- **Parameter:**
    - `id` (UUID): ID dari pengguna yang akan dihapus.
- **Return Type:** void

### 6. deleteAll()
- **Deskripsi:** Menghapus semua pengguna dari basis data.
- **Return Type:** void

