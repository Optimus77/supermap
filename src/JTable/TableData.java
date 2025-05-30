package JTable;

import lombok.Data;

@Data
public class TableData {
    private int id;
    private String name;
    private int chineseScore;
    private int mathScore;
    private int englishScore;

    public TableData(int id, String name, int chineseScore, int mathScore, int englishScore) {
        this.id = id;
        this.name = name;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getChineseScore() { return chineseScore; }
    public void setChineseScore(int chineseScore) { this.chineseScore = chineseScore; }
    public int getMathScore() { return mathScore; }
    public void setMathScore(int mathScore) { this.mathScore = mathScore; }
    public int getEnglishScore() { return englishScore; }
    public void setEnglishScore(int englishScore) { this.englishScore = englishScore; }
}