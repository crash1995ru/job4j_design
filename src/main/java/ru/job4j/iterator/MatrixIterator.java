package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator<Integer> {
    private final int[][] data;
    private int row;
    private int column;

    public MatrixIterator(int[][] data) {
        this.data = data;
        this.row = 0;
        this.column = 0;
    }

    @Override
    public boolean hasNext() {
        if (data == null || data.length == 0) {
                return false;
            }
        while (row < data.length) {
            if (column < data[row].length) {
                if (data[row][column] != 0) {
                    return true;
                }
                column++;
            }
            if (column >= data[row].length) {
                row++;
                column = 0;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}