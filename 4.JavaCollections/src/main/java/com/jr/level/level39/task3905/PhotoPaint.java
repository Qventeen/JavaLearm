package com.jr.level.level39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if(!inBounds(x,y,image)) return false;
        if(image[y][x] == desiredColor) return false;

        Color oldColor = image[y][x];
        fill(image, x, y, desiredColor, oldColor);

        return true;
    }

    private boolean inBounds(int x, int y, Color[][] image){
        return y >= 0 && y < image.length && x >= 0 && x < image[0].length;
    }

    private void fill(Color[][] image, int x, int y, Color desiredColor, Color oldColor){
        if(!inBounds(x,y,image)) return;
        if(image[y][x] == desiredColor || image[y][x] != oldColor) return;
        image[y][x] = desiredColor;
        fill(image, x + 1, y, desiredColor, oldColor);
        fill(image, x , y + 1, desiredColor, oldColor);
        fill(image, x - 1, y, desiredColor, oldColor);
        fill(image, x , y - 1, desiredColor, oldColor);
    }
}
