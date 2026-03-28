package model;

public abstract class Jarmu implements IIdomulo{
    protected float pozicio;
    protected Sav aktualisSav;

    public abstract void elakad();
    public abstract void megcsuszik();
    public abstract void utkozik(Jarmu masik);

    public void lep(){};

    @Override
    public void idotLep(){};
}
