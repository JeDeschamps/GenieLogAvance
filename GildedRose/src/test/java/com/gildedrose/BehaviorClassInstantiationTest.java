package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;

import com.gildedrose.*;
import com.gildedrose.behavior.*;
import com.gildedrose.conjured.*;


class BehaviorClassInstantiationTest { 
    /* Tests unitaires pour verifier la bonne instanciation des classes */
    @Test
    void FactoryReturnsBackstagePassBehaviorClass() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10) };
        Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
        assertThat(behave.getClass(), is(BackstagePassBehavior.class));
    }

    @Test
    void FactoryReturnsAgedBrieBehaviorClass() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 50)  };
        Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
        assertThat(behave.getClass(), is(AgedBrieBehavior.class));
    }

    @Test
    void FactoryReturnsDefaultBehaviorClassDexterityVest() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", -1, 50)  };
        Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
        assertThat(behave.getClass(), is(DefaultBehavior.class));
    }

    @Test
    void FactoryReturnsDefaultBehaviorClassElixir() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7) };
        Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
        assertThat(behave.getClass(), is(DefaultBehavior.class));
    }

    @Test
    void FactoryReturnsSulfuraBehaviorClass() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80), };
        Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
        assertThat(behave.getClass(), is(SulfurasBehavior.class));
    }

    
    @Test
    void BehaviorFactoryClass() {
        BehaviorFactory Factory = new BehaviorFactory();
        assertThat(Factory.getClass(), is(BehaviorFactory.class));
    }

    @Test
    void FactoryReturnsDefaultBehaviorIfItemDoesntExist() {
        Item[] items = new Item[] { new Item("Item doesn't exist", 0, 80), };
        Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
        assertThat(behave.getClass(), is(DefaultBehavior.class));
    }
    @Test
    void FactoryReturnsConjuredBehaviorClass() {
        Item[] items = new Item[] { new Item("Conjured Sulfuras, Hand of Ragnaros", 0, 80) };
        Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
        assertThat(behave.getClass(), is(ConjuredBehavior.class));
    }
}