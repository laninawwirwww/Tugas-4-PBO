
// Main class

import java.util.Scanner;

public class ProgramFaktur {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input data
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();
            validateInput(noFaktur, "No Faktur"); // Validasi input kosong

            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine();
            validateInput(kodeBarang, "Kode Barang"); // Validasi input kosong

            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();
            validateInput(namaBarang, "Nama Barang"); // Validasi input kosong

            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = scanner.nextDouble();
            if (hargaBarang <= 0) { // Validasi harga tidak boleh nol atau negatif
                throw new InvalidInputException("Harga barang harus lebih besar dari 0!");
            }

            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = scanner.nextInt();
            if (jumlahBeli <= 0) { // Validasi jumlah beli tidak boleh nol atau negatif
                throw new InvalidInputException("Jumlah beli harus lebih besar dari 0!");
            }

            // Membuat objek Faktur (memanfaatkan inheritance dari Barang)
            Faktur faktur = new Faktur(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);

            // Menampilkan data faktur
            System.out.println("\n=== Data Faktur ===");
            faktur.displayFaktur();

        } catch (InvalidInputException e) { // Menangani custom exception
            System.out.println("Kesalahan Input: " + e.getMessage());
        } catch (Exception e) { // Menangani exception umum
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            // Menutup scanner
            scanner.close();
            System.out.println("Program selesai.");
        }
    }

    // Method untuk validasi input string (tidak boleh kosong)
    public static void validateInput(String input, String fieldName) throws InvalidInputException {
        // Mengecek apakah input null atau hanya berisi spasi
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInputException(fieldName + " tidak boleh kosong!");
        }
    }
}