package cn.chenhuanming.octopus.reader;


import cn.chenhuanming.octopus.config.ConfigFactory;
import cn.chenhuanming.octopus.exception.SheetNotFoundException;
import cn.chenhuanming.octopus.model.CellPosition;

/**
 * @author chenhuanming
 * Created at 2019-01-09
 */
public interface ExcelReader<T> {
    SheetReader<T> get(int index, ConfigFactory configFactory, CellPosition startPoint) throws ArrayIndexOutOfBoundsException;

    SheetReader<T> get(String sheetName, ConfigFactory configFactory, CellPosition startPoint) throws SheetNotFoundException;
}
