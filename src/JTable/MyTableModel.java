package JTable;

import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * 自定义表格模型，继承DefaultTableModel
 * 负责管理表格数据、列定义和数据操作
 */
public class MyTableModel extends DefaultTableModel {
    private final List<TableData> dataList; // 存储表格数据的列表
    private final String[] columnNames = new String[]{
            "id",
            "学生名称",
            "语文分数",
            "数学分数",
            "英语分数",
            "总分",
            "评级"};

    /**
     * 构造函数，初始化表格模型
     * @param dataList 表格数据列表
     */
    public MyTableModel(List<TableData> dataList) {
        this.dataList = dataList;
    }

    /**
     * 重写getRowCount()方法，获取到JTable表格的行数
     * @return
     */
    @Override
    public int getRowCount() {
        return dataList != null ? dataList.size() : 0; // 返回数据行数
    }

    /**
     * 根据创建好的列名，重写getColumnCount()方法，获取到JTable表格的列数
     */
    @Override
    public int getColumnCount() {
        return columnNames.length; // 返回列数
    }

    /**
     * 重写getColumnName(int column)方法，定义列名
     */
    @Override
    public String getColumnName(int column) {
        return columnNames[column]; // 返回指定列的名称
    }

    /**
     * 重写getValueAt(int row, int column)，JTable打开时会通过该方法取
     */
    @Override
    public Object getValueAt(int row, int column) {
        TableData data = this.dataList.get(row); // 获取指定行的数据对象
        switch (column) {
            case 0: return data.getId(); // 返回id
            case 1: return data.getName(); // 返回名称
            case 2: return data.getChineseScore(); // 返回语文分数
            case 3: return data.getMathScore(); // 返回数学分数
            case 4: return data.getEnglishScore(); // 返回英文分数
            case 5: return data.getChineseScore() + data.getMathScore() + data.getEnglishScore(); // 计算并返回总分
            case 6: return (data.getChineseScore() + data.getMathScore() + data.getEnglishScore()) >= 150 ? "优" : "良"; // 根据总和返回评级
            default: return super.getValueAt(row, column);
        }
    }

    /**
     * 重写setValueAt(Object aValue, int row, int column)方法，在修改值后会进行调用
     */
    @Override
    public void setValueAt(Object aValue, int row, int column) {
        TableData data = this.dataList.get(row); // 获取要修改的行数据
        switch (column) {
            case 0: data.setId((int) aValue); break; // 设置id
            case 1: data.setName((String) aValue); break; // 设置名称
            case 2: data.setChineseScore((int) aValue); break; // 设置语文分数
            case 3: data.setMathScore((int) aValue); break; // 设置数学分数
            case 4: data.setEnglishScore((int) aValue); break; // 设置英文分数
        }
        fireTableCellUpdated(row, column); // 通知表格单元格已更新
        // 更新总和和评级列
        fireTableCellUpdated(row, 5);
        fireTableCellUpdated(row, 6);
    }

    /**
     * 强制规定只允许编辑前5列
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        // 只允许编辑前5列（id,名称,值1,值2,值3）
        // 总和和评级列是计算得出的，不允许直接编辑
        return column < 5 && column >= 1;
    }

    /**
     * 设置每一列的类型，可以设置不同列有不同的类型，从而根据列类型设置渲染器和编辑器
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // 指定列的数据类型，影响渲染器和编辑器的选择
        if (columnIndex == 1 || columnIndex == 6) {
            return String.class; // 名称和评级列是字符串类型
        }
        return Integer.class; // 其他列是整数类型
    }
}