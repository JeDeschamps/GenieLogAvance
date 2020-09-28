package com.gildedrose;

import com.gildedrose.Item;

public interface Behavior {
    void updateItemQuality(Item it);

    default void updateItemSellIn(Item it){
        if(!it.getName().equals("Sulfuras, Hand of Ragnaros"))
        {
            it.setSellIn(it.getSellIn()-1);
        }
    }

    default public boolean isExpired(Item it){
        return (it.getSellIn() <= 0);
    }
}
