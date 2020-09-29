package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import com.gildedrose.*;
import com.gildedrose.behavior.*;

import static org.hamcrest.Matchers.*;


class QualityBoundariesTest {
    /* Qualite ne passe pas en dessous de 0 quand l'item n'est pas perime */
    @Test
    void DexterityVestQualityDoesntDropUnder0() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 0) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].getQuality(), is(0));
    }

    @Test
    void ElixirQualityDoesntDropUnder0() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 0)  };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].getQuality(), is(0));
    }
    private transient String BackstagePass = "Backstage passes to a TAFKAL80ETC concert";
    @Test
    void BackStagePassQualityDoesntDropUnder0() {
        Item[] items = new Item[] { new Item(BackstagePass, -2, 0) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].getQuality(), is(0));
    }

    @Test
    void BackStagePassQualityEquals0WhenExpired() {
        Item[] items = new Item[] { new Item(BackstagePass, -2, -10) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].getQuality(), is(0));
    }

    /* Qualite ne depasse pas les 50 quand l'item n'est pas perime */

    @Test
    void AgedBrieQualityDoesntGoAbove50() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].getQuality(), is(50));
    }

    @Test
    void AgedBrieQualityIncrementsWhenQualityUnder0() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, -2) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].getQuality(), is(-1));
    }

    @Test
    void BackStagePassQualityDoesntGoAbove50WhenSellInAbove10() {
        Item[] items = new Item[] { new Item(BackstagePass, 15, 50) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].getQuality(), is(50));
    }

    @Test
    void BackStagePassQualityDoesntGoAbove50WhenSellInUnder10Above5() {
        Item[] items = new Item[] { new Item(BackstagePass, 10, 49) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].getQuality(), is(50));
    }

    @Test
    void BackStagePassQualityDoesntGoAbove50WhenSellInUnder5Above0() {
        Item[] items = new Item[] { new Item(BackstagePass, 5, 48) };
        GildedRose testitem = new GildedRose(items);
        testitem.updateQuality();
        assertThat(testitem.items[0].getQuality(), is(50));
    }
}