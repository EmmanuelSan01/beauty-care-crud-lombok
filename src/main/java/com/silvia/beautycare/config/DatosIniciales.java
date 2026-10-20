package com.silvia.beautycare.config;

import com.silvia.beautycare.model.Producto;
import com.silvia.beautycare.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Carga unos productos de ejemplo la primera vez (solo si la tabla esta vacia),
 * para que la lista no aparezca en blanco. Son datos de muestra.
 *
 * @Slf4j (Lombok) crea la variable "log" para escribir mensajes en la consola.
 */
@Slf4j
@Configuration
public class DatosIniciales {

    @Bean
    ApplicationRunner cargarProductosDeEjemplo(ProductoRepository repo) {
        return args -> {
            if (repo.contar() > 0) {
                return;
            }
            repo.crear(ejemplo("Joseph Sneider Villamizar", "CSU 2-1", 1, 20,
                    "Para estudiar."));
            repo.crear(ejemplo("Emmanuel Sánchez Estepa", "CSU 2-2", 2, 15,
                    "Para hacer tarea."));
            repo.crear(ejemplo("Juan Sebastián Bohorquez", "CSU 2-3", 1, 10,
                    "Para trabajar."));
            repo.crear(ejemplo("Juan Fernando Umaña", "CSU 2-1", 3, 12,
                    "Para jugar."));
            repo.crear(ejemplo("Sebartián Torres", "CSU 2-2", 1, 8,
                    "Para investigar."));
            repo.crear(ejemplo("Jimmy Andrés Carpeta", "CSU 2-3", 2, 11,
                    "Para desplegar."));
            repo.crear(ejemplo("Juan Carpeta", "CSU 2-1", 3, 10,
                    "Para hackear."));
            log.info("Se cargaron {} productos de ejemplo", repo.contar());
        };
    }

    private static Producto ejemplo(String usuario, String sala, int horas, int equipo, String motivo) {
        return Producto.builder()
                .usuario(usuario)
                .sala(sala)
                .horas(horas)
                .equipo(equipo)
                .motivo(motivo)
                .build();
    }
}
