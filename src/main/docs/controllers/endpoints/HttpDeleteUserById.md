### Langkah-langkah Menggunakan Postman untuk Endpoint DELETE `/user/{id}`

#### 1. **Buka Postman**:
Buka aplikasi Postman di komputer Anda.

#### 2. **Pilih Metode HTTP**:
Pilih metode HTTP sebagai `DELETE`.

#### 3. **Masukkan URL**:
Masukkan URL `http://127.0.0.1:8000/user/{id}`, gantilah `{id}` dengan ID pengguna yang ingin Anda hapus.

#### 4. **Kirim Permintaan**:
Klik tombol "Send" untuk mengirim permintaan.

### Hasil Respons:

#### Jika Data Pengguna Ditemukan dan Dihapus:
```
User with id : 8b64da6c-1001-4192-af5d-970c32598e3f has been deleted successfully!
```

#### Jika ID Tidak Ditemukan:
```json
{
    "error message": "User not found: 00123abc-0000-5642-af5d-0970c32598e3"
}
```