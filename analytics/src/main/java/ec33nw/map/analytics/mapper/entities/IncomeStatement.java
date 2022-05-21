package ec33nw.map.analytics.mapper.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class IncomeStatement extends Report {

	private static final long serialVersionUID = -1413080264580022740L;

	private BigDecimal totalRevenue;
	private BigDecimal costOfRevenue;
	private BigDecimal ebit;
	private BigDecimal grossProfit;
	private BigDecimal incomeTax;
	private BigDecimal interestIncome;
	private BigDecimal minorityInterest;
	private BigDecimal netIncome;
	private BigDecimal netIncomeBasic;
	private BigDecimal operatingExpense;
	private BigDecimal operatingIncome;
	private BigDecimal otherIncomeExpenseNet;
	private BigDecimal pretaxIncome;
	private BigDecimal researchAndDevelopment;
	private BigDecimal sellingGeneralAndAdmin;

	@JsonCreator
	public IncomeStatement(@JsonProperty("symbol") final String symbol, @JsonProperty("id") final String id,
			@JsonProperty("key") final String key, @JsonProperty("subkey") final String subkey,
			@JsonProperty("updated") final Long updated, @JsonProperty("date") final Long date,
			@JsonProperty("reportDate") final LocalDate reportDate,
			@JsonProperty("fiscalDate") final LocalDate fiscalDate, @JsonProperty("currency") final String currency,
			@JsonProperty("totalRevenue") final BigDecimal totalRevenue,
			@JsonProperty("costOfRevenue") final BigDecimal costOfRevenue,
			@JsonProperty("grossProfit") final BigDecimal grossProfit,
			@JsonProperty("researchAndDevelopment") final BigDecimal researchAndDevelopment,
			@JsonProperty("sellingGeneralAndAdmin") final BigDecimal sellingGeneralAndAdmin,
			@JsonProperty("operatingExpense") final BigDecimal operatingExpense,
			@JsonProperty("operatingIncome") final BigDecimal operatingIncome,
			@JsonProperty("otherIncomeExpenseNet") final BigDecimal otherIncomeExpenseNet,
			@JsonProperty("ebit") final BigDecimal ebit,
			@JsonProperty("interestIncome") final BigDecimal interestIncome,
			@JsonProperty("pretaxIncome") final BigDecimal pretaxIncome,
			@JsonProperty("incomeTax") final BigDecimal incomeTax,
			@JsonProperty("minorityInterest") final BigDecimal minorityInterest,
			@JsonProperty("netIncome") final BigDecimal netIncome,
			@JsonProperty("netIncomeBasic") final BigDecimal netIncomeBasic,
			@JsonProperty("filingType") final String filingType,
			@JsonProperty("fiscalQuarter") final BigDecimal fiscalQuarter,
			@JsonProperty("fiscalYear") final BigDecimal fiscalYear) {
		super(symbol, id, key, subkey, updated, reportDate, filingType, fiscalDate, fiscalQuarter, fiscalYear, currency,
				date);
		this.totalRevenue = totalRevenue;
		this.costOfRevenue = costOfRevenue;
		this.grossProfit = grossProfit;
		this.researchAndDevelopment = researchAndDevelopment;
		this.sellingGeneralAndAdmin = sellingGeneralAndAdmin;
		this.operatingExpense = operatingExpense;
		this.operatingIncome = operatingIncome;
		this.otherIncomeExpenseNet = otherIncomeExpenseNet;
		this.ebit = ebit;
		this.interestIncome = interestIncome;
		this.pretaxIncome = pretaxIncome;
		this.incomeTax = incomeTax;
		this.minorityInterest = minorityInterest;
		this.netIncome = netIncome;
		this.netIncomeBasic = netIncomeBasic;
	}

	public BigDecimal getTotalRevenue() {
		return totalRevenue;
	}

	public BigDecimal getCostOfRevenue() {
		return costOfRevenue;
	}

	public BigDecimal getGrossProfit() {
		return grossProfit;
	}

	public BigDecimal getResearchAndDevelopment() {
		return researchAndDevelopment;
	}

	public BigDecimal getSellingGeneralAndAdmin() {
		return sellingGeneralAndAdmin;
	}

	public BigDecimal getOperatingExpense() {
		return operatingExpense;
	}

	public BigDecimal getOperatingIncome() {
		return operatingIncome;
	}

	public BigDecimal getOtherIncomeExpenseNet() {
		return otherIncomeExpenseNet;
	}

	public BigDecimal getEbit() {
		return ebit;
	}

	public BigDecimal getInterestIncome() {
		return interestIncome;
	}

	public BigDecimal getPretaxIncome() {
		return pretaxIncome;
	}

	public BigDecimal getIncomeTax() {
		return incomeTax;
	}

	public BigDecimal getMinorityInterest() {
		return minorityInterest;
	}

	public BigDecimal getNetIncome() {
		return netIncome;
	}

	public BigDecimal getNetIncomeBasic() {
		return netIncomeBasic;
	}

	public void setTotalRevenue(BigDecimal totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public void setCostOfRevenue(BigDecimal costOfRevenue) {
		this.costOfRevenue = costOfRevenue;
	}

	public void setEbit(BigDecimal ebit) {
		this.ebit = ebit;
	}

	public void setGrossProfit(BigDecimal grossProfit) {
		this.grossProfit = grossProfit;
	}

	public void setIncomeTax(BigDecimal incomeTax) {
		this.incomeTax = incomeTax;
	}

	public void setInterestIncome(BigDecimal interestIncome) {
		this.interestIncome = interestIncome;
	}

	public void setMinorityInterest(BigDecimal minorityInterest) {
		this.minorityInterest = minorityInterest;
	}

	public void setNetIncome(BigDecimal netIncome) {
		this.netIncome = netIncome;
	}

	public void setNetIncomeBasic(BigDecimal netIncomeBasic) {
		this.netIncomeBasic = netIncomeBasic;
	}

	public void setOperatingExpense(BigDecimal operatingExpense) {
		this.operatingExpense = operatingExpense;
	}

	public void setOperatingIncome(BigDecimal operatingIncome) {
		this.operatingIncome = operatingIncome;
	}

	public void setOtherIncomeExpenseNet(BigDecimal otherIncomeExpenseNet) {
		this.otherIncomeExpenseNet = otherIncomeExpenseNet;
	}

	public void setPretaxIncome(BigDecimal pretaxIncome) {
		this.pretaxIncome = pretaxIncome;
	}

	public void setResearchAndDevelopment(BigDecimal researchAndDevelopment) {
		this.researchAndDevelopment = researchAndDevelopment;
	}

	public void setSellingGeneralAndAdmin(BigDecimal sellingGeneralAndAdmin) {
		this.sellingGeneralAndAdmin = sellingGeneralAndAdmin;
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
		final IncomeStatement that = (IncomeStatement) o;
		return Objects.equals(totalRevenue, that.totalRevenue) && Objects.equals(costOfRevenue, that.costOfRevenue)
				&& Objects.equals(grossProfit, that.grossProfit)
				&& Objects.equals(researchAndDevelopment, that.researchAndDevelopment)
				&& Objects.equals(sellingGeneralAndAdmin, that.sellingGeneralAndAdmin)
				&& Objects.equals(operatingExpense, that.operatingExpense)
				&& Objects.equals(operatingIncome, that.operatingIncome)
				&& Objects.equals(otherIncomeExpenseNet, that.otherIncomeExpenseNet) && Objects.equals(ebit, that.ebit)
				&& Objects.equals(interestIncome, that.interestIncome)
				&& Objects.equals(pretaxIncome, that.pretaxIncome) && Objects.equals(incomeTax, that.incomeTax)
				&& Objects.equals(minorityInterest, that.minorityInterest) && Objects.equals(netIncome, that.netIncome)
				&& Objects.equals(netIncomeBasic, that.netIncomeBasic);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), totalRevenue, costOfRevenue, grossProfit, researchAndDevelopment,
				sellingGeneralAndAdmin, operatingExpense, operatingIncome, otherIncomeExpenseNet, ebit, interestIncome,
				pretaxIncome, incomeTax, minorityInterest, netIncome, netIncomeBasic);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("totalRevenue", totalRevenue).add("costOfRevenue", costOfRevenue)
				.add("grossProfit", grossProfit).add("researchAndDevelopment", researchAndDevelopment)
				.add("sellingGeneralAndAdmin", sellingGeneralAndAdmin).add("operatingExpense", operatingExpense)
				.add("operatingIncome", operatingIncome).add("otherIncomeExpenseNet", otherIncomeExpenseNet)
				.add("ebit", ebit).add("interestIncome", interestIncome).add("pretaxIncome", pretaxIncome)
				.add("incomeTax", incomeTax).add("minorityInterest", minorityInterest).add("netIncome", netIncome)
				.add("netIncomeBasic", netIncomeBasic).toString();
	}
}
