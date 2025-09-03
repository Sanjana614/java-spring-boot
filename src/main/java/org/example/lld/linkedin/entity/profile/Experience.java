package org.example.lld.linkedin.entity.profile;

import java.time.YearMonth;

public class Experience {
    private final String title;
    private final String company;
    private final YearMonth startYear;
    private final YearMonth endYear;

    public Experience(String title, String company, YearMonth startYear, YearMonth endYear) {
        this.title = title;
        this.company = company;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public YearMonth getStartYear() {
        return startYear;
    }

    public YearMonth getEndYear() {
        return endYear;
    }

    @Override
    public String toString() {
        return String.format("%s at %s (%s to %s)", title, company, startYear, endYear == null ? "Present" : endYear);
    }
}
