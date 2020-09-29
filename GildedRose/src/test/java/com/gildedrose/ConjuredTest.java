package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import com.gildedrose.*;
import com.gildedrose.behavior.*;

import static org.hamcrest.Matchers.*;


class ConjuredTest { 
    /* Tests comportements du conjured */
    
    @Test
    void ConjuredDexterityVestQualityUpgrade() {
        Item[] items = new Item[] { new Item("Conjured +5 Dexterity Vest", 5, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(18));
    }

    @Test
    void ConjuredDexterityVestQualityUpgradeWhenExpired() {
        Item[] items = new Item[] { new Item("Conjured +5 Dexterity Vest", -5 , 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(16));
    }
    @Test
    void ConjuredSulfurasQualityUpgrade() {
        Item[] items = new Item[] { new Item("Conjured Sulfuras, Hand of Ragnaros", 5, 80)  };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(80));
    }

    @Test
    void ConjuredSulfurasQualityUpgradeWhenExpired() {
        Item[] items = new Item[] { new Item("Conjured Sulfuras, Hand of Ragnaros", -5, 80)  };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(80));
    }

    @Test
    void ConjuredElixirQualityUpgrade() {
        Item[] items = new Item[] { new Item("Conjured Elixir of the Mongoose", 5, 7) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(5));
    }

    @Test
    void ConjuredAgedBrieQualityUpgrade() {
        Item[] items = new Item[] { new Item("Conjured Aged Brie", 2, 0) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(2));
    }

    private transient String conjuredBackstagePass = "Conjured Backstage passes to a TAFKAL80ETC concert";
    @Test
    void ConjuredBackstagePassQualityUpgradeSellInAbove10() {
        Item[] items = new Item[] { new Item(conjuredBackstagePass, 15, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(22));
    }

    @Test
    void ConjuredBackstagePassQualityUpgradeSellInUnder10Above5() {
        Item[] items = new Item[] { new Item(conjuredBackstagePass, 10, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(24));
    }

    @Test
    void ConjuredBackstagePassQualityUpgradeSellInUnder5Above0() {
        Item[] items = new Item[] { new Item(conjuredBackstagePass, 1, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(26));
    }
    @Test
    void ConjuredBackstagePassQualityUpgradeSellInUnder5Above0CapsAt50() {
        Item[] items = new Item[] { new Item(conjuredBackstagePass, 1, 46) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(50));
    }
}