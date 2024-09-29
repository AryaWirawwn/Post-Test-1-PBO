# Profil
Nama: Muhammad Aryaputra Wirawan\
NIM: 2309116027\
Tema: Sistem Manajemen Armada Pesawat

# Deskripsi
Program ini adalah sebuah program sederhana CRUD dengan tema sistem manajemen armada pesawat. Di program ini user dapat membuat, membaca, mengedit, dan menghapus data pesawat.

# Source Code
## Main.java
```java
package main;

import pesawat.ManajemenPesawat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean selesai = false;
        int pilihan;
        ManajemenPesawat manajemen = new ManajemenPesawat();
        do {
            manajemen.MenuAwal();
            pilihan = scanner.nextInt();
            switch (pilihan) {
                case 1:
                    manajemen.buatPesawat();
                    break;
                case 2:
                    System.out.println("Daftar Pesawat:");
                    manajemen.tampilkanPesawat();
                    break;
                case 3:
                    System.out.println("Daftar Pesawat:");
                    manajemen.tampilkanPesawat();
                    scanner.nextLine();
                    manajemen.perbaruiPesawat();
                    break;
                case 4:
                    System.out.println("Daftar Pesawat:");
                    manajemen.tampilkanPesawat();
                    scanner.nextLine();
                    manajemen.hapusPesawat();
                    break;
                case 5:
                    selesai = true;
                    System.out.println("+============================================+");
                    System.out.println("| Terima Kasih Telah Menggunakan Program Ini |");
                    System.out.println("+============================================+");
                    break;
                default:
                    System.out.println("+=========================+");
                    System.out.println("| Pilihan tidak tersedia! |");
                    System.out.println("+=========================+");
            }
        }
        while (selesai == false);
    }
}
```

## ManajemenPesawat.java
```java
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
```

## Pesawat.java
```java
package pesawat;

public class Pesawat {
    String idPesawat;
    String namaPesawat;
    int kecepatanPesawat;

    public Pesawat(String id, String nama, int kecepatan){
        this.idPesawat = id;
        this.namaPesawat = nama;
        this.kecepatanPesawat = kecepatan;
    }

    public String getID(){
        return idPesawat;
    }

    public String getNama(){
        return namaPesawat;
    }

    public void changeNama(String namaPesawat){
        this.namaPesawat = namaPesawat;
    }

    public int getKecepatan(){
        return kecepatanPesawat;
    }

    public void changeKecepatan(int kecepatanPesawat){
        this.kecepatanPesawat = kecepatanPesawat;
    }
}
```

## Output Program
### Menu Utama
![{8806B86F-1647-4807-8918-506A53F01C67}](https://github.com/user-attachments/assets/6b831e7e-3991-444f-9193-c03e0887f1c0)

Ketika pertama kali menjalankan kode maka akan muncul menu utama yang berisi Create, Read, Update, Delete, dan Exit.

### Menu Create
![{CFA24213-8D1B-4A8E-BF8E-9A94ACA55298}](https://github.com/user-attachments/assets/8a3783b6-5846-4255-93a4-6ce1595cfffa)

Ketika memasukkan angka 1 di menu utama akan muncul menu membuat data pesawat. Jika ID pesawat tidak ada di ArrayList maka akan muncul pesan untuk memasukkan nama pesawat dan kecepatan pesawat.

![{DAA7C803-2922-45DF-A7A6-FD7FB585FA8A}](https://github.com/user-attachments/assets/780d2d6b-4167-4109-a802-66441e3308bc)

Jika ID pesawat sudah di data sebelumnya maka akan muncul pesan ID tersebut sudah ada. User harus memasukkan ID yang tidak ada di data.

### Menu Read
![{AE0E7512-DC97-45D1-918D-E1198DEC417E}](https://github.com/user-attachments/assets/4ac589d1-e38e-4e33-b2e5-56d9e8111731)

Ketika memasukkan angka 2 di menu utama maka akan muncul daftar data pesawat.

### Menu Update
![{3AA6B3B8-B8CC-4FBC-B30D-FFA62FD3CAD0}](https://github.com/user-attachments/assets/f1571082-aaec-4a00-91f8-eca27734c83d)

![{824CC740-B6D6-4168-909A-6C68F254A5BC}](https://github.com/user-attachments/assets/151eaf8f-e1de-4f20-b999-393b5859cc52)

Ketika memasukkan angka 3 di menu utama maka akan muncul daftar data pesawat dan menu untuk memasukkan ID pesawat yang ingin diubah. Jika berhasil diubah maka akan muncul pesan data pesawat berhasil diubah.

![{68C17899-49A3-4703-BFD6-2C65807263E7}](https://github.com/user-attachments/assets/566dffa9-cea5-412b-b104-57a5c0417cf6)

Jika ID pesawat tidak ada, maka akan muncul pesan pesawat tidak ditemukan.

### Menu Delete
![{51A84AF9-5414-40C3-84FD-6B1ADCE6949C}](https://github.com/user-attachments/assets/9bdf60c3-e9c3-4868-ac8c-ab331698eb5e)

![{C58300FB-EE3B-4D0D-B8BE-9F194775D710}](https://github.com/user-attachments/assets/75e41e34-e77d-4cf5-ad11-07feab1f02bd)

Ketika memasukkan angka 4 di menu utama maka akan muncul daftar pesawat dan menu untuk memasukkan ID pesawat yang ingin dihapus. Jika berhasil dihapus maka akan muncul pesan data pesawat berhasil dihapus.

![{71F82621-24C3-4F78-8705-0F42BF5260EA}](https://github.com/user-attachments/assets/3b020b8a-233a-49f4-9068-82b0322ba28c)

Jika ID pesawat tidak ada, maka akan muncul pesan pesawat tidak ditemukan.

### Exit
![{1CC8FEEB-8541-4405-94FA-CABFB177035E}](https://github.com/user-attachments/assets/7e062d94-a076-4710-90e9-b5c790ca7ae9)

Masukkan angka 5 pada menu utama untuk keluar dari program.

