package Model;

import Helper.KoneksiDb_07359;
import java.sql.Connection;

public abstract class ModelAbstract_07359 {
    Connection conn = KoneksiDb_07359.getconnection();
    public abstract void updatePassword(String password, int id);
    public abstract int cekLogin(String npm, String Password);
}
