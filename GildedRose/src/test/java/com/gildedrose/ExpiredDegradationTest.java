package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;

/**
 * Cette classe va tester le comportement de degradation / augmentation
 * de qualite pour les items quand ils sont expires, degradation / augmentation
 * double.
 * Tests effectues :
 * - La qualite de backstage pass tombe a 0 quand perime
 * - Degradation de qualite de dexterity vest perime
 * - Degradation de qualite de dexterity vest perime ne tombe pas dans les negatifs
 * - Degradation de qualite de l'elixir perime
 * - Degradation de qualite de l'elixir perime ne tombe pas dans les negatifs
 * - Augmentation de qualite aged brie perime
 * - Augmentation de qualite aged brie perime ne depasse pas 50
 * - Qualite de sulfuras ne change pas
 */
class ExpiredDegradationTest {

  private final transient String dexterityVest = "+5 Dexterity Vest";
  private final transient String elixirMongoose = "Elixir of the Mongoose";
  private final transient String agedBrie = "Aged Brie";

  @Test
  void backstagePassQualityDropsToZeroWhenExpired() {
    final Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(0));
  }

  @Test
  void dexterityVestQualityUpgradeWhenExpired() {
    final Item[] items = new Item[] {new Item(dexterityVest, -1, 20) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(18));
  }

  @Test
  void elixirQualityUpgradeWhenExpired() {
    final Item[] items = new Item[] {new Item(elixirMongoose, -1, 7) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(5));
  }

  @Test
  void agedBrieQualityUpgradeWhenExpired() {
    final Item[] items = new Item[] {new Item(agedBrie, -1, 0) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(2));
  }
  @Test
  void agedBrieQualityUpgradeWhenExpiredCapsAt50() {
    final Item[] items = new Item[] {new Item(agedBrie, -1, 49) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(50));
  }

  @Test
  void sulfurasQualityDoesntChangeWhenExpired() {
    final Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(80));
  }
  /* Qualite ne passe pas en dessous de 0 quand l'item est perime */
  @Test
  void dexterityVestQualityDoesntDropUnder0WhenExpired() {
    final Item[] items = new Item[] {new Item(dexterityVest, -1, 1) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(0));
  }

  @Test
  void elixirQualityDoesntDropUnder0WhenExpired() {
    final Item[] items = new Item[] {new Item(elixirMongoose, -1, 1)  };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].getQuality(), is(0));
  }
}
