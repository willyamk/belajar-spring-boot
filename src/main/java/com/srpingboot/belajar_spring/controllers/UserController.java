package com.srpingboot.belajar_spring.controllers;

import com.srpingboot.belajar_spring.exception.UserNotFoundException;
import com.srpingboot.belajar_spring.models.User;
import com.srpingboot.belajar_spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.srpingboot.belajar_spring.utils.FileUploadResponse.*;

/**
 * UserController adalah kelas yang mengatur semua endpoint terkait pengguna (user) dalam aplikasi.
 * Ini menyediakan operasi dasar seperti membuat, membaca, memperbarui, dan menghapus (CRUD)
 * untuk entitas User.
 */
@RestController
public class UserController {

    /**
     * UserRepository.md digunakan untuk mengakses dan memanipulasi data pengguna dalam basis data.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Endpoint untuk membuat pengguna baru.
     * @param newUser Objek User baru yang akan dibuat.
     * @return Objek User yang baru dibuat.
     */
    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        String userCode = generateUserCode();
        newUser.setUser_code(userCode);
        return userRepository.save(newUser);
    }

    /**
     * Endpoint untuk mengupload data pengguna dari file JSON.
     * @param users List<User> data pengguna yang akan diupload dari file JSON.
     * @return ResponseEntity<Object> yang berisi pesan keberhasilan atau kegagalan upload.
     */
    @PostMapping("/users/json")
    public ResponseEntity<Object> uploadUsersFromJSON(@RequestBody List<User> users) {
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No user data provided!");
        }

        try {
            for (User user : users) {
                String userCode = generateUserCode();
                user.setUser_code(userCode);
                user.setId(UUID.randomUUID());
            }

            List<User> savedUsers = userRepository.saveAll(users);

            return ResponseEntity.status(HttpStatus.OK).body(savedUsers.size() + " users data uploaded successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload users data!");
        }
    }

    /**
     * Endpoint untuk mengupload data pengguna dari file CSV.
     * @param files Array MultipartFile yang berisi file CSV yang akan diupload.
     * @return ResponseEntity<Object> yang berisi pesan keberhasilan atau kegagalan upload.
     */
    @PostMapping("/users/csv")
    public ResponseEntity<Object> uploadUsersFromCSV(@RequestParam("file") MultipartFile[] files) {
        if (files.length != 1) {
            List<String> fileNames = new ArrayList<>();
            for (MultipartFile file : files) {
                fileNames.add(file.getOriginalFilename());
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(createResponse("Failed", "Only one file can be uploaded at a time!", fileNames, 0));
        }

        MultipartFile file = files[0];

        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(createResponse("Failed", "Please select a file to upload!", file.getOriginalFilename(), 0));
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String header = reader.readLine();

            if (isValidCSVHeader(header, "username,email,password")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(createResponse("Failed", "Invalid CSV file format! Header must be 'username,email,password'.", file.getOriginalFilename(), 0));
            }

            List<User> users = new ArrayList<>();
            String line;
            int successfulUploads = 0;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    UUID userId = UUID.randomUUID();
                    String user_code = generateUserCode();
                    String username = data[0];
                    String email = data[1];
                    String password = data[2];

                    User user = new User(userId, user_code, username, email, password);
                    users.add(user);
                    successfulUploads++;
                }
            }

            userRepository.saveAll(users);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(createResponse("Success", "File uploaded successfully!", file.getOriginalFilename(), successfulUploads));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(createResponse("Failed", "Failed to upload file!", file.getOriginalFilename(), 0));
        }
    }

    /**
     * Endpoint untuk membaca data pengguna dari file CSV.
     * @param files Array MultipartFile yang berisi file CSV yang akan dibaca.
     * @return ResponseEntity<Object> yang berisi data pengguna yang telah dibaca atau pesan kegagalan.
     */
    @PostMapping("/users/csv/read")
    public ResponseEntity<Object> uploadCSV(@RequestParam("file") MultipartFile[] files) {
        if (files.length != 1) {
            List<String> fileNames = new ArrayList<>();
            for (MultipartFile file : files) {
                fileNames.add(file.getOriginalFilename());
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(createResponse("Failed", "Only one file can be uploaded at a time!", fileNames, 0));
        }

        MultipartFile file = files[0];

        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(createResponse("Failed", "Please select a file to upload!", file.getOriginalFilename(), 0));
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String header = reader.readLine();

            if (isValidCSVHeader(header, "username,email,password")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(createResponse("Failed", "Invalid CSV file format! Header must be 'username,email,password'.", file.getOriginalFilename(), 0));
            }

            List<User> userDataList = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    UUID userId = UUID.randomUUID();
                    String user_code = generateUserCode();
                    String username = data[0];
                    String email = data[1];
                    String password = data[2];

                    User userData = new User(userId, user_code, username, email, password);
                    userDataList.add(userData);
                }
            }
            return ResponseEntity.ok().body(userDataList);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(createResponse("Failed", "Failed to read CSV file!", file.getOriginalFilename(), 0));
        }
    }

    /**
     * Endpoint untuk mengedit data pengguna dari file CSV.
     * @param files Array MultipartFile yang berisi file CSV yang akan diedit.
     * @return ResponseEntity<Object> yang berisi pesan keberhasilan atau kegagalan edit.
     */
    @PostMapping("/users/edit/csv")
    public ResponseEntity<Object> editUsersFromCSV(@RequestParam("file") MultipartFile[] files) {
        if (files.length != 1) {
            List<String> fileNames = new ArrayList<>();
            for (MultipartFile file : files) {
                fileNames.add(file.getOriginalFilename());
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(createResponse("Failed", "Only one file can be uploaded at a time!", fileNames, 0));
        }

        MultipartFile file = files[0];

        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(createResponse("Failed", "Please select a file to upload!", file.getOriginalFilename(), 0));
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String header = reader.readLine();

            if (isValidCSVHeader(header, "user_code,username,email,password")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(createResponse("Failed", "Invalid CSV file format! Header must be 'user_code,username,email,password'.", file.getOriginalFilename(), 0));
            }

            String[] headers = header.split(",");
            int userCodeIndex = -1;

            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equalsIgnoreCase("user_code")) {
                    userCodeIndex = i;
                    break;
                }
            }

            if (userCodeIndex == -1) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(createResponse("Failed", "Invalid CSV file format! Header must contain 'user_code,username,email,password'.", file.getOriginalFilename(), 0));
            }

            List<User> updatedUsers = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    try {
                        String userCode = data[userCodeIndex];
                        String username = data[1];
                        String email = data[2];
                        String password = data[3];

                        User existingUser = userRepository.findByUser_code(userCode);
                        if (existingUser != null) {
                            existingUser.setUsername(username);
                            existingUser.setEmail(email);
                            existingUser.setPassword(password);
                            updatedUsers.add(existingUser);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            userRepository.saveAll(updatedUsers);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(createResponse("Success", "User data updated successfully!", file.getOriginalFilename(), updatedUsers.size()));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(createResponse("Failed", "Failed to edit user data!", file.getOriginalFilename(), 0));
        }
    }

    /**
     * Endpoint untuk mendapatkan semua pengguna yang ada.
     * @return Daftar semua pengguna dalam bentuk List<User>.
     */
    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAllOrderedByUserCodeAsc();
    }

    /**
     * Endpoint untuk mendapatkan pengguna berdasarkan ID.
     * @param id UUID dari pengguna yang akan dicari.
     * @return Objek User yang sesuai dengan ID yang diberikan.
     * @throws UserNotFoundException Jika pengguna dengan ID yang diberikan tidak ditemukan.
     */
    @GetMapping("/user/{id}")
    User getUser(@PathVariable UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * Endpoint untuk memperbarui informasi pengguna yang ada.
     * @param id UUID dari pengguna yang akan diperbarui.
     * @param newUser Objek User yang berisi informasi baru yang akan diperbarui.
     * @return Objek User yang telah diperbarui.
     * @throws UserNotFoundException Jika pengguna dengan ID yang diberikan tidak ditemukan.
     */
    @PutMapping("/user/{id}")
    User updateUser(@PathVariable UUID id, @RequestBody User newUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * Endpoint untuk menghapus pengguna berdasarkan ID.
     * @param id UUID dari pengguna yang akan dihapus.
     * @return Pesan sukses setelah pengguna berhasil dihapus.
     * @throws UserNotFoundException Jika pengguna dengan ID yang diberikan tidak ditemukan.
     */
    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable UUID id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id : " + id + " has been deleted successfully!";
    }

    /**
     * Endpoint untuk menghapus semua pengguna.
     * @return Pesan sukses setelah semua pengguna berhasil dihapus.
     */
    @DeleteMapping("/users")
    String deleteAllUsers() {
        userRepository.deleteAll();
        return "All users have been deleted successfully!";
    }

    private static boolean isValidCSVHeader(String header, String expectedHeader) {
        return header == null || !header.equalsIgnoreCase(expectedHeader);
    }

    private static int userCounter = 0;

    private String generateUserCode() {
        userCounter++;
        return "USR-" + userCounter;
    }
}