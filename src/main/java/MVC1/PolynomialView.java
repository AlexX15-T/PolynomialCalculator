package MVC1;

import DocumentFilter.MyDocumentFilter;
import Exceptions.IncorrectInput;
import MVC1.PolynomialModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;

public class PolynomialView extends JFrame {
    private PolynomialModel calcModel;

    private JLabel titleLabel = new JLabel("Polynomial Calculator");
    private JLabel firstPolynomLabel = new JLabel("First Polynomial");
    private JLabel secondPolynomLabel = new JLabel("Second Polynomial");

    private JTextField firstPolynomial = new JTextField(1);
    private JTextField secondPolynomial = new JTextField(1);

    private JButton multiplicateButton = new JButton("Multiplicate");
    private JButton divideButton = new JButton("Divide");
    private JButton addButton = new JButton("Add");
    private JButton subtractButton = new JButton("Subtract");
    private JButton moduloButton = new JButton("Modulo");
    private JButton integrateButton = new JButton("Integrate(First)");
    private JButton derivateButton = new JButton("Differentiate(First)");
    private JButton exitButton = new JButton("Exit");

    private JButton[] bNumbers = new JButton[10];
    private JButton bp, bm, bd, bs, bc, bpoint, bx, bdel;

    PolynomialView(PolynomialModel mModel)
    {
        calcModel = mModel;
        setAll();
    }

    public void setAll() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("MVC.Polynomial Calculator");
        this.setSize(400, 600);

        JPanel writePanel = new JPanel();
        JPanel buttonsPanel = new JPanel();
        JPanel mainPanel = new JPanel();

        titleLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        titleLabel.setBorder(new LineBorder(Color.BLACK));
        Font newLabelFont=new Font("Serif", Font.BOLD + Font.ITALIC,35);
        titleLabel.setFont(newLabelFont);
        titleLabel.setFont(newLabelFont);
        writePanel.setLayout(new BoxLayout(writePanel, BoxLayout.X_AXIS));
        mainPanel.setLayout(new GridLayout(4, 1));
        buttonsPanel.setLayout(new GridLayout(4,2));

///partea de scris polinoame
        JPanel polynomL = new JPanel();
        JPanel polynomR = new JPanel();
        polynomL.setLayout(new BoxLayout(polynomL, BoxLayout.Y_AXIS));
        polynomR.setLayout(new BoxLayout(polynomR, BoxLayout.Y_AXIS));

        writePanel.add(polynomL);
        writePanel.add( Box.createRigidArea(new Dimension(20,20)) );
        writePanel.add(polynomR);

        firstPolynomLabel.setFont(new Font("Serif", Font.BOLD, 20));
        secondPolynomLabel.setFont(new Font("Serif", Font.BOLD, 20));

        firstPolynomLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);
        secondPolynomLabel.setHorizontalAlignment(SwingConstants.HORIZONTAL);

        polynomL.add(firstPolynomLabel);
        polynomL.add( Box.createRigidArea(new Dimension(20,20)) );
        polynomL.add(secondPolynomLabel);

        polynomR.add(firstPolynomial);
        polynomR.add(secondPolynomial);

///partea de butoane
        buttonsPanel.add(multiplicateButton);
        buttonsPanel.add(subtractButton);
        buttonsPanel.add(divideButton);
        buttonsPanel.add(moduloButton);
        buttonsPanel.add(integrateButton);
        buttonsPanel.add(derivateButton);
        buttonsPanel.add(addButton);
        buttonsPanel.add(exitButton);
        buttonsPanel.setBorder(new LineBorder(Color.BLACK));

        mainPanel.add(titleLabel);
        mainPanel.add(writePanel);
        mainPanel.add(buttonsPanel);

///parte de numere
        JPanel thirdPanel = new JPanel();
        JPanel leftNumbersPanel = new JPanel();
        JPanel rightNumbersPanel = new JPanel();

        leftNumbersPanel.setLayout(new GridLayout(3,3));
        leftNumbersPanel.setBorder(new LineBorder(Color.BLACK));
        rightNumbersPanel.setLayout(new GridLayout(3,3));
        rightNumbersPanel.setBorder(new LineBorder(Color.BLACK));

        for(int i = 0; i < 10; i++)
            bNumbers[i] = new JButton(String.valueOf(i));

        bp = new JButton("+");
        bm = new JButton("-");
        bd = new JButton("/");
        bs = new JButton("*");
        bc = new JButton("^");
        bpoint = new JButton(".");
        bx = new JButton("x");
        bdel = new JButton("del");

        for(int i = 1; i < 10; i++)
            leftNumbersPanel.add(bNumbers[i]);
        rightNumbersPanel.add(bNumbers[0]);

        rightNumbersPanel.add(bp);
        rightNumbersPanel.add(bm);
        rightNumbersPanel.add(bd);
        rightNumbersPanel.add(bs);
        rightNumbersPanel.add(bc);
        rightNumbersPanel.add(bpoint);
        rightNumbersPanel.add(bx);
        rightNumbersPanel.add(bdel);

        thirdPanel.setLayout(new GridLayout(1,2));
        thirdPanel.setBorder(new LineBorder(Color.BLACK));

        thirdPanel.add(leftNumbersPanel);
        thirdPanel.add(rightNumbersPanel);
        mainPanel.add(thirdPanel);

        this.add(mainPanel);
    }

    public void addDocumentFilter()
    {
        AbstractDocument d1 = (AbstractDocument) firstPolynomial.getDocument();
        AbstractDocument d2 = (AbstractDocument) secondPolynomial.getDocument();

        d1.setDocumentFilter( new MyDocumentFilter());
        d2.setDocumentFilter( new MyDocumentFilter());
    }

    public void addSumListener(ActionListener call)
    {
        addButton.addActionListener(call);
    }

    public void addSubstractListener(ActionListener call)
    {
        subtractButton.addActionListener(call);
    }

    public void addMultiplyListener(ActionListener call)
    {
        multiplicateButton.addActionListener(call);
    }

    public void addDivideListener(ActionListener call)
    {
        divideButton.addActionListener(call);
    }

    public void addModuloListener(ActionListener call)
    {
        moduloButton.addActionListener(call);
    }

    public void addDerivateListener(ActionListener call)
    {
        derivateButton.addActionListener(call);
    }

    public void addIntegrateListener(ActionListener call)
    {
        integrateButton.addActionListener(call);
    }

    public void addExitListener(ActionListener call)
    {
        exitButton.addActionListener(call);
    }

    public void addFocusListenerForPolynomials(FocusListener p1, FocusListener p2)
    {
        firstPolynomial.addFocusListener(p1);
        secondPolynomial.addFocusListener(p2);
    }

    public void addButtonsListeners(ActionListener call)
    {
        int i = 0;
        for(JButton b : bNumbers) {
            b.addActionListener(call);
            i++;
        }
    }

    public void addOperatorsListeners(ActionListener[] call)
    {
        bp.addActionListener(call[0]);
        bm.addActionListener(call[1]);
        bd.addActionListener(call[2]);
        bs.addActionListener(call[3]);
    }

    public void addSymbolsListeners(ActionListener[] call)
    {
        bc.addActionListener(call[0]);
        bpoint.addActionListener(call[1]);
        bx.addActionListener(call[2]);
    }

    public void addDelListener(ActionListener call)
    {
        bdel.addActionListener(call);
    }

    public void updateFirstPolynomial(String s)
    {
        String now = firstPolynomial.getText();
        firstPolynomial.setText(now + s);
    }

    public void updateSecondPolynomial(String s)
    {
        String now = secondPolynomial.getText();
        secondPolynomial.setText(now + s);
    }

    public JButton getButton(int index) { return bNumbers[index]; }

    public void eraseFirstPolynomial()
    {
        firstPolynomial.setText("");
    }

    public void eraseSecondPolynomial() {
        secondPolynomial.setText("");
    }

    public Polynomial getFirstPolynomial() throws IncorrectInput {
        String aux = firstPolynomial.getText();
        Polynomial p = new Polynomial();
        p.stringToPolynomial(aux);
        return p;
    }

    public Polynomial getSecondPolynomial() throws IncorrectInput {
        String aux = secondPolynomial.getText();
        Polynomial p = new Polynomial();
        p.stringToPolynomial(aux);
        return p;
    }
}