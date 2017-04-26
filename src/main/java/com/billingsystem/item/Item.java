package com.billingsystem.item;

/**
 * Created by e.kamberi on 25/04/2017.
 */
public class Item {

private String name;
private double cost;
private double tax;
private ItemType type;
private boolean imported;

public Item() {
}

public Item(String name, double cost, ItemType type, boolean imported) {
    this.name = name;
    this.cost = cost;
    this.type = type;
    this.imported = imported;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public double getCost() {
    return cost;
}

public void setCost(double cost) {
    this.cost = cost;
}

public double getTax() {
    return tax;
}

public void setTax(double tax) {
    this.tax += tax;
}

public ItemType getType() {
    return type;
}

public void setType(ItemType type) {
    this.type = type;
}

public boolean isImported() {
    return imported;
}

public void setImported(boolean imported) {
    this.imported = imported;
}
}