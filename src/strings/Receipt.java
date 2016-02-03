package strings;

import java.util.*;
public class Receipt {
 private double total = 0;
 private int Item_width=20;
 private int Qty_width=5;
 private int Price_width=10;
 private int Price_precicion=2;
 
 private Formatter f = new Formatter(System.out);
 public void printTitle() {
 f.format("%-"+Item_width+"s %"+Qty_width+"s %"+Price_width+"s\n", "Item", "Qty", "Price");
 f.format("%-"+Item_width+"s %"+Qty_width+"s %"+Price_width+"s\n", "----", "---", "-----");
 }
 public void print(String name, int qty, double price) {
 f.format("%-"+Item_width+"."+Item_width+"s %"+Qty_width+"s %"+Price_width+"."+Price_precicion+"f\n", name, qty, price);
 total += price;
 }
 public void printTotal() {
 f.format("%-"+Item_width+"s %"+Qty_width+"s %"+Price_width+"."+Price_precicion+"f\n", "Tax", "", total*0.06);
 f.format("%-"+Item_width+"s %"+Qty_width+"s %"+Price_width+"s\n", "", "", "-----");
 f.format("%-"+Item_width+"s %"+Qty_width+"s %"+Price_width+"."+Price_precicion+"f\n", "Total", "",
 total * 1.06);
 }
 public static void main(String[] args) {
 Receipt receipt = new Receipt();
 receipt.printTitle();
 receipt.print("Jack’s Magic Beans", 4, 4.25);
 receipt.print("Princess Peas", 3, 5.1);
 receipt.print("Three Bears Porridge", 1, 14.29);
 receipt.printTotal();
 }
} 