package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import com.gildedrose.behavior.*;

import static org.hamcrest.Matchers.*;


class QualityBoundariesTest {
  /* Qualite ne passe pas en dessous de 0 quand l'item n'est pas perime */

  private transient String backstagePass = "Backstage passes to a TAFKAL80ETC concert";
  private final transient String agedBrie = "Aged Brie";

  @Test
  void dexterityVestQualityDoesntDropUnder0() {
    final Item[] items = new Item[] {new Item("+5 Dexterity Vest", 10, 0) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(0));
  }

  @Test
  void elixirQualityDoesntDropUnder0() {
    final Item[] items = new Item[] {new Item("Elixir of the Mongoose", 5, 0)  };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(0));
  }

  @Test
  void backStagePassQualityDoesntDropUnder0() {
    final Item[] items = new Item[] {new Item(backstagePass, -2, 0) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(0));
  }

  @Test
  void backStagePassQualityEquals0WhenExpired() {
    final Item[] items = new Item[] {new Item(backstagePass, -2, -10) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(0));
  }

  /* Qualite ne depasse pas les 50 quand l'item n'est pas perime */

  @Test
  void agedBrieQualityDoesntGoAbove50() {
    final Item[] items = new Item[] {new Item(agedBrie, 2, 50) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(50));
  }

  @Test
  void agedBrieQualityIncrementsWhenQualityUnder0() {
    final Item[] items = new Item[] {new Item(agedBrie, 2, -2) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(-1));
  }

  @Test
  void backStagePassQualityDoesntGoAbove50WhenSellInAbove10() {
    final Item[] items = new Item[] {new Item(backstagePass, 15, 50) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(50));
  }

  @Test
  void backStagePassQualityDoesntGoAbove50WhenSellInUnder10Above5() {
    final Item[] items = new Item[] {new Item(backstagePass, 10, 49) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(50));
  }

  @Test
  void backStagePassQualityDoesntGoAbove50WhenSellInUnder5Above0() {
    final Item[] items = new Item[] {new Item(backstagePass, 5, 48) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(50));
  }
}
