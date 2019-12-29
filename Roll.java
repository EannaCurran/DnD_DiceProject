import java.lang.Math;

public class Roll {
    protected int upperLimit;
    protected int numOfDice;
    protected int roll;
    protected int modifier;
    protected int total = 0;
    protected int grandTotal;

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

    public String rollDice(String input)
    {
        int mid_point = input.indexOf('X');
        int d_location = input.indexOf('D');
        int m_location = input.indexOf(':');
        String output = "";
        System.out.println(input);

        setUpperLimit(Integer.parseInt(input.substring(d_location + 1, mid_point).trim()));
        setNumOfDice(Integer.parseInt(input.substring(mid_point+2, mid_point+3).trim()));
        System.out.println(this.numOfDice);

        if(input.contains(":"))
        {
            setModifier(Integer.parseInt(input.substring(m_location + 2, input.length()).trim()));
            setModifier(modifier * -1);
        }

        for(int count = 0; count < numOfDice ; count++)
        {
            if(upperLimit == 100)
            {
                setRoll((int)(Math.random() * (upperLimit - 1)));
                roll += modifier;
                this.total += roll;
                output += "D" + upperLimit + "number" + count + "rolled: " + roll + '\n';
                System.out.println(output);
            }

            else
            {
                setRoll((int)(Math.random() * (upperLimit - 1)) + 1);
                roll += modifier;
                this.total += roll;
                output += "D" + upperLimit + " number " + count + "rolled: " + roll + '\n';
            }
        }

        output += "Your total is: " + this.total;

        return output;
    }

    public String rollAdvantage(String input)
    {
        int mid_point = input.indexOf('X');
        int d_location = input.indexOf('D');
        int m_location = input.indexOf(':');
        String output = "";

        setUpperLimit(Integer.parseInt(input.substring(d_location, mid_point).trim()));
        setNumOfDice(Integer.parseInt(input.substring(mid_point, '+' - 1).trim()));

        if(input.contains("-"))
        {
            setModifier(Integer.parseInt(input.substring(m_location + 2, input.length()).trim()));
            setModifier(modifier * -1);
        }

        else
        {
            setModifier(Integer.parseInt(input.substring(m_location + 1, input.length()).trim()));
        }

        for(int count = 0; count < numOfDice; count++)
        {
            int temporary = (int) (Math.random() * (upperLimit - 1)) + 1;
            setRoll((int) (Math.random() * (upperLimit - 1)) + 1);

            if (temporary >= roll)
            {
                setRoll(temporary);
                total += roll;
            }
            output += "Your roll with advantage was: " + roll + '\n';
        }

        output += "Your total is: " + total;
        return output;
    }

    public String rollDisadvantage(String input)
    {
        int mid_point = input.indexOf('X');
        int d_location = input.indexOf('D');
        int m_location = input.indexOf(':');
        String output = "";

        setUpperLimit(Integer.parseInt(input.substring(d_location, mid_point).trim()));
        setNumOfDice(Integer.parseInt(input.substring(mid_point, '+' - 1).trim()));

        if(input.contains("-"))
        {
            setModifier(Integer.parseInt(input.substring(m_location + 2, input.length()).trim()));
            setModifier(modifier * -1);
        }

        else
        {
            setModifier(Integer.parseInt(input.substring(m_location + 1, input.length()).trim()));
        }



        for(int count = 0; count < numOfDice; count++)
        {
           int temporary = (int) (Math.random() * (upperLimit - 1)) + 1;
           setRoll((int) (Math.random() * (upperLimit - 1)) + 1);

           if (temporary <= roll)
           {
               setRoll(temporary);
               total += roll;
           }
            output += "Your roll with disadvantage was: " + roll + '\n';
        }

        output += "Your total is: " + total;
        return output;
    }

}
