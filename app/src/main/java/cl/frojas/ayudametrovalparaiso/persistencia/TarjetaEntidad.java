package cl.frojas.ayudametrovalparaiso.persistencia;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tarjeta")
public class TarjetaEntidad {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "numero_tarjeta")
    private String numeroTarjeta;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
}
