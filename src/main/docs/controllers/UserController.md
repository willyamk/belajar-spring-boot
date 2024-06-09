# Dokumentasi Endpoint untuk Pengguna (User)

## UserController

Kelas `UserController` mengatur semua endpoint terkait pengguna dalam aplikasi ini. Ini menyediakan operasi dasar seperti membuat, membaca, memperbarui, dan menghapus (CRUD) untuk entitas User.

### Dependencies
- `UserRepository`: Digunakan untuk mengakses dan memanipulasi data pengguna dalam basis data.

### Endpoints

#### 1. Membuat Pengguna Baru

- **Method:** POST
- **Endpoint:** `/user`
- **Request Body:** Objek JSON yang mewakili pengguna baru.
- **Response:** Objek JSON yang mewakili pengguna yang baru dibuat.

#### 2. Mendapatkan Semua Pengguna

- **Method:** GET
- **Endpoint:** `/users`
- **Response:** Daftar semua pengguna dalam bentuk JSON Array.

#### 3. Mendapatkan Pengguna Berdasarkan ID

- **Method:** GET
- **Endpoint:** `/user/{id}`
- **Path Variable:** `id` - UUID dari pengguna yang akan dicari.
- **Response:** Objek JSON yang mewakili pengguna yang sesuai dengan ID yang diberikan.

#### 4. Memperbarui Informasi Pengguna yang Ada

- **Method:** PUT
- **Endpoint:** `/user/{id}`
- **Path Variable:** `id` - UUID dari pengguna yang akan diperbarui.
- **Request Body:** Objek JSON yang berisi informasi baru pengguna.
- **Response:** Objek JSON yang mewakili pengguna yang telah diperbarui.

#### 5. Menghapus Pengguna Berdasarkan ID

- **Method:** DELETE
- **Endpoint:** `/user/{id}`
- **Path Variable:** `id` - UUID dari pengguna yang akan dihapus.
- **Response:** Pesan sukses setelah pengguna berhasil dihapus.

#### 6. Menghapus Semua Pengguna

- **Method:** DELETE
- **Endpoint:** `/users`
- **Response:** Pesan sukses setelah semua pengguna berhasil dihapus.

### Exception Handling

- Jika pengguna dengan ID yang diberikan tidak ditemukan, akan dilemparkan `UserNotFoundException`.