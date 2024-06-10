# Dokumentasi Kelas User

`User` adalah entitas yang merepresentasikan pengguna dalam aplikasi. Ini digunakan untuk menyimpan informasi pengguna seperti nama pengguna, email, dan kata sandi.

## Atribut

### 1. id
- **Deskripsi:** ID unik untuk setiap pengguna.
- **Tipe Data:** UUID
- **Anotasi:** @Id, @GeneratedValue

### 2. user_code
- **Deskripsi:** Kode pengguna dari pengguna.
- **Tipe Data:** String

### 3. username
- **Deskripsi:** Nama pengguna dari pengguna.
- **Tipe Data:** String

### 4. email
- **Deskripsi:** Alamat email dari pengguna.
- **Tipe Data:** String

### 5. password
- **Deskripsi:** Kata sandi dari pengguna.
- **Tipe Data:** String

## Metode

### 1. Constructor User(UUID id, String user_code, String username, String email, String password)
- **Deskripsi:** Constructor untuk membuat objek User dengan parameter tertentu.
- **Parameter:**
   - `id` (UUID): ID pengguna.
   - `user_code` (String): Kode pengguna.
   - `username` (String): Nama pengguna.
   - `email` (String): Alamat email.
   - `password` (String): Kata sandi.
- **Anotasi:** @Entity

### 2. getId()
- **Deskripsi:** Mengembalikan ID dari pengguna.
- **Return Type:** UUID

### 3. setId(UUID id)
- **Deskripsi:** Mengatur ID untuk pengguna.
- **Parameter:** `id` (UUID): ID yang akan diatur.

### 4. getUsername()
- **Deskripsi:** Mengembalikan nama pengguna dari pengguna.
- **Return Type:** String

### 5. setUsername(String username)
- **Deskripsi:** Mengatur nama pengguna untuk pengguna.
- **Parameter:** `username` (String): Nama pengguna yang akan diatur.

### 6. getUser_code()
- **Deskripsi:** Mengembalikan kode pengguna dari pengguna.
- **Return Type:** String

### 7. setUser_code(String user_code)
- **Deskripsi:** Mengatur kode pengguna untuk pengguna.
- **Parameter:** `user_code` (String): Kode pengguna yang akan diatur.

### 8. getEmail()
- **Deskripsi:** Mengembalikan alamat email dari pengguna.
- **Return Type:** String

### 9. setEmail(String email)
- **Deskripsi:** Mengatur alamat email untuk pengguna.
- **Parameter:** `email` (String): Alamat email yang akan diatur.

### 10. getPassword()
- **Deskripsi:** Mengembalikan kata sandi dari pengguna.
- **Return Type:** String

### 11. setPassword(String password)
- **Deskripsi:** Mengatur kata sandi untuk pengguna. Metode ini akan mengenkripsi kata sandi menggunakan BCryptPasswordEncoder.
- **Parameter:** `password` (String): Kata sandi yang akan diatur.