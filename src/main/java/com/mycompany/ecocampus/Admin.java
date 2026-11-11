package com.mycompany.ecocampus;

class Admin extends Pengguna{
    private String idAdmin;
    
    public Admin(String nama, String username, String password, String idAdmin){
        super(nama, username, password);
        this.idAdmin = idAdmin;
    }
    
    public String getIdAdmin(){
        return idAdmin;
    }
    
    public void setIdAdmin(String idAdmin){
        this.idAdmin = idAdmin;
    }
    
    public void lihatSemuaLaporan(){
        System.out.println("Menampilkan semua laporan sampah");
    }
    
    public void ubahStatusLaporan(){
        System.out.println("Admin memperbarui status laporan");
    }
}
