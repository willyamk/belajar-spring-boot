## Dokumentasi Proyek Maven

### Deskripsi
Proyek Maven ini merupakan aplikasi backend yang dibangun menggunakan framework Spring Boot.

### Detail Proyek
- **Group ID**: com.srpingboot
- **Artifact ID**: belajar-spring
- **Versi**: 0.0.1-SNAPSHOT

### Parent POM
Proyek ini menggunakan `spring-boot-starter-parent` sebagai parent POM. Versi yang digunakan adalah `3.2.6`.

### Dependencies
1. **spring-boot-starter-data-jpa**: Starter untuk mengintegrasikan Spring Data JPA.
2. **spring-boot-starter-web**: Starter untuk membuat aplikasi web dengan Spring MVC.
3. **mysql-connector-j**: Driver JDBC untuk MySQL.
4. **spring-boot-starter-test**: Starter untuk pengujian unit dan integrasi dengan Spring Boot Test.
5. **spring-security-crypto**: Library untuk fitur keamanan dan enkripsi pada Spring Security.
6. **opencsv**: Library untuk membaca dan menulis file CSV.

### Properties
- **java.version**: Versi Java yang digunakan adalah `21`.

### Build
Plugin `spring-boot-maven-plugin` digunakan untuk membangun proyek Spring Boot.

### Struktur Proyek
```
belajar-spring
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── srpingboot
│   │   │           └── belajar_spring
│   │   │               └── (source code)
│   │   └── resources
│   │       ├── application.properties
│   │       └── (other resources)
│   └── test
│       └── java
│           └── com
│               └── srpingboot
│                   └── belajar_spring
│                       └── (test files)
├── target
└── pom.xml
```

### Catatan Tambahan
Pastikan versi Java yang terpasang sesuai dengan yang ditentukan dalam properti `java.version`. Juga, pastikan dependency MySQL sudah sesuai dengan versi yang dibutuhkan.