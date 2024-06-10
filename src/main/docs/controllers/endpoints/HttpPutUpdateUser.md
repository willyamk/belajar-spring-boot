### Langkah-langkah Menggunakan Postman untuk Endpoint PUT `/user/{id}`

#### 1. **Buka Postman**:
Buka aplikasi Postman di komputer Anda.

#### 2. **Pilih Metode HTTP**:
Pilih metode HTTP sebagai `PUT`.

#### 3. **Masukkan URL**:
Masukkan URL `http://127.0.0.1:8000/user/{id}`, gantilah `{id}` dengan ID pengguna yang ingin Anda perbarui.

#### 4. **Atur Body Permintaan**:
Pilih tab "Body", kemudian pilih "raw" dan jenis konten "JSON". Masukkan data pengguna yang ingin Anda perbarui, seperti contoh berikut:
```json
{
    "username": "update_username_put_http",
    "email": "update_username_put_http@gmail.com",
    "password": "123_Update_pa$sw@rd_456"
}
```

#### 5. **Kirim Permintaan**:
Klik tombol "Send" untuk mengirim permintaan.

### Hasil Respons:

#### Jika Data Pengguna Ditemukan dan Diperbarui:
```json
{
    "id": "8b64da6c-1001-4192-af5d-970c32598e3f",
    "user_code": "USR-1",
    "username": "update_username_put_http",
    "email": "update_username_put_http@gmail.com",
    "password": "$2a$10$U5nrS1JJ/UrBN8uRvIgW2OTyErSZmgljTUBH7xyAbu14kSHScZJQC"
}
```

#### Jika ID Tidak Ditemukan:
```json
{
    "error message": "User not found: 00123abc-0000-5642-af5d-0970c32598e3"
}
```