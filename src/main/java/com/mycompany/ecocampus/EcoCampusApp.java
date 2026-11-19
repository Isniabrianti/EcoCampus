
package com.mycompany.ecocampus;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class EcoCampusApp extends Application {

    private static ArrayList<LaporanSampah> daftarLaporan =
            new ArrayList<>();
    private static int nomorLaporan = 1;

    @Override
    public void start(Stage stage) {

        Label judul = new Label("ECO CAMPUS");
        Label keterangan = new Label(
                "Sistem Informasi Pelaporan Sampah"
        );
        Label labelUsername = new Label("Username");
        TextField inputUsername = new TextField();
        inputUsername.setPromptText("Masukkan username");

        Label labelPassword = new Label("Password");
        PasswordField inputPassword = new PasswordField();
        inputPassword.setPromptText("Masukkan password");

        Button tombolLogin = new Button("Login");

        tombolLogin.setOnAction(event -> {
            String username = inputUsername.getText();
            String password = inputPassword.getText();
            if (username.isEmpty() || password.isEmpty()) {
                tampilkanAlert(
                        Alert.AlertType.WARNING,
                        "Peringatan",
                        "Username dan password harus diisi!"
                );
            } else if (username.equals("isnimhs")
                    && password.equals("2006")) {
                tampilkanAlert(
                        Alert.AlertType.INFORMATION,
                        "Login Berhasil",
                        "Selamat datang, Isni!"
                );
                tampilkanDashboardMahasiswa(stage);
            } else if (username.equals("admin")
                    && password.equals("12345678")) {
                tampilkanAlert(
                        Alert.AlertType.INFORMATION,
                        "Login Berhasil",
                        "Selamat datang, Admin EcoCampus!"
                );
                tampilkanDashboardAdmin(stage);
            } else {
                tampilkanAlert(
                        Alert.AlertType.ERROR,
                        "Login Gagal",
                        "Username atau password salah!"
                );
            }
        });
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPrefWidth(350);
        layout.getChildren().addAll(
                judul,
                keterangan,
                labelUsername,
                inputUsername,
                labelPassword,
                inputPassword,
                tombolLogin
        );
        Scene scene = new Scene(layout, 500, 400);
        stage.setTitle("EcoCampus");
        stage.setScene(scene);
        stage.show();
    }

    private void tampilkanAlert(
            Alert.AlertType tipe,
            String judul,
            String pesan) {
        Alert alert = new Alert(tipe);
        alert.setTitle(judul);
        alert.setHeaderText(null);
        alert.setContentText(pesan);
        alert.showAndWait();
    }

    private void tampilkanDashboardMahasiswa(Stage stage) {

        Label judul = new Label("ECO CAMPUS");
        Label subjudul = new Label("Dashboard Mahasiswa");
        Label sapaan = new Label("Halo, Isni!");
        Label keterangan = new Label(
                "Selamat datang di aplikasi EcoCampus."
        );
        Button tombolBuatLaporan = new Button("Buat Laporan");
        Button tombolRiwayat = new Button("Riwayat Laporan");
        Button tombolLogout = new Button("Logout");
        tombolBuatLaporan.setOnAction(event -> {
            tampilkanFormLaporan(stage);
        });
        tombolRiwayat.setOnAction(event -> {
            tampilkanRiwayatLaporan(stage);
        });
        tombolLogout.setOnAction(event -> {
            start(stage);
        });
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPrefWidth(500);
        layout.getChildren().addAll(
                judul,
                subjudul,
                sapaan,
                keterangan,
                tombolBuatLaporan,
                tombolRiwayat,
                tombolLogout
        );
        Scene scene = new Scene(layout, 500, 400);
        stage.setTitle("Dashboard Mahasiswa - EcoCampus");
        stage.setScene(scene);
        stage.show();
    }

    private void tampilkanFormLaporan(Stage stage) {
        Label judul = new Label("FORMULIR LAPORAN SAMPAH");

        Label labelLokasi = new Label("Lokasi");
        TextField inputLokasi = new TextField();
        inputLokasi.setPromptText("Masukkan lokasi sampah");

        Label labelJenis = new Label("Jenis Sampah");
        ComboBox<String> inputJenis = new ComboBox<>();

        inputJenis.getItems().addAll(
                "Plastik",
                "Organik",
                "Kertas",
                "Logam",
                "Lainnya"
        );
        inputJenis.setPromptText("Pilih jenis sampah");

        Label labelDeskripsi = new Label("Deskripsi");
        TextArea inputDeskripsi = new TextArea();

        inputDeskripsi.setPromptText(
                "Jelaskan kondisi sampah..."
        );
        inputDeskripsi.setPrefRowCount(4);

        Button tombolKirim = new Button("Kirim Laporan");
        Button tombolKembali = new Button("Kembali");

        tombolKirim.setOnAction(event -> {
            String lokasi = inputLokasi.getText();
            String jenis = inputJenis.getValue();
            String deskripsi = inputDeskripsi.getText();
            if (lokasi.trim().isEmpty()
                    || jenis == null
                    || deskripsi.trim().isEmpty()) {
                tampilkanAlert(
                        Alert.AlertType.WARNING,
                        "Peringatan",
                        "Semua data laporan harus diisi!"
                );
            } else {
                LaporanSampah laporan = new LaporanSampah(
                        nomorLaporan,
                        lokasi,
                        jenis,
                        deskripsi
                );
                daftarLaporan.add(laporan);
                tampilkanAlert(
                        Alert.AlertType.INFORMATION,
                        "Laporan Berhasil",
                        "Laporan berhasil disimpan!\n"
                        + "ID Laporan: " + nomorLaporan
                        + "\nStatus: Menunggu Penanganan"
                );
                nomorLaporan++;
                tampilkanDashboardMahasiswa(stage);
            }
        });
        tombolKembali.setOnAction(event -> {
            tampilkanDashboardMahasiswa(stage);
        });
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPrefWidth(500);

        layout.getChildren().addAll(
                judul,
                labelLokasi,
                inputLokasi,
                labelJenis,
                inputJenis,
                labelDeskripsi,
                inputDeskripsi,
                tombolKirim,
                tombolKembali
        );
        Scene scene = new Scene(layout, 500, 550);
        stage.setTitle("Buat Laporan - EcoCampus");
        stage.setScene(scene);
        stage.show();
    }

    private void tampilkanRiwayatLaporan(Stage stage) {

        Label judul = new Label("RIWAYAT LAPORAN");
        VBox daftar = new VBox(15);
        if (daftarLaporan.isEmpty()) {
            Label kosong = new Label(
                    "Belum ada laporan yang dibuat."
            );
            daftar.getChildren().add(kosong);
        } else {
            for (LaporanSampah laporan : daftarLaporan) {
                Label detail = new Label(
                        "ID Laporan: " + laporan.getIdLaporan()
                        + "\nLokasi: " + laporan.getLokasi()
                        + "\nJenis Sampah: "
                        + laporan.getJenisSampah()
                        + "\nDeskripsi: " + laporan.getDeskripsi()
                        + "\nStatus: " + laporan.getStatus()
                );
                daftar.getChildren().add(detail);
            }
        }
        Button tombolKembali = new Button("Kembali");
        tombolKembali.setOnAction(event -> {
            tampilkanDashboardMahasiswa(stage);
        });
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(
                judul,
                daftar,
                tombolKembali
        );
        Scene scene = new Scene(layout, 500, 550);
        stage.setTitle("Riwayat Laporan - EcoCampus");
        stage.setScene(scene);
        stage.show();
    }

    private void tampilkanDashboardAdmin(Stage stage) {
        Label judul = new Label("ECO CAMPUS");
        Label subjudul = new Label("Dashboard Admin");

        Label sapaan = new Label("Halo, Admin!");
        Label keterangan = new Label(
                "Selamat datang di halaman pengelolaan laporan."
        );
        Button tombolLihatLaporan =
                new Button("Lihat Semua Laporan");
        Button tombolUbahStatus =
                new Button("Ubah Status Laporan");
        Button tombolLogout = new Button("Logout");
        tombolLihatLaporan.setOnAction(event -> {
            tampilkanSemuaLaporan(stage);
        });
        tombolUbahStatus.setOnAction(event -> {
            tampilkanUbahStatus(stage);
        });
        tombolLogout.setOnAction(event -> {
            start(stage);
        });
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPrefWidth(500);
        layout.getChildren().addAll(
                judul,
                subjudul,
                sapaan,
                keterangan,
                tombolLihatLaporan,
                tombolUbahStatus,
                tombolLogout
        );
        Scene scene = new Scene(layout, 500, 400);
        stage.setTitle("Dashboard Admin - EcoCampus");
        stage.setScene(scene);
        stage.show();
    }

    private void tampilkanSemuaLaporan(Stage stage) {
        Label judul = new Label("DAFTAR SEMUA LAPORAN");
        VBox daftar = new VBox(15);
        if (daftarLaporan.isEmpty()) {
            Label kosong = new Label(
                    "Belum ada laporan dari mahasiswa."
            );
            daftar.getChildren().add(kosong);
        } else {
            for (LaporanSampah laporan : daftarLaporan) {
                Label detail = new Label(
                        "ID Laporan: " + laporan.getIdLaporan()
                        + "\nLokasi: " + laporan.getLokasi()
                        + "\nJenis Sampah: "
                        + laporan.getJenisSampah()
                        + "\nDeskripsi: " + laporan.getDeskripsi()
                        + "\nStatus: " + laporan.getStatus()
                );
                daftar.getChildren().add(detail);
            }
        }
        Button tombolKembali = new Button("Kembali");
        tombolKembali.setOnAction(event -> {
            tampilkanDashboardAdmin(stage);
        });
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(
                judul,
                daftar,
                tombolKembali
        );
        Scene scene = new Scene(layout, 550, 550);
        stage.setTitle("Semua Laporan - EcoCampus");
        stage.setScene(scene);
        stage.show();
    }

    private void tampilkanUbahStatus(Stage stage) {
        Label judul = new Label("UBAH STATUS LAPORAN");
        Label labelID = new Label("Pilih ID Laporan");
        ComboBox<Integer> pilihanID = new ComboBox<>();
        for (LaporanSampah laporan : daftarLaporan) {
            pilihanID.getItems().add(
                    laporan.getIdLaporan()
            );
        }
        Label labelStatus = new Label("Pilih Status Baru");
        ComboBox<String> pilihanStatus = new ComboBox<>();
        pilihanStatus.getItems().addAll(
                "Menunggu Penanganan",
                "Sedang Diproses",
                "Selesai"
        );
        pilihanStatus.setPromptText("Pilih status");
        Button tombolSimpan = new Button("Simpan Perubahan");
        Button tombolKembali = new Button("Kembali");
        tombolSimpan.setOnAction(event -> {
            Integer id = pilihanID.getValue();
            String status = pilihanStatus.getValue();
            if (id == null || status == null) {
                tampilkanAlert(
                        Alert.AlertType.WARNING,
                        "Peringatan",
                        "Pilih ID laporan dan status terlebih dahulu!"
                );
            } else {
                for (LaporanSampah laporan : daftarLaporan) {
                    if (laporan.getIdLaporan() == id) {
                        laporan.setStatus(status);
                        tampilkanAlert(
                                Alert.AlertType.INFORMATION,
                                "Berhasil",
                                "Status laporan berhasil diubah!"
                        );
                        tampilkanDashboardAdmin(stage);
                        break;
                    }
                }
            }
        });
        tombolKembali.setOnAction(event -> {
            tampilkanDashboardAdmin(stage);
        });
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(
                judul,
                labelID,
                pilihanID,
                labelStatus,
                pilihanStatus,
                tombolSimpan,
                tombolKembali
        );
        Scene scene = new Scene(layout, 500, 450);
        stage.setTitle("Ubah Status Laporan - EcoCampus");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}