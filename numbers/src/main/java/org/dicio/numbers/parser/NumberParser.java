package org.dicio.numbers.parser;

import org.dicio.numbers.parser.param.Gender;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public abstract class NumberParser {

    public abstract double extractNumber(String text, boolean shortScale, boolean ordinal);

    public abstract List<Double> extractNumbers(String text, boolean shortScale, boolean ordinal);

    public abstract long extractDuration(String text);

    public abstract LocalDateTime extractDateTime(String text,
                                                  boolean anchorDate,
                                                  LocalTime defaultTime);

    public abstract String normalize(String text, boolean removeArticles);


    public abstract Gender getGender(String text, String context);

    public abstract boolean isFractional(String text, boolean shortScale, boolean spoken);

    public abstract boolean isOrdinal(String text, boolean shortScale, boolean spoken);
}
