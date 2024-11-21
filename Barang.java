// Parent class
class Barang {
    // Atribut barang
    protected String kodeBarang;
    protected String namaBarang;
    protected double hargaBarang;

    // Constructor untuk inisialisasi atribut
    public Barang(String kodeBarang, String namaBarang, double hargaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }

    // Method untuk menampilkan detail barang
    public void displayBarang() {
        System.out.println("Kode Barang: " + kodeBarang);
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Harga Barang: " + hargaBarang);
    }
}

// Child class (Inheritance)
class Faktur extends Barang { // Menggunakan inheritance untuk mewarisi properti Barang
    private String noFaktur;
    private int jumlahBeli;
    private double total;

    // Constructor untuk inisialisasi faktur
    public Faktur(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        // Memanggil constructor dari parent class Barang
        super(kodeBarang, namaBarang, hargaBarang); 
        this.noFaktur = noFaktur;
        this.jumlahBeli = jumlahBeli;
        this.total = calculateTotal(); // Menghitung total otomatis
    }

    // Method untuk menghitung total harga
    private double calculateTotal() {
        return hargaBarang * jumlahBeli;
    }

    // Method untuk menampilkan detail faktur
    public void displayFaktur() {
        System.out.println("No Faktur: " + noFaktur);
        displayBarang(); // Memanggil method dari parent class
        System.out.println("Jumlah Beli: " + jumlahBeli);
        System.out.println("Total: " + total);
    }
}

// Custom exception class untuk validasi input
class InvalidInputException extends Exception { // Custom exception untuk kesalahan input
    public InvalidInputException(String message) {
        super(message); // Meneruskan pesan kesalahan ke parent class Exception
    }
}
