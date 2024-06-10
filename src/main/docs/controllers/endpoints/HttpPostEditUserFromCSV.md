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
user_code,username,email,password
USR-1,edit_username_1,edit_password_1@gmail.com,edit_password_1
USR-2,edit_username_2,edit_password_2@gmail.com,edit_password_2
USR-3,edit_username_3,edit_password_3@gmail.com,edit_password_3
```

### Hasil Respons:

#### Jika Berhasil:
```json
{
    "Status": "Success",
    "Message": "User data updated successfully!",
    "FileName": "edit_data_form_csv.csv",
    "Amount": 3
}
```

#### Jika Gagal Karena Format CSV Salah:
```json
{
    "Status": "Failed",
    "Message": "Invalid CSV file format! Header must be 'user_code,username,email,password'.",
    "FileName": "data.csv",
    "Amount": 0
}
```

#### Jika File yang Diinput Lebih dari 1:
```json
{
    "Status": "Failed",
    "Message": "Only one file can be uploaded at a time!",
    "FileNames": {
        "File 1": "data.csv",
        "File 2": "edit_data_form_csv.csv"
    },
    "Amount": 0
}
```