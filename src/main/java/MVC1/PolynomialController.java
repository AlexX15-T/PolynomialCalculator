package MVC1;
import Exceptions.IncorrectInput;
import Exceptions.ZeroDivision;
import javax.swing.*;
import java.awt.event.*;

public class PolynomialController {
    private PolynomialView pV;
    private PolynomialModel pM;
    boolean firstPolynomialPressed;
    boolean secondPolynomialPressed;

    public PolynomialController(PolynomialView pV, PolynomialModel pM) {
        this.pV = pV;
        this.pM = pM;
        addAllListeners();
        pV.addDocumentFilter();
    }

    public void addAllListeners()
    {
        pV.addSumListener(new AddListener());
        pV.addSubstractListener(new SubstractListener());
        pV.addDivideListener(new DivideListener());
        pV.addModuloListener(new ModuloListener());
        pV.addMultiplyListener(new MultiplyListener());
        pV.addDerivateListener(new DerivateListener());
        pV.addIntegrateListener(new IntegrateListener());
        pV.addExitListener(new ExitListener());
        pV.addFocusListenerForPolynomials(new FocusListenerFirstPolynomial(), new FocusListenerSecondPolynomial());
        pV.addButtonsListeners(new ButtonsListener());
        pV.addDelListener(new DelListener());
        ActionListener[] Operators = new ActionListener[4];
        ActionListener[] Symbols = new ActionListener[4];
        Operators[0] = new PlusListener();
        Operators[1] = new MinusListener();
        Operators[2] = new DivideOpListener();
        Operators[3] = new MultiplyOpListener();
        Symbols[0] = new XorListener();
        Symbols[1] = new PointListener();
        Symbols[2] = new XListener();
        pV.addOperatorsListeners(Operators);
        pV.addSymbolsListeners(Symbols);
    }

    class FocusListenerFirstPolynomial implements FocusListener
    {
        @Override
        public void focusGained(FocusEvent e) {
            firstPolynomialPressed = true;
            secondPolynomialPressed = false;
        }
        @Override
        public void focusLost(FocusEvent e) {
            firstPolynomialPressed = false;
            secondPolynomialPressed = true;
        }
    }

    class FocusListenerSecondPolynomial implements FocusListener
    {
        @Override
        public void focusGained(FocusEvent e) {
            firstPolynomialPressed = false;
            secondPolynomialPressed = true;
        }
        @Override
        public void focusLost(FocusEvent e) {
            firstPolynomialPressed = true;
            secondPolynomialPressed = false;
        }
    }

    class AddListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                pM.setFirstPolynomial(pV.getFirstPolynomial());
                pM.setSecondPolynomial(pV.getSecondPolynomial());
                JOptionPane.showMessageDialog(pV, pM.add());
            } catch (IncorrectInput ex) {
                JOptionPane.showMessageDialog(pV,ex);
            }
        }
    }

    class MultiplyListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                pM.setFirstPolynomial(pV.getFirstPolynomial());
                pM.setSecondPolynomial(pV.getSecondPolynomial());
                JOptionPane.showMessageDialog(pV, pM.multiply());
            } catch (IncorrectInput ex) {
                JOptionPane.showMessageDialog(pV,ex);
            }
        }
    }

    class SubstractListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                pM.setFirstPolynomial(pV.getFirstPolynomial());
                pM.setSecondPolynomial(pV.getSecondPolynomial());
                JOptionPane.showMessageDialog(pV, pM.substract());
            } catch (IncorrectInput ex) {
                JOptionPane.showMessageDialog(pV,ex);
            }
        }
    }

    class DivideListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                pM.setFirstPolynomial(pV.getFirstPolynomial());
                pM.setSecondPolynomial(pV.getSecondPolynomial());
                try {
                    JOptionPane.showMessageDialog(pV, pM.divide().getQ());
                } catch (ZeroDivision ex) {
                    JOptionPane.showMessageDialog(pV,ex);
                }
            } catch (IncorrectInput ex) {
                JOptionPane.showMessageDialog(pV,ex);
            }
        }
    }
    class ModuloListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                pM.setFirstPolynomial(pV.getFirstPolynomial());
                pM.setSecondPolynomial(pV.getSecondPolynomial());
                try {
                    JOptionPane.showMessageDialog(pV, pM.divide().getRest());
                } catch (ZeroDivision ex) {
                    JOptionPane.showMessageDialog(pV,ex);
                }

            } catch (IncorrectInput ex) {
                JOptionPane.showMessageDialog(pV,ex);
            }
        }
    }
    class IntegrateListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                pM.setFirstPolynomial(pV.getFirstPolynomial());
                pM.setSecondPolynomial(pV.getSecondPolynomial());
                JOptionPane.showMessageDialog(pV, pM.integrate());
            } catch (IncorrectInput ex) {
                JOptionPane.showMessageDialog(pV,ex);
            }
        }
    }
    class DerivateListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                pM.setFirstPolynomial(pV.getFirstPolynomial());
                pM.setSecondPolynomial(pV.getSecondPolynomial());
                JOptionPane.showMessageDialog(pV, pM.derivate());
            } catch (IncorrectInput ex) {
                JOptionPane.showMessageDialog(pV,ex);
            }
        }
    }
    class ExitListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            pV.dispose();
        }
    }
    class ButtonsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 10; i++)
                if (e.getSource() == pV.getButton(i)) {
                    if (!firstPolynomialPressed) pV.updateFirstPolynomial(String.valueOf(i));
                    else if (!secondPolynomialPressed) pV.updateSecondPolynomial(String.valueOf(i));
                    break;
                }
        }
    }
    class PlusListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!firstPolynomialPressed) pV.updateFirstPolynomial("+");
            else if(!secondPolynomialPressed) pV.updateSecondPolynomial("+");
        }
    }
    class MinusListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!firstPolynomialPressed) pV.updateFirstPolynomial("-");
            else if(!secondPolynomialPressed) pV.updateSecondPolynomial("-");
        }
    }
    class DivideOpListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!firstPolynomialPressed) pV.updateFirstPolynomial("/");
            else if(!secondPolynomialPressed) pV.updateSecondPolynomial("/");
        }
    }
    class MultiplyOpListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!firstPolynomialPressed) pV.updateFirstPolynomial("*");
            else if(!secondPolynomialPressed) pV.updateSecondPolynomial("*");
        }
    }
    class XorListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!firstPolynomialPressed) pV.updateFirstPolynomial("^");
            else if(!secondPolynomialPressed) pV.updateSecondPolynomial("^");
        }
    }
    class PointListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!firstPolynomialPressed) pV.updateFirstPolynomial(".");
            else if(!secondPolynomialPressed) pV.updateSecondPolynomial(".");
        }
    }
    class XListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!firstPolynomialPressed) pV.updateFirstPolynomial("x");
            else if(!secondPolynomialPressed) pV.updateSecondPolynomial("x");
        }
    }
    class DelListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!firstPolynomialPressed) pV.eraseFirstPolynomial();
            else if(!secondPolynomialPressed) pV.eraseSecondPolynomial();
        }
    }
}