package org.example;

import junit.framework.TestCase;
import org.junit.Test;
import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JTextAreaOperator;

import javax.swing.*;
import java.awt.*;

public class TestMathUi extends TestCase {
    private JFrame frm;

    private JFrameOperator frmOpr;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        frm=new JFrame("MathUi Test");
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frm.setSize(new Dimension(400,320));
        frm.getContentPane().add(new MathUi());
        frm.pack();
        frm.setVisible(true);

        frmOpr=new JFrameOperator("MathUi Test");
    }

    @Override
    protected void tearDown() throws Exception {
        frm.dispose();
        super.tearDown();
    }

    @Test
    public void testMathUi(){
        JTextAreaOperator txtOpr=new JTextAreaOperator(frmOpr,0);
        assertEquals("",txtOpr.getText());
        txtOpr.append("abcde");
        assertEquals("abcde",txtOpr.getText());
        txtOpr.clearText();
        assertEquals("",txtOpr.getText());

        JButtonOperator btnOpr=new JButtonOperator(frmOpr,"Math");
        btnOpr.doClick();
        assertEquals("1+1=2",txtOpr.getText());
        txtOpr.append("2");
        assertEquals("1+1=22",txtOpr.getText());

        JButtonOperator resetBtnOpr=new JButtonOperator(frmOpr,"Reset");
        resetBtnOpr.doClick();
        assertEquals("",txtOpr.getText());

        JButtonOperator checkBtnOpr=new JButtonOperator(frmOpr,"Check");
        btnOpr.doClick();
        checkBtnOpr.doClick();
        assertEquals("1+1=2      Good!",txtOpr.getText());
    }
}
