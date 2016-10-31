/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package askack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import jdk.internal.org.objectweb.asm.Handle;

/**
 *
 * @author mdis
 */
public class Askack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Stack s1 = new Stack();
        String str1 = new String();
        String str2 = new String();
        System.out.println("Welcome To Stack");
        str2 = JOptionPane.showInputDialog(null, "Please Enter the Size of the Stack", "Stack Size", JOptionPane.INFORMATION_MESSAGE);
        do {
            try {
                str1 = JOptionPane.showInputDialog("Please Select (1) = Push,"
                        + " (2) = pop, (3) = Load From File "
                        + "(4) = Stare to File, (5) print, (6) = peek (7) = Flush");
                str1 = str1.toLowerCase();
            } catch (Exception e) {
                System.out.println("!!! Invalid Entry!!! ");
            }

            switch (str1) {
                case "1":
                    str2 = JOptionPane.showInputDialog(null, "Enter Value to Push", "Push Entry", JOptionPane.INFORMATION_MESSAGE);
                    s1.push(Integer.parseInt(str2));
                    break;
                case "2":
//                    str2 = JOptionPane.showInputDialog(null, "Enter Value to Push", "Push Entry",JOptionPane.INFORMATION_MESSAGE);
                    s1.pop();
                    break;
                case "3":
                    s1.load();
                    break;
                case "4":
                    s1.store();
                    break;
                case "5":
                    s1.print();
                    break;
                case "6":
                    s1.peek();
                    break;
                case "7":
                    s1.flash();
                    break;
                default:
                    System.out.println("Invalid!!! Try Again");
                    break;
            }
        } while (!"end".equals(str1));
        System.out.println("System Exit");

    }

}

class Stack {

    private int[] stk;
    private int sp;

    public Stack(int Size) {
// Enter the size of the Stack
        sp = Size;
        stk = new int[Size];
    }

    public Stack() {
// Enter the size of the Stack
        this(10);
    }

    void push(int Data) {
        if (sp > 0) {
            sp--;
            stk[sp] = Data;
            System.out.println("Pushed Value : " + Data);
        } else {
            System.out.println("Stack is full");
        }
    }

    int pop() {

        if (sp == stk.length) {
            System.out.println("No Data in Stack");
            return 0;
        } else {
            System.out.println("POP Data: " + stk[sp]);
            return stk[sp++];
        }
    }

    void print() {
        if(sp != stk.length){
        System.out.println("Printing Stack");
        for (int a = sp; a < stk.length; a++) {
            System.out.println(stk[a]);
        }
        }
    }

    void flash() {
        System.out.println("Flasing the Stack");
        sp = stk.length;
    }

    // Write Data to A file
    void store() throws IOException {
        System.out.println("Storing the Stack");
        String OutPath = "D:\\outpot.text";
        PrintWriter Fos = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(OutPath)
                ), true
        );
        for (int a = sp; a < stk.length; a++) {
            Fos.println(stk[a]);
        }
    }

// Read Data from A file
    void load() throws IOException {

        System.out.println("Load a Stack");
        BufferedReader Fis = new BufferedReader(
                new FileReader("D:\\outpot.text"));

        String str1 = Fis.readLine();
        while (str1 != null) {
            push(Integer.parseInt(str1));
            str1 = Fis.readLine();
        }
        print();
        flash();

    }

    void peek() {
        if (sp != stk.length) {
            System.out.println("The Peek Data is : " + stk[sp]);
        } else {
            System.out.println("Nothing in stack");
        }

    }

}
