### Langkah-langkah Menggunakan Postman untuk Endpoint GET `/users`

#### 1. **Buka Postman**:
Buka aplikasi Postman di komputer Anda.

#### 2. **Pilih Metode HTTP**:
Pilih metode HTTP sebagai `GET`.

#### 3. **Masukkan URL**:
Masukkan URL `http://127.0.0.1:8000/users`.

#### 4. **Kirim Permintaan**:
Klik tombol "Send" untuk mengirim permintaan.

### Hasil Respons:

#### Jika Data Pengguna Tersedia:
```json
[
    {
        "id": "8b64da6c-1001-4192-af5d-970c32598e3f",
        "user_code": "USR-1",
        "username": "edit_username_1",
        "email": "edit_password_1@gmail.com",
        "password": "$2a$10$43V8mkYtdc1zfBBRqAWKcetAlrpx9ywvvB.77WLtWshUUjfRqt2T."
    },
    {
        "id": "40f80d5f-ae01-4d31-8746-1efae1abdd8d",
        "user_code": "USR-2",
        "username": "edit_username_2",
        "email": "edit_password_2@gmail.com",
        "password": "$2a$10$ncFRtPFCrUx7HLJ83Hvz9uIImggdpnA8t0XlIWxAcqzw9dCYnFlEW"
    },
    {
        "id": "af912da2-bd91-41d3-b41a-362facf838e0",
        "user_code": "USR-3",
        "username": "edit_username_3",
        "email": "edit_password_3@gmail.com",
        "password": "$2a$10$fGYnRE8nYs6j8PhXR9KgWeurauQB62WrNDwzPy9CA7v2EYNrkzY4m"
    }
]
```

#### Jika Belum Ada Data Pengguna:
```json
[]
```