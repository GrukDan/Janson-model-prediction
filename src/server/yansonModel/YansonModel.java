package server.yansonModel;

public class YansonModel {

    public Double Xcp(Double An, Double A0, int n) {
        return (Math.log(An) / Math.log(A0)) / n;
    }

    public Double Ycp(Double Bn, Double B0, int n) {
        return (Math.log(Bn) / Math.log(B0)) / n;
    }

    public Double Xi(Double A, Double A_1) {
        return Math.log(A_1) - Math.log(A);
    }

    public Double Yi(Double B, Double B_1) {
        return Math.log(B_1) - Math.log(B);
    }

    public Double sigmaAsquared(Double[] arrayOfSourceDataA) {
        Double Xcp = Xcp(arrayOfSourceDataA[0], arrayOfSourceDataA[arrayOfSourceDataA.length - 1], arrayOfSourceDataA.length);
        Double sigmaA = new Double("0");
        for (int i = 0; i < arrayOfSourceDataA.length; i++) {
            if ((i + 2) < arrayOfSourceDataA.length)
                sigmaA += Math.pow((Xi(arrayOfSourceDataA[i], arrayOfSourceDataA[i + 1]) - Xcp), 2.0);
        }
        return sigmaA / arrayOfSourceDataA.length;
    }

    public Double sigmaBsquared(Double[] arrayOfSourceDataB) {
        Double Ycp = Ycp(arrayOfSourceDataB[0], arrayOfSourceDataB[arrayOfSourceDataB.length - 1], arrayOfSourceDataB.length);
        Double sigmaB = new Double("0");
        for (int i = 0; i < arrayOfSourceDataB.length; i++) {
            if ((i + 2) < arrayOfSourceDataB.length)
                sigmaB += Math.pow((Yi(arrayOfSourceDataB[i], arrayOfSourceDataB[i + 1]) - Ycp), 2.0);
        }
        return sigmaB / arrayOfSourceDataB.length;
    }

    public Double tetaA(Double Xcp, Double sigmaAsquared) {
        return Xcp + sigmaAsquared / 2;
    }

    public Double tetaB(Double Ycp, Double sigmaBsquared) {
        return Ycp + sigmaBsquared / 2;
    }

    public Double Z(boolean flag) {
        double a = Math.random();
        if (flag) {
            return Math.pow((-2.0 * Math.log(a)), 1 / 2) * Math.cos(2 * Math.PI * a);
        } else {
            return Math.pow((-2.0 * Math.log(a)), 1 / 2) * Math.sin(2 * Math.PI * a);
        }
    }

    public Double sigmaAsquaredHatch(Double sigmaAsquared) {
        return sigmaAsquared;
    }

    public Double sigmaBsquaredHatch(Double sigmaBsquared) {
        return sigmaBsquared;
    }

    public Double At(Double[] arrayOfSourceDataA, int t, boolean flag) {
        return arrayOfSourceDataA[0] * Math.pow(Math.E,
                (((tetaA(Xcp(arrayOfSourceDataA[arrayOfSourceDataA.length-1], arrayOfSourceDataA[0], arrayOfSourceDataA.length), sigmaAsquared(arrayOfSourceDataA))
                        - 0.5*(sigmaAsquaredHatch(sigmaAsquared(arrayOfSourceDataA))))*t
                        + (sigmaAsquared(arrayOfSourceDataA) * Z(flag)))));
    }

    public Double Bt(Double[] arrayOfSourceDataB, int t, boolean flag) {
        return arrayOfSourceDataB[0] * Math.pow(Math.E,
                (((tetaB(Xcp(arrayOfSourceDataB[arrayOfSourceDataB.length-1], arrayOfSourceDataB[0], arrayOfSourceDataB.length), sigmaBsquared(arrayOfSourceDataB))
                        - 0.5*(sigmaBsquaredHatch(sigmaBsquared(arrayOfSourceDataB))))*t
                        + (sigmaBsquared(arrayOfSourceDataB) * Z(flag)))));
    }

    public Double prognosisFunction(Double[] arrayOfSourceDataA,Double[] arrayOfSourceDataB,int t,boolean flag){
        return  Math.log(At(arrayOfSourceDataA,t,flag)/Bt(arrayOfSourceDataB,t,flag));
    }
}
