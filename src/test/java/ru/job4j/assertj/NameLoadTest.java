package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkValidData() {
        NameLoad nameLoad = new NameLoad();
        nameLoad.parse("John=Doe");
        assertThat(!nameLoad.getMap().isEmpty());
    }

    @Test
    void isNotKey() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("=Doe"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isNotValue() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("John="))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isNotValid() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("John Doe"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isCheckEmptyMap() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("collection contains no data");
    }
}