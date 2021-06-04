package com.isaProject.isa.Model.DTO;

public class AnnualReportDTO {

    private int jan;
    private int feb;
    private int mart;
    private int apr;
    private int maj;
    private int jun;
    private int jul;
    private int avg;
    private int sep;
    private int okt;
    private int nov;
    private int dec;

    public AnnualReportDTO(int jan, int feb, int mart, int apr, int maj, int jun, int jul, int avg, int sep, int okt, int nov, int dec) {
        this.jan = jan;
        this.feb = feb;
        this.mart = mart;
        this.apr = apr;
        this.maj = maj;
        this.jun = jun;
        this.jul = jul;
        this.avg = avg;
        this.sep = sep;
        this.okt = okt;
        this.nov = nov;
        this.dec = dec;
    }

    public AnnualReportDTO() {
    }


    public int getJan() {
        return jan;
    }

    public void setJan(int jan) {
        this.jan = jan;
    }

    public int getFeb() {
        return feb;
    }

    public void setFeb(int feb) {
        this.feb = feb;
    }

    public int getMart() {
        return mart;
    }

    public void setMart(int mart) {
        this.mart = mart;
    }

    public int getApr() {
        return apr;
    }

    public void setApr(int apr) {
        this.apr = apr;
    }

    public int getMaj() {
        return maj;
    }

    public void setMaj(int maj) {
        this.maj = maj;
    }

    public int getJun() {
        return jun;
    }

    public void setJun(int jun) {
        this.jun = jun;
    }

    public int getJul() {
        return jul;
    }

    public void setJul(int jul) {
        this.jul = jul;
    }

    public int getAvg() {
        return avg;
    }

    public void setAvg(int avg) {
        this.avg = avg;
    }

    public int getSep() {
        return sep;
    }

    public void setSep(int sep) {
        this.sep = sep;
    }

    public int getOkt() {
        return okt;
    }

    public void setOkt(int okt) {
        this.okt = okt;
    }

    public int getNov() {
        return nov;
    }

    public void setNov(int nov) {
        this.nov = nov;
    }

    public int getDec() {
        return dec;
    }

    public void setDec(int dec) {
        this.dec = dec;
    }
}
