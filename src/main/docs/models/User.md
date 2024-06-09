# Dokumentasi Entitas Pengguna (User)

Kelas `User` merepresentasikan pengguna dalam aplikasi ini. Ini digunakan untuk menyimpan informasi pengguna seperti nama pengguna, email, dan kata sandi.

## Attributes

1. **id** (UUID)
    - Deskripsi: ID unik untuk setiap pengguna.
2. **username** (String)
    - Deskripsi: Nama pengguna dari pengguna.
3. **email** (String)
    - Deskripsi: Alamat email dari pengguna.
4. **password** (String)
    - Deskripsi: Kata sandi dari pengguna. Kata sandi akan disimpan dalam bentuk terenkripsi menggunakan BCryptPasswordEncoder.

## Methods

### 1. getId()
- **Deskripsi:** Mengembalikan ID dari pengguna.
- **Return Type:** UUID

### 2. setId(UUID id)
- **Deskripsi:** Mengatur ID untuk pengguna.
- **Parameter:** id (UUID) - ID yang akan diatur.

### 3. getUsername()
- **Deskripsi:** Mengembalikan nama pengguna dari pengguna.
- **Return Type:** String

### 4. setUsername(String username)
- **Deskripsi:** Mengatur nama pengguna untuk pengguna.
- **Parameter:** username (String) - Nama pengguna yang akan diatur.

### 5. getEmail()
- **Deskripsi:** Mengembalikan alamat email dari pengguna.
- **Return Type:** String

### 6. setEmail(String email)
- **Deskripsi:** Mengatur alamat email untuk pengguna.
- **Parameter:** email (String) - Alamat email yang akan diatur.

### 7. getPassword()
- **Deskripsi:** Mengembalikan kata sandi dari pengguna.
- **Return Type:** String

### 8. setPassword(String password)
- **Deskripsi:** Mengatur kata sandi untuk pengguna. Metode ini akan mengenkripsi kata sandi menggunakan BCryptPasswordEncoder.
- **Parameter:** password (String) - Kata sandi yang akan diatur.