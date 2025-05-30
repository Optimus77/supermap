package HomeWork;

import CalculatorBase.GridBagConstraintsHelper;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridBagLayout示例");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);

        Container contentPane = frame.getContentPane();
        GridBagLayout layout = new GridBagLayout();
        contentPane.setLayout(layout);

        // 创建5个示例组件
        JButton buttonA = createButton("A");
        JButton buttonB = createButton("B");
        JButton buttonC = createButton("C");
        JButton buttonD = createButton("D");
        JButton buttonE = createButton("E");
        JButton buttonF = createButton("F");
        JButton buttonG = createButton("G");
        JButton buttonH = createButton("H");

        frame.add(buttonA,
                new GridBagConstraintsHelper(0, 0,1,6) //起始网格 + 占据网格
                        .setAnchor(GridBagConstraints.WEST) //组件在网格中摆放的位置：
                        .setFill(GridBagConstraints.VERTICAL) //当组件在网格内不能撑满网格时，NONE、VERTICAL、HORIZONTAL、BOTH
                        .setInsets(GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP, GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP)//组件与网格的间隔
//                        .setIpad(400, 0) //组件的内部填充，
                        .setWeight(0, 6) //拉伸权重
        );

        frame.add(buttonB,
                new GridBagConstraintsHelper(1, 0,3,1) //起始网格 + 占据网格
                        .setAnchor(GridBagConstraints.NORTH) //组件在网格中摆放的位置：
                        .setFill(GridBagConstraints.HORIZONTAL) //当组件在网格内不能撑满网格时，NONE、VERTICAL、HORIZONTAL、BOTH
                        .setInsets(GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP, GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP)//组件与网格的间隔
//                        .setIpad(400, 0) //组件的内部填充，
                        .setWeight(3, 0) //拉伸权重
        );
        frame.add(buttonC,
                new GridBagConstraintsHelper(4, 0,1,6) //起始网格 + 占据网格
                        .setAnchor(GridBagConstraints.EAST) //组件在网格中摆放的位置：
                        .setFill(GridBagConstraints.VERTICAL) //当组件在网格内不能撑满网格时，NONE、VERTICAL、HORIZONTAL、BOTH
                        .setInsets(GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP, GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP)//组件与网格的间隔
//                        .setIpad(400, 0) //组件的内部填充，
                        .setWeight(0, 6) //拉伸权重
        );
        frame.add(buttonD,
                new GridBagConstraintsHelper(1, 1,1,4) //起始网格 + 占据网格
                        .setAnchor(GridBagConstraints.WEST) //组件在网格中摆放的位置：
                        .setFill(GridBagConstraints.VERTICAL) //当组件在网格内不能撑满网格时，NONE、VERTICAL、HORIZONTAL、BOTH
                        .setInsets(GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP, GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP)//组件与网格的间隔
//                        .setIpad(400, 0) //组件的内部填充，
                        .setWeight(0, 4) //拉伸权重
        );
        frame.add(buttonE,
                new GridBagConstraintsHelper(2, 1,1,1) //起始网格 + 占据网格
                        .setAnchor(GridBagConstraints.NORTH) //组件在网格中摆放的位置：
                        .setFill(GridBagConstraints.HORIZONTAL) //当组件在网格内不能撑满网格时，NONE、VERTICAL、HORIZONTAL、BOTH
                        .setInsets(GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP, GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP)//组件与网格的间隔
//                        .setIpad(400, 0) //组件的内部填充，
                        .setWeight(1, 0) //拉伸权重
        );
        frame.add(buttonF,
                new GridBagConstraintsHelper(3, 1,1,4) //起始网格 + 占据网格
                        .setAnchor(GridBagConstraints.EAST) //组件在网格中摆放的位置：
                        .setFill(GridBagConstraints.VERTICAL) //当组件在网格内不能撑满网格时，NONE、VERTICAL、HORIZONTAL、BOTH
                        .setInsets(GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP, GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP)//组件与网格的间隔
//                        .setIpad(400, 0) //组件的内部填充，
                        .setWeight(0, 4) //拉伸权重
        );
        frame.add(buttonG,
                new GridBagConstraintsHelper(2, 4,1,1) //起始网格 + 占据网格
                        .setAnchor(GridBagConstraints.SOUTH) //组件在网格中摆放的位置：
                        .setFill(GridBagConstraints.HORIZONTAL) //当组件在网格内不能撑满网格时，NONE、VERTICAL、HORIZONTAL、BOTH
                        .setInsets(GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP, GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP)//组件与网格的间隔
//                        .setIpad(400, 0) //组件的内部填充，
                        .setWeight(1, 0) //拉伸权重
        );
        frame.add(buttonH,
                new GridBagConstraintsHelper(1, 5,3,1) //起始网格 + 占据网格
                        .setAnchor(GridBagConstraints.SOUTH) //组件在网格中摆放的位置：
                        .setFill(GridBagConstraints.HORIZONTAL) //当组件在网格内不能撑满网格时，NONE、VERTICAL、HORIZONTAL、BOTH
                        .setInsets(GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP, GridBagConstraintsHelper.FRAME_CONTROL_GAP, GridBagConstraintsHelper.CONTROLS_GAP)//组件与网格的间隔
//                        .setIpad(400, 0) //组件的内部填充，
                        .setWeight(3, 0) //拉伸权重
        );

        frame.setVisible(true);
    }

    private static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        return button;
    }
}
