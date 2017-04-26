package com.billingsystem.bill;

import com.billingsystem.item.Item;
import com.billingsystem.item.ItemType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e.kamberi on 25/04/2017.
 */

//The class contains unit tests for class Bill.
//The tests are mainly to check the logic of getTotalBillCost() and getTotalBillTaxes methods.
public class BillTest {

List<Item> items1;
List<Item> items2;
List<Item> items3;

@Before
//Initializing method, initialize list of items
public void setUp () {

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

}

@Test
public void billConstructorTest(){
    Bill bill_1 = new Bill(items1);
    Assert.assertEquals(bill_1.getItems(), items1);
    Bill bill_2 = new Bill(items2);
    Assert.assertEquals(bill_2.getItems(), items2);
    Bill bill_3 = new Bill(items3);
    Assert.assertEquals(bill_3.getItems(), items3);
}

@Test
public void billSettersTest(){
    Bill bill_1 = new Bill();
    bill_1.setItems(items1);
    Assert.assertEquals(bill_1.getItems(), items1);

    Bill bill_2 = new Bill();
    bill_2.setItems(items2);
    Assert.assertEquals(bill_2.getItems(), items2);

    Bill bill_3 = new Bill();
    bill_3.setItems(items3);
    Assert.assertEquals(bill_3.getItems(), items3);
}

@Test
public void totalBillCostTest(){
    Bill bill_1 = new Bill(items1);
    bill_1.updateItemTaxes(items1);
    Assert.assertEquals(bill_1.getTotalBillCost(), 29.83, 0.0);

    Bill bill_2 = new Bill(items2);
    bill_2.updateItemTaxes(items2);
    Assert.assertEquals(bill_2.getTotalBillCost(), 65.15, 0.0);

    Bill bill_3 = new Bill(items3);
    bill_3.updateItemTaxes(items3);
    Assert.assertEquals(bill_3.getTotalBillCost(), 74.63, 0.0);
}

@Test
public void totalBillTaxesTest(){
    Bill bill_1 = new Bill(items1);
    bill_1.updateItemTaxes(items1);
    Assert.assertEquals(bill_1.getTotalBillTaxes(), 1.50, 0.0);

    Bill bill_2 = new Bill(items2);
    bill_2.updateItemTaxes(items2);
    Assert.assertEquals(bill_2.getTotalBillTaxes(), 7.65, 0.0);

    Bill bill_3 = new Bill(items3);
    bill_3.updateItemTaxes(items3);
    Assert.assertEquals(bill_3.getTotalBillTaxes(), 6.65, 0.0);
}

}