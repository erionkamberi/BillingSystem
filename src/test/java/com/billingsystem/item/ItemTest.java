package com.billingsystem.item;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by e.kamberi on 26/04/2017.
 */

//The class contains unit tests for class Item.
public class ItemTest
{

    @Test
    public void itemConstructorTest(){
        Item item = new Item("book", 12.49, ItemType.BOOK, false);
        Assert.assertEquals("book", item.getName());
        Assert.assertEquals(12.49, item.getCost(), 0.0);
        Assert.assertEquals(ItemType.BOOK, item.getType());
        Assert.assertEquals(false, item.isImported());
    }

    @Test
    public void itemSetterTest(){
        Item item = new Item();
        item.setName("book");
        item.setCost(12.49);
        item.setType(ItemType.BOOK);
        item.setImported(false);
        Assert.assertEquals("book", item.getName());
        Assert.assertEquals(12.49, item.getCost(), 0.0);
        Assert.assertEquals(ItemType.BOOK, item.getType());
        Assert.assertEquals(false, item.isImported());
    }

}