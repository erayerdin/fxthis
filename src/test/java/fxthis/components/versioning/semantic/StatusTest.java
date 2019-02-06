package fxthis.components.versioning.semantic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusTest {
    @Test
    void getStatusSnapshot() {
        assertEquals(Status.SNAPSHOT, Status.getStatus("snapshot"));
    }

    @Test
    void getStatusPrealpha() {
        assertEquals(Status.PREALPHA, Status.getStatus("prealpha"));
    }

    @Test
    void getStatusAlpha() {
        assertEquals(Status.ALPHA, Status.getStatus("alpha"));
    }

    @Test
    void getStatusBeta() {
        assertEquals(Status.BETA, Status.getStatus("beta"));
    }

    @Test
    void getStatusStable() {
        assertEquals(Status.STABLE, Status.getStatus("stable"));
    }

    @Test
    void getStatus() {
        assertEquals(Status.STABLE, Status.getStatus("foo"));
        assertEquals(Status.STABLE, Status.getStatus(null));
    }
}