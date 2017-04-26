package com.billingsystem.bill;

/**
 * Created by e.kamberi on 25/04/2017.
 */

import com.billingsystem.item.Item;
import com.billingsystem.item.ExemptItemType;

import java.util.ArrayList;
import java.util.List;


// Class for bill, it contains a list of items,
// it provides method to calculate payable/taxes amount for bill
public class Bill {

public static final int SALES_TAX_PERCENT = 10;
public static final int IMPORT_TAX_PERCENT = 5;

private List<Item> items;
private double totalBillCost;
private double totalBillTaxes;


public Bill() {
}

public Bill(List<Item> items) {
    this.items = items;
}

//Method to find Sale Taxable Items in the bill
private List<Item> findSaleTaxableItems(List<Item> items){
    List<Item> saleTaxableItems = new ArrayList<Item>();
    for(Item item : items){
        boolean contains = false;
        for(ExemptItemType exemptItem : ExemptItemType.values()){
            if( item.getType().name().equals(exemptItem.name()) ){
                contains = true;
                break;
            }
        }
        if(!contains)
            saleTaxableItems.add(item);
    }
    return saleTaxableItems;
}

//Method to find imported items in  the bill
private List<Item> findImportedItems(List<Item> items){
    List<Item> importedItems = new ArrayList<Item>();
    for(Item item : items){
        if(item.isImported())
            importedItems.add(item);
    }
    return importedItems;
}

public void updateItemTaxes(List<Item> items){
    List<Item> saleTaxableItems = findSaleTaxableItems(items);
    List<Item> importedItems = findImportedItems(items);

    for(Item item : items){
        if(saleTaxableItems.contains(item)) {
            item.setTax( Math.round( ((item.getCost() * SALES_TAX_PERCENT)/100) * 20) / 20.0);
        }
        if(importedItems.contains(item)){
            item.setTax( Math.round( (((item.getCost()) * IMPORT_TAX_PERCENT)/100) * 20) / 20.0);
        }
    }

}

public List<Item> getItems() {
    return items;
}

public void setItems(List<Item> items) {
    this.items = items;
}

public double getTotalBillCost() {
    for(Item item : items){
        totalBillCost += item.getCost() + item.getTax();
    }
    return Math.round(totalBillCost*100)/100.00;
}

public void setTotalBillCost(double totalBillCost) {
    this.totalBillCost = totalBillCost;
}

public double getTotalBillTaxes() {
    for(Item item : items){
        totalBillTaxes += item.getTax();
    }
    return Math.round(totalBillTaxes*100)/100.00;
}

public void setTotalBillTaxes(double totalBillTaxes) {
    this.totalBillTaxes = totalBillTaxes;
}
}
