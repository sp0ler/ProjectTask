package org.study.pixelbattleback.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Контейнер запроса для окрашивания пикселя
 */
@Getter
@Setter
public class PixelRequest {
    private int x;

    private int y;

    /**
     * Цвета хранятся внутри числа
     *  1-8 биты - blue
     *  9-16 биты - green
     *  17-24 биты - red
     *  25-32 - не используются
     */
    private int color;
}
