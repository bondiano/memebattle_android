package com.mrswimmer.memebattle.presentation.main.fragment.modes.recycler;


public class Mode {
    public String Title;
    public int Image;
    public int Time;
    public int Type;
    public int Color;
    /*Типы игры
            0 - бесконечный баттл
            1 - турнирка
    */
    public Mode(int image, String title, int time, int type, int color) {
        Title = title;
        Image = image;
        Time = time;
        Type = type;
        Color = color;
    }
}
