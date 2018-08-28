package com.bsworld.springboot.basic;
/*
*author: xieziyang
*date: 2018/8/15
*time: 17:27
*description:
* 付款excel读取
*/

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ExcelUtil {
    private static final ConcurrentHashMap<String, Integer> indexHashMap = MerTranExcelModel.getIndexHashMap();
    private static final ConcurrentHashMap<String, String> mappingHashMap = MerTranExcelModel.getMappingHashMap();

    public static List<MerTransferModel> parse0(byte[] bytes) {
        /*存储每一条记录的数据*/
        List<MerTransferModel> entityList = new ArrayList<>(64);
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(bis);
            for (Sheet sheet : workbook) {
                if (sheet == null) {
                    continue;
                }
                int rowIndex = 0;
                int columnIndex = 0;//记录获取到相应列表名称时的行数
                boolean flag = false;
                for (Row row : sheet) {
                    if (row == null) {
                        rowIndex++;
                        continue;
                    }
                    int i = 0;
                    if (!flag) {
                        for (Cell cell : row) {
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            String value = cell.getStringCellValue();
                            if (indexHashMap.containsKey(value)) {
                                indexHashMap.put(value, i);
                                if (MerTranExcelModel.SerialNum.equals(value)) {
                                    flag = true;
                                    columnIndex = rowIndex;
                                }
                            }
                            i++;
                        }
                    }
                    boolean confition = rowIndex > columnIndex && flag;
                    if (confition) {
                        Cell seriAlNumCell = row.getCell(indexHashMap.get(MerTranExcelModel.SerialNum));
                        if (seriAlNumCell != null) {
                            seriAlNumCell.setCellType(Cell.CELL_TYPE_STRING);
                            String cellValue = seriAlNumCell.getStringCellValue();
                            if (cellValue == null || "".equals(cellValue.trim())) {
                                break;
                            }
                        } else {
                            break;
                        }
                        Set<Map.Entry<String, Integer>> entries = indexHashMap.entrySet();
                        MerTransferModel model = new MerTransferModel();
                        Class<? extends MerTransferModel> aClass = model.getClass();
                        for (Map.Entry<String, Integer> entry : entries) {
                            String name = entry.getKey();
                            Integer index = entry.getValue();
                            Cell cell = row.getCell(index);
                            if (cell != null) {
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                String entityName = mappingHashMap.get(name);
                                if (entityName != null && entityName.trim() != "") {
                                    try {
                                        String fieldName = "";
                                        if (entityName.length() > 1) {
                                            String substring0 = entityName.substring(0, 1).toUpperCase();
                                            String substring1 = entityName.substring(1);
                                            fieldName = substring0 + substring1;
                                        } else {
                                            fieldName = entityName.toUpperCase();
                                        }
                                        Method method = aClass.getMethod("set" + fieldName, String.class);
                                        method.invoke(model, cell.getStringCellValue());
                                    } catch (NoSuchMethodException e) {
                                        e.printStackTrace();
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    } catch (InvocationTargetException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        entityList.add(model);
                    }
                    rowIndex++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entityList;
    }

    public static ConcurrentHashMap<String, Integer> getIndexHashMap() {
        return indexHashMap;
    }
}
