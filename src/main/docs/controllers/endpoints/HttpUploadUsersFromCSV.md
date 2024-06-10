### Langkah-langkah Menggunakan Postman untuk Endpoint POST `/users/csv`

#### 1. **Buka Postman**:
Buka aplikasi Postman di komputer Anda.

#### 2. **Pilih Metode HTTP**:
Pilih metode HTTP sebagai `POST`.

#### 3. **Masukkan URL**:
Masukkan URL `http://127.0.0.1:8000/users/csv`.

#### 4. **Pilih Tab Body**:
Pilih tab "Body" di bawah bidang URL.

#### 5. **Pilih Form-Data**:
Pilih opsi "form-data".

#### 6. **Tambahkan Key dan Pilih File**:
- Tambahkan key dengan nama `file`.
- Pada kolom "Type", pilih `File`.
- Pilih file CSV yang akan diunggah pada kolom "Value".

#### 7. **Kirim Permintaan**:
Klik tombol "Send" untuk mengirim permintaan.

### Contoh Data CSV:

#### Isi File CSV:
```csv
username,email,password
data_1,test_1@gmail.com,123456
data-2,test_2@gmail.com,654321
```

### Hasil Respons:

#### Jika Berhasil:
```json
{
    "Status": "Success",
    "Message": "File uploaded successfully!",
    "FileName": "data.csv",
    "Amount": 2
}
```

#### Jika Gagal Karena Format CSV Salah:
```json
{
    "Status": "Failed",
    "Message": "Invalid CSV file format! Header must be 'username,email,password'.",
    "FileName": "data_salah.csv",
    "Amount": 0
}
```

#### Jika File yang Diinput Lebih dari 1:
```json
{
    "Status": "Failed",
    "Message": "Only one file can be uploaded at a time!",
    "FileNames": {
        "File 1": "data_salah.csv",
        "File 2": "data.csv"
    },
    "Amount": 0
}
```