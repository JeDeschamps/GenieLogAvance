package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;

import com.gildedrose.behavior.*;
import com.gildedrose.conjured.*;

/** .
 * Cette classe a pour seul objectif de tester la bonne instanciation des classes
 * au travers de la factory de comportement.
 * On effectue les tests suivants :
 * - Bonne instanciation de la classe comportement par défaut
 *   quand l'item est une dexterity vest/elixir/item qui n'existe pas
 * - Factory renvoie le comportement de backstage pass peu importe le concert
 * - Factory renvoie le comportement de aged brie
 * - Factory renvoie le comportement de sulfuras
 * - Factory renvoie le comportement de conjured pour un item conjured aleatoire
 *
 * @see Behavior
 * @see Conjured
 * @see Item
 */

class BehaviorClassInstantiationTest {
  @Test
  void factoryReturnsBackstagePassBehaviorClass() {
    final Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10) };
    final Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
    assertThat(behave.getClass(), is(BackstagePassBehavior.class));
  }

  @Test
  void factoryReturnsAgedBrieBehaviorClass() {
    final Item[] items = new Item[] {new Item("Aged Brie", -1, 50)  };
    final Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
    assertThat(behave.getClass(), is(AgedBrieBehavior.class));
  }

  @Test
  void factoryReturnsDefaultBehaviorClassDexterityVest() {
    final Item[] items = new Item[] {new Item("+5 Dexterity Vest", -1, 50)  };
    final Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
    assertThat(behave.getClass(), is(DefaultBehavior.class));
  }

  @Test
  void factoryReturnsDefaultBehaviorClassElixir() {
    final Item[] items = new Item[] {new Item("Elixir of the Mongoose", 5, 7) };
    final Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
    assertThat(behave.getClass(), is(DefaultBehavior.class));
  }

  @Test
  void factoryReturnsSulfuraBehaviorClass() {
    final Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 0, 80), };
    final Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
    assertThat(behave.getClass(), is(SulfurasBehavior.class));
  }

  @Test
  void factoryReturnsDefaultBehaviorIfItemDoesntExist() {
    final Item[] items = new Item[] {new Item("Item doesn't exist", 0, 80), };
    final Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
    assertThat(behave.getClass(), is(DefaultBehavior.class));
  }
  @Test
  void factoryReturnsConjuredBehaviorClass() {
    final Item[] items = new Item[] {new Item("Conjured Sulfuras, Hand of Ragnaros", 0, 80) };
    final Behavior behave = BehaviorFactory.getItemBehavior(items[0]);
    assertThat(behave.getClass(), is(ConjuredBehavior.class));
  }
}
