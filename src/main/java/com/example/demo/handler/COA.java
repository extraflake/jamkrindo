package com.example.demo.handler;

import java.util.Map;

public class COA {
    public static String getCode(Map<String, Object> transaction, int transactionType, boolean isDebet) {
        Integer regionCode = Integer.parseInt(transaction.get("kode_wilayah_kerja").toString());
        Integer bankCode = Integer.parseInt(transaction.get("kode_bank").toString());
        Integer product = Integer.parseInt(transaction.get("lob").toString()) * 100 + (Integer.parseInt(transaction.get("kode_produk").toString()));
        Integer agentCode = Integer.parseInt(transaction.get("kode_agen").toString());

        String entityCode = (regionCode == 3) ? "12345" : "54321";
        String costCenter = "001";
        String naturalAccount;
        if (transactionType == 1) { // Penjaminan
            naturalAccount = isDebet ? "ABC01" : "CBA05";
        } else { // Klaim
            naturalAccount = isDebet ? "DCBA01" : "ABCD05";
        }

        return entityCode + regionCode + costCenter + naturalAccount + bankCode.toString() + product.toString() + agentCode;
    }
}
