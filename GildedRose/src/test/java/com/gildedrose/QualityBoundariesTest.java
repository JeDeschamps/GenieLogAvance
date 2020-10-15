package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import com.gildedrose.behavior.*;

import static org.hamcrest.Matchers.*;

/**
 * Cette classe effectue les tests d'augmentation / degradation de la qualite selon les items.
 * Dans les cas proches des limites 0 et 50
 * On va verifier que la qualite des items ne peut pas passer en dessous
 * de 0 et au dessus de 50 quand ils sont a ces limites
 * Tests effectues :
 * - Degradation d'une dexterity vest a 0 de qualite
 * - Degradation d'un elixir a 0 de qualite
 * - Backstage pass reste a 0 de qualite apres une mise a jour
 *   ou il est perime
 * - Mise a jour de la qualite de backstage pass met la qualite a 0
 *   quand l'item est perime (instancie avec une qualite de -10)
 * - Aged brie ne depasse pas les 50 de qualite
 * - La qualite de agedbrie augmente meme s'il est instancie avec
 *   une qualite negative (seul item a se comporte comme ca)
 * - La qualite de backstage pass ne depasse pas 50 dans les 3 cas possibles
 */

class QualityBoundariesTest {

  private transient String backstagePass = "Backstage passes to a TAFKAL80ETC concert";
  private final transient String agedBrie = "Aged Brie";

  @Test
  void dexterityVestQualityDoesntDropUnder0() {
    final Item[] items = new Item[] {new Item("+5 Dexterity Vest", 10, 0) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].quality, is(0));
  }

  @Test
  void elixirQualityDoesntDropUnder0() {
    final Item[] items = new Item[] {new Item("Elixir of the Mongoose", 5, 0)  };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].quality, is(0));
  }

  @Test
  void backStagePassQualityDoesntDropUnder0() {
    final Item[] items = new Item[] {new Item(backstagePass, -2, 0) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].quality, is(0));
  }

  @Test
  void backStagePassQualityEquals0WhenExpired() {
    final Item[] items = new Item[] {new Item(backstagePass, -2, -10) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].quality, is(0));
  }

  /* Qualite ne depasse pas les 50 quand l'item n'est pas perime */

  @Test
  void agedBrieQualityDoesntGoAbove50() {
    final Item[] items = new Item[] {new Item(agedBrie, 2, 50) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].quality, is(50));
  }

  @Test
  void agedBrieQualityIncrementsWhenQualityUnder0() {
    final Item[] items = new Item[] {new Item(agedBrie, 2, -2) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].quality, is(-1));
  }

  @Test
  void backStagePassQualityDoesntGoAbove50WhenSellInAbove10() {
    final Item[] items = new Item[] {new Item(backstagePass, 15, 50) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].quality, is(50));
  }

  @Test
  void backStagePassQualityDoesntGoAbove50WhenSellInUnder10Above5() {
    final Item[] items = new Item[] {new Item(backstagePass, 10, 49) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].quality, is(50));
  }

  @Test
  void backStagePassQualityDoesntGoAbove50WhenSellInUnder5Above0() {
    final Item[] items = new Item[] {new Item(backstagePass, 5, 48) };
    final GildedRose testitem = new GildedRose(items);
    testitem.updateQuality();
    assertThat(testitem.items[0].quality, is(50));
  }
}
