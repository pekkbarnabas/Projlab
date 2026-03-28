package model;

/**
 * A játékban megvásárolható összes tárgy, eszköz és erőforrás egységes típusazonosítóit gyűjti össze.
 */
public enum Arucikk {
    /** Útszóró só, a sávok jégmentesítéséhez. */
    SO,
    /** Biokerozin, a hókotrók üzemeltetéséhez. */
    KEROZIN,
    /** Maga a hókotró munkagép alapváza. */
    HOKOTRO,
    /** Alacsony erőforrás-igényű tisztítófej. */
    SOPROFEJ,
    /** Kifejezetten a jégpáncél feltörésére optimalizált eszköz. */
    JEGTOROFEJ,
    /** Nagy hatékonyságú, speciális képességekkel rendelkező fej. */
    SARKANYFEJ,
    /** A hó sávok közötti mozgatására alkalmas eszköz. */
    HANYOFEJ,
    /** A só kijuttatását végző egység. */
    SOSZOROFEJ
}