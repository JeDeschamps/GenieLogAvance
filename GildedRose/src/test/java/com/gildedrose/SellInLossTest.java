package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;


class SellInLossTest {
    /* Test de degradation du SellIn */
    @Test
    void AgedBrieSellInUpgrade() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 0) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].sellIn, is(4));
    }

    @Test
    void ElixirSellInUpgrade() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].sellIn, is(4));
    }
    
    @Test
    void DexterityVestSellInUpgrade() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].sellIn, is(9));
    }

    @Test
    void BackStagePassSellInUpgrade() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].sellIn, is(14));
    }

    @Test
    void SulfurasSellInDoesntChange() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].sellIn, is(0));
    }

}