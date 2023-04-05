package org.study.pixelbattleback.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Контейнер ответного сообщения
 */
@Getter
@Setter
public class ResultResponse {
    private State state;

    private PixelRequest pixel;

    private Map map;

    private String errorMessage;

    /**
     * Формирование ответа после окраски пикселя
     *
     * @param request
     * @return
     */
    public static ResultResponse pixel(PixelRequest request) {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setState(State.PIXEL);
        resultResponse.setPixel(request);
        return resultResponse;
    }

    /**
     * Формирование ответа после получения всей карты
     *
     * @param map
     * @return
     */
    public static ResultResponse map(Map map) {
        ResultResponse res = new ResultResponse();
        res.setState(State.UPDATE);
        res.setMap(map);
        return res;
    }

    /**
     * Формирование ответа после ошибки
     *
     * @param msg
     * @return
     */
    public static ResultResponse error(String msg) {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setState(State.ERROR);
        resultResponse.setErrorMessage(msg);
        return resultResponse;
    }


    public enum State {
        /**
         * Окраска пикселя
         */
        PIXEL,

        /**
         * Получение всей карты
         */
        UPDATE,

        /**
         * Ошибка
         */
        ERROR
    }
}
