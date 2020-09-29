package com.gildedrose.behavior;
import com.gildedrose.*;
import com.gildedrose.conjured.*;

public class BehaviorFactory {

    public static Behavior getItemBehavior(Item it){
        String str = it.getName().substring(0, 8);
        switch (str) {
            case "+5 Dexte":
                return getDefaultBehavior();

            case "Aged Bri":
                return getAgedBrieBehavior();
            
            case "Elixir o":
                return getDefaultBehavior();
            
            case "Sulfuras":
                return getSulfurasBehavior();

            case "Backstag":
                return getBackstagePassBehavior();
            case "Conjured":
                return getConjuredBehavior();
            default:
                break;
        }
        return getDefaultBehavior();
    }

    public static Behavior getAgedBrieBehavior() {
        return new AgedBrieBehavior();
    }
    public static Behavior getBackstagePassBehavior() {
        return new BackstagePassBehavior();
    }
    public static Behavior getDefaultBehavior() {
        return new DefaultBehavior();
    }
    public static Behavior getSulfurasBehavior() {
        return new SulfurasBehavior();
    }
    public static Behavior getConjuredBehavior() {
        return new ConjuredBehavior();
    }
}
