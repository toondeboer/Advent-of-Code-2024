package com.toondeboer.solutions;

import com.toondeboer.utils.Coordinate;
import com.toondeboer.utils.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day06 extends Solution {
    int currentX;
    int currentY;
    String direction = "up";
    Set<Coordinate> visited = new HashSet<>();

    public Day06() {
        super("06");
    }

    @Override
    public int solvePart1(String input) {
        List<List<Character>> grid = getGrid(input);

        return calculatePath(grid);
    }

    @Override
    public int solvePart2(String input) {
        List<List<Character>> grid = getGrid(input);
        return 0;
    }

    private static List<List<Character>> getGrid(String input) {
        String[] lines = input.split("\\n");
        List<List<Character>> grid = new ArrayList<>();

        for (String line : lines) {
            char[] chars = line.toCharArray();
            List<Character> charList = new ArrayList<>();
            for (char c : chars) {
                charList.add(c);
            }
            grid.add(charList);
        }

        return grid;
    }

    private int calculatePath(List<List<Character>> grid) {
        setStartPosition(grid);

        boolean inGrid = true;
        while (inGrid) {
            visited.add(new Coordinate(currentX, currentY));
            takeStep(grid);
            inGrid = inGrid(grid, currentX, currentY);
        }

        return visited.size();
    }

    private void setStartPosition(List<List<Character>> grid) {
        for (int x = 0; x < grid.size(); x++) {
            for (int y = 0; y < grid.getFirst().size(); y++) {
                if (grid.get(x).get(y) == '^') {
                    currentX = x;
                    currentY = y;
                    return;
                }
            }
        }
    }

    private void takeStep(List<List<Character>> grid) {
        switch (direction) {
            case "up" -> {
                if (validStep(grid, -1, 0)) {
                    currentX--;
                    return;
                }
                direction = "right";
            }
            case "right" -> {
                if (validStep(grid, 0, 1)) {
                    currentY++;
                    return;
                }
                direction = "down";
            }
            case "down" -> {
                if (validStep(grid, 1, 0)) {
                    currentX++;
                    return;
                }
                direction = "left";
            }
            case "left" -> {
                if (validStep(grid, 0, -1)) {
                    currentY--;
                    return;
                }
                direction = "up";
            }
        }
    }

    private boolean validStep(List<List<Character>> grid, int deltaX, int deltaY) {
        int nextX = currentX + deltaX;
        int nextY = currentY + deltaY;
        if (!inGrid(grid, nextX, nextY)) {
            return true;
        }

        char nextPosition = grid.get(nextX).get(nextY);

        return nextPosition != '#';
    }

    private boolean inGrid(List<List<Character>> grid, int x, int y) {
        return (x >= 0 && x < grid.size() && y >= 0 && y < grid.getFirst().size());
    }
}