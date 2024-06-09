# Dokumentasi UserNotFoundException

`UserNotFoundException` adalah pengecualian khusus yang dilemparkan ketika pengguna (user) tidak ditemukan.

## Konstruktor

### 1. UserNotFoundException(UUID id)
- **Deskripsi:** Membuat objek UserNotFoundException dengan pesan kesalahan yang sesuai.
- **Parameter:**
    - `id` (UUID): ID UUID dari pengguna yang tidak ditemukan.
- **Pesan Kesalahan:** "User not found: [id]"