### Langkah-langkah Menggunakan Postman untuk Endpoint POST `/user`

1. Buka Postman.
2. Pilih metode HTTP sebagai POST.
3. Masukkan URL `http://127.0.0.1:8000/user`.
4. Pilih tab "Body".
5. Pilih "Raw" dan atur jenis konten sebagai "JSON (application/json)".
6. Masukkan data pengguna contoh berikut ke dalam bidang teks:
```json
{
    "username": "My name is ....",
    "email": "test@gmail.com",
    "password": "123456"
}
```
7. Klik tombol "Send" untuk mengirim permintaan.

### Hasil Respons:

Anda akan menerima respons dengan format JSON sebagai berikut:
```json
{
    "id": "8b64da6c-1001-4192-af5d-970c32598e3f",
    "user_code": "USR-1",
    "username": "My name is ....",
    "email": "test@gmail.com",
    "password": "$2a$10$v.nCoytxYJU4pgJoEm8yuuQxAUk.iFj74Jr68YC43icNvjL/i1zeK"
}
```

Pada respons tersebut, `id` adalah ID unik yang dibuat untuk pengguna baru, `user_code` adalah kode pengguna yang dihasilkan, dan `password` adalah kata sandi yang telah dienkripsi menggunakan BCryptPasswordEncoder.