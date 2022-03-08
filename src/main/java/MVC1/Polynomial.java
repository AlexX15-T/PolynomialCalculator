package MVC1;
import Exceptions.IncorrectInput;
import Exceptions.ZeroDivision;
import java.util.*;

public class Polynomial extends Monomial {
    private List < Monomial > monomialsList;

    public Polynomial()
    {
        monomialsList = new ArrayList<Monomial>();
    }

    public Polynomial(int gradMax)
    {
        monomialsList = Collections.nCopies(gradMax, new Monomial(0, 0));
    }

    public Polynomial(List<Monomial> monomialsList) {
        this.monomialsList = monomialsList;
    }

    public Monomial getMonomial(int index) throws IndexOutOfBoundsException
    {
        try {
            return monomialsList.get(index);
        }
        catch (IndexOutOfBoundsException e)
        {
            e.printStackTrace();
        }
        return new Monomial(0,0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polynomial)) return false;
        Polynomial that = (Polynomial) o;
        if(monomialsList.size() != that.monomialsList.size())
            return false;
        if(monomialsList.size() == 0 && that.monomialsList.size() == 0)
            return true;
        for(int i = 0; i < monomialsList.size(); i++)
            if(monomialsList.get(i).getCoef() != that.monomialsList.get(i).getCoef() || monomialsList.get(i).getGrad() != that.monomialsList.get(i).getGrad())
                return false;
        return true;
    }


    public int getGrad()
    {
        return monomialsList.get(monomialsList.size() - 1).getGrad();
    }

    public double getCoef()
    {
        return monomialsList.get(monomialsList.size() - 1).getCoef();
    }

    public void stringToPolynomial(String a) throws IncorrectInput {
        String[] aux = a.replace(" ", "").split("(?=\\+|\\-)");

        if(a.equals("x")) {
            monomialsList.add(new Monomial(1, 1));
            return;
        }

        if(a.length() == 1) {
            monomialsList.add(new Monomial(0, Double.parseDouble(aux[0])));
            return;
        }

       try {
            for (String i : aux) {

                if (i.length() == 1)
                {
                    if(i.equals("x"))
                        monomialsList.add(new Monomial(1, 1));

                    if(!i.contains("x"))
                        monomialsList.add(new Monomial(0, Double.parseDouble(aux[0])));
                }
                else
                    monomialsList.add(Monomial.stringToMonomial(i));
            }
        } catch (Exception ex) {
            throw new IncorrectInput("Error: Input Incorect!");
        }
            monomialsList.sort(Monomial::compareTo);

    }

    @Override
    public String toString() {
        if(monomialsList.size() == 0)
            return "0.00";

        Collections.reverse(monomialsList);

        StringBuilder newStringBuilder = new StringBuilder();

        newStringBuilder.append(monomialsList.get(0));

        for (Monomial i : monomialsList.subList(1, monomialsList.size())) {
                newStringBuilder.append(" ");

                if (i.getCoef() > 0) {
                    newStringBuilder.append("+ ");
                    newStringBuilder.append(i);
                }
                else {
                    newStringBuilder.append("- ");
                    newStringBuilder.append(i.negat());
                }
            }
        Collections.reverse(monomialsList);
        return newStringBuilder.toString();
    }

    public Polynomial plus(Polynomial other)
    {
        int gradMax = Math.max(getGrad(), other.getGrad());
        Polynomial p = new Polynomial();
        add();
        other.add();
        if(getGrad() == gradMax) {
            for (int i = 0; i < other.monomialsList.size(); i++)
                p.monomialsList.add(monomialsList.get(i).plus(other.getMonomial(i)));

            for(int i = other.monomialsList.size(); i <= gradMax; i++)
                p.monomialsList.add(monomialsList.get(i));
        }
        else
        {
            for (int i = 0; i < monomialsList.size(); i++)
                p.monomialsList.add(monomialsList.get(i).plus(other.getMonomial(i)));

            for(int i = monomialsList.size(); i <= gradMax; i++)
                p.monomialsList.add(other.monomialsList.get(i));
        }
        p.reduce();
        other.reduce();
        reduce();
        return p;
    }

    public Polynomial minus(Polynomial other)
    {
        int gradMax = Math.max(getGrad(), other.getGrad());
        Polynomial p = new Polynomial();
        add();
        other.add();

        if(getGrad() == gradMax) {
            for (int i = 0; i < other.monomialsList.size(); i++)
                p.monomialsList.add(monomialsList.get(i).minus(other.getMonomial(i)));

            for(int i = other.monomialsList.size(); i <= gradMax; i++)
                p.monomialsList.add(monomialsList.get(i));
        }
        else
        {
            for (int i = 0; i < monomialsList.size(); i++)
                p.monomialsList.add(monomialsList.get(i).minus(other.getMonomial(i)));

            for(int i = monomialsList.size(); i <= gradMax; i++)
                p.monomialsList.add(other.monomialsList.get(i));

            for(int i = monomialsList.size(); i <= gradMax; i++)
                p.monomialsList.get(i).setCoef((-1) * p.monomialsList.get(i).getCoef());
        }
        p.reduce();
        other.reduce();
        reduce();
        return p;
    }

    public void addMonomial(Monomial other) {
        for(Monomial a : monomialsList)
            if(a.getGrad() == other.getGrad()) {
                a.setCoef(a.plus(other).getCoef());
                return;
            }
        monomialsList.add(other);
            monomialsList.sort(Monomial::compareTo);

    }

    public Polynomial multiply(Polynomial other)
    {
        int grad = getGrad() + other.getGrad();
        List < Monomial > aux2 = new ArrayList<Monomial>();
        Monomial[] aux = new Monomial[grad + 1];
        add();
        other.add();
        for(int i = 0; i < grad + 1; i++)
        {
            aux[i] = new Monomial(i,0);
        }
        for(int i = 0; i < monomialsList.size(); i++)
            for(int j = 0; j < other.monomialsList.size(); j++)
                aux[i + j].setCoef( aux[i + j].getCoef() +  monomialsList.get(i).multiply(other.monomialsList.get(j)).getCoef());

        for(int i = 0; i < grad + 1; i++) {
            aux[i].setGrad(i);
            aux2.add(aux[i]);
        }
            reduce();
            other.reduce();
            Polynomial finalPolinom = new Polynomial(aux2);
            finalPolinom.reduce();

        return finalPolinom;
    }
    public DivideResult divide(Polynomial other) throws ZeroDivision
    {
        if(other.monomialsList.size() == 0 || (other.monomialsList.size() == 1 && other.getCoef() == 0))
            throw new ZeroDivision("Error: Impartirea la un polinom nul nu e posibila!");
        Polynomial q = new Polynomial();
        Polynomial r = this;

        while (r.monomialsList.size() != 0 && other.monomialsList.size() != 0 && r.getGrad() >= other.getGrad()) {
            Monomial aux = new Monomial( r.getGrad() - other.getGrad(), r.getCoef() / other.getCoef());
            q.addMonomial(aux);
            Polynomial b = new Polynomial();
            b.monomialsList.add(aux.negat());
            r = r.plus(other.multiply(b));
        }
        return new DivideResult(q,r);
    }
    public Polynomial derviate()
    {
        add();
        if(getGrad() == 0)
            return new Polynomial();
        List <Monomial> p = new ArrayList<>();
        for(int i = 0; i < getGrad(); i++)
            p.add(new Monomial(i, 0));

        for(int i = 0; i < getGrad(); i++)
            p.get(i).setCoef( (i + 1) * monomialsList.get(i+1).getCoef());

        Polynomial finalPolynom = new Polynomial(p);
        finalPolynom.reduce();
        return finalPolynom;
    }
    public Polynomial integrate()
    {
        add();
        List < Monomial > p = new ArrayList<>();
        for(int i = 0; i <= getGrad() + 1; i++)
            p.add(new Monomial(i, 0));

        for(int i = getGrad() + 1; i > 0; i--)
            p.get(i).setCoef( (double)1/i * monomialsList.get(i-1).getCoef());
        Polynomial finalPolynom = new Polynomial(p);
        finalPolynom.reduce();
        return finalPolynom;

    }
    public void reduce()
    {
        List < Monomial > newReduce = new ArrayList < Monomial >();

        for(Monomial a : monomialsList)
        {
            if(a.getCoef() != 0)
                newReduce.add(a);
        }
        this.monomialsList = newReduce;
    }
    public void add()
    {
        int grd = getGrad();
        boolean[] viz = new boolean[1001];

        for(Monomial m : monomialsList)
        {
            viz[m.getGrad()] = true;
        }
        for(int i = 0; i < grd; i++)
            if(!viz[i])
                monomialsList.add(new Monomial(i, 0));
        monomialsList.sort(Monomial::compareTo);
    }
}