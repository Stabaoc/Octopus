package cn.chenhuanming.octopus.core;

import cn.chenhuanming.octopus.config.ConfigFactory;
import cn.chenhuanming.octopus.config.XMLConfigFactory;
import cn.chenhuanming.octopus.entity.Applicants;
import cn.chenhuanming.octopus.model.DefaultCellPosition;
import cn.chenhuanming.octopus.reader.DefaultSheetReader;
import cn.chenhuanming.octopus.reader.SheetReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author chenhuanming
 * Created at 2019-01-07
 */
public class FieldSheetReaderTest {

    private Sheet sheet;

    @Before
    public void prepare() throws IOException, InvalidFormatException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("export.xlsx");
        Workbook workbook = WorkbookFactory.create(is);
        this.sheet = workbook.getSheetAt(0);
    }

    @Test
    public void test() {
        ConfigFactory configFactory = new XMLConfigFactory(this.getClass().getClassLoader().getResourceAsStream("applicants.xml"));

        final SheetReader<Applicants> sheetReader = new DefaultSheetReader<>(sheet, configFactory.getConfig(), new DefaultCellPosition(2, 0));

        for (Applicants applicants : sheetReader) {
            System.out.println(applicants);
        }

    }

}