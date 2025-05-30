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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // 创建表格数据
        List<TableData> tableDataList = new ArrayList<>();
        tableDataList.add(new TableData(0, "name1", 1, 36, 85));
        tableDataList.add(new TableData(1, "name2", 2, 32, 98));
        tableDataList.add(new TableData(2, "name3", 3, 65, 87));
        tableDataList.add(new TableData(3, "name4", 0, 65, 95));
        tableDataList.add(new TableData(4, "name5", 1, 68, 35));
        tableDataList.add(new TableData(5, "name6", 2, 8, 1));

        // 创建自定义TableModel
        MyTableModel tableModel = new MyTableModel(tableDataList);

        // 创建JTable并设置模型
        JTable table = new JTable(tableModel);
        table.getTableHeader().setPreferredSize(new Dimension(table.getWidth(), 70));
        table.setRowHeight(70);
        table.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 20));
        table.setFont(new Font("微软雅黑", Font.BOLD, 20));

        // 设置自定义渲染器
        table.setDefaultRenderer(Integer.class, new MyCellRenderer());

        // 设置自定义编辑器
        table.setDefaultEditor(Integer.class, new MyCellEditor());

        // 将表格放入滚动面板
        JScrollPane scrollPane = new JScrollPane(table);

        // 添加到窗口
        frame.add(scrollPane, BorderLayout.CENTER);

        // 显示窗口
        frame.setVisible(true);

    }

}
