package com.example.demo.DTO;

public class Journal {
    private String wilayahKerja;
    private String kodeCOA;
    private String nominalDebet;
    private String nominalKredit;
    private String tanggalJurnal;

    @Override
    public String toString() {
        return "Journal [wilayahKerja=" + wilayahKerja + ", kodeCOA=" + kodeCOA + ", nominalDebet=" + nominalDebet
                + ", nominalKredit=" + nominalKredit + ", tanggalJurnal=" + tanggalJurnal + "]";
    }

    public String getWilayahKerja() {
        return wilayahKerja;
    }

    public void setWilayahKerja(String wilayahKerja) {
        this.wilayahKerja = wilayahKerja;
    }

    public String getKodeCOA() {
        return kodeCOA;
    }

    public void setKodeCOA(String kodeCOA) {
        this.kodeCOA = kodeCOA;
    }

    public String getNominalDebet() {
        return nominalDebet;
    }

    public void setNominalDebet(String nominalDebet) {
        this.nominalDebet = nominalDebet;
    }

    public String getNominalKredit() {
        return nominalKredit;
    }

    public void setNominalKredit(String nominalKredit) {
        this.nominalKredit = nominalKredit;
    }

    public String getTanggalJurnal() {
        return tanggalJurnal;
    }

    public void setTanggalJurnal(String tanggalJurnal) {
        this.tanggalJurnal = tanggalJurnal;
    }
}
