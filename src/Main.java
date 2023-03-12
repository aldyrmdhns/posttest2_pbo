//Library Import
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class Main{
    //Static Declaration for Input and ArrayList
    static InputStreamReader masuk = new InputStreamReader(System.in);
    static BufferedReader masukan = new BufferedReader(masuk);
    static ArrayList<Order> pesan = new ArrayList<>(){
        {
            add(new Order("Takami Izaya", "081234567890", "Jalan Perjuangan 1", "Pintu Besar", 101.2, 192.3, 2));
            add(new Order("Sakayanagi Ruika", "08098765432", "Jalan Pertempuran 1", "Jendela Kecil", 80.78, 102.3, 5));
        }
    };

    //Main Class
    public static void main(String[] args) throws NumberFormatException, IOException {
        Boolean loop = true;
        int pilihan = 0;
        
        while(loop){
            while (true) {
                try {
                    ClearScreen();
                    System.out.println("|=================================|");
                    System.out.println("|PROGRAM PEMESANAN KUSEN DAN MEBEL|");
                    System.out.println("|           SINAR PUTRA           |");
                    System.out.println("|=================================|");
                    System.out.println("|  [1]  Lihat Daftar Pesanan      |");
                    System.out.println("|  [2]  Tambah Daftar Pesanan     |");
                    System.out.println("|  [3]  Ubah Daftar Pesanan       |");
                    System.out.println("|  [4]  Hapus Daftar Pesanan      |");
                    System.out.println("|  [0]  Keluar                    |");
                    System.out.println("|=================================|");
                    System.out.print("   >> ");
                    pilihan = Integer.parseInt(masukan.readLine());
                    break;
                } catch (Exception e) {
                    ClearScreen();
                    System.out.println(" Masukan Input dengan Benar ! ! !");
                    System.out.println("  Tekan Enter Untuk Kembali");
                    masukan.readLine();
                }
            }
    
            switch (pilihan) {
                case 1:
                    ClearScreen();
                    isDisplay();
                    break;
                case 2:
                    ClearScreen();
                    isAdd();
                    break;
                case 3:
                    ClearScreen();
                    isChange();
                    break;
                case 4:
                    ClearScreen();
                    isDelete();
                    break;
                case 0:
                    ClearScreen();
                    System.out.println(" Adios Amigos~");
                    loop = false;
                    break;
                default:
                    ClearScreen();
                    System.out.println("- Inputan Salah -");
                    masukan.readLine();
                    break;
            }
        }
    }

    //CRUD Method/Function
    public static void isDisplay() throws IOException{
        int isiArray = pesan.size();
        if (isiArray == 0) {
            System.out.println(" Data Pesanan Masih Kosong ");
        } else{
            for (int i = 0; i < isiArray; i++) {
                System.out.println("=====================================");
                System.out.println("| Nama Pemesan      : " + pesan.get(i).getNama());
                System.out.println("| No HP Pemesan     : " + pesan.get(i).getNoHp());
                System.out.println("| Alamat Pemesan    : " + pesan.get(i).getAlamat());
                System.out.println("| Barang Pesanan    : " + pesan.get(i).getBarang());
                System.out.println("| Panjang Barang    : " + pesan.get(i).getPanjang());
                System.out.println("| Tinggi Barang     : " + pesan.get(i).getTinggi());
                System.out.println("| Banyak Barang     : " + pesan.get(i).getBanyak());
                System.out.println("=====================================");
                // pesan.get(i).isDisplay(); System.out.println();
            }
        }
        System.out.println("Tekan enter untuk melanjutkan"); masukan.readLine();
    }

    public static void isAdd() throws NumberFormatException, IOException{
        String nama, noHp, alamat, barang;
        Double panjang, tinggi;
        int banyak;
        boolean isInArray = true;
        ClearScreen();

        while (true) {
            try {
                System.out.println("================================================================");
                System.out.println("|                      Tambah Data Pesanan                     |");
                System.out.println("================================================================");
                System.out.print(" Nama Pemesan           : "); nama = masukan.readLine();
                System.out.print(" No Hp Pemesan          : "); noHp = masukan.readLine();
                System.out.print(" Alamat Pemesan         : "); alamat = masukan.readLine();
                System.out.print(" Nama Barang Pesanan    : "); barang = masukan.readLine();
                System.out.print(" Panjang Barang         : "); panjang = Double.parseDouble(masukan.readLine());
                System.out.print(" Tinggi Barang          : "); tinggi = Double.parseDouble(masukan.readLine());
                System.out.print(" Banyak Barang          : "); banyak = Integer.parseInt(masukan.readLine());
                break;    
            } catch (Exception e) {
                ClearScreen();
                System.out.println(" Inputan Anda Salah, Mohon Masukan dengan Benar");
                System.out.println("  Tekan Enter untuk Mengulangi");
                masukan.readLine();
                ClearScreen();
            }

        }
        System.out.println("================================================================");
        
        for (int i = 0; i < pesan.size(); i++) {
            if (pesan.get(i).getNama().equals(nama)) {
                System.out.println(" - Nama Tersebut sudah Tersedia!!! ");
                System.out.println("  Tekan Enter Untuk Kembali"); masukan.readLine();
                isInArray = false;
            }
        }

        if (isInArray) {
            Order addOrder = new Order(nama, noHp, alamat, barang, panjang, tinggi, banyak);
            pesan.add(addOrder);
            System.out.println("                   Pesanan Berhasil Ditambahkan                   ");
            System.out.println("================================================================");
            System.out.println("  Tekan Enter Untuk Kembali");
            masukan.readLine();
        }
    }

    public static void isChange() throws NumberFormatException, IOException{
        int isiArray = pesan.size();
        if (isiArray == 0) {
            System.out.println(" Data Pesanan Masih Kosong ");
        } else {
            System.out.println("================================================================");
            System.out.println("|                       Ubah Data Pesanan                      |");
            System.out.println("================================================================");
            for (int i = 0; i < pesan.size(); i++) {
                System.out.println(i+1 + ". " + pesan.get(i).getNama());
            }
            System.out.println("================================================================");
            System.out.print("  Masukan Nama Pemesan : "); String cariNama = masukan.readLine();
            System.out.println("================================================================");
            for (Order order : pesan) {
                if (order.getNama().equals(cariNama)) {
                    System.out.println("  1. Ubah Nama\t\t\t  2. Ubah No Hp\n  3. Ubah Alamat\t\t  4. Ubah Barang\n  5. Ubah Panjang\t\t  6. Ubah Tinggi\n  7. Ubah Banyak Barang\t\t  0. Kembali ke menu Sebelumnya");
                    System.out.println("================================================================");
                    System.out.print("  >> "); int pilihan = Integer.parseInt(masukan.readLine());
                    
                    switch (pilihan) {
                        case 1:
                            System.out.print("  Masukan Nama Pemesan Yang Baru : "); String newName = masukan.readLine();
                            order.setNama(newName);
                            System.out.println("\n  Nama Berhasil Diubah!");
                            System.out.println("\n  Tekan Enter untuk Kembali!");masukan.readLine();
                            break;
                        case 2:
                            System.out.print("  Masukan No Hp Yang Baru : "); String newNohp = masukan.readLine();
                            order.setNoHp(newNohp);
                            System.out.println("\n  No Hp Berhasil Diubah!");
                            System.out.println("\n  Tekan Enter untuk Kembali!");masukan.readLine();
                            break;
                        case 3:
                            System.out.print("  Masukan Alamat Yang Baru : "); String newAlamat = masukan.readLine();
                            order.setAlamat(newAlamat);
                            System.out.println("\n  Alamat Berhasil Diubah!");
                            System.out.println("\n  Tekan Enter untuk Kembali!");masukan.readLine();
                            break;
                        case 4:
                            System.out.print("  Masukan Nama barang Yang Baru : "); String newBarang = masukan.readLine();
                            order.setBarang(newBarang);
                            System.out.println("\n  Nama barang Berhasil Diubah!");
                            System.out.println("\n  Tekan Enter untuk Kembali!");masukan.readLine();
                            break;
                        case 5:
                            Double newPanjang = null;
                            while (true) {
                                try {
                                    System.out.print("  Masukan Panjang Barang Yang Baru : "); newPanjang = Double.parseDouble(masukan.readLine());
                                    break;
                                } catch (Exception e) {
                                    System.out.println(" Inputan Anda Salah, Mohon Masukan dengan Benar");
                                    System.out.println("  Tekan Enter untuk Mengulangi");
                                    masukan.readLine();
                                }
                            }
                            order.setPanjang(newPanjang);
                            System.out.println("\n  Panjang Barang Berhasil Diubah!");
                            System.out.println("\n  Tekan Enter untuk Kembali!");masukan.readLine();
                            break;
                        case 6:
                            Double newTinggi = null;
                            while (true) {
                                try {
                                    System.out.print("  Masukan Tinggi Barang Yang Baru : "); newTinggi = Double.parseDouble(masukan.readLine());
                                    break;
                                } catch (Exception e) {
                                    System.out.println(" Inputan Anda Salah, Mohon Masukan dengan Benar");
                                    System.out.println("  Tekan Enter untuk Mengulangi");
                                    masukan.readLine();
                                }
                                
                            }
                            order.setTinggi(newTinggi);
                            System.out.println("\n  Tinggi Barang Berhasil Diubah!");
                            System.out.println("\n  Tekan Enter untuk Kembali!");masukan.readLine();
                            break;
                        case 7:
                            int newBanyak = 0;
                            while (true) {
                                try {
                                    System.out.print("  Masukan Banyak Barang Yang Baru : "); newBanyak = Integer.parseInt(masukan.readLine());
                                    break;
                                } catch (Exception e) {
                                    System.out.println(" Inputan Anda Salah, Mohon Masukan dengan Benar");
                                    System.out.println("  Tekan Enter untuk Mengulangi");
                                    masukan.readLine();
                                }
                            }
                            order.setBanyak(newBanyak);
                            System.out.println("\n  Banyak Barang Berhasil Diubah!");
                            System.out.println("\n  Tekan Enter untuk Kembali!");masukan.readLine();
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("  Inputan Tidak Tersedia ");
                            break;
                    }
                }
            }
        }
    }

    public static void isDelete() throws IOException{
        int isiArray = pesan.size();
        if (isiArray == 0) {
            System.out.println(" Data Pesanan Masih Kosong ");
        } else {
            System.out.println("================================================================");
            System.out.println("|                      Hapus Data Pesanan                      |");
            System.out.println("================================================================");
            for (int i = 0; i < pesan.size(); i++) {
                System.out.println(i+1 + ". " + pesan.get(i).getNama());
            }
            System.out.println("================================================================");
            System.out.print("  Masukan Nama Pemesan : "); String cariNama = masukan.readLine();
            System.out.println("================================================================");
            for (int i = 0; i < pesan.size(); i++) {
                if (pesan.get(i).getNama().equals(cariNama)) {
                    pesan.get(i).Display();
                    while (true) {
                        System.out.println(" Apakah Anda Yakin untuk Menghapus? [y/n]"); char acc = (char)masukan.read();
                        if (acc == 'y') {
                            pesan.remove(i);
                            System.out.println("Pesanan Telah Dihapus");
                            System.out.println("  Tekan Enter Untuk Kembali");
                            masukan.readLine();
                            break;
                        } else if(acc == 'n'){
                            System.out.println("Tidak Jadi Menghapus Pesanan");
                            System.out.println("  Tekan Enter Untuk Kembali");
                            masukan.readLine();
                            break;
                        } else{
                            System.out.println(" Inputan tidak Tersedia");
                            System.out.println("  Tekan Enter Untuk Kembali");
                            masukan.readLine();
                        }
                    }
                }
        }
    }
}

    //Some Other Methods/Function
    // public static void Wait(int lama){
    //     try{
    //         Thread.sleep(lama);
    //     }
    //     catch(InterruptedException ex){
    //         Thread.currentThread().interrupt();
    //     }
    // }

    public static void ClearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else{
                System.out.print("\033\143");
            }
        } catch (Exception ex) {
            System.err.println("Gagal Membersihkan");
        }
    }
}