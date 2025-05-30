package JTable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JTableDemo {

    public static void main(String[] args) {
        new JTableDemo();
    }

    public JTableDemo() {
        // 创建主窗口
        JFrame frame = new JFrame("JTable Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭时退出程序
        frame.setSize(800, 600); // 设置窗口大小

        // 创建表格数据 - 初始化6条示例数据
        List<TableData> tableDataList = new ArrayList<>();
        tableDataList.add(new TableData(1, "学生1", 1, 36, 85));
        tableDataList.add(new TableData(2, "学生2", 2, 32, 98));
        tableDataList.add(new TableData(3, "学生3", 3, 65, 87));
        tableDataList.add(new TableData(4, "学生4", 0, 65, 95));
        tableDataList.add(new TableData(5, "学生5", 1, 68, 35));
        tableDataList.add(new TableData(6, "学生6", 2, 8, 1));
        tableDataList.add(new TableData(7, "学生7", 11, 22, 33));
        tableDataList.add(new TableData(8, "学生8", 44, 55, 66));
        tableDataList.add(new TableData(9, "学生9", 77, 88, 99));

        // 创建TableModel（同时将数据列表传入TableModel）
        MyTableModel tableModel = new MyTableModel(tableDataList);

        // 创建JTable（同时将TableModel传入JTable）
        JTable table = new JTable(tableModel);

        // 设置表头部分的高度和字体
        table.getTableHeader().setPreferredSize(new Dimension(table.getWidth(), 70));
        table.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 20));

        // 设置表格主体部分的行高和字体
        table.setRowHeight(70);
        table.setFont(new Font("微软雅黑", Font.BOLD, 20));

        // 设置自定义渲染器（控制单元格显示方式）
        table.setDefaultRenderer(Integer.class, new MyCellRenderer());
        table.setDefaultRenderer(String.class, new MyCellRenderer());

        // 设置自定义编辑器（控制单元格编辑方式）
        table.setDefaultEditor(Integer.class, new MyCellEditor());
        table.setDefaultEditor(String.class, new MyCellEditor());

        // 将表格放入滚动面板（JScrollPane 不仅提供滚动功能，还会自动包含表格的标题行）
        JScrollPane scrollPane = new JScrollPane(table);

        // 添加到窗口中心位置
        frame.add(scrollPane, BorderLayout.CENTER);

        // 显示窗口
        frame.setVisible(true);
    }
}