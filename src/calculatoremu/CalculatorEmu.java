package calculatoremu;

// build a GUI front-end for a radio
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/*
So the idea was to add in listeners, then determine which button was pressed
and to add that to a string. After having built the string by pressing buttons,
pass into the eval method we made in HW5 in order to calculate to output.
*/

class Calculator extends JFrame implements ActionListener
{

    private JButton oneJButton, twoJButton, threeJButton, fourJButton,
            fiveJButton, sixJButton, sevenJButton, eightJButton, offJButton,
            nineJButton, zeroJButton, zero2JButton, addJButton, minusJButton,
            divideJButton, multJButton, equalsJButton, decJButton, c_lastJButton,
            c_allJButton; 
    private JPanel numbersJPanel, opJPanel, clearJPanel;
    private JTextField interfaceJTextField;
    private double result = 0;
    private String operator = "=";
    private String text = "";
    private boolean calculating = true;
    public static double ans = 0;

    // no-arg constructor
    public Calculator() 
    {
        createUserInterface();
    }
    
    //create and position our GUI components
    private void createUserInterface()
    {
        //get contentPane and set layout to null
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setLayout(null);
        
        //set up numberstJPanel
        numbersJPanel = new JPanel();
        numbersJPanel.setLayout(null);
        numbersJPanel.setBorder(new BevelBorder(BevelBorder.LOWERED ));
        numbersJPanel.setBounds(16,85,250,240);
        numbersJPanel.setBackground(Color.LIGHT_GRAY);
        contentPane.add(numbersJPanel);
        
        //setup oneJButton
        oneJButton = new JButton();
        oneJButton.setBounds(16,22,72,50); 
        oneJButton.setFont(new Font("SansSerif", Font.PLAIN, 24 ));
        oneJButton.setText("1");
        oneJButton.setBackground(Color.CYAN);
        oneJButton.addActionListener(this);
        numbersJPanel.add(oneJButton);
        
        //setup twoJButton
        twoJButton = new JButton();
        twoJButton.setBounds(88,22,72,50); //(x,y,w,h)
        twoJButton.setFont(new Font("SansSerif", Font.PLAIN, 24 ));
        twoJButton.setText("2");
        twoJButton.setBackground(Color.CYAN);
        twoJButton.addActionListener(this);
        numbersJPanel.add(twoJButton);
        
        threeJButton = new JButton();
        threeJButton.setBounds(160,22,72,50); //(x,y,w,h)
        threeJButton.setFont(new Font("SansSerif", Font.PLAIN, 24 ));
        threeJButton.setText("3");
        threeJButton.setBackground(Color.CYAN);
        threeJButton.addActionListener(this);
        numbersJPanel.add(threeJButton);
        
        fourJButton = new JButton();
        fourJButton.setBounds(16,72,72,50); //(x,y,w,h)
        fourJButton.setFont(new Font("SansSerif", Font.PLAIN, 24 ));
        fourJButton.setText("4");
        fourJButton.setBackground(Color.CYAN);
        fourJButton.addActionListener(this);
        numbersJPanel.add(fourJButton);
        
        fiveJButton = new JButton();
        fiveJButton.setBounds(88,72,72,50); //(x,y,w,h)
        fiveJButton.setFont(new Font("SansSerif", Font.PLAIN, 24 ));
        fiveJButton.setText("5");
        fiveJButton.setBackground(Color.CYAN);
        fiveJButton.addActionListener(this);
        numbersJPanel.add(fiveJButton);
        
        sixJButton = new JButton();
        sixJButton.setBounds(160,72,72,50); //(x,y,w,h)
        sixJButton.setFont(new Font("SansSerif", Font.PLAIN, 24 ));
        sixJButton.setText("6");
        sixJButton.setBackground(Color.CYAN);
        sixJButton.addActionListener(this);
        numbersJPanel.add(sixJButton);
        
        sevenJButton = new JButton();
        sevenJButton.setBounds(16,122,72,50); //(x,y,w,h)
        sevenJButton.setFont(new Font("SansSerif", Font.PLAIN, 24 ));
        sevenJButton.setText("7");
        sevenJButton.setBackground(Color.CYAN);
        sevenJButton.addActionListener(this);
        numbersJPanel.add(sevenJButton);
        
        eightJButton = new JButton();
        eightJButton.setBounds(88,122,72,50); //(x,y,w,h)
        eightJButton.setFont(new Font("SansSerif", Font.PLAIN, 24 ));
        eightJButton.setText("8");
        eightJButton.setBackground(Color.CYAN);
        eightJButton.addActionListener(this);
        numbersJPanel.add(eightJButton);
        
        nineJButton = new JButton();
        nineJButton.setBounds(160,122,72,50); //(x,y,w,h)
        nineJButton.setFont(new Font("SansSerif", Font.PLAIN, 24 ));
        nineJButton.setText("9");
        nineJButton.setBackground(Color.CYAN);
        nineJButton.addActionListener(this);
        numbersJPanel.add(nineJButton);
        
        zeroJButton = new JButton();
        zeroJButton.setBounds(16,172,72,50); //(x,y,w,h)
        zeroJButton.setFont(new Font("SansSerif", Font.PLAIN, 24 ));
        zeroJButton.setText("0");
        zeroJButton.setBackground(Color.CYAN);
        zeroJButton.addActionListener(this);
        numbersJPanel.add(zeroJButton);
        
        zero2JButton = new JButton();
        zero2JButton.setBounds(88,172,144,50); //(x,y,w,h)
        zero2JButton.setFont(new Font("SansSerif", Font.PLAIN, 24 ));
        zero2JButton.setText("00");
        zero2JButton.setBackground(Color.CYAN);
        zero2JButton.addActionListener(this);
        numbersJPanel.add(zero2JButton);
        
        //operators jpanel
        opJPanel = new JPanel();
        opJPanel.setLayout(null);
        opJPanel.setBorder(new BevelBorder(BevelBorder.LOWERED ));
        opJPanel.setBounds(282,85,250,240);
        opJPanel.setBackground(Color.LIGHT_GRAY);
        contentPane.add(opJPanel);
        
        addJButton = new JButton();
        addJButton.setBounds(16,22,120,135); //(x,y,w,h)
        addJButton.setFont(new Font("SansSerif", Font.PLAIN, 18 ));
        addJButton.setText("+");
        addJButton.setBackground(Color.CYAN);
        addJButton.addActionListener(this);
        opJPanel.add(addJButton);
        
        minusJButton = new JButton();
        minusJButton.setBounds(152,22,83,50); //(x,y,w,h)
        minusJButton.setFont(new Font("SansSerif", Font.PLAIN, 24 ));
        minusJButton.setText("-");
        minusJButton.setBackground(Color.CYAN);
        minusJButton.addActionListener(this);
        opJPanel.add(minusJButton);
        
        multJButton = new JButton();
        multJButton.setBounds(152,72,83,50); //(x,y,w,h)
        multJButton.setFont(new Font("SansSerif", Font.PLAIN, 24 ));
        multJButton.setText("*");
        multJButton.setBackground(Color.CYAN);
        multJButton.addActionListener(this);
        opJPanel.add(multJButton);
        
        divideJButton = new JButton();
        divideJButton.setBounds(152,122,83,50); //(x,y,w,h)
        divideJButton.setFont(new Font("SansSerif", Font.PLAIN, 24 ));
        divideJButton.setText("/");
        divideJButton.setBackground(Color.CYAN);
        divideJButton.addActionListener(this);
        opJPanel.add(divideJButton);
        
        equalsJButton = new JButton();
        equalsJButton.setBounds(152,172,83,50); //(x,y,w,h)
        equalsJButton.setFont(new Font("SansSerif", Font.PLAIN, 24 ));
        equalsJButton.setText("=");
        equalsJButton.setBackground(Color.CYAN);
        equalsJButton.addActionListener(this);
        opJPanel.add(equalsJButton);
        
        decJButton = new JButton();
        decJButton.setBounds(16,167,120,56); //(x,y,w,h)
        decJButton.setFont(new Font("SansSerif", Font.PLAIN, 30 ));
        decJButton.setText(".");
        decJButton.setBackground(Color.CYAN);
        decJButton.addActionListener(this);
        opJPanel.add(decJButton);
        
        //add panel for clear buttons
        clearJPanel = new JPanel();
        clearJPanel.setLayout(null);
        clearJPanel.setBorder(new BevelBorder(BevelBorder.LOWERED ));
        clearJPanel.setBounds(550,85,114,150);
        clearJPanel.setBackground(Color.LIGHT_GRAY);
        contentPane.add(clearJPanel);
        
        c_lastJButton = new JButton();
        c_lastJButton.setBounds(16,22,82,55); //(x,y,w,h)
        c_lastJButton.setFont(new Font("SansSerif", Font.PLAIN, 18 ));
        c_lastJButton.setText("C");
        c_lastJButton.setBackground(Color.CYAN);
        c_lastJButton.addActionListener(this);
        clearJPanel.add(c_lastJButton);
        
        c_allJButton = new JButton();
        c_allJButton.setBounds(16,77,82,55); //(x,y,w,h)
        c_allJButton.setFont(new Font("SansSerif", Font.PLAIN, 18 ));
        c_allJButton.setText("C/A");
        c_allJButton.setBackground(Color.CYAN);
        c_allJButton.addActionListener(this);
        clearJPanel.add(c_allJButton);
        
        offJButton = new JButton();
        offJButton.setBounds(550,257,115,69); //(x,y,w,h)
        offJButton.setFont(new Font("SansSerif", Font.PLAIN, 18 ));
        offJButton.setText("OFF");
        offJButton.setBackground(Color.CYAN);
        offJButton.addActionListener(this);
        contentPane.add(offJButton);
        
        //input and ouput interface
        interfaceJTextField = new JTextField();
        interfaceJTextField.setBounds(16,20,648,50);
        interfaceJTextField.setFont(new Font("SansSerif", Font.PLAIN, 30 ));
        interfaceJTextField.setText("0");
        interfaceJTextField.setEditable(false);
        interfaceJTextField.setHorizontalAlignment(JLabel.RIGHT);
        interfaceJTextField.setBackground(Color.WHITE);
        contentPane.add(interfaceJTextField);
        
        //set properties for application window
        setTitle("Calculator"); //set title bar text in window
        setSize(700, 400);  // w,h
        setVisible(true);  // displays the window
    }

    //build the string based on what action was selected, or perform
    //another task such as shutdown or
    //i'm realizing after having built it, it would look cleaner
    //with a switch statement
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()== oneJButton)
        {
            text = text + '1';
            interfaceJTextField.setText(text);
        }
        else if(e.getSource() == twoJButton)
        {
            text = text + '2';
            interfaceJTextField.setText(text);
        }
        else if(e.getSource() == threeJButton)
        {
            text = text + '3';
            interfaceJTextField.setText(text);
        }
        else if(e.getSource() == fourJButton)
        {
            text = text + '4';
            interfaceJTextField.setText(text);
        }
        else if(e.getSource() == fiveJButton)
        {
            text = text + '5';
            interfaceJTextField.setText(text);
        }
        else if(e.getSource() == sixJButton)
        {
            text = text + '6';
            interfaceJTextField.setText(text);
        }
        else if(e.getSource() == sevenJButton)
        {
            text = text + '7';
            interfaceJTextField.setText(text);
        }
        else if(e.getSource() == eightJButton)
        {
            text = text + '8';
            interfaceJTextField.setText(text);
        }
        else if(e.getSource() == nineJButton)
        {
            text = text + '9';
            interfaceJTextField.setText(text);
        }
        else if(e.getSource() == zeroJButton)
        {
            text = text + '0';
            interfaceJTextField.setText(text);
        }
        else if(e.getSource() == zero2JButton)
        {
            text = text + '0' + '0';
            interfaceJTextField.setText(text);
        }
        else if(e.getSource() == addJButton)
        {
            text = text + '+';
            interfaceJTextField.setText(text);
        }
        else if(e.getSource() == minusJButton)
        {
            text = text + '-';
            interfaceJTextField.setText(text);
        }
        else if(e.getSource() == multJButton)
        {
            text = text + '*';
            interfaceJTextField.setText(text);
        }
        else if(e.getSource() == divideJButton)
        {
            text = text + '/';
            interfaceJTextField.setText(text);
        }
        else if(e.getSource() == decJButton)
        {
            text = text + '.';
            interfaceJTextField.setText(text);
        }
        else if(e.getSource() == equalsJButton)
        {
            //send it all to a method to calculate and reset
            double output = evalE(text);
            interfaceJTextField.setText(Double.toString(output));
            text = "";
        }
        else if(e.getSource() == c_lastJButton)
        {
            //clear up until an operator
            int i;
            for(i = text.length()-1; i >= 0; i--)
            {
                if(text.charAt(i) == '*' || text.charAt(i) == '/' || text.charAt(i) == '+'
                        || text.charAt(i) == '-')
                    break;
            }
            text = text.substring(0, i);
            interfaceJTextField.setText(text);
        }
        else if(e.getSource() == c_allJButton)
        {
            text = "";
            interfaceJTextField.setText("0");
        }
        else if(e.getSource() == offJButton)
        {
            System.exit(0);
        }
    }
    
    /*
    So I just used this from HW5, after having built a string based on
    buttons being clicked, then passed it to here
    */
    
    public static double evalE(String e)
    {
        //base case to return the expression as just an integer
        if (!e.contains("+") && !e.contains("-") && !e.contains("*") && !e.contains("/")) 
        {
            return Double.parseDouble(e);
        }
        
        int i;
        
        //check for operators location
        for (i = 0; i < e.length(); i++) 
        {
            if (e.charAt(i) == '*' || e.charAt(i) == '/') 
            {
                break;
            }
        }
        
        if(i == e.length())
        {
            for(i = 0; i < e.length(); i++)
            {
                if(e.charAt(i) == '+' || e.charAt(i) == '-')
                {
                    break;
                }
            }
        }
        
        //build the two substrings
        String sub1 = e.substring(0, i);
        String sub2 = e.substring(i+1, e.length());
        if(e.charAt(i+1) == '-') 
        {
            sub2 = e.substring(i+2, e.length());
        }
        
        switch(e.charAt(i))
        {
            //check the operator(s) then perform the evaluation
            case '+':
                if(e.charAt(i+1) == '-')
                {
                    ans = evalE(sub1) + - evalE(sub2);
                }
                else
                {
                    ans = evalE(sub1) + evalE(sub2);
                }
                break;
            case '-':
                if(e.charAt(i+1) == '-')
                {
                    ans = evalE(sub1) - - evalE(sub2);
                }
                else
                {
                    ans = evalE(sub1) - evalE(sub2);
                }
                break;
            //if it's * or /, call evalMD
            case '*': case '/':
                evalMD(e);
                break;
        }
        return ans;
    }
    
    //this basically does the same thing as evalE
    public static double evalMD(String e)
    {
        if (!e.contains("+") && !e.contains("-") && !e.contains("*") && !e.contains("/")) 
        {
            return Double.parseDouble(e);
        }
        
        int i;
        
        //check for + or -
        for (i = 0; i < e.length(); i++) 
        {
            if (e.charAt(i) == '*' || e.charAt(i) == '/') 
            {
                break;
            }
        }
        if(i == e.length())
        {
            for(i = 0; i < e.length(); i++)
            {
                if(e.charAt(i) == '+' || e.charAt(i) == '-')
                {
                    break;
                }
            }
        }
        
        String sub1 = e.substring(0, i);
        String sub2 = e.substring(i+1, e.length());
        if(e.charAt(i+1) == '-') 
        {
            sub2 = e.substring(i+2, e.length());
        }
        
        switch(e.charAt(i))
        {
            case '*':
                if(e.charAt(i+1) == '-')
                {
                    ans = evalMD(sub1) * - evalMD(sub2);
                }
                else
                {
                    ans = evalMD(sub1) * evalMD(sub2);
                }
                break;
            case '/':
                if(e.charAt(i+1) == '-')
                {
                    ans = evalMD(sub1) / - evalMD(sub2);
                }
                else
                {
                    ans = evalMD(sub1) / evalMD(sub2);
                }
                break;
            //if it's * or /, call evalMD
            case '+': case '-':
                evalE(e);
                break;
        }
        return ans;
    }
}

public class CalculatorEmu 
{

    public static void main(String[] args) 
    {
        Calculator app = new Calculator();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}