package com.gildedrose.behavior;
import com.gildedrose.*;
import com.gildedrose.conjured.*;

public final class BehaviorFactory {
  private BehaviorFactory() {

  }

  public static Behavior getItemBehavior(Item it) {
    final String str = it.getName().substring(0, 8);
    switch (str) {
      case "+5 Dexte":
        return new DefaultBehavior();

      case "Aged Bri":
        return new AgedBrieBehavior();

      case "Elixir o":
        return new DefaultBehavior();

      case "Sulfuras":
        return new SulfurasBehavior();
      case "Backstag":
        return new BackstagePassBehavior();
      case "Conjured":
        return new ConjuredBehavior();
      default:
        break;
    }
    return new DefaultBehavior();
  }
}
