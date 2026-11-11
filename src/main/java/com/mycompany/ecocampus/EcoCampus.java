package com.mycompany.ecocampus;

import java.util.ArrayList;
import java.util.Scanner;

public class EcoCampus {
    static Scanner input = new Scanner(System.in);
    static ArrayList<LaporanSampah> daftarLaporan = new ArrayList<>();

    static Mahasiswa mahasiswa = new Mahasiswa(
            "Budi", "mhs", "123", "2317051001"
    );

    static Admin admin = new Admin(
            "Admin EcoCampus", "admin", "123", "ADM01"
    );
    static int nomorLaporan = 1;

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n===== ECO CAMPUS =====");
            System.out.println("1. Login Mahasiswa");
            System.out.println("2. Login Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = Integer.parseInt(input.nextLine());

            switch (pilihan) {
                case 1:
                    prosesLoginMahasiswa();
                    break;
                case 2:
                    prosesLoginAdmin();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan EcoCampus.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia!");
            }
        } while (pilihan != 3);
    }

    static void prosesLoginMahasiswa() {
        System.out.print("Username: ");
        String username = input.nextLine();

        System.out.print("Password: ");
        String password = input.nextLine();

        if (username.equals(mahasiswa.getUsername())
                && password.equals(mahasiswa.getPassword())) {
            System.out.println("\nLogin mahasiswa berhasil!");
            menuMahasiswa();
        } else {
            System.out.println("Username atau password salah!");
        }
    }

    static void prosesLoginAdmin() {
        System.out.print("Username: ");
        String username = input.nextLine();

        System.out.print("Password: ");
        String password = input.nextLine();

        if (username.equals(admin.getUsername())
                && password.equals(admin.getPassword())) {
            System.out.println("\nLogin admin berhasil!");
            menuAdmin();
        } else {
            System.out.println("Username atau password salah!");
        }
    }

    static void menuMahasiswa() {
        int pilihan;
        do {
            System.out.println("\n===== MENU MAHASISWA =====");
            System.out.println("1. Buat Laporan Sampah");
            System.out.println("2. Lihat Laporan");
            System.out.println("3. Logout");
            System.out.print("Pilih menu: ");
            pilihan = Integer.parseInt(input.nextLine());

            switch (pilihan) {
                case 1:
                    buatLaporan();
                    break;
                case 2:
                    lihatLaporan();
                    break;
                case 3:
                    System.out.println("Berhasil logout.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia!");
            }
        } while (pilihan != 3);
    }

    static void menuAdmin() {
        int pilihan;
        do {
            System.out.println("\n===== MENU ADMIN =====");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Ubah Status Laporan");
            System.out.println("3. Logout");
            System.out.print("Pilih menu: ");
            pilihan = Integer.parseInt(input.nextLine());

            switch (pilihan) {
                case 1:
                    lihatLaporan();
                    break;
                case 2:
                    ubahStatusLaporan();
                    break;
                case 3:
                    System.out.println("Berhasil logout.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia!");
            }
        } while (pilihan != 3);
    }

    static void buatLaporan() {
        System.out.println("\n===== BUAT LAPORAN =====");

        System.out.print("Lokasi sampah: ");
        String lokasi = input.nextLine();

        System.out.print("Jenis sampah: ");
        String jenisSampah = input.nextLine();

        System.out.print("Deskripsi: ");
        String deskripsi = input.nextLine();

        LaporanSampah laporan = new LaporanSampah(
                nomorLaporan, lokasi, jenisSampah, deskripsi
        );
        daftarLaporan.add(laporan);
        nomorLaporan++;

        System.out.println("Laporan berhasil dibuat!");
    }

    static void lihatLaporan() {
        System.out.println("\n===== DAFTAR LAPORAN =====");

        if (daftarLaporan.isEmpty()) {
            System.out.println("Belum ada laporan.");
        } else {
            for (LaporanSampah laporan : daftarLaporan) {
                System.out.println("-------------------------");
                laporan.tampilkanLaporan();
            }
        }
    }

    static void ubahStatusLaporan() {
        lihatLaporan();

        if (daftarLaporan.isEmpty()) {
            return;
        }
        System.out.print("\nMasukkan ID laporan: ");
        int id = Integer.parseInt(input.nextLine());

        for (LaporanSampah laporan : daftarLaporan) {
            if (laporan.getIdLaporan() == id) {
                System.out.println("1. Menunggu Penanganan");
                System.out.println("2. Diproses");
                System.out.println("3. Selesai");
                System.out.print("Pilih status baru: ");
                int pilihan = Integer.parseInt(input.nextLine());

                switch (pilihan) {
                    case 1:
                        laporan.setStatus("Menunggu Penanganan");
                        break;
                    case 2:
                        laporan.setStatus("Diproses");
                        break;
                    case 3:
                        laporan.setStatus("Selesai");
                        break;
                    default:
                        System.out.println("Pilihan status tidak tersedia!");
                        return;
                }
                System.out.println("Status laporan berhasil diperbarui!");
                return;
            }
        }

        System.out.println("ID laporan tidak ditemukan!");
    }
}
