package JTable;

import javax.swing.*;
import java.awt.*;

public class MyCellEditor extends DefaultCellEditor {
    private final JTextField textField;
    private final JCheckBox checkBox;
    private final JComboBox<Integer> comboBox;
    private Component currentComponent;

    public MyCellEditor() {
        super(new JTextField());
        this.textField = new JTextField();
        this.checkBox = new JCheckBox();
        this.comboBox = new JComboBox<>(new Integer[]{0, 1, 2, 3});

        // 设置编辑器
        this.textField.setHorizontalAlignment(JTextField.CENTER);
        this.checkBox.setHorizontalAlignment(JCheckBox.CENTER);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        // 根据列和值类型决定使用哪种编辑器
        if (column == 2 && value instanceof Integer) {
            int intValue = (Integer) value;
            if (intValue == 0) {
                comboBox.setSelectedItem(intValue);
                currentComponent = comboBox;
                return comboBox;
            } else if (intValue == 1) {
                checkBox.setSelected(true);
                currentComponent = checkBox;
                return checkBox;
            }
        }

        // 默认使用文本框
        textField.setText(value != null ? value.toString() : "");
        currentComponent = textField;
        return textField;
    }

    @Override
    public Object getCellEditorValue() {
        if (currentComponent == comboBox) {
            return comboBox.getSelectedItem();
        } else if (currentComponent == checkBox) {
            return checkBox.isSelected() ? 1 : 0;
        } else if (currentComponent == textField) {
            try {
                return Integer.parseInt(textField.getText());
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return super.getCellEditorValue();
    }
}
