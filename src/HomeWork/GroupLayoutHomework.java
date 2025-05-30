package HomeWork;

import javax.swing.*;
import java.awt.*;

public class GroupLayoutHomework {

    JLabel labelUser = new JLabel("User");
    JLabel labelPass = new JLabel("Password");

    JTextArea textUser = new JTextArea("User");
    JTextArea textPass = new JTextArea("Password");

    JButton buttonOK = new JButton("OK");
    JButton buttonCancel = new JButton("Cancel");

    public GroupLayoutHomework() {
        JFrame frame = new JFrame("HomeWork.GroupLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        Container contentPane = frame.getContentPane(); // 获取真正的组件容器

        GroupLayout layout = new GroupLayout(contentPane);// 用内容面板作为容器
        layout.setAutoCreateContainerGaps(true);//自动在组件和容器边缘之间添加间距。
        layout.setAutoCreateGaps(true);//自动在组件之间添加间距。

        contentPane.setLayout(layout);// 获取真正的组件容器，并设置布局layout

        layout.setHorizontalGroup(layout.createSequentialGroup() //创建一个顺序排列的组(SequentialGroup)（从左到右布局组件），表示组件按顺序排列
                .addGroup(layout.createParallelGroup() //在顺序组中添加一个并行组(ParallelGroup)，表示组内组件垂直方向对齐

                        //标签部分 + 文本框部分
                        .addGroup(layout.createSequentialGroup() //先创建一个顺序组（按行排布）
                                //标签部分（用户名和密码标签）：
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) //包含一个垂直方向对齐的组（labelUser 和 labelPass 组件左对齐（LEADING））。
                                        .addComponent(labelUser)
                                        .addComponent(labelPass))
                                //文本框部分（用户名和密码文本框）：
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING) //包含一个垂直方向对齐的组（textUser 和 textPass 组件左对齐（LEADING））
                                        //最小尺寸：使用系统默认(DEFAULT_SIZE)、
                                        //首选尺寸：根据组件内容自动决定（PREFERRED_SIZE），组件会按照自己的理想大小排布（不拉伸）
                                        //最大尺寸：允许尽可能扩展（Integer.MAX_VALUE）
                                        //意思是：这些文本框会根据内容自适应宽度，但在空间足够的情况下，会自动扩展到最大宽度。
                                        .addComponent(textUser, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
                                        .addComponent(textPass, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE))

                                //按钮部分：
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, Integer.MAX_VALUE) //提供一个弹性间隔（用于将按钮推到右侧），最小 5，首选 5，最大不限（尽可能右对齐按钮）。
                                        .addComponent(buttonOK) //添加 OK 按钮。
                                        .addComponent(buttonCancel))))); //添加Cancel 按钮。

        layout.setVerticalGroup(layout.createSequentialGroup()
                //标签部分（用户名和密码标签）：
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)//水平方向并排放置 labelUser 和 textUser，垂直方向居中对齐。
                        //最小尺寸：根据组件内容自动决定（PREFERRED_SIZE），组件会按照自己的理想大小排布（不拉伸）
                        //首选尺寸：根据组件内容自动决定（PREFERRED_SIZE），组件会按照自己的理想大小排布（不拉伸）
                        //最大尺寸：根据组件内容自动决定（PREFERRED_SIZE），组件会按照自己的理想大小排布（不拉伸）
                        //意思是：这些文本框会根据内容自适应宽度，但在空间足够的情况下，会自动扩展到最大宽度。
                        .addComponent(labelPass)
                        .addComponent(textPass, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))

                //文本框部分（用户名和密码文本框）：
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        //同上自适应
                        .addComponent(labelUser)
                        .addComponent(textUser, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))

                //按钮部分：
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)//将按钮放在一行中，并水平排列。
                        .addComponent(buttonOK)
                        .addComponent(buttonCancel)));

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GroupLayoutHomework();
    }
}
