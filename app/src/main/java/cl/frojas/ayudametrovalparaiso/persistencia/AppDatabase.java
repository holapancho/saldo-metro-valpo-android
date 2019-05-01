package cl.frojas.ayudametrovalparaiso.persistencia;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import cl.frojas.ayudametrovalparaiso.constantes.Constantes;

@Database(entities = {TarjetaEntidad.class}, version = Constantes.VERSION_BD)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TarjetaDao tarjetaDao();
}