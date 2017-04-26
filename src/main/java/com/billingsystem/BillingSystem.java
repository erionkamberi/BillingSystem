package com.billingsystem;

import com.billingsystem.bill.Bill;
import com.billingsystem.item.Item;
import com.billingsystem.item.ItemType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by e.kamberi on 25/04/2017.
 */
public class BillingSystem {
    public static void main(String[] args) {
        List<Item> items1;
        List<Item> items2;
        List<Item> items3;

        items1 = new ArrayList<Item>();
        items1.add(new Item("book", 12.49, ItemType.BOOK, false));
        items1.add(new Item("music CD",  14.99, ItemType.MUSICAL, false));
        items1.add(new Item("chocolate bar", 0.85, ItemType.FOOD, false));

        items2 = new ArrayList<Item>();
        items2.add(new Item("imported box of chocolates", 10.00, ItemType.FOOD, true));
        items2.add(new Item("imported bottle of perfume", 47.50, ItemType.PERFUMES, true));

        items3 = new ArrayList<Item>();
        items3.add(new Item("imported bottle of perfume", 27.99, ItemType.PERFUMES, true));
        items3.add(new Item("bottle of perfume", 18.99, ItemType.PERFUMES, false));
        items3.add(new Item("packet of headache pills", 9.75, ItemType.MEDICAL, false));
        items3.add(new Item("box of imported chocolates ", 11.25, ItemType.FOOD, true));


        Bill bill_1 = new Bill(items1);
        Bill bill_2 = new Bill(items2);
        Bill bill_3 = new Bill(items3);

        List<Bill> billList = new ArrayList<Bill>();
        billList.add(bill_1);
        billList.add(bill_2);
        billList.add(bill_3);

        int i = 1;
        for(Bill bill : billList){

            Map <String, Long> itemsGrouped = bill.getItems().stream().collect(Collectors.groupingBy(Item::getName, Collectors.counting()));

            System.out.println("Bill " + i + ":");
            for(Item item : bill.getItems()) {
                System.out.println( itemsGrouped.get(item.getName()) + " " + item.getName() + " at " + Math.round(item.getCost()*100)/100.00);
            }

            System.out.print("\n");
            bill.updateItemTaxes(bill.getItems());
            System.out.println("Output Bill " + i + ":");

            for(Item item : bill.getItems()) {
                System.out.println( itemsGrouped.get(item.getName()) + " " + item.getName() + " at " + Math.round((item.getCost()+item.getTax())*100)/100.00);
            }
            System.out.println("Sales Taxes: " + bill.getTotalBillTaxes());
            System.out.println("Total: " + bill.getTotalBillCost());
            System.out.print("\n");
            i++;
        }
    }
}
