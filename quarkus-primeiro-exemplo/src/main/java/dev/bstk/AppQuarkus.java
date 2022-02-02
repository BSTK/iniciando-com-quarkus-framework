package dev.bstk;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class AppQuarkus {

    public static void main(String[] args) {
        Quarkus.run(args);
    }
}
