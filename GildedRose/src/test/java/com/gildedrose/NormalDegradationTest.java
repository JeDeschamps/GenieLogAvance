package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;


class NormalDegradationTest {
  private final transient String dexterityVest = "+5 Dexterity Vest";
  private final transient String elixirMongoose = "Elixir of the Mongoose";
  private final transient String backstagePass = "Backstage passes to a TAFKAL80ETC concert";
  @Test
  void toStringReturnsString() {
    final Item tmp = new Item(dexterityVest, 10, 20);
    final String str = tmp.toString();
    assertThat(str.getClass(), is(String.class));
  }
  /* Tests de bonne degradation de la qualite pour chaque items */
  @Test
  void dexterityVestQualityUpgrade() {
    final Item[] items = new Item[] {new Item(dexterityVest, 10, 20) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(19));
  }

  @Test
  void elixirQualityUpgrade() {
    final Item[] items = new Item[] {new Item(elixirMongoose, 5, 7) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(6));
  }

  @Test
  void qualityUpgradeWhenNegativeQualityHasNoEffect() {
    final Item[] items = new Item[] {new Item(elixirMongoose, 5, -5) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(-5));
  }
  @Test
  void agedBrieQualityUpgrade() {
    final Item[] items = new Item[] {new Item("Aged Brie", 2, 0) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(1));
  }

  @Test
  void sulfurasQualityDoesntChange() {
    final Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 0, 50) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(50));
  }

  @Test
  void backstagePassQualityUpgradeSellInAbove10() {
    final Item[] items = new Item[] {new Item(backstagePass, 15, 20) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(21));
  }

  @Test
  void backstagePassQualityUpgradeSellInUnder10Above5() {
    final Item[] items = new Item[] {new Item(backstagePass, 10, 20) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(22));
  }

  @Test
  void backstagePassQualityUpgradeSellInUnder5Above0() {
    final Item[] items = new Item[] {new Item(backstagePass, 1, 20) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(23));
  }

}
