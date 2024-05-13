package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
    public static List<Map<String, Object>> getTransactions() {
        List<Map<String, Object>> transactions = new ArrayList<>();
        Map<String, Object> transaction1 = new HashMap<>();
        transaction1.put("id_transaksi", 150130);
        transaction1.put("kode_wilayah_kerja", 3);
        transaction1.put("kode_produk", 30);
        transaction1.put("kode_bank", 567);
        transaction1.put("lob", 3);
        transaction1.put("kode_agen", 1);
        transaction1.put("jenis transaksi", 1);
        transaction1.put("id_dd_reas", 2);
        transaction1.put("nominal", "Rp. 12.500.000");
        transaction1.put("created_date", "2024-05-02");
        transaction1.put("created_by", 661);

        Map<String, Object> transaction2 = new HashMap<>();
        transaction2.put("id_transaksi", 150131);
        transaction2.put("kode_wilayah_kerja", 1);
        transaction2.put("kode_produk", 30);
        transaction2.put("kode_bank", 567);
        transaction2.put("lob", 3);
        transaction2.put("kode_agen", 0);
        transaction2.put("jenis transaksi", 2);
        transaction2.put("id_dd_reas", null);
        transaction2.put("nominal", "Rp. 5.000.000");
        transaction2.put("created_date", "2024-05-02");
        transaction2.put("created_by", 661);

        transactions.add(transaction1);
        transactions.add(transaction2);
        return transactions;
    }
}