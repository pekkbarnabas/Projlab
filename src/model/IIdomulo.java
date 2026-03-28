package model;

import skeleton.Skeleton;

/**
 * Közös interfész a szimuláció azon elemei számára, amelyeknek reagálniuk kell az idő múlására.
 */
public interface IIdomulo {
    /**
     * Meghívásakor az objektum végrehajtja az egy időegységre jutó logikáját.
     */
    void idotLep();
}