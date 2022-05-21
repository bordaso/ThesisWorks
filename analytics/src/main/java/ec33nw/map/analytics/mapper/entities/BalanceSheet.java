package ec33nw.map.analytics.mapper.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class BalanceSheet extends Report {

    private static final long serialVersionUID = 903088600080035429L;

    private BigDecimal currentCash;
    private BigDecimal shortTermInvestments;
    private BigDecimal receivables;
    private BigDecimal inventory;
    private BigDecimal otherCurrentAssets;
    private BigDecimal currentAssets;
    private BigDecimal longTermInvestments;
    private BigDecimal propertyPlantEquipment;
    private BigDecimal goodwill;
    private BigDecimal intangibleAssets;
    private BigDecimal otherAssets;
    private BigDecimal totalAssets;
    private BigDecimal accountsPayable;
    private BigDecimal currentLongTermDebt;
    private BigDecimal otherCurrentLiabilities;
    private BigDecimal totalCurrentLiabilities;
    private BigDecimal longTermDebt;
    private BigDecimal otherLiabilities;
    private BigDecimal minorityInterest;
    private BigDecimal totalLiabilities;
    private BigDecimal commonStock;
    private BigDecimal retainedEarnings;
    private BigDecimal treasuryStock;
    private BigDecimal capitalSurplus;
    private BigDecimal shareholderEquity;
    private BigDecimal netTangibleAssets;

    @JsonCreator
    public BalanceSheet(
            @JsonProperty("symbol") final String symbol,
            @JsonProperty("id") final String id,
            @JsonProperty("key") final String key,
            @JsonProperty("subkey") final String subkey,
            @JsonProperty("updated") final Long updated,
            @JsonProperty("date") final Long date,
            @JsonProperty("reportDate") final LocalDate reportDate,
            @JsonProperty("fiscalDate") final LocalDate fiscalDate,
            @JsonProperty("currency") final String currency,
            @JsonProperty("currentCash") final BigDecimal currentCash,
            @JsonProperty("shortTermInvestments") final BigDecimal shortTermInvestments,
            @JsonProperty("receivables") final BigDecimal receivables,
            @JsonProperty("inventory") final BigDecimal inventory,
            @JsonProperty("otherCurrentAssets") final BigDecimal otherCurrentAssets,
            @JsonProperty("currentAssets") final BigDecimal currentAssets,
            @JsonProperty("longTermInvestments") final BigDecimal longTermInvestments,
            @JsonProperty("propertyPlantEquipment") final BigDecimal propertyPlantEquipment,
            @JsonProperty("goodwill") final BigDecimal goodwill,
            @JsonProperty("intangibleAssets") final BigDecimal intangibleAssets,
            @JsonProperty("otherAssets") final BigDecimal otherAssets,
            @JsonProperty("totalAssets") final BigDecimal totalAssets,
            @JsonProperty("accountsPayable") final BigDecimal accountsPayable,
            @JsonProperty("currentLongTermDebt") final BigDecimal currentLongTermDebt,
            @JsonProperty("otherCurrentLiabilities") final BigDecimal otherCurrentLiabilities,
            @JsonProperty("totalCurrentLiabilities") final BigDecimal totalCurrentLiabilities,
            @JsonProperty("longTermDebt") final BigDecimal longTermDebt,
            @JsonProperty("otherLiabilities") final BigDecimal otherLiabilities,
            @JsonProperty("minorityInterest") final BigDecimal minorityInterest,
            @JsonProperty("totalLiabilities") final BigDecimal totalLiabilities,
            @JsonProperty("commonStock") final BigDecimal commonStock,
            @JsonProperty("retainedEarnings") final BigDecimal retainedEarnings,
            @JsonProperty("treasuryStock") final BigDecimal treasuryStock,
            @JsonProperty("capitalSurplus") final BigDecimal capitalSurplus,
            @JsonProperty("shareholderEquity") final BigDecimal shareholderEquity,
            @JsonProperty("netTangibleAssets") final BigDecimal netTangibleAssets,
            @JsonProperty("filingType") final String filingType,
            @JsonProperty("fiscalQuarter") final BigDecimal fiscalQuarter,
            @JsonProperty("fiscalYear") final BigDecimal fiscalYear) {
        super(symbol, id, key, subkey, updated, reportDate, filingType, fiscalDate, fiscalQuarter, fiscalYear,
                currency, date);
        this.currentCash = currentCash;
        this.shortTermInvestments = shortTermInvestments;
        this.receivables = receivables;
        this.inventory = inventory;
        this.otherCurrentAssets = otherCurrentAssets;
        this.currentAssets = currentAssets;
        this.longTermInvestments = longTermInvestments;
        this.propertyPlantEquipment = propertyPlantEquipment;
        this.goodwill = goodwill;
        this.intangibleAssets = intangibleAssets;
        this.otherAssets = otherAssets;
        this.totalAssets = totalAssets;
        this.accountsPayable = accountsPayable;
        this.currentLongTermDebt = currentLongTermDebt;
        this.otherCurrentLiabilities = otherCurrentLiabilities;
        this.totalCurrentLiabilities = totalCurrentLiabilities;
        this.longTermDebt = longTermDebt;
        this.otherLiabilities = otherLiabilities;
        this.minorityInterest = minorityInterest;
        this.totalLiabilities = totalLiabilities;
        this.commonStock = commonStock;
        this.retainedEarnings = retainedEarnings;
        this.treasuryStock = treasuryStock;
        this.capitalSurplus = capitalSurplus;
        this.shareholderEquity = shareholderEquity;
        this.netTangibleAssets = netTangibleAssets;
    }

    public BigDecimal getCurrentCash() {
        return currentCash;
    }

    public BigDecimal getShortTermInvestments() {
        return shortTermInvestments;
    }

    public BigDecimal getReceivables() {
        return receivables;
    }

    public BigDecimal getInventory() {
        return inventory;
    }

    public BigDecimal getOtherCurrentAssets() {
        return otherCurrentAssets;
    }

    public BigDecimal getCurrentAssets() {
        return currentAssets;
    }

    public BigDecimal getLongTermInvestments() {
        return longTermInvestments;
    }

    public BigDecimal getPropertyPlantEquipment() {
        return propertyPlantEquipment;
    }

    public BigDecimal getGoodwill() {
        return goodwill;
    }

    public BigDecimal getIntangibleAssets() {
        return intangibleAssets;
    }

    public BigDecimal getOtherAssets() {
        return otherAssets;
    }

    public BigDecimal getTotalAssets() {
        return totalAssets;
    }

    public BigDecimal getAccountsPayable() {
        return accountsPayable;
    }

    public BigDecimal getCurrentLongTermDebt() {
        return currentLongTermDebt;
    }

    public BigDecimal getOtherCurrentLiabilities() {
        return otherCurrentLiabilities;
    }

    public BigDecimal getTotalCurrentLiabilities() {
        return totalCurrentLiabilities;
    }

    public BigDecimal getLongTermDebt() {
        return longTermDebt;
    }

    public BigDecimal getOtherLiabilities() {
        return otherLiabilities;
    }

    public BigDecimal getMinorityInterest() {
        return minorityInterest;
    }

    public BigDecimal getTotalLiabilities() {
        return totalLiabilities;
    }

    public BigDecimal getCommonStock() {
        return commonStock;
    }

    public BigDecimal getRetainedEarnings() {
        return retainedEarnings;
    }

    public BigDecimal getTreasuryStock() {
        return treasuryStock;
    }

    public BigDecimal getCapitalSurplus() {
        return capitalSurplus;
    }

    public BigDecimal getShareholderEquity() {
        return shareholderEquity;
    }

    public BigDecimal getNetTangibleAssets() {
        return netTangibleAssets;
    }
    
    public void setCurrentCash(BigDecimal currentCash) {
		this.currentCash = currentCash;
	}

	public void setShortTermInvestments(BigDecimal shortTermInvestments) {
		this.shortTermInvestments = shortTermInvestments;
	}

	public void setReceivables(BigDecimal receivables) {
		this.receivables = receivables;
	}

	public void setInventory(BigDecimal inventory) {
		this.inventory = inventory;
	}

	public void setOtherCurrentAssets(BigDecimal otherCurrentAssets) {
		this.otherCurrentAssets = otherCurrentAssets;
	}

	public void setCurrentAssets(BigDecimal currentAssets) {
		this.currentAssets = currentAssets;
	}

	public void setLongTermInvestments(BigDecimal longTermInvestments) {
		this.longTermInvestments = longTermInvestments;
	}

	public void setPropertyPlantEquipment(BigDecimal propertyPlantEquipment) {
		this.propertyPlantEquipment = propertyPlantEquipment;
	}

	public void setGoodwill(BigDecimal goodwill) {
		this.goodwill = goodwill;
	}

	public void setIntangibleAssets(BigDecimal intangibleAssets) {
		this.intangibleAssets = intangibleAssets;
	}

	public void setOtherAssets(BigDecimal otherAssets) {
		this.otherAssets = otherAssets;
	}

	public void setTotalAssets(BigDecimal totalAssets) {
		this.totalAssets = totalAssets;
	}

	public void setAccountsPayable(BigDecimal accountsPayable) {
		this.accountsPayable = accountsPayable;
	}

	public void setCurrentLongTermDebt(BigDecimal currentLongTermDebt) {
		this.currentLongTermDebt = currentLongTermDebt;
	}

	public void setOtherCurrentLiabilities(BigDecimal otherCurrentLiabilities) {
		this.otherCurrentLiabilities = otherCurrentLiabilities;
	}

	public void setTotalCurrentLiabilities(BigDecimal totalCurrentLiabilities) {
		this.totalCurrentLiabilities = totalCurrentLiabilities;
	}

	public void setLongTermDebt(BigDecimal longTermDebt) {
		this.longTermDebt = longTermDebt;
	}

	public void setOtherLiabilities(BigDecimal otherLiabilities) {
		this.otherLiabilities = otherLiabilities;
	}

	public void setMinorityInterest(BigDecimal minorityInterest) {
		this.minorityInterest = minorityInterest;
	}

	public void setTotalLiabilities(BigDecimal totalLiabilities) {
		this.totalLiabilities = totalLiabilities;
	}

	public void setCommonStock(BigDecimal commonStock) {
		this.commonStock = commonStock;
	}

	public void setRetainedEarnings(BigDecimal retainedEarnings) {
		this.retainedEarnings = retainedEarnings;
	}

	public void setTreasuryStock(BigDecimal treasuryStock) {
		this.treasuryStock = treasuryStock;
	}

	public void setCapitalSurplus(BigDecimal capitalSurplus) {
		this.capitalSurplus = capitalSurplus;
	}

	public void setShareholderEquity(BigDecimal shareholderEquity) {
		this.shareholderEquity = shareholderEquity;
	}

	public void setNetTangibleAssets(BigDecimal netTangibleAssets) {
		this.netTangibleAssets = netTangibleAssets;
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
        final BalanceSheet that = (BalanceSheet) o;
        return Objects.equals(currentCash, that.currentCash) &&
                Objects.equals(shortTermInvestments, that.shortTermInvestments) &&
                Objects.equals(receivables, that.receivables) &&
                Objects.equals(inventory, that.inventory) &&
                Objects.equals(otherCurrentAssets, that.otherCurrentAssets) &&
                Objects.equals(currentAssets, that.currentAssets) &&
                Objects.equals(longTermInvestments, that.longTermInvestments) &&
                Objects.equals(propertyPlantEquipment, that.propertyPlantEquipment) &&
                Objects.equals(goodwill, that.goodwill) &&
                Objects.equals(intangibleAssets, that.intangibleAssets) &&
                Objects.equals(otherAssets, that.otherAssets) &&
                Objects.equals(totalAssets, that.totalAssets) &&
                Objects.equals(accountsPayable, that.accountsPayable) &&
                Objects.equals(currentLongTermDebt, that.currentLongTermDebt) &&
                Objects.equals(otherCurrentLiabilities, that.otherCurrentLiabilities) &&
                Objects.equals(totalCurrentLiabilities, that.totalCurrentLiabilities) &&
                Objects.equals(longTermDebt, that.longTermDebt) &&
                Objects.equals(otherLiabilities, that.otherLiabilities) &&
                Objects.equals(minorityInterest, that.minorityInterest) &&
                Objects.equals(totalLiabilities, that.totalLiabilities) &&
                Objects.equals(commonStock, that.commonStock) &&
                Objects.equals(retainedEarnings, that.retainedEarnings) &&
                Objects.equals(treasuryStock, that.treasuryStock) &&
                Objects.equals(capitalSurplus, that.capitalSurplus) &&
                Objects.equals(shareholderEquity, that.shareholderEquity) &&
                Objects.equals(netTangibleAssets, that.netTangibleAssets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currentCash, shortTermInvestments, receivables, inventory,
                otherCurrentAssets, currentAssets, longTermInvestments, propertyPlantEquipment, goodwill,
                intangibleAssets, otherAssets, totalAssets, accountsPayable, currentLongTermDebt,
                otherCurrentLiabilities, totalCurrentLiabilities, longTermDebt, otherLiabilities, minorityInterest,
                totalLiabilities, commonStock, retainedEarnings, treasuryStock, capitalSurplus, shareholderEquity,
                netTangibleAssets);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("currentCash", currentCash)
                .add("shortTermInvestments", shortTermInvestments)
                .add("receivables", receivables)
                .add("inventory", inventory)
                .add("otherCurrentAssets", otherCurrentAssets)
                .add("currentAssets", currentAssets)
                .add("longTermInvestments", longTermInvestments)
                .add("propertyPlantEquipment", propertyPlantEquipment)
                .add("goodwill", goodwill)
                .add("intangibleAssets", intangibleAssets)
                .add("otherAssets", otherAssets)
                .add("totalAssets", totalAssets)
                .add("accountsPayable", accountsPayable)
                .add("currentLongTermDebt", currentLongTermDebt)
                .add("otherCurrentLiabilities", otherCurrentLiabilities)
                .add("totalCurrentLiabilities", totalCurrentLiabilities)
                .add("longTermDebt", longTermDebt)
                .add("otherLiabilities", otherLiabilities)
                .add("minorityInterest", minorityInterest)
                .add("totalLiabilities", totalLiabilities)
                .add("commonStock", commonStock)
                .add("retainedEarnings", retainedEarnings)
                .add("treasuryStock", treasuryStock)
                .add("capitalSurplus", capitalSurplus)
                .add("shareholderEquity", shareholderEquity)
                .add("netTangibleAssets", netTangibleAssets)
                .toString();
    }

}
