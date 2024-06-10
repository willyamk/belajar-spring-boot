### Langkah-langkah Menggunakan Postman untuk Endpoint POST `/users/csv/read`

#### 1. **Buka Postman**:
Buka aplikasi Postman di komputer Anda.

#### 2. **Pilih Metode HTTP**:
Pilih metode HTTP sebagai `POST`.

#### 3. **Masukkan URL**:
Masukkan URL `http://127.0.0.1:8000/users/csv/read`.

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
data_2,test_2@gmail.com,123456
data_3,test_3@gmail.com,123456
data_4,test_4@gmail.com,123456
data_5,test_5@gmail.com,123456
```

### Hasil Respons:

#### Jika Berhasil:
```json
[
    {
        "id": "27021738-894e-4bcd-b7ee-99ea286fa0f8",
        "user_code": "USR-1",
        "username": "data_1",
        "email": "test_1@gmail.com",
        "password": "$2a$10$zfBSL0Ef4bk6ePbQ2mT93O9a65hhvHWthtguKkGbuxwn.amsrIEE2"
    },
    {
        "id": "8abbef7b-5e12-4553-a8af-91bc41556d8f",
        "user_code": "USR-2",
        "username": "data_2",
        "email": "test_2@gmail.com",
        "password": "$2a$10$bXMznpb9dXdCMMtxzBNyn.mntp.i6Nv34uRCMh1NAZGulBRQCwbTG"
    },
    {
        "id": "27839b36-5de9-4787-ae12-ba1eff1f6a47",
        "user_code": "USR-3",
        "username": "data_3",
        "email": "test_3@gmail.com",
        "password": "$2a$10$8q8j1Cr6LiT7rV79G2KlQ.OPVXLgADDRRMzlc5Q6JNTGCqHRtgIg."
    },
    {
        "id": "9f7091e1-4f81-49d2-a896-65ff4bb1d481",
        "user_code": "USR-4",
        "username": "data_4",
        "email": "test_4@gmail.com",
        "password": "$2a$10$1IVBzUnJ.AZoRlZRRGY0feyDoU1612Y4Gj5UZPPUiMXhMa4L4MgJK"
    },
    {
        "id": "36756cfc-2a2b-449d-8d0a-4602abc9cc72",
        "user_code": "USR-5",
        "username": "data_5",
        "email": "test_5@gmail.com",
        "password": "$2a$10$WHd0kCnbCzjoLiB80xrVFOzEallJjQGTeWj0PTg.7UG5WwgsWDvIm"
    }
]
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