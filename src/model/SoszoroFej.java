package model;

import skeleton.Skeleton;

public class SoszoroFej implements IKotrofej {
    @Override
    public void dolgozik(Sav s, Hokotro h) {
        Skeleton.hivas(this, "dolgozik(s, h)");

        if (h != null && h.sotFogyaszt(1)) {
            if (s != null) {
                // Sózás elindítása a sávon
                s.sozas();
            }
        }

        Skeleton.end("");
    }
}
