package org.dicio.numbers.param;

import org.dicio.numbers.NumberFormatter;

import java.time.Duration;

public class NiceDurationParameters {

    private final NumberFormatter numberFormatter;
    private final Duration duration;

    // default values
    private boolean speech = true;

    public NiceDurationParameters(final NumberFormatter numberFormatter, final Duration duration) {
        this.numberFormatter = numberFormatter;
        this.duration = duration;
    }

    public NiceDurationParameters speech(final boolean speech) {
        this.speech = speech;
        return this;
    }

    public String get() {
        return numberFormatter.niceDuration(duration, speech);
    }
}
