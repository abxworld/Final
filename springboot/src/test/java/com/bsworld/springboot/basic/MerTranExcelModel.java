package com.bsworld.springboot.basic;
/*
*author: xieziyang
*date: 2018/8/17
*time: 13:53
*description:
*/

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

public class MerTranExcelModel {
    private static final ConcurrentHashMap<String, Integer> indexHashMap = new ConcurrentHashMap<>(32);
    private static final ConcurrentHashMap<String, String> mappingHashMap = new ConcurrentHashMap<>(32);

    static {
        injectIndex();
        injectMapping();
    }

    private static void injectIndex() {
        Class<MerTranExcelModel> aClass = MerTranExcelModel.class;
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            if ("indexHashMap".equals(field.getName()) || "mappingHashMap".equals(field.getName())) {
                continue;
            }
            try {
                field.setAccessible(true);
                indexHashMap.put(String.valueOf(field.get(aClass)), 0);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private static void injectMapping() {
        mappingHashMap.put(BeneficiaryName, "accountHolderName");
        mappingHashMap.put(BeneficiaryAccount, "accountNumber");
        mappingHashMap.put(BankCountry, "countryAbName");
        mappingHashMap.put(BeneficiaryAddress, "benefiAddress");
        mappingHashMap.put(BankName, "bankName");
        mappingHashMap.put(BankAddress, "bankAddress");
        mappingHashMap.put(Currency, "payCurrencyCode");
        mappingHashMap.put(Amount, "amount");
        mappingHashMap.put(BankCity, "benefiCity");
        mappingHashMap.put(BankCodeType, "bankCodeType");
        mappingHashMap.put(BankCode, "bankCodeValue");
        mappingHashMap.put(BIC_SWIFT_Code, "swiftBic");
        mappingHashMap.put(Comment, "description");
    }

    //Excel表格的字段
    private final static String BeneficiaryName = "BeneficiaryName";
    private final static String BeneficiaryAccount = "BeneficiaryAccount";
    private final static String BankCountry = "BankCountry";
    private final static String BeneficiaryAddress = "BeneficiaryAddress";
    private final static String BankName = "BankName";
    private final static String BankAddress = "BankAddress";
    private final static String Currency = "Currency";
    private final static String Amount = "Amount";
    private final static String BankCity = "BankCity";
    private final static String BankCodeType = "BankCodeType";
    private final static String BankCode = "BankCode";
    private final static String BIC_SWIFT_Code = "BIC/SWIFT Code";
    private final static String Comment = "Comment";
    //*作为excel读取标识，如果该列下没有序号则停止读取
    public final static String SerialNum = "SerialNum";

    public static ConcurrentHashMap<String, Integer> getIndexHashMap() {
        return indexHashMap;
    }

    public static ConcurrentHashMap<String, String> getMappingHashMap() {
        return mappingHashMap;
    }
}
