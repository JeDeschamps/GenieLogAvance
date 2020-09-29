package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;


class NormalDegradationTest {
    
    @Test 
    void toStringReturnsString() {
        Item tmp = new Item("+5 Dexterity Vest", 10, 20);
        String str = tmp.toString();
        assertThat(str.getClass(), is(String.class));
    }
    /* Tests de bonne degradation de la qualite pour chaque items */
    @Test
    void DexterityVestQualityUpgrade() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].getQuality(), is(19));
    }

    @Test
    void ElixirQualityUpgrade() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].getQuality(), is(6));
    }

    @Test
    void QualityUpgradeWhenNegativeQualityHasNoEffect() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, -5) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].getQuality(), is(-5));
    }
    @Test
    void AgedBrieQualityUpgrade() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].getQuality(), is(1));
    }
    
    @Test
    void SulfurasQualityDoesntChange() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 50) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].getQuality(), is(50));
    }

    @Test
    void BackstagePassQualityUpgradeSellInAbove10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].getQuality(), is(21));
    }

    @Test
    void BackstagePassQualityUpgradeSellInUnder10Above5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].getQuality(), is(22));
    }

    @Test
    void BackstagePassQualityUpgradeSellInUnder5Above0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].getQuality(), is(23));
    }
    
}

