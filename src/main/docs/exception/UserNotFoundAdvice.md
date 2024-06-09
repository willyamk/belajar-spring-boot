# Dokumentasi UserNotFoundAdvice

`UserNotFoundAdvice` adalah kelas penanganan pengecualian khusus untuk kasus ketika pengguna (user) tidak ditemukan. Ini akan menangani pengecualian `UserNotFoundException` dan memberikan respons HTTP NOT_FOUND.

## Metode

### 1. exceptionHandler(UserNotFoundException exception)
- **Deskripsi:** Metode ini menangani pengecualian `UserNotFoundException` dan mengembalikan pesan kesalahan dalam format yang ditentukan.
- **Parameter:**
    - `exception` (UserNotFoundException): Pengecualian `UserNotFoundException` yang terjadi.
- **Return Type:** Map<String, String>: Map yang berisi pesan kesalahan.
- **HTTP Response Status:** NOT_FOUND (404)