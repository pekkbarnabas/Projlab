package model;

import skeleton.Skeleton;

/**
 * A játékon belüli gazdasági rendszer kiszolgálója.
 */
public class Bolt {
    private String nev = "b";
    public void setNev(String nev) { this.nev = nev; }

    /** Eladja az árucikket a takarítónak, ha az ki tudja fizetni. */
    public boolean elad(Takarito t, Arucikk a) {
        Skeleton.hivas(this, "elad(t, Arucikk." + a.name() + ")");
        int ar = 50;
        // A Bolt megkéri a Takarítót, hogy fizessen
        if (t != null && t.fizet(ar)) {
            Skeleton.end("true");
            return true;
        }
        
        Skeleton.end("false");
        return false;
    }
}