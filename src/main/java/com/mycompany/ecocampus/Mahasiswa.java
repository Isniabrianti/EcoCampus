package com.mycompany.ecocampus;

class Mahasiswa extends Pengguna{
    private String npm;
    
    public Mahasiswa(String nama, String username, String password, String npm){
        super(nama, username, password);
        this.npm = npm;
    }
    
    public String getNpm(){
        return npm;
    }
    
    public void setNpm(String npm){
        this.npm = npm;
    }
    
    public void buatLaporan(){
        System.out.println("Mahasiswa membuat laporan sampah");
    }
    
    public void lihatLaporan(){
        System.out.println("Menampilkan laporan mahasiswa");
    }
}
