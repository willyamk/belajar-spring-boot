### Langkah-langkah Menggunakan Postman untuk Endpoint POST `/users/json`

1. **Buka Postman**:
   Buka aplikasi Postman di komputer Anda.

2. **Pilih Metode HTTP**:
   Pilih metode HTTP sebagai `POST`.

3. **Masukkan URL**:
   Masukkan URL `http://127.0.0.1:8000/users/json`.

4. **Pilih Tab Body**:
   Pilih tab "Body" di bawah bidang URL.

5. **Pilih Raw dan JSON**:
   Pilih opsi "Raw" dan atur tipe konten sebagai "JSON (application/json)".

6. **Masukkan Data JSON**:
   Masukkan data JSON berikut ke dalam bidang teks:
   ```json
   [
       {
           "username": "first_data",
           "email": "first_data@gmail.com",
           "password": "123456"
       },
       {
           "username": "second_data",
           "email": "second_data@gmail.com",
           "password": "654321"
       }
   ]
   ```

7. **Kirim Permintaan**:
   Klik tombol "Send" untuk mengirim permintaan.

### Hasil Respons:

Anda akan menerima respons dengan pesan sebagai berikut:
```json
2 users data uploaded successfully!
```