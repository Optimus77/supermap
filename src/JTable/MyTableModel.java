package JTable;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class MyTableModel extends DefaultTableModel {
    private final List<TableData> dataList;
    private final String[] columnNames = new String[]{"id", "名称", "值1", "值2", "值3", "总和", "评级"};

    public MyTableModel(List<TableData> dataList) {
        this.dataList = dataList;
    }

    @Override
    public int getRowCount() {
        return dataList != null ? dataList.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        TableData data = this.dataList.get(row);
        switch (column) {
            case 0: return data.getId();
            case 1: return data.getName();
            case 2: return data.getNum1();
            case 3: return data.getNum2();
            case 4: return data.getNum3();
            case 5: return data.getNum1() + data.getNum2() + data.getNum3();
            case 6: return (data.getNum1() + data.getNum2() + data.getNum3()) >= 150 ? "优" : "良";
            default: return super.getValueAt(row, column);
        }
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        TableData data = this.dataList.get(row);
        switch (column) {
            case 0: data.setId((int) aValue); break;
            case 1: data.setName((String) aValue); break;
            case 2: data.setNum1((int) aValue); break;
            case 3: data.setNum2((int) aValue); break;
            case 4: data.setNum3((int) aValue); break;
        }
        fireTableCellUpdated(row, column);
        // 更新总和和评级列
        fireTableCellUpdated(row, 5);
        fireTableCellUpdated(row, 6);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        // 只允许编辑前5列（id,名称,值1,值2,值3）
        return column < 5;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 1 || columnIndex == 6) {
            return String.class;
        }
        return Integer.class;
    }
}
