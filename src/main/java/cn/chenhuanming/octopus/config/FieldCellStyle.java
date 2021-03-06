package cn.chenhuanming.octopus.config;

import lombok.Builder;
import lombok.Data;
import org.apache.poi.ss.usermodel.BorderStyle;

import java.awt.*;

/**
 * cell style config of field
 * @author guangdao
 * Created at 2019-02-25
 */
@Data
@Builder
public class FieldCellStyle {
    private short fontSize;
    private java.awt.Color color;
    private boolean bold;
    private java.awt.Color foregroundColor;
    private BorderStyle[] border;
    private java.awt.Color[] borderColor;

    public static FieldCellStyle defaultCellStyle() {
        return builder()
                .fontSize((short) 14)
                .color(Color.BLACK)
                .bold(false)
                .foregroundColor(null)
                .border(null)
                .borderColor(null)
                .build();
    }

    public static FieldCellStyle defaultHeaderCellStyle() {
        return builder()
                .fontSize((short) 15)
                .color(Color.BLACK)
                .bold(true)
                .foregroundColor(null)
                .border(new BorderStyle[]{BorderStyle.THIN, BorderStyle.THIN, BorderStyle.THIN, BorderStyle.THIN})
                .borderColor(null)
                .build();
    }
}
