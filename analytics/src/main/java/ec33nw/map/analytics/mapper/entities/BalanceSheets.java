package ec33nw.map.analytics.mapper.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.List;

import static pl.zankowski.iextrading4j.api.util.ListUtil.immutableList;

public class BalanceSheets implements Serializable {

    private static final long serialVersionUID = -6344117637699888256L;

    private String symbol;
    private List<BalanceSheet> balanceSheet;

    public BalanceSheets() {
		super();
	}

	@JsonCreator
    public BalanceSheets(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("balancesheet") final List<BalanceSheet> balanceSheet) {
        this.symbol = symbol;
        this.balanceSheet = immutableList(balanceSheet);
    }

    public String getSymbol() {
        return symbol;
    }

    public List<BalanceSheet> getBalanceSheet() {
        return balanceSheet;
    }

    public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setBalanceSheet(List<BalanceSheet> balanceSheet) {
		this.balanceSheet = balanceSheet;
	}

	@Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BalanceSheets that = (BalanceSheets) o;
        return Objects.equal(symbol, that.symbol) &&
                Objects.equal(balanceSheet, that.balanceSheet);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(symbol, balanceSheet);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("symbol", symbol)
                .add("balanceSheet", balanceSheet)
                .toString();
    }

}
