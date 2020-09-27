package com.gildedrose;

import com.gildedrose.AgedBrieBehavior;
import com.gildedrose.Item;

public class BehaviorFactory {

    public static Behavior getItemBehavior(Item it){
        if (it.name.startsWith("Conjured "))
            return getConjuredBehavior();

        switch (it.name) {
            case "+5 Dexterity Vest":
                return getDexterityVestBehavior();

            case "Aged Brie":
                return getAgedBrieBehavior();
            
            case "Elixir of the Mongoose":
                return getElixirBehavior();
            
            case "Sulfuras, Hand of Ragnaros":
                return getSulfurasBehavior();

            case "Backstage passes to a TAFKAL80ETC concert":
                return getBackstagePassBehavior();
            default:
                break;
        }
        return null;
    }

    public static Behavior getAgedBrieBehavior() {
        return new AgedBrieBehavior();
    }
    public static Behavior getBackstagePassBehavior() {
        return new BackstagePassBehavior();
    }
    public static Behavior getDexterityVestBehavior() {
        return new DexterityVestBehavior();
    }
    public static Behavior getElixirBehavior() {
        return new ElixirBehavior();
    }
    public static Behavior getSulfurasBehavior() {
        return new SulfurasBehavior();
    }
    public static Behavior getConjuredBehavior() {
        return new ConjuredBehavior();
    }
}