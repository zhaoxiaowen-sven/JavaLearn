package design.bridge.demo2;

public class ExcelDataCollect implements DataCollect{

    private ExcelRead excelRead;

    public ExcelDataCollect(){
        excelRead = new ExcelRead();
    }

    @Override
    public Data collectData() {
        return new Data("ExcelDataCollect " + excelRead.readExcel());//(excelRead.readExcel());
    }
}
