package services;
import models.Productos;
import java.util.List;
import java.util.Arrays;

public class ProdcutoServiceImplement implements ProductoService {
    @Override
    public List<Productos> listar() {
        return Arrays.asList(new Productos( 1L, "laptop", "computación", 523.21),
                new Productos(2L, "mouse", "inalambrico", 15.25),
                new Productos(3L, "impresora" , "tinta continua" , 256.25 ));
    }
}
