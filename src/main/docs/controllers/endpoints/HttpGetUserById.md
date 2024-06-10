### Langkah-langkah Menggunakan Postman untuk Endpoint GET `/user/{id}`

#### 1. **Buka Postman**:
Buka aplikasi Postman di komputer Anda.

#### 2. **Pilih Metode HTTP**:
Pilih metode HTTP sebagai `GET`.

#### 3. **Masukkan URL**:
Masukkan URL `http://127.0.0.1:8000/user/{id}`, gantilah `{id}` dengan ID pengguna yang ingin Anda cari.

#### 4. **Kirim Permintaan**:
Klik tombol "Send" untuk mengirim permintaan.

### Hasil Respons:

#### Jika Data Pengguna Ditemukan:
```json
{
    "id": "8b64da6c-1001-4192-af5d-970c32598e3f",
    "user_code": "USR-1",
    "username": "edit_username_1",
    "email": "edit_password_1@gmail.com",
    "password": "$2a$10$43V8mkYtdc1zfBBRqAWKcetAlrpx9ywvvB.77WLtWshUUjfRqt2T."
}
```

#### Jika ID Tidak Ditemukan:
```json
{
    "error message": "User not found: 00123abc-0000-5642-af5d-0970c32598e3"
}
```