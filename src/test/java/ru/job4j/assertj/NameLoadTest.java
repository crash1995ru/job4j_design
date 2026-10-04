package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void shouldMissingSeparatorWillException() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("John Doe"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: John Doe does not contain the symbol '='");
    }

    @Test
    void shouldStartsWithSeparatorWillException() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("=Doe"))
        .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: =Doe does not contain a key");
    }

    @Test
    void shouldSeparatorAtTheEndThrowsException() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse("John="))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not contain a value");
    }

    @Test
    void shouldCorrectData() {
        NameLoad nameLoad = new NameLoad();
        nameLoad.parse("John=Doe", "Philip = Van", "John = Vandervafla");
        Map<String, String> map = new HashMap<>();
        map.put("John", "Doe");
        map.put("Philip", "Van");
        map.put("John", "Doe+Vandervafla");
        assertThat(nameLoad.getMap()).isNotEmpty()
                .containsExactlyInAnyOrderEntriesOf(map);
    }

    @Test
    void shouldWePassNull() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse(null))
        .isInstanceOf(NullPointerException.class);
    }
}