package cl.frojas.ayudametrovalparaso;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import cl.frojas.ayudametrovalparaiso.persistencia.AppDatabase;
import cl.frojas.ayudametrovalparaiso.persistencia.TarjetaDao;
import cl.frojas.ayudametrovalparaiso.persistencia.TarjetaEntidad;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class PersistenciaTest {

    private TarjetaDao tarjetaDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class)
                .allowMainThreadQueries()
                .build();
        tarjetaDao = db.tarjetaDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void probarEscrituraYLectura() throws Exception {
        TarjetaEntidad tarjetaEntidad = new TarjetaEntidad();
        tarjetaEntidad.setNumeroTarjeta("123");
        tarjetaDao.insertAll(tarjetaEntidad);
        TarjetaEntidad encontrado = tarjetaDao.findByNumeroTarjeta("123");
        assertThat(encontrado.getNumeroTarjeta(), equalTo("123"));
    }

}
