package JTable;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * 自定义表格单元格渲染器
 * 控制单元格的显示方式和样式
 */
public class MyCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        // 调用父类方法获取默认渲染组件
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        //一定要恢复默认前景色，否则会污染下面的String类型的column。
        // 因为String类型的column用的是同一个MyCellRenderer（Swing的渲染器复用机制），刚才已经设置颜色了
        component.setForeground(table.getForeground());

        // 添加居中设置
        if (component instanceof JLabel) {
            ((JLabel) component).setHorizontalAlignment(JLabel.CENTER);
        }

        // 第3列(索引2)的特殊渲染（值为1时显示为复选框）（值为0时默认为下拉框）（其他情况使用默认文本框编辑器）
        if (column == 2 && value instanceof Integer) {
            int intValue = (Integer) value;
            if (intValue == 1) {
                JCheckBox checkBox = new JCheckBox(); // 创建复选框
                checkBox.setSelected(true); // 设置为选中状态
                // 设置背景色，如果被选中则使用选中背景色，否则使用青色
                checkBox.setBackground(isSelected ? table.getSelectionBackground() : Color.CYAN);
                checkBox.setHorizontalAlignment(JLabel.CENTER); // 居中对齐
                return checkBox; // 返回复选框组件
            }
        }

        // 第6列(索引5)的特殊样式
        if (column == 5) {
            int intValue = (int) value;
            JLabel jLabel = new JLabel();
            if (intValue >= 150) {
                jLabel.setText("优");
                jLabel.setForeground(Color.RED); // 优显示为红色
                jLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
                jLabel.setHorizontalAlignment(JLabel.CENTER);
                return jLabel;
            } else {
                jLabel.setText("良");
                jLabel.setForeground(Color.BLUE);// 良显示为蓝色
                jLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
                jLabel.setHorizontalAlignment(JLabel.CENTER);
                return jLabel;
            }
        }

        // 第7列(索引6)的特殊样式
        if (column == 6) {
            if ("优".equals(value)) {
                component.setForeground(Color.RED); // 优显示为红色
            } else if ("良".equals(value)){
                component.setForeground(Color.BLUE); // 良显示为蓝色
            }
        }

        // 针对分数列（语文、数学、英语），及格分60分以上显示粗体
        if (column >= 2 && column <= 4 && value instanceof Integer) {
            int score = (Integer) value;
            int style = score >= 60 ? Font.BOLD : Font.PLAIN; // 分数≥60加粗
            component.setFont(new Font("微软雅黑", style, 20));
        }

        return component; // 返回配置好的组件
    }
}