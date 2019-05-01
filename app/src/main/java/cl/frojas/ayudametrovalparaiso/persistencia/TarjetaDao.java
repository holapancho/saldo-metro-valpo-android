package cl.frojas.ayudametrovalparaiso.persistencia;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TarjetaDao {

    @Query("SELECT * FROM tarjeta")
    List<TarjetaEntidad> getAll();

    @Query("SELECT * FROM tarjeta WHERE uid IN (:ids)")
    List<TarjetaEntidad> loadAllByIds(int[] ids);

    @Query("SELECT * FROM tarjeta WHERE numero_tarjeta LIKE :numeroTarjeta LIMIT 1")
    TarjetaEntidad findByNumeroTarjeta(String numeroTarjeta);

    @Insert
    void insertAll(TarjetaEntidad... tarjetaEntidads);

    @Delete
    void delete(TarjetaEntidad tarjetaEntidad);

}
