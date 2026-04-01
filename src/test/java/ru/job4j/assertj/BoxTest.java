package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class BoxTest {

    @Test
    void shouldReturnSphereTypeWhenVertexCountIsZero() {
        Box box = new Box(0, 10);
        String shapeType = box.whatsThis();
        assertThat(shapeType).isEqualTo("Sphere");
    }

    @Test
    void shouldReturnZeroVerticesForSphere() {
        Box box = new Box(0, 3);
        int numberOfVertices = box.getNumberOfVertices();
        assertThat(numberOfVertices).isEqualTo(0);
    }

    @Test
    void shouldExistWhenVertexCountIsValidAndEdgeIsPositive() {
        Box box = new Box(0, 7);
        boolean exist = box.isExist();
        assertThat(exist).isTrue();
    }

    @Test
    void shouldNotExistWhenEdgeIsZero() {
        Box box = new Box(0, 0);
        boolean exists = box.isExist();
        assertThat(exists).isFalse();
    }

    @Test
    void shouldExistWhenVertexCountIsFour() {
        Box box = new Box(4, 3);
        boolean exist = box.isExist();
        assertThat(exist).isTrue();
    }

    @Test
    void shouldExistWhenVertexCountIsEight() {
        Box box = new Box(8, 3);
        boolean exist = box.isExist();
        assertThat(exist).isTrue();
    }

    @Test
    void shouldBeInvalidWhenEdgeIsNegative() {
        Box box = new Box(8, -1);
        boolean exists = box.isExist();
        assertThat(exists).isFalse();
    }

    @Test
    void shouldCalculateSphereAreaCorrectly() {
        Box box = new Box(0, 12);
        double actualArea = box.getArea();
        assertThat(actualArea).isCloseTo(1809.55, offset(0.02));
    }

    @Test
    void shouldCalculateCubeAreaCorrectly() {
        Box cube = new Box(8, 5);
        assertThat(cube.getArea()).isCloseTo(150.0, offset(0.01));
    }

    @Test
    void shouldCalculateTetrahedronAreaCorrectly() {
        Box tetra = new Box(4, 3);
        assertThat(tetra.getArea()).isCloseTo(15.588, offset(0.01));
    }

    @Test
    void shouldReturnZeroAreaWhenShapeDoesNotExist() {
        Box invalid = new Box(0, -5);
        assertThat(invalid.getArea()).isEqualTo(0);
    }

    @Test
    void shouldNotExistWhenVertexCountIsNotSupported() {
        Box box = new Box(5, 10);
        assertThat(box.isExist()).isFalse();
        assertThat(box.whatsThis()).isEqualTo("Unknown object");
    }
}