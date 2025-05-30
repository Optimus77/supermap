package CalculatorBase;

import javax.swing.*;
import java.awt.*;

public class CalculatorBase {
    //创建JFrame
    public JFrame frame = new JFrame("GridBagLayout Calculator");
    public StringBuilder input = new StringBuilder();
    public JTextField display = new JTextField();//单行文本框

    public static void main(String[] args) {
        new CalculatorBase();
    }

    public CalculatorBase() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1200);
        Container contentPane = frame.getContentPane(); // 获取真正的组件容器

        //创建一个 GridBagLayout 实例，并绑定到当前容器 frame.getContentPane()
        GridBagLayout layout = new GridBagLayout();
        contentPane.setLayout(layout);// contentPane的setLayout方法，设置布局layout

        // 显示区域
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 50));
        display.setHorizontalAlignment(JTextField.RIGHT);

        //设置JTextField（单行文本框）的布局参数
        frame.add(display,
                new GridBagConstraintsHelper(0, 0) //起始网格(0,0) ,也就是左上角网格
                        .setSize(4, 1) //水平方向占据4个单位，竖直方向占据1个单位
                        .setAnchor(GridBagConstraints.CENTER) //组件在网格中摆放的位置：上下左右全都居中
                        .setFill(GridBagConstraints.BOTH) //当组件在网格内不能撑满网格时，水平方向与竖直方向均拉伸
                        .setInsets(30, 30, 0, 0)//组件与网格的间隔
                        .setIpad(10, 40) //组件的内部填充，左右各加5px，上下各加5px
                        .setWeight(1, 1.5) //拉伸权重
        );

        // 按钮 - 只保留数字和=号
        String[] buttons = {
                "7", "8", "9",
                "4", "5", "6",
                "1", "2", "3",
                "0", "C", "="
        };

        int pos = 0;
        for (int row = 1; row <= 4; row++) {
            for (int col = 0; col < 3; col++) {
                if (pos >= buttons.length) break;
                String label = buttons[pos++];
                JButton button = new JButton(label);
                button.setFont(new Font("Arial", Font.BOLD, 70));

                //依次设置每个按钮的布局参数
                frame.add(button, new GridBagConstraintsHelper(col, row)
                        .setSize(1, 1)
                        .setAnchor(GridBagConstraints.CENTER)
                        .setFill(GridBagConstraints.BOTH)
                        .setInsets(20, 20, 0, 0)
                        .setWeight(1, 1)
                );
            }
        }

        frame.setVisible(true);
    }
}