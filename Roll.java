package com.company.Projects;
import java.lang.Math;

public class Roll {
    protected int upperLimit;
    protected int numOfDice;
    protected int roll;
    protected int modifier;
    protected int total;
    protected int grandTotal;

    public Roll(int uL, int nOD, int m) throws IllegalArgumentException
    {
        upperLimit = uL;
        numOfDice = nOD;
        modifier = m;

        if(uL > 1000 || uL < 0)
        {
            throw new IllegalArgumentException("ERROR: Invalid value entered, must be between 0 and 1000");
        }

        if(nOD < 0)
        {
            throw new IllegalArgumentException("ERROR: Invalid value entered, must be above 0");
        }
    } //Constructor


    public int getUpperLimit()
    {
        return upperLimit;
    } //Accessor

    public int getNumOfDice()
    {
        return numOfDice;
    } //Accessor

    public int getRoll()
    {
        return roll;
    } //Accessor

    public int getModifier()
    {
        return modifier;
    } //Accessor

    public int getTotal()
    {
        return total;
    } //Accessor

    public int getGrandTotal()
    {
        return grandTotal;
    } //Accessor


    public void setUpperLimit(int upperLimit) throws IllegalArgumentException
    {
        this.upperLimit = upperLimit;

        if(upperLimit > 1000 || upperLimit < 0)
        {
            throw new IllegalArgumentException("ERROR: Invalid value entered, must be between 0 and 1000");
        }
    } //Mutator

    public void setNumOfDice(int numOfDice) throws IllegalArgumentException
    {
        this.numOfDice = numOfDice;

        if(numOfDice < 0)
        {
            throw new IllegalArgumentException("ERROR: Invalid value entered, must be above 0");
        }
    } //Mutator

    public void setRoll(int roll)
    {
        this.roll = roll;
    } //Mutator

    public void setModifier(int modifier)
    {
        this.modifier = modifier;
    } //Mutator

    public void setTotal(int total)
    {
        this.total = total;
    } //Mutator

    public void setGrandTotal(int grandTotal)
    {
        this.grandTotal = grandTotal;
    } //Mutator


    public static void main(String[] args) {
        
    }

    public static int roll(Roll r)
    {
        if(r.upperLimit == 100)
        {
            r.roll = (int)(Math.random() * (r.upperLimit - 1));
            r.roll += r.modifier;
            return r.roll;
        }

        else
        {
            r.roll = (int)(Math.random() * (r.upperLimit - 1)) + 1;
            r.roll += r.modifier;
            return r.roll;
        }
    }
}
