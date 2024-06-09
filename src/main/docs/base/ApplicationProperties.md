# Konfigurasi Aplikasi Spring Boot

Berikut adalah konfigurasi aplikasi Spring Boot yang didefinisikan dalam file `application.properties`.

## 1. Nama aplikasi Spring Boot
- **spring.application.name:** belajar-spring

## 2. Port Server
- **server.port:** 8000

## 3. Konfigurasi Hibernate
- **spring.jpa.hibernate.ddl-auto:** update
    - Deskripsi: Konfigurasi Hibernate untuk mengotomatisasi pembuatan dan pembaruan skema basis data.

## 4. Konfigurasi Database MySQL
- **spring.datasource.url:** jdbc:mysql://localhost:3306/spring_bot
    - Deskripsi: URL JDBC untuk koneksi ke database MySQL.
- **spring.datasource.username:** root
    - Deskripsi: Username untuk mengakses database MySQL.
- **spring.datasource.password:** [diisi oleh pengguna]
    - Deskripsi: Password untuk mengakses database MySQL.
- **spring.datasource.driver-class-name:** com.mysql.cj.jdbc.Driver
    - Deskripsi: Kelas driver JDBC untuk MySQL.

