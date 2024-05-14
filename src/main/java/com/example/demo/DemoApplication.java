package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.DTO.Journal;
import com.example.demo.handler.COA;
import com.example.demo.handler.Currency;
import com.example.demo.handler.CustomCalendar;
import com.example.demo.handler.Region;
import com.example.demo.model.Data;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        List<Map<String, Object>> dataTransaksi = Data.getTransactions();

        List<Journal> jurnalList = new ArrayList<>();
        for (Map<String, Object> transaksi : dataTransaksi) {
            Journal debetJurnal = new Journal();
            Journal kreditJurnal = new Journal();

            int jenisTransaksi = (int) transaksi.get("jenis transaksi");
            String nominal = Currency.get(transaksi);
            String tanggalJurnal = CustomCalendar.getLastDayOfMonth((String) transaksi.get("created_date"));

            debetJurnal.setWilayahKerja(Region.getRegion((int) transaksi.get("kode_wilayah_kerja")));
            kreditJurnal.setWilayahKerja(debetJurnal.getWilayahKerja());

            debetJurnal.setNominalDebet(nominal);
            debetJurnal.setNominalKredit("0");
            kreditJurnal.setNominalDebet("0");
            kreditJurnal.setNominalKredit(nominal);

            debetJurnal.setTanggalJurnal(tanggalJurnal);
            kreditJurnal.setTanggalJurnal(tanggalJurnal);

            debetJurnal.setKodeCOA(COA.getCode(transaksi, jenisTransaksi, true));
            kreditJurnal.setKodeCOA(COA.getCode(transaksi, jenisTransaksi, false));

            jurnalList.add(debetJurnal);
            jurnalList.add(kreditJurnal);
        }

        for (Journal journal : jurnalList) {
            System.out.println(journal.toString());
        }
    }
}
