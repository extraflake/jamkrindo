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

        List<Map<String, Object>> transactions = Data.getTransactions();

        List<Journal> journalList = new ArrayList<>();
        for (Map<String, Object> transaction : transactions) {
            Journal journal = new Journal();
            journal.setWilayahKerja(Region.getRegion((int) transaction.get("kode_wilayah_kerja")));
            journal.setTanggalJurnal(CustomCalendar.getLastDayOfMonth((String) transaction.get("created_date")));
            journal.setKodeCOA(COA.getCode(transaction));
            journal.setNominalDebet(Currency.get(transaction));
            journal.setNominalKredit(Currency.get(transaction));
            journalList.add(journal);
        }

        for (Journal journal : journalList) {
            System.out.println(journal.toString());
        }
    }
}
