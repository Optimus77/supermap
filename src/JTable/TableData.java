package JTable;

import lombok.Data;

@Data
public class TableData {
    private int id;
    private String name;
    private int num1;
    private int num2;
    private int num3;

    public TableData(int id, String name, int num1, int num2, int num3) {
        this.id = id;
        this.name = name;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    // Getter和Setter方法
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getNum1() { return num1; }
    public void setNum1(int num1) { this.num1 = num1; }
    public int getNum2() { return num2; }
    public void setNum2(int num2) { this.num2 = num2; }
    public int getNum3() { return num3; }
    public void setNum3(int num3) { this.num3 = num3; }
}
