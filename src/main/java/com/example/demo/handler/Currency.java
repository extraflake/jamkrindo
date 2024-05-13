package com.example.demo.handler;

import java.util.Map;

public class Currency {
    public static String get(Map<String, Object> transaksi) {
        String nominalStr = (String) transaksi.get("nominal");
        return nominalStr.replaceAll("\\D", "");
    }
}
