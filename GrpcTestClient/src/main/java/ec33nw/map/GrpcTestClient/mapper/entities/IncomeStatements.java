package ec33nw.map.GrpcTestClient.mapper.entities;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class IncomeStatements implements Serializable {

	private static final long serialVersionUID = -4920654684070765966L;

	private String symbol;
	private List<IncomeStatement> income;

	public IncomeStatements() {
		super();
	}

	@JsonCreator
	public IncomeStatements(@JsonProperty("symbol") final String symbol,
			@JsonProperty("income") final List<IncomeStatement> income) {
		this.symbol = symbol;
		this.income = immutableList(income);
	}

	public String getSymbol() {
		return symbol;
	}

	public List<IncomeStatement> getIncome() {
		return income;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setIncome(List<IncomeStatement> income) {
		this.income = income;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final IncomeStatements that = (IncomeStatements) o;
		return Objects.equal(symbol, that.symbol) && Objects.equal(income, that.income);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(symbol, income);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("symbol", symbol).add("income", income).toString();
	}

}
