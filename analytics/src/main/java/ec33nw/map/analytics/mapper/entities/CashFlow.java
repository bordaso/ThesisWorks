package ec33nw.map.analytics.mapper.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class CashFlow extends Report {

    private static final Long serialVersionUID = 3659383763381838960L;

    private BigDecimal netIncome;
    private BigDecimal depreciation;
    private BigDecimal changesInReceivables;
    private BigDecimal changesInInventories;
    private BigDecimal cashChange;
    private BigDecimal cashFlow;
    private BigDecimal capitalExpenditures;
    private BigDecimal investments;
    private BigDecimal investingActivityOther;
    private BigDecimal totalInvestingCashFlows;
    private BigDecimal dividendsPaid;
    private BigDecimal netBorrowings;
    private BigDecimal otherFinancingCashFlows;
    private BigDecimal cashFlowFinancing;
    private BigDecimal exchangeRateEffect;

    @JsonCreator
    public CashFlow(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("id") final String id,
            @JsonProperty("key") final String key,
            @JsonProperty("subkey") final String subkey,
            @JsonProperty("updated") final Long updated,
            @JsonProperty("date") final Long date,
            @JsonProperty("reportDate") final LocalDate reportDate,
            @JsonProperty("fiscalDate") final LocalDate fiscalDate,
            @JsonProperty("currency") final String currency,
            @JsonProperty("netIncome") final BigDecimal netIncome,
            @JsonProperty("depreciation") final BigDecimal depreciation,
            @JsonProperty("changesInReceivables") final BigDecimal changesInReceivables,
            @JsonProperty("changesInInventories") final BigDecimal changesInInventories,
            @JsonProperty("cashChange") final BigDecimal cashChange,
            @JsonProperty("cashFlow") final BigDecimal cashFlow,
            @JsonProperty("capitalExpenditures") final BigDecimal capitalExpenditures,
            @JsonProperty("investments") final BigDecimal investments,
            @JsonProperty("investingActivityOther") final BigDecimal investingActivityOther,
            @JsonProperty("totalInvestingCashFlows") final BigDecimal totalInvestingCashFlows,
            @JsonProperty("dividendsPaid") final BigDecimal dividendsPaid,
            @JsonProperty("netBorrowings") final BigDecimal netBorrowings,
            @JsonProperty("otherFinancingCashFlows") final BigDecimal otherFinancingCashFlows,
            @JsonProperty("cashFlowFinancing") final BigDecimal cashFlowFinancing,
            @JsonProperty("exchangeRateEffect") final BigDecimal exchangeRateEffect,
            @JsonProperty("filingType") final String filingType,
            @JsonProperty("fiscalQuarter") final BigDecimal fiscalQuarter,
            @JsonProperty("fiscalYear") final BigDecimal fiscalYear) {
        super(symbol, id, key, subkey, updated, reportDate, filingType, fiscalDate, fiscalQuarter, fiscalYear,
                currency, date);
        this.netIncome = netIncome;
        this.depreciation = depreciation;
        this.changesInReceivables = changesInReceivables;
        this.changesInInventories = changesInInventories;
        this.cashChange = cashChange;
        this.cashFlow = cashFlow;
        this.capitalExpenditures = capitalExpenditures;
        this.investments = investments;
        this.investingActivityOther = investingActivityOther;
        this.totalInvestingCashFlows = totalInvestingCashFlows;
        this.dividendsPaid = dividendsPaid;
        this.netBorrowings = netBorrowings;
        this.otherFinancingCashFlows = otherFinancingCashFlows;
        this.cashFlowFinancing = cashFlowFinancing;
        this.exchangeRateEffect = exchangeRateEffect;
    }

    public BigDecimal getNetIncome() {
        return netIncome;
    }

    public BigDecimal getDepreciation() {
        return depreciation;
    }

    public BigDecimal getChangesInReceivables() {
        return changesInReceivables;
    }

    public BigDecimal getChangesInInventories() {
        return changesInInventories;
    }

    public BigDecimal getCashChange() {
        return cashChange;
    }

    public BigDecimal getCashFlow() {
        return cashFlow;
    }

    public BigDecimal getCapitalExpenditures() {
        return capitalExpenditures;
    }

    public BigDecimal getInvestments() {
        return investments;
    }

    public BigDecimal getInvestingActivityOther() {
        return investingActivityOther;
    }

    public BigDecimal getTotalInvestingCashFlows() {
        return totalInvestingCashFlows;
    }

    public BigDecimal getDividendsPaid() {
        return dividendsPaid;
    }

    public BigDecimal getNetBorrowings() {
        return netBorrowings;
    }

    public BigDecimal getOtherFinancingCashFlows() {
        return otherFinancingCashFlows;
    }

    public BigDecimal getCashFlowFinancing() {
        return cashFlowFinancing;
    }

    public BigDecimal getExchangeRateEffect() {
        return exchangeRateEffect;
    }

    public void setNetIncome(BigDecimal netIncome) {
		this.netIncome = netIncome;
	}

	public void setDepreciation(BigDecimal depreciation) {
		this.depreciation = depreciation;
	}

	public void setChangesInReceivables(BigDecimal changesInReceivables) {
		this.changesInReceivables = changesInReceivables;
	}

	public void setChangesInInventories(BigDecimal changesInInventories) {
		this.changesInInventories = changesInInventories;
	}

	public void setCashChange(BigDecimal cashChange) {
		this.cashChange = cashChange;
	}

	public void setCashFlow(BigDecimal cashFlow) {
		this.cashFlow = cashFlow;
	}

	public void setCapitalExpenditures(BigDecimal capitalExpenditures) {
		this.capitalExpenditures = capitalExpenditures;
	}

	public void setInvestments(BigDecimal investments) {
		this.investments = investments;
	}

	public void setInvestingActivityOther(BigDecimal investingActivityOther) {
		this.investingActivityOther = investingActivityOther;
	}

	public void setTotalInvestingCashFlows(BigDecimal totalInvestingCashFlows) {
		this.totalInvestingCashFlows = totalInvestingCashFlows;
	}

	public void setDividendsPaid(BigDecimal dividendsPaid) {
		this.dividendsPaid = dividendsPaid;
	}

	public void setNetBorrowings(BigDecimal netBorrowings) {
		this.netBorrowings = netBorrowings;
	}

	public void setOtherFinancingCashFlows(BigDecimal otherFinancingCashFlows) {
		this.otherFinancingCashFlows = otherFinancingCashFlows;
	}

	public void setCashFlowFinancing(BigDecimal cashFlowFinancing) {
		this.cashFlowFinancing = cashFlowFinancing;
	}

	public void setExchangeRateEffect(BigDecimal exchangeRateEffect) {
		this.exchangeRateEffect = exchangeRateEffect;
	}

	@Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final CashFlow cashFlow1 = (CashFlow) o;
        return Objects.equals(netIncome, cashFlow1.netIncome) &&
                Objects.equals(depreciation, cashFlow1.depreciation) &&
                Objects.equals(changesInReceivables, cashFlow1.changesInReceivables) &&
                Objects.equals(changesInInventories, cashFlow1.changesInInventories) &&
                Objects.equals(cashChange, cashFlow1.cashChange) &&
                Objects.equals(cashFlow, cashFlow1.cashFlow) &&
                Objects.equals(capitalExpenditures, cashFlow1.capitalExpenditures) &&
                Objects.equals(investments, cashFlow1.investments) &&
                Objects.equals(investingActivityOther, cashFlow1.investingActivityOther) &&
                Objects.equals(totalInvestingCashFlows, cashFlow1.totalInvestingCashFlows) &&
                Objects.equals(dividendsPaid, cashFlow1.dividendsPaid) &&
                Objects.equals(netBorrowings, cashFlow1.netBorrowings) &&
                Objects.equals(otherFinancingCashFlows, cashFlow1.otherFinancingCashFlows) &&
                Objects.equals(cashFlowFinancing, cashFlow1.cashFlowFinancing) &&
                Objects.equals(exchangeRateEffect, cashFlow1.exchangeRateEffect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), netIncome, depreciation, changesInReceivables, changesInInventories,
                cashChange, cashFlow, capitalExpenditures, investments, investingActivityOther, totalInvestingCashFlows,
                dividendsPaid, netBorrowings, otherFinancingCashFlows, cashFlowFinancing, exchangeRateEffect);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("netIncome", netIncome)
                .add("depreciation", depreciation)
                .add("changesInReceivables", changesInReceivables)
                .add("changesInInventories", changesInInventories)
                .add("cashChange", cashChange)
                .add("cashFlow", cashFlow)
                .add("capitalExpenditures", capitalExpenditures)
                .add("investments", investments)
                .add("investingActivityOther", investingActivityOther)
                .add("totalInvestingCashFlows", totalInvestingCashFlows)
                .add("dividendsPaid", dividendsPaid)
                .add("netBorrowings", netBorrowings)
                .add("otherFinancingCashFlows", otherFinancingCashFlows)
                .add("cashFlowFinancing", cashFlowFinancing)
                .add("exchangeRateEffect", exchangeRateEffect)
                .toString();
    }

}
