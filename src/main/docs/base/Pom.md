# Konfigurasi Maven (pom.xml)

Berikut adalah konfigurasi Maven (pom.xml) untuk proyek Spring Boot.

## 1. Parent Project
- **Group ID:** org.springframework.boot
- **Artifact ID:** spring-boot-starter-parent
- **Version:** 3.2.6

## 2. Informasi Proyek
- **Group ID:** com.srpingboot
- **Artifact ID:** belajar-spring
- **Version:** 0.0.1-SNAPSHOT
- **Nama:** belajar-spring
- **Deskripsi:** Backend Application Spring Boot

## 3. Properties
- **java.version:** 21

## 4. Dependencies
- **spring-boot-starter-data-jpa:** Starter untuk Spring Data JPA.
- **spring-boot-starter-web:** Starter untuk pengembangan aplikasi web Spring Boot.
- **mysql-connector-j:** Koneksi JDBC ke MySQL (runtime scope).
- **spring-boot-starter-test:** Starter untuk pengujian unit Spring Boot.
- **spring-security-crypto:** Pustaka untuk operasi keamanan kriptografi Spring.

## 5. Plugin Build
- **spring-boot-maven-plugin:** Plugin Maven untuk menjalankan dan membangun aplikasi Spring Boot.