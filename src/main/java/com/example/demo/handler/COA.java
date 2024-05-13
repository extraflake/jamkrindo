package com.example.demo.handler;

import java.util.Map;

public class COA {
    public static String getCode(Map<String, Object> transaction) {
        Integer regionCode = Integer.parseInt(transaction.get("kode_wilayah_kerja").toString());
        Integer transactionType = Integer.parseInt(transaction.get("jenis transaksi").toString());
        Integer bankCode = Integer.parseInt(transaction.get("kode_bank").toString());
        Integer product = Integer.parseInt(transaction.get("lob").toString()) * 100 + (Integer.parseInt(transaction.get("kode_produk").toString()));
        Integer agentCode = Integer.parseInt(transaction.get("kode_agen").toString());

        String agent = (agentCode == 1) ? agentCode.toString() : "000";
        String entityCode = (regionCode == 3) ? "12345" : "54321";
        String costCenter = "001";
        String naturalAccount;
        if (transactionType == 1) {
            naturalAccount = (agentCode == 1) ? "12345ABC01" : "12345CBA05";
        } else {
            naturalAccount = (agentCode == 1) ? "54321DCBA01" : "54321DCBA05";
        }
        return entityCode + regionCode + costCenter + naturalAccount + bankCode.toString() + product.toString() + agent;
    }
}
