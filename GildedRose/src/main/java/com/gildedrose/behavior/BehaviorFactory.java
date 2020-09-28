package com.gildedrose;

import com.gildedrose.AgedBrieBehavior;
import com.gildedrose.Item;

public class BehaviorFactory {

    public static Behavior getItemBehavior(Item it){
        String str = it.getName().substring(0, 8);
        switch (str) {
            case "+5 Dexte":
                return getDexterityVestBehavior();

            case "Aged Bri":
                return getAgedBrieBehavior();
            
            case "Elixir o":
                return getElixirBehavior();
            
            case "Sulfuras":
                return getSulfurasBehavior();

            case "Backstag":
                return getBackstagePassBehavior();
            case "Conjured":
                return getConjuredBehavior();
            default:
                break;
        }
        return getElixirBehavior();
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