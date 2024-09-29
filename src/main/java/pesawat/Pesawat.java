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
