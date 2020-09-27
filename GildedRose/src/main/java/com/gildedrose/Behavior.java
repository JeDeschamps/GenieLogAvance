package com.gildedrose;

import com.gildedrose.Item;

public interface Behavior {
    void updateItemQuality(Item it);

    default void updateItemSellIn(Item it){
        if(!it.name.equals("Sulfuras, Hand of Ragnaros"))
        {
            it.sellIn = it.sellIn - 1;
        }
    }

    default public boolean isExpired(Item it){
        return (it.sellIn <= 0);
    }
}
