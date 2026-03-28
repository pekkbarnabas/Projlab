package model;

import skeleton.Skeleton;

/**
 * A játékon belüli gazdasági rendszer kiszolgálója.
 */
public class Bolt {
    /**
     * Lekéri a paraméterként kapott árucikk árát, majd felszólítja a takarítót a fizetésre.
     */
    public boolean elad(Takarito vevo, Arucikk targy) {
        Skeleton.hivas(this, "elad(vevo, targy)");
        Skeleton.end("true");
        return true;
    }
}