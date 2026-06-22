package Rechner;

public class Rechner {
        private double Volt;
    private double Ampere;
    private int winkelIn;
    private double winkelGrad;
    private String präfixus;
    private String präfixusMaximus;
    private double phi;

    //Umrechnung von Wattauf mWatt
    public static double umRechner(double p){
        return p*1000;
    }
    //Meine wirkleistungsmethode
    public static double berechneWirkleistung(double Volt, double Ampere, int winkelIn, double WinkelGrad, double phi, String präfix, String präfixusMaximus){
        if (winkelIn == 1) {
            phi = Math.toRadians(WinkelGrad);
        }else{
            phi = WinkelGrad;
        }
        if (präfix == "Kilo"){
            Volt = Volt*1000;
        }else if(präfix == "milli"){
            Volt = Volt*0.001;
        }else{
            
            Volt = Volt;
        }
        if(präfixusMaximus == "Kilo"){
            Ampere = Ampere * 1000;
        }else if(präfixusMaximus == "milli"){
            Ampere = Ampere * 0.001;
        }else{
            Ampere = Ampere;
        }
        return Volt * Ampere * Math.cos(phi);
    }
    }

