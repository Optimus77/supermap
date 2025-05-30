package JTable;

import javax.swing.*;
import java.awt.*;

/**
 * 自定义表格单元格编辑器
 * 控制单元格的编辑方式和行为
 */
public class MyCellEditor extends DefaultCellEditor {
    private final JTextField textField; // 文本编辑框
    private final JCheckBox checkBox;   // 复选框
    private final JComboBox<Integer> comboBox; // 下拉框
    private Component currentComponent; // 当前使用的编辑组件

    // +++ 添加记录当前编辑列的功能 +++
    private int editingColumn = -1;

    /**
     * 构造函数，初始化各种编辑器组件
     */
    public MyCellEditor() {
        super(new JTextField()); // 调用父类构造函数，默认使用文本框
        this.textField = new JTextField();
        this.checkBox = new JCheckBox();
        this.comboBox = new JComboBox<>(new Integer[]{0, 1, 2, 3}); // 初始化下拉框选项

        // 设置编辑器、下拉框的对齐方式
        this.textField.setHorizontalAlignment(JTextField.CENTER); // 文本框内容居中
        this.checkBox.setHorizontalAlignment(JCheckBox.CENTER);   // 复选框居中

        // 设置编辑器、下拉框的字体样式
        this.textField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        this.comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 20));
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        this.editingColumn = column; // 记录当前编辑的列索引

        // 根据列和值类型决定使用哪种编辑器
        if (column == 2 && value instanceof Integer) {
            int intValue = (Integer) value;
            if (intValue == 0) {
                // 值为0时使用下拉框编辑器
                comboBox.setSelectedItem(intValue);
                currentComponent = comboBox;
                return comboBox;
            } else if (intValue == 1) {
                // 值为1时使用复选框编辑器
                checkBox.setSelected(true);
                currentComponent = checkBox;
                return checkBox;
            }
        }

        // 默认使用文本框编辑器
        textField.setText(value != null ? value.toString() : "");
        currentComponent = textField;
        return textField;
    }

    @Override
    public Object getCellEditorValue() {
        // 根据当前使用的编辑器组件获取编辑后的值
        if (currentComponent == comboBox) {
            return comboBox.getSelectedItem(); // 从下拉框获取选中的值
        } else if (currentComponent == checkBox) {
            return checkBox.isSelected() ? 1 : 0; // 从复选框获取状态(1或0)
        } else if (currentComponent == textField) {
            // 需要根据当前编辑的列返回不同类型，否则修改名字会报错类型转换错误
            if (editingColumn == 1) { // 学生姓名列（索引1）
                return textField.getText(); // 直接返回字符串
            } else {
                try {
                    // 其他列返回整数
                    return Integer.parseInt(textField.getText());
                } catch (NumberFormatException e) {
                    return 0;
                }
            }
        }
        return super.getCellEditorValue();
    }
}