package CalculatorImpl;

import CalculatorBase.CalculatorBase;
import CalculatorBase.GridBagConstraintsHelper;
import CalculatorOperator.BasicOperator;
import CalculatorOperator.Operator;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

/**
 * 计算器操作实现类，继承自CalculatorBase
 *
 * 功能：
 * 1. 使用双栈(数字栈和运算符栈)
 * 2. 支持连续运算和表达式显示
 *
 * 主要属性：
 * 1.数字栈(numberStack): 存储待运算的数字
 * 2.运算符栈(operatorStack): 存储待运算的运算符
 * 3.当前表达式(currentExpression): 记录完整的运算表达式
 * 4.输入缓冲区(input): 继承自父类，记录当前输入的数字
 */
public class CalculatorOperation extends CalculatorBase {

    // 数字栈，用于存储运算数
    private final Stack<Double> numberStack = new Stack<>();

    // 运算符栈，用于存储运算符
    private final Stack<Operator> operatorStack = new Stack<>();

    // 当前运算表达式，（如 "1 + 2 * "），最后一位会append一个空格好看一些
    private final StringBuilder currentExpression = new StringBuilder();

    // 最近数字缓冲区，用于保存最近输入的连续数字，和currentExpression合在一起就是完整的文本框展示
    private final StringBuilder currentNumbers = new StringBuilder();

    /**
     * 主方法，程序入口
     */
    public static void main(String[] args) {
        new CalculatorOperation();
    }

    /**
     * 构造函数
     */
    public CalculatorOperation() {
        super();  // 调用父类构造函数初始化界面
        setupOperatorButtons();  // 设置运算符按钮（加减乘除）的布局 + 绑定事件执行规则
        setupControlButtons();   // 设置控制按钮(数字、等号、清除)的绑定事件执行规则
    }

    /**
     * 设置运算符按钮（加减乘除）(+,-,*,/)
     * 在界面右侧添加运算符按钮并绑定事件处理
     */
    private void setupOperatorButtons() {
        String[] operators = {"+", "-", "*", "/"};

        // 在网格的第4列(gridx = 3)，第2~5行（gridy = 1~4）添加运算符按钮
        for (int i = 0; i <= operators.length-1; i++) {
            JButton button = createButton(operators[i], 3, i + 1);
            // 为每个运算符按钮添加事件监听
            button.addActionListener(e -> handleOperatorInputEvent(button.getText().charAt(0)));
        }
    }

    /**
     * 设置控制按钮(数字、等号、清除)
     * 为继承自父类的按钮添加相应的事件处理
     */
    private void setupControlButtons() {
        // 遍历容器中的所有组件
        for (Component comp : frame.getContentPane().getComponents()) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                String text = button.getText();

                // 根据按钮文本设置不同的事件处理
                if ("=".equals(text)) {
                    // 等号按钮 - 计算结果
                    button.addActionListener(e -> handleCalculateResultEvent());
                } else if ("C".equals(text)) {
                    // 清除按钮 - 重置计算器状态
                    button.addActionListener(e -> handleClearAllEvent());
                } else if (!isOperator(text)) {
                    // 数字按钮 - 追加到最近数字缓冲区
                    button.addActionListener(e -> {
                        currentNumbers.append(text);
                        updateDisplay();
                    });
                }
            }
        }
    }

    /**
     */
    private JButton createButton(String text, int gridx, int gridy) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 70));

        // 使用GridBagConstraintsHelper设置按钮布局
        frame.add(button, new GridBagConstraintsHelper(gridx, gridy)
                .setSize(1, 1)
                .setAnchor(GridBagConstraints.CENTER)
                .setFill(GridBagConstraints.BOTH)
                .setInsets(20, 20, 0, 20)
                .setWeight(1, 1));
        return button;
    }

    /**
     * 此事件绑定在运算符按钮（加减乘除）的身上，每次输入运算符就会触发。用于处理运算符（加减乘除的）输入
     *
     * @param operatorChar 运算符字符(+, -, *, /)
     */
    private void handleOperatorInputEvent(char operatorChar) {
        // 将字符转换为对应的运算符枚举对象
        BasicOperator operator = BasicOperator.fromSymbol(operatorChar);

        // 如果最近数字缓冲区不为空，先压入数字栈，等稍后再处理输入的运算符
        if (!currentNumbers.toString().isEmpty()) {
            pushNumberStack(Double.parseDouble(currentNumbers.toString()));
            currentNumbers.setLength(0);  // 清空最近数字缓冲区
        }

        // 如果最近数字缓冲区为空，且如果当前表达式以运算符（加减乘除）结尾，则需要替换上一个运算符，因为不可以连续两个运算符挨着。
        // 此逻辑是为了防止用户连续输入两个运算符，比如1 + *（非法），这里给他强制忽略后一个运算符，变成 1 *
        else if (!currentExpression.toString().isEmpty() &&
                isOperator(currentExpression.charAt(currentExpression.length()-2))) {
            currentExpression.setLength(currentExpression.length()-3);
        }

        // 正式处理输入的运算符：将运算符添加到表达式并处理运算符
        currentExpression.append(operatorChar).append(" ");
        pushOperatorStack(operator);
        updateDisplay();
    }

    /**
     * 将数字压入数字栈（并更新表达式）
     *
     * @param number 要压入栈的数字
     */
    private void pushNumberStack(double number) {
        numberStack.push(number);  // 压入数字栈
        currentExpression.append(number).append(" ");  // 更新表达式显示
    }

    /**
     * 将运算符压入运算符栈（考虑运算符优先级）
     *
     * @param newOperator 新输入的运算符
     */
    private void pushOperatorStack(Operator newOperator) {
        // 如果此时栈顶运算符优先级大于等于即将入栈的新运算符时，先计算运算栈顶再说，使用while循环处理直到确保新入栈的运算符优先级最高
        while (!operatorStack.isEmpty() &&
                operatorStack.peek().getPriority() >= newOperator.getPriority()) {
            calculatorTop();
        }
        // 将新运算符压入运算符栈
        operatorStack.push(newOperator);
    }

    /**
     * 执行栈顶元素的运算（数字栈顶 + 运算符栈顶）
     * 从数字栈弹出两个数，从运算符栈弹出一个运算符，计算后将结果压回数字栈
     */
    private void calculatorTop() {
        // 检查是否有足够的运算数和运算符
        if (numberStack.size() < 2 || operatorStack.isEmpty()) {
            return;
        }

        // 弹出运算数和运算符(注意顺序:先弹出的是第二个运算数)
        double b = numberStack.pop();
        double a = numberStack.pop();
        Operator op = operatorStack.pop();

        try {
            // 执行运算并将结果压回数字栈
            double result = op.apply(a, b);
            numberStack.push(result);
        } catch (ArithmeticException e) {
            // 处理数学错误(如除以零)
            display.setText("Error");
            handleClearAllEvent();
        }
    }

    /**
     * 此事件绑定在 “等号 =”身上
     * 计算最终结果
     * 处理完所有输入后，计算栈中剩余的运算
     */
    private void handleCalculateResultEvent() {
        // 如果输入缓冲区还有数字，先压入栈
        if (!currentNumbers.toString().isEmpty()) {
            pushNumberStack(Double.parseDouble(currentNumbers.toString()));
            currentNumbers.setLength(0);
        }

        // 计算栈中剩余的所有运算
        while (!operatorStack.isEmpty()) {
            calculatorTop();
        }

        // 检查计算结果的有效性
        if (numberStack.size() != 1) {
            display.setText("Error");
            return;
        }

        // 获取完整表达式和结果
        String fullExpression = currentExpression.toString();
        double result = numberStack.pop();

        // 重置计算器状态并显示结果
        handleClearAllEvent();
        display.setText(fullExpression + "= " + result);
        currentNumbers.append(result);  // 将结果存入输入缓冲区以便继续运算
    }

    /**
     * 此事件绑定在 “清除号 C ”的身上
     * 清除所有计算状态
     * 重置输入缓冲区、表达式、数字栈和运算符栈
     */
    private void handleClearAllEvent() {
        currentNumbers.setLength(0);          // 清空输入缓冲区
        currentExpression.setLength(0); // 清空表达式
        numberStack.clear();          // 清空数字栈
        operatorStack.clear();        // 清空运算符栈
        display.setText("");          // 清空显示
    }

    /**
     * 更新显示内容
     * 将当前表达式和输入缓冲区内容合并显示
     */
    private void updateDisplay() {
        display.setText(currentExpression.toString() + currentNumbers.toString());
    }

    /**
     * 检查字符串是否是运算符
     *
     * @param text 要检查的字符串
     * @return 如果是运算符(+, -, *, /)返回true，否则false
     */
    private boolean isOperator(String text) {
        return text.matches("[+\\-*/]");
    }

    /**
     * 检查字符是否是运算符
     *
     * @param c 要检查的字符
     * @return 如果是运算符(+, -, *, /)返回true，否则false
     */
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}