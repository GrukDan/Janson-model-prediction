package server.yansonModel;

import server.database.entities.Record;
import server.database.entities.Result;

import java.util.ArrayList;
import java.util.List;

public class CoefficientCalculator {

    public Result findValues(Record[] records, Result result) {
        switch (result.getCoefficient()) {
            case "Коэффициент независимости": {
                return coefficientOfIndependence(records, result);
            }
            case "Коэффициент финансирования": {
                return coefficientOfFinancing(records, result);
            }
            case "Коэффициент инвестирования собственных источников": {
                return CoefficientOfInvestmentOfOwnSources(records, result);
            }
            case "Коэффициент финансовой устойчивости": {
                return financialStabilityRatio(records, result);
            }
            case "Коэффициент инвестирования": {
                return investmentRatio(records, result);
            }
            case "Коэффициент абсолютной ликвидности": {
                return absoluteLliquidityRatio(records, result);
            }
            case "Уточнённый коэффициент ликвидности": {
                return refinedLiquidityRatio(records, result);
            }
            case "Общий коэффициент ликвидности": {
                return totalLiquidityRatio(records, result);
            }
        }
        return result;
    }

    private Result coefficientOfIndependence(Record[] records, Result result) {
        YansonModel yansonModel = new YansonModel();
        List<Double> assets = new ArrayList();
        List<Double> liabilities = new ArrayList();
        List<Double> relation = new ArrayList();
        List<Double> functionValues = new ArrayList<>();
        for (Record record : records) {
            assets.add(record.getAuthorizedCapital() +
                    record.getUndesterbutedProfits() +
                    record.getReserves() +
                    record.getSinkingFund());
            liabilities.add(record.getNetBalanceCurrency());
            relation.add((record.getAuthorizedCapital() +
                    record.getUndesterbutedProfits() +
                    record.getReserves() +
                    record.getSinkingFund()) / record.getNetBalanceCurrency());
        }
        boolean flag = true;
        Double[] assetsArray = new Double[assets.size()];
        assets.toArray(assetsArray);
        Double[] liabilitiesArray = new Double[liabilities.size()];
        liabilities.toArray(liabilitiesArray);
        Double[] relationArray = new Double[relation.size()];
        relation.toArray(relationArray);
        for (int i = 1; i <= result.getTerm(); i++) {
            functionValues.add(yansonModel.prognosisFunction(assetsArray, liabilitiesArray, i, flag));
            flag = !flag;
        }
        Double[] functionValuesArray = new Double[functionValues.size()];
        functionValues.toArray(functionValuesArray);
        result.setAssets(assetsArray);
        result.setLiabilities(liabilitiesArray);
        result.setRelation(relationArray);
        result.setFunctionValues(functionValuesArray);
        return result;
    }

    private Result coefficientOfFinancing(Record[] records, Result result) {
        YansonModel yansonModel = new YansonModel();
        List<Double> assets = new ArrayList();
        List<Double> liabilities = new ArrayList();
        List<Double> relation = new ArrayList();
        List<Double> functionValues = new ArrayList<>();
        for (Record record : records) {
            assets.add(record.getAuthorizedCapital() +
                    record.getUndesterbutedProfits() +
                    record.getReserves() +
                    record.getSinkingFund());
            liabilities.add(record.getShorttermDebt() +
                    record.getLongtermDebt());
            relation.add((record.getAuthorizedCapital() +
                    record.getUndesterbutedProfits() +
                    record.getReserves() +
                    record.getSinkingFund()) / (record.getShorttermDebt() +
                    record.getLongtermDebt()));
        }
        boolean flag = true;
        Double[] assetsArray = new Double[assets.size()];
        assets.toArray(assetsArray);
        Double[] liabilitiesArray = new Double[liabilities.size()];
        liabilities.toArray(liabilitiesArray);
        Double[] relationArray = new Double[relation.size()];
        relation.toArray(relationArray);
        for (int i = 1; i <= result.getTerm(); i++) {
            functionValues.add(yansonModel.prognosisFunction(assetsArray, liabilitiesArray, i, flag));
            flag = !flag;
        }
        Double[] functionValuesArray = new Double[functionValues.size()];
        functionValues.toArray(functionValuesArray);
        result.setAssets(assetsArray);
        result.setLiabilities(liabilitiesArray);
        result.setRelation(relationArray);
        result.setFunctionValues(functionValuesArray);
        return result;
    }

    private Result CoefficientOfInvestmentOfOwnSources(Record[] records, Result result) {
        YansonModel yansonModel = new YansonModel();
        List<Double> assets = new ArrayList();
        List<Double> liabilities = new ArrayList();
        List<Double> relation = new ArrayList();
        List<Double> functionValues = new ArrayList<>();
        for (Record record : records) {
            assets.add(record.getAuthorizedCapital() +
                    record.getUndesterbutedProfits() +
                    record.getReserves() +
                    record.getSinkingFund() +
                    record.getLongtermDebt());
            liabilities.add(record.getFixedAssets() +
                    record.getOtherInvestments());
            relation.add((record.getAuthorizedCapital() +
                    record.getUndesterbutedProfits() +
                    record.getReserves() +
                    record.getSinkingFund() +
                    record.getLongtermDebt()) / (record.getFixedAssets() +
                    record.getOtherInvestments()));
        }
        boolean flag = true;
        Double[] assetsArray = new Double[assets.size()];
        assets.toArray(assetsArray);
        Double[] liabilitiesArray = new Double[liabilities.size()];
        liabilities.toArray(liabilitiesArray);
        Double[] relationArray = new Double[relation.size()];
        relation.toArray(relationArray);
        for (int i = 1; i <= result.getTerm(); i++) {
            functionValues.add(yansonModel.prognosisFunction(assetsArray, liabilitiesArray, i, flag));
            flag = !flag;
        }
        Double[] functionValuesArray = new Double[functionValues.size()];
        functionValues.toArray(functionValuesArray);
        result.setAssets(assetsArray);
        result.setLiabilities(liabilitiesArray);
        result.setRelation(relationArray);
        result.setFunctionValues(functionValuesArray);
        return result;
    }

    private Result financialStabilityRatio(Record[] records, Result result) {
        YansonModel yansonModel = new YansonModel();
        List<Double> assets = new ArrayList();
        List<Double> liabilities = new ArrayList();
        List<Double> relation = new ArrayList();
        List<Double> functionValues = new ArrayList<>();
        for (Record record : records) {
            assets.add(record.getAuthorizedCapital() +
                    record.getUndesterbutedProfits() +
                    record.getReserves() +
                    record.getSinkingFund()+
                    record.getLongtermDebt());
            liabilities.add(record.getNetBalanceCurrency());
            relation.add((record.getAuthorizedCapital() +
                    record.getUndesterbutedProfits() +
                    record.getReserves() +
                    record.getSinkingFund()+
                    record.getLongtermDebt()) / record.getNetBalanceCurrency());
        }
        boolean flag = true;
        Double[] assetsArray = new Double[assets.size()];
        assets.toArray(assetsArray);
        Double[] liabilitiesArray = new Double[liabilities.size()];
        liabilities.toArray(liabilitiesArray);
        Double[] relationArray = new Double[relation.size()];
        relation.toArray(relationArray);
        for (int i = 1; i <= result.getTerm(); i++) {
            functionValues.add(yansonModel.prognosisFunction(assetsArray, liabilitiesArray, i, flag));
            flag = !flag;
        }
        Double[] functionValuesArray = new Double[functionValues.size()];
        functionValues.toArray(functionValuesArray);
        result.setAssets(assetsArray);
        result.setLiabilities(liabilitiesArray);
        result.setFunctionValues(functionValuesArray);
        result.setRelation(relationArray);
        return result;
    }

    private Result investmentRatio(Record[] records, Result result) {
        YansonModel yansonModel = new YansonModel();
        List<Double> assets = new ArrayList();
        List<Double> liabilities = new ArrayList();
        List<Double> relation = new ArrayList();
        List<Double> functionValues = new ArrayList<>();
        for (Record record : records) {
            assets.add(record.getAuthorizedCapital() +
                    record.getUndesterbutedProfits() +
                    record.getReserves() +
                    record.getSinkingFund());
            liabilities.add(record.getFixedAssets() +
                    record.getOtherInvestments());
            relation.add((record.getAuthorizedCapital() +
                    record.getUndesterbutedProfits() +
                    record.getReserves() +
                    record.getSinkingFund()) / (record.getFixedAssets() +
                    record.getOtherInvestments()));
        }
        boolean flag = true;
        Double[] assetsArray = new Double[assets.size()];
        assets.toArray(assetsArray);
        Double[] liabilitiesArray = new Double[liabilities.size()];
        liabilities.toArray(liabilitiesArray);
        Double[] relationArray = new Double[relation.size()];
        relation.toArray(relationArray);
        for (int i = 1; i <= result.getTerm(); i++) {
            functionValues.add(yansonModel.prognosisFunction(assetsArray, liabilitiesArray, i, flag));
            flag = !flag;
        }
        Double[] functionValuesArray = new Double[functionValues.size()];
        functionValues.toArray(functionValuesArray);
        result.setAssets(assetsArray);
        result.setLiabilities(liabilitiesArray);
        result.setFunctionValues(functionValuesArray);
        result.setRelation(relationArray);
        return result;
    }

    private Result absoluteLliquidityRatio(Record[] records, Result result) {
        YansonModel yansonModel = new YansonModel();
        List<Double> assets = new ArrayList();
        List<Double> liabilities = new ArrayList();
        List<Double> relation = new ArrayList();
        List<Double> functionValues = new ArrayList<>();
        for (Record record : records) {
            assets.add(record.getCash() +
                    record.getSecurites());
            liabilities.add(record.getShorttermDebt());
            relation.add((record.getCash() +
                    record.getSecurites()) / record.getShorttermDebt());
        }
        boolean flag = true;
        Double[] assetsArray = new Double[assets.size()];
        assets.toArray(assetsArray);
        Double[] liabilitiesArray = new Double[liabilities.size()];
        liabilities.toArray(liabilitiesArray);
        Double[] relationArray = new Double[relation.size()];
        relation.toArray(relationArray);
        for (int i = 1; i <= result.getTerm(); i++) {
            functionValues.add(yansonModel.prognosisFunction(assetsArray, liabilitiesArray, i, flag));
            flag = !flag;
        }
        Double[] functionValuesArray = new Double[functionValues.size()];
        functionValues.toArray(functionValuesArray);
        result.setAssets(assetsArray);
        result.setLiabilities(liabilitiesArray);
        result.setFunctionValues(functionValuesArray);
        result.setRelation(relationArray);
        return result;
    }

    private Result refinedLiquidityRatio(Record[] records, Result result) {
        YansonModel yansonModel = new YansonModel();
        List<Double> assets = new ArrayList();
        List<Double> liabilities = new ArrayList();
        List<Double> relation = new ArrayList();
        List<Double> functionValues = new ArrayList<>();
        for (Record record : records) {
            assets.add(record.getCash() +
                    record.getSecurites() +
                    record.getAccountsReceivable());
            liabilities.add(record.getShorttermDebt());
            relation.add((record.getCash() +
                    record.getSecurites() +
                    record.getAccountsReceivable()) / record.getShorttermDebt());
        }
        boolean flag = true;
        Double[] assetsArray = new Double[assets.size()];
        assets.toArray(assetsArray);
        Double[] liabilitiesArray = new Double[liabilities.size()];
        liabilities.toArray(liabilitiesArray);
        Double[] relationArray = new Double[relation.size()];
        relation.toArray(relationArray);
        for (int i = 1; i <= result.getTerm(); i++) {
            functionValues.add(yansonModel.prognosisFunction(assetsArray, liabilitiesArray, i, flag));
            flag = !flag;
        }
        Double[] functionValuesArray = new Double[functionValues.size()];
        functionValues.toArray(functionValuesArray);
        result.setAssets(assetsArray);
        result.setLiabilities(liabilitiesArray);
        result.setFunctionValues(functionValuesArray);
        result.setRelation(relationArray);
        return result;
    }

    private Result totalLiquidityRatio(Record[] records, Result result) {
        YansonModel yansonModel = new YansonModel();
        List<Double> assets = new ArrayList();
        List<Double> liabilities = new ArrayList();
        List<Double> relation = new ArrayList();
        List<Double> functionValues = new ArrayList<>();
        for (Record record : records) {
            assets.add(record.getFixedAssets());
            liabilities.add(record.getShorttermDebt());
            relation.add(record.getFixedAssets() / record.getShorttermDebt());
        }
        boolean flag = true;
        Double[] assetsArray = new Double[assets.size()];
        assets.toArray(assetsArray);
        Double[] liabilitiesArray = new Double[liabilities.size()];
        liabilities.toArray(liabilitiesArray);
        Double[] relationArray = new Double[relation.size()];
        relation.toArray(relationArray);
        for (int i = 1; i <= result.getTerm(); i++) {
            functionValues.add(yansonModel.prognosisFunction(assetsArray, liabilitiesArray, i, flag));
            flag = !flag;
        }
        Double[] functionValuesArray = new Double[functionValues.size()];
        functionValues.toArray(functionValuesArray);
        result.setAssets(assetsArray);
        result.setLiabilities(liabilitiesArray);
        result.setFunctionValues(functionValuesArray);
        result.setRelation(relationArray);
        return result;
    }
}
