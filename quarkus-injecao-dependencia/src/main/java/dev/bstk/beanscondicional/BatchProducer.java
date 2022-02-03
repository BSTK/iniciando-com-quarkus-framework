package dev.bstk.beanscondicional;

import io.quarkus.arc.DefaultBean;
import io.quarkus.arc.profile.IfBuildProfile;

import javax.enterprise.inject.Produces;

public class BatchProducer {

    @Produces
    @DefaultBean
    public Batch batchAWS() {
        return new BatchProcessamentoAWS();
    }

    @Produces
    @IfBuildProfile("nuvem-gcp")
    public Batch batchGCP() {
        return new BatchProcessamentoGCP();
    }

    @Produces
    @IfBuildProfile("nuvem-azure")
    public Batch batchAzure() {
        return new BatchProcessamentoAzure();
    }

    @Produces
    @IfBuildProfile("nuvem-ibm")
    public Batch batchIBM() {
        return new BatchProcessamentoIBM();
    }

    @Produces
    @IfBuildProfile("nuvem-oci")
    public Batch batchOCI() {
        return new BatchProcessamentoOCI();
    }
}
