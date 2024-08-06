package org.study.pixelbattleback.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static org.study.pixelbattleback.MapService.height;
import static org.study.pixelbattleback.MapService.width;

@RequiredArgsConstructor
public final class Coordinate {

    private static final Map<Integer, Coordinate> coordinates =
            new HashMap<>(width * height, 1.0f);

    @Getter
    private static final int[] colors = new int[width * height];

    static {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < width; y++) {
                coordinates.put(y * width + x, new Coordinate(x, y));
            }
        }
    }
    @Getter
    private final int x;
    @Getter
    private final int y;

    @Setter
    private int color;

    public static Coordinate getCoordinate(PixelRequest pixel) {
        return coordinates.get(pixel.getY() * width + pixel.getX());
    }

    public static boolean changeColor(Coordinate coordinate, int color) {
        CompletableFuture.runAsync(() -> {
            synchronized (coordinate) {
                coordinate.setColor(color);
                colors[coordinate.getY() * width + coordinate.getX()] = color;
            }
        });

        return true;
    }
}
