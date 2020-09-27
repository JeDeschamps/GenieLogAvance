package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;


class ExpiredDegradationTest {
    /* Test de degradation de qualite quand les items sont expires */
    @Test
    void BackstagePassQualityDropsToZeroWhenExpired() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(0));
    }

    @Test
    void DexterityVestQualityUpgradeWhenExpired() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", -1, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(18));
    }

    @Test
    void ElixirQualityUpgradeWhenExpired() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", -1, 7) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(5));
    }

    @Test
    void AgedBrieQualityUpgradeWhenExpired() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 0) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(2));
    }
    @Test
    void AgedBrieQualityUpgradeWhenExpiredCapsAt50() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 49) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(50));
    }
    
    @Test
    void SulfurasQualityDoesntChangeWhenExpired() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(80));
    }
    /* Qualite ne passe pas en dessous de 0 quand l'item est perime */
    @Test
    void DexterityVestQualityDoesntDropUnder0WhenExpired() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", -1, 1) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(0));
    }

    @Test
    void ElixirQualityDoesntDropUnder0WhenExpired() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", -1, 1)  };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(0));
    }


    /* Qualite ne depasse pas les 50 quand l'item est perime */

    @Test
    void AgedBrieQualityDoesntGoAbove50WhenExpired() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 50) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].quality, is(50));
    }
}
