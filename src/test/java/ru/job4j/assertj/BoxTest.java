package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {
    @Test
    void whenSphereThenCorrectProperties() {
        Box box = new Box(0, 10);
        assertThat(box.whatsThis()).isEqualTo("Sphere");
        assertThat(box.getNumberOfVertices()).isEqualTo(0);
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void whenTetrahedronThenCorrectProperties() {
        Box box = new Box(4, 5);
        assertThat(box.whatsThis()).isEqualTo("Tetrahedron");
        assertThat(box.getNumberOfVertices()).isEqualTo(4);
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void whenCubeThenCorrectProperties() {
        Box box = new Box(8, 3);
        assertThat(box.whatsThis()).isEqualTo("Cube");
        assertThat(box.getNumberOfVertices()).isEqualTo(8);
        assertThat(box.isExist()).isTrue();
        assertThat(box.getArea()).isEqualTo(54.0);
    }

    @Test
    void whenUnknownVerticesThenUnknownObject() {
        Box box = new Box(12, 4);
        assertThat(box.whatsThis()).isEqualTo("Unknown object");
        assertThat(box.getNumberOfVertices()).isEqualTo(-1);
        assertThat(box.isExist()).isFalse();
        assertThat(box.getArea()).isEqualTo(0);
    }

    @Test
    void whenEdgeIsZeroThenObjectIsInvalid() {
        Box box = new Box(4, 0);
        assertThat(box.whatsThis()).isEqualTo("Unknown object");
        assertThat(box.getNumberOfVertices()).isEqualTo(-1);
        assertThat(box.isExist()).isFalse();
        assertThat(box.getArea()).isEqualTo(0);
    }

    @Test
    void whenEdgeIsNegativeThenObjectIsInvalid() {
        Box box = new Box(8, -5);
        assertThat(box.whatsThis()).isEqualTo("Unknown object");
        assertThat(box.getNumberOfVertices()).isEqualTo(-1);
        assertThat(box.isExist()).isFalse();
        assertThat(box.getArea()).isEqualTo(0);
    }

}