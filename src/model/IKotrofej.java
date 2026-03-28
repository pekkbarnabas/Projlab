package model;

import skeleton.Skeleton;

/**
 * Közös interfész a hókotróra szerelhető fejek számára (Strategy minta).
 */
public interface IKotrofej {
    /**
     * A paraméterként kapott sávon elvégzi a fej típusára jellemző módosításokat.
     * @param s A tisztítandó sáv.
     * @param h A hókotró, amire a fej fel van szerelve.
     */
    void dolgozik(Sav s, Hokotro h);
}