package org.example.lld.linkedin.entity.profile;

import java.time.YearMonth;

public class Education {
    private final String institute;
    private final String stream;
    private final YearMonth startYear;
    private final YearMonth endYear;

    public Education(String institute, String stream, YearMonth startYear, YearMonth endYear) {
        this.institute = institute;
        this.stream = stream;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public String getInstitute() {
        return institute;
    }

    public String getStream() {
        return stream;
    }

    public YearMonth getStartYear() {
        return startYear;
    }

    public YearMonth getEndYear() {
        return endYear;
    }

    @Override
    public String toString() {
        return "Education{" +
                "institute='" + institute + '\'' +
                ", stream='" + stream + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                '}';
    }
}
