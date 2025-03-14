package io.loop.utilities;

public class TestExcel {
    public static void main(String[] args) {
        ExcelUtils excelUtils = new ExcelUtils("C:\\Users\\udasc\\IdeaProjects\\cucumber-project-b4\\src\\test\\resources\\Book1.xlsx","Sheet1");
        System.out.println("exceLUtils.getCellData(1,1) = " + excelUtils.getCellData(0,0));

        excelUtils.setCellData("this is a testsjb",3,4);
    }
}
