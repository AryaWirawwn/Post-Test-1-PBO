package pesawat;

import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenPesawat {
    ArrayList<Pesawat> daftarPesawat = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    String idPesawat;
    String namaPesawat;
    int kecepatanPesawat;

    public ManajemenPesawat(){
        daftarPesawat.add(new Pesawat("1113", "McDonnell Douglas F-4 Phantom II", 2716));
        daftarPesawat.add(new Pesawat("1112", "IAI Kfir", 2469));
        daftarPesawat.add(new Pesawat("1212", "MiG-29", 2840));
    }

    public static void MenuAwal(){
        System.out.println("+=================================+");
        System.out.println("| Sistem Manajemen Armada Pesawat |");
        System.out.println("+=================================+");
        System.out.println("| [1]. Create                     |");
        System.out.println("| [2]. Read                       |");
        System.out.println("| [3]. Update                     |");
        System.out.println("| [4]. Delete                     |");
        System.out.println("| [5]. Exit                       |");
        System.out.println("+=================================+");
        System.out.print("| Masukkan pilihan anda: ");
    }

    public void buatPesawat(){
        boolean ketemu = false;

        System.out.print("Masukkan ID pesawat: ");
        idPesawat = scanner.nextLine();

        for (Pesawat pesawat:daftarPesawat){
            if (pesawat.getID().equalsIgnoreCase(idPesawat)){
                ketemu = true;
                System.out.println("+=======================+");
                System.out.println("| ID Tersebut Sudah Ada |");
                System.out.println("+=======================+");
                System.out.println("Tekan enter untuk melanjutkan...");
                scanner.nextLine();
            }
        }

        if (ketemu == false){
            System.out.print("Masukkan nama pesawat: ");
            namaPesawat = scanner.nextLine();
            System.out.print("Masukkan kecepatan pesawat: ");
            kecepatanPesawat = scanner.nextInt();
            scanner.nextLine();

            daftarPesawat.add(new Pesawat(idPesawat, namaPesawat, kecepatanPesawat));
            System.out.println("Pesawat " + namaPesawat + " berhasil ditambahkan");
        }

    }

    public void tampilkanPesawat(){
        for (Pesawat pesawat : daftarPesawat){
            System.out.println("ID Pesawat: "+ pesawat.getID() + "\nNama Pesawat: " + pesawat.getNama() + "\nKecepatan Pesawat: " + pesawat.getKecepatan() + " km/h");
            System.out.println();
        }
    }

    public void perbaruiPesawat(){
        System.out.print("Masukkan ID pesawat: ");
        idPesawat = scanner.nextLine();

        boolean ketemu = false;

        for (Pesawat pesawat: daftarPesawat){
            if(pesawat.getID().equalsIgnoreCase(idPesawat)) {
                ketemu = true;
                System.out.print("Masukkan nama baru: ");
                namaPesawat = scanner.nextLine();
                System.out.print("Masukkan kecepatan baru: ");
                kecepatanPesawat = scanner.nextInt();
                scanner.nextLine();

                pesawat.changeNama(namaPesawat);
                pesawat.changeKecepatan(kecepatanPesawat);

                System.out.println("Data pesawat dengan ID " + pesawat.getID() + " berhasil diubah");
            }
        }
        if (ketemu == false){
            System.out.println("+=========================+");
            System.out.println("| Pesawat Tidak Ditemukan |");
            System.out.println("+=========================+");
        }
    }

    public void hapusPesawat(){
        System.out.print("Masukkan ID pesawat: ");
        idPesawat = scanner.nextLine();
        Pesawat pesawatditemukan = null;
        boolean ketemu = false;

        for (Pesawat pesawat: daftarPesawat){
            if(pesawat.getID().equalsIgnoreCase(idPesawat)) {
                ketemu = true;
                pesawatditemukan = pesawat;
                break;
            }
        }

        if (ketemu == true){
            daftarPesawat.remove(pesawatditemukan);
            System.out.println("+==========================+");
            System.out.println("| Pesawat berhasil dihapus |");
            System.out.println("+==========================+");
        } else {
            System.out.println("+=========================+");
            System.out.println("| Pesawat Tidak Ditemukan |");
            System.out.println("+=========================+");
        }
    }
}
