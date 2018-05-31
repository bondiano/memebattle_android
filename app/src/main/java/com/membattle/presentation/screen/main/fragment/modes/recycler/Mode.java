package com.membattle.presentation.screen.main.fragment.modes.recycler;


public class Mode {
    public String title;
    public int image;
    public int time;
    public int type;
    public int color;
    /*Типы игры
            0 - бесконечный баттл
            1 - турнирка
    */
    public Mode(int image, String title, int time, int type, int color) {
        this.title = title;
        this.image = image;
        this.time = time;
        this.type = type;
        this.color = color;
    }
}
