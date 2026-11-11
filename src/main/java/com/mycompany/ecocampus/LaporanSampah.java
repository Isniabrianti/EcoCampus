package com.mycompany.ecocampus;

class LaporanSampah {
    private int idLaporan;
    private String lokasi;
    private String jenisSampah;
    private String deskripsi;
    private String status;
    
    public LaporanSampah(int idLaporan, String lokasi, String jenisSampah, String deskripsi){
        this.idLaporan = idLaporan;
        this.lokasi = lokasi;
        this.jenisSampah = jenisSampah;
        this.deskripsi = deskripsi;
        this.status = "Menunggu Penanganan";
    }
    
    public int getIdLaporan(){
        return idLaporan;
    }
    
    public String getLokasi(){
        return lokasi;
    }
    
    public String getJenisSampah(){
        return jenisSampah;
    }
    
    public String getDeskripsi(){
        return deskripsi;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setIdLaporan(int idLaporan){
        this.idLaporan = idLaporan;
    }
    
    public void setLokasi(String lokasi){
        this.lokasi = lokasi;
    }
    
    public void setJenisSampah(String jenisSampah){
        this.jenisSampah = jenisSampah;
    }
    
    public void setDeskripsi(String deskripsi){
        this.deskripsi = deskripsi;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public void tampilkanLaporan(){
        System.out.println("ID Laporan: " + idLaporan);
        System.out.println("Lokasi: " + lokasi);
        System.out.println("Jenis Sampah: " + jenisSampah);
        System.out.println("Deskripsi: " + deskripsi);
        System.out.println("Status " + status);
    }
}
