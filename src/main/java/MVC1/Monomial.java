package MVC1;

import Exceptions.IncorrectInput;

import java.text.DecimalFormat;

public class Monomial implements Comparable {
    private int grad;
    private double coef;

    public Monomial() {}

    public Monomial(int grad, double coef) {
        this.grad = grad;
        this.coef = coef;
    }

    public void setMonomial(Monomial other)
    {
        this.grad = other.getGrad();
        this.coef = other.getCoef();
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monomial)) return false;
        Monomial monomial = (Monomial) o;
        return grad == monomial.grad;
    }

    public static Monomial stringToMonomial(String a) throws Exception
    {
        a.replace(" ", "");
        a.replace("*", "");

        String[] splitAroundX = a.split("x", 2);

        double c = 1;
        int grad = 1;

        if (splitAroundX[0].contains("-")) {
            c = -1;
            splitAroundX[0].replace("-", "");
        }

        splitAroundX[0].replace("+", "");
        splitAroundX[0].replace("-", "");

        if(splitAroundX[0].length() > 1) {

            String coefAux = "";
            for (int i = 0; i < splitAroundX[0].length(); i++)
                if ((splitAroundX[0].charAt(i) >= '0' && splitAroundX[0].charAt(i) <= '9') || splitAroundX[0].charAt(i) == '.')
                    coefAux += splitAroundX[0].charAt(i);

                c *= Double.parseDouble(coefAux);
        }

        else
        {
            if(splitAroundX[0].length() == 1 && !splitAroundX[0].equals("-") && !splitAroundX[0].equals("+"))
            c *= Integer.parseInt(splitAroundX[0]);
        }

        if(splitAroundX.length > 1 && splitAroundX[1].length() > 1)
             grad = Integer.parseInt(splitAroundX[1].replace("^", ""));

        if(splitAroundX.length == 1)
            return new Monomial(0, c);

        return new Monomial(grad,c);
    }

    public Monomial plus(Monomial other)
    {
        return new Monomial(other.getGrad(), getCoef() + other.getCoef());
    }

    public Monomial minus(Monomial other)
    {
        return new Monomial(other.getGrad(), getCoef() - other.getCoef());
    }

    public Monomial multiply(Monomial other)
    {
        return new Monomial(this.getGrad() + other.getGrad(), getCoef() * other.getCoef());
    }

    public Monomial negat()
    {
        return new Monomial(getGrad(), -getCoef());
    }

    @Override
    public int compareTo(Object o) {
        return this.grad - ((Monomial) o).grad;
    }

    @Override
    public String toString() {
        if (grad == 0) {
            return String.format("%.2f", coef);
        }

        if ( grad == 1 )
            return String.format("%.2f", coef) + "x";

        return String.format("%.2f", coef) + "x^" + grad;
    }
}