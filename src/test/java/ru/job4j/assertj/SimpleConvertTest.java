package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void shouldEmptyArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] empty = simpleConvert.toArray();
        assertThat(empty).isEmpty();
    }

    @Test
    void shouldCheckingTheListWithTheCorrectParameters() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).isNotNull()
                .hasSize(5)
                .startsWith("first")
                .containsExactly("first", "second", "three", "four", "five");
    }

    @Test
    void shouldListWithDuplicates() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "first");
        assertThat(list).hasSize(3)
                .containsExactly("first", "second", "first");
    }

    @Test
    void shouldCheckingTheSetWithTheCorrectParameters() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(set).isNotNull()
                .hasSize(5)
                .contains("five")
                .containsExactlyInAnyOrder("first", "second", "three", "four", "five");

    }

    @Test
    void shouldCheckingForDuplicatesInSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "first");
        assertThat(set).hasSize(2)
                .containsExactlyInAnyOrder("first", "second");
    }

    @Test
    void shouldCheckingTheMapWithTheCorrectParameters() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "four", "five");
        assertThat(map).isNotNull()
                .hasSize(4)
                .containsKeys("first", "second", "four", "five")
                .containsValues(0, 3, 1, 2)
                .containsEntry("first", 0)
                .containsEntry("four", 2);
    }

    @Test
    void shouldMapWithDuplicateKeys() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("key", "key", "key");
        assertThat(map).hasSize(1)
                .containsEntry("key", 0);
    }
}