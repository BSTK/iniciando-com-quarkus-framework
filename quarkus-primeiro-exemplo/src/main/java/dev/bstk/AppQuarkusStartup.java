package dev.bstk;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppQuarkusStartup implements QuarkusApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppQuarkusStartup.class);

    @Override
    public int run(String... args) throws Exception {
        LOGGER.info("Manipula os parametros ... {}", (Object[]) args);

        Quarkus.waitForExit();
        return 0;
    }

}
