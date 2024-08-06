package org.study.pixelbattleback.dto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static org.study.pixelbattleback.MapService.height;
import static org.study.pixelbattleback.MapService.width;

@Log4j2
@RequiredArgsConstructor
public final class Coordinate {

    private static final Executor executor = Executors.newFixedThreadPool(10);

    private static final Map<Integer, Integer> COLORS =
            new ConcurrentHashMap<>(width * height, 1.0f);

    static {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < width; y++) {
                COLORS.put(y * width + x, 0);
            }
        }
    }

    public static boolean changeColor(int x, int y, int color) {
        CompletableFuture.runAsync(() -> COLORS.put(y * width + x, color), executor);
        return true;
    }

    public static int[] getColors() {
        return COLORS.values().stream().mapToInt(Integer::intValue).toArray();
    }
}
