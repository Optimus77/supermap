package JTable;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class MyCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // 评级列特殊样式
        if (column == 6) {
            if ("优".equals(value)) {
                component.setForeground(Color.RED);
                component.setFont(component.getFont().deriveFont(Font.BOLD));
            } else {
                component.setForeground(Color.BLUE);
            }
        }

        // 值1列的特殊渲染（值为1时显示为复选框）
        if (column == 2 && value instanceof Integer) {
            int intValue = (Integer) value;
            if (intValue == 1) {
                JCheckBox checkBox = new JCheckBox();
                checkBox.setSelected(true);
                checkBox.setBackground(isSelected ? table.getSelectionBackground() : Color.CYAN);
                checkBox.setHorizontalAlignment(JLabel.CENTER);
                return checkBox;
            }
        }

        // 其他单元格居中显示
        if (component instanceof JLabel) {
            ((JLabel) component).setHorizontalAlignment(JLabel.CENTER);
        }

        return component;
    }
}
