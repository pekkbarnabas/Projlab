package model;

public class Busz extends Jarmu{
    private Buszvezeto tulajdonos;
    private int buntetoido;
    private Csomopont[] vegallomasok = new Csomopont[2];
    private Csomopont aktualisVegallomas;

    public void vegallomasraEr(Csomopont aktualis){};
}
