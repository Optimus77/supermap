package HomeWork;

import CalculatorBase.GridBagConstraintsHelper;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutHomework {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridBagLayout示例");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        Container contentPane = frame.getContentPane();
        GridBagLayout layout = new GridBagLayout();
        contentPane.setLayout(layout);

        // 创建5个示例组件
        JButton buttonA = createButton("A");
        JButton buttonB = createButton("B");
        JButton buttonC = createButton("C");
        JButton buttonD = createButton("D");
        JButton buttonE = createButton("E");

        frame.add(buttonA,
                new GridBagConstraintsHelper(0, 0,1,1) //起始网格
//                        .setSize(39, 1) //水平方向占据，竖直方向占据
                        .setAnchor(GridBagConstraints.WEST) //组件在网格中摆放的位置：上下左右全都居中
                        .setFill(GridBagConstraints.HORIZONTAL) //当组件在网格内不能撑满网格时，水平方向与竖直方向均拉伸
                        .setInsets(100, GridBagConstraintsHelper.CONTROLS_GAP, GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP)//组件与网格的间隔
//                        .setIpad(400, 0) //组件的内部填充，
                        .setWeight(2, 0) //拉伸权重
        );
        frame.add(buttonB,
                new GridBagConstraintsHelper(1,0,1,1) //起始网格
//                        .setSize(10, 1) //水平方向占据，竖直方向占据
                        .setAnchor(GridBagConstraints.EAST) //组件在网格中摆放的位置：上下左右全都居中
                        .setFill(GridBagConstraints.HORIZONTAL) //当组件在网格内不能撑满网格时，水平方向与竖直方向均拉伸
                        .setInsets(100, GridBagConstraintsHelper.CONTROLS_GAP, GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP)//组件与网格的间隔
//                        .setIpad(100, 0) //组件的内部填充
                        .setWeight(1, 0) //拉伸权重
        );
        frame.add(buttonC,
                new GridBagConstraintsHelper(0, 1,1,1) //起始网格
//                        .setSize(39, 1) //水平方向占据，竖直方向占据
                        .setAnchor(GridBagConstraints.WEST) //组件在网格中摆放的位置：上下左右全都居中
                        .setFill(GridBagConstraints.HORIZONTAL) //当组件在网格内不能撑满网格时，水平方向与竖直方向均拉伸
                        .setInsets(GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP, GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP)//组件与网格的间隔
//                        .setIpad(400, 0) //组件的内部填充，
                        .setWeight(2, 0) //拉伸权重
        );
        frame.add(buttonD,
                new GridBagConstraintsHelper(1, 1,0,3) //起始网格
//                        .setSize(1, 6) //水平方向占据，竖直方向占据
                        .setAnchor(GridBagConstraints.CENTER) //组件在网格中摆放的位置：上下左右全都居中
                        .setFill(GridBagConstraints.VERTICAL) //当组件在网格内不能撑满网格时，水平方向与竖直方向均拉伸
                        .setInsets(GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP, GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP)//组件与网格的间隔
//                        .setIpad(0, 100) //组件的内部填充，左右各加5px，上下各加5px
                        .setWeight(1, 4) //拉伸权重
        );
       frame.add(buttonE,
               new GridBagConstraintsHelper(0, 4,1,2) //起始网格
//                        .setSize(39, 1) //水平方向占据，竖直方向占据
                       .setAnchor(GridBagConstraints.WEST) //组件在网格中摆放的位置：上下左右全都居中
                       .setFill(GridBagConstraints.BOTH) //当组件在网格内不能撑满网格时，水平方向与竖直方向均拉伸
                       .setInsets(10, GridBagConstraintsHelper.CONTROLS_GAP, GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP)//组件与网格的间隔
//                        .setIpad(400, 0) //组件的内部填充，
                       .setWeight(2, 1) //拉伸权重
       );
        frame.setVisible(true);
    }

    private static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        return button;
    }

//    private static JLabel createLabel(String text) {
//        JLabel label = new JLabel(text, SwingConstants.CENTER);
//        label.setFont(new Font("Arial", Font.BOLD, 24));
//        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        label.setPreferredSize(new Dimension(100, 50));
//        return label;
//    }




}