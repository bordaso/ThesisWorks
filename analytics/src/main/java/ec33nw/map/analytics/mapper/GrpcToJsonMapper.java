package ec33nw.map.analytics.mapper;

import java.math.BigDecimal;
import java.math.MathContext;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import ec33nw.map.analytics.AnalyticsApplication;
import ec33nw.map.analytics.mapper.entities.BalanceSheet;
import ec33nw.map.analytics.mapper.entities.BalanceSheets;
import ec33nw.map.analytics.mapper.entities.CashFlow;
import ec33nw.map.analytics.mapper.entities.CashFlows;
import ec33nw.map.analytics.mapper.entities.IncomeStatement;
import ec33nw.map.analytics.mapper.entities.IncomeStatements;
import iexcloud.gen.BalanceSheetGrpc;
import iexcloud.gen.BalanceSheetsGrpc;
import iexcloud.gen.CashflowStatementGrpc;
import iexcloud.gen.CashflowStatementsGrpc;
import iexcloud.gen.DecimalValue;
import iexcloud.gen.IncomeStatementGrpc;
import iexcloud.gen.IncomeStatementsGrpc;
import iexcloud.gen.Symbol;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class GrpcToJsonMapper {

	public static GrpcToJsonMapper INSTANCE = Mappers.getMapper(GrpcToJsonMapper.class);

	@Mapping(source = "balanceSheetGrpcList", target = "balanceSheet")
	public abstract BalanceSheets map(BalanceSheetsGrpc balanceSheetsGrpc);

	@Mapping(source = "cashflowStatementGrpcList", target = "cashFlow")
	public abstract CashFlows map(CashflowStatementsGrpc cashflowStatementsGrpc);

	@Mapping(source = "incomeStatementGrpcList", target = "income")
	public abstract IncomeStatements map(IncomeStatementsGrpc incomeStatementsGrpc);

	public abstract BalanceSheet map(BalanceSheetGrpc balanceSheetGrpc);
	
	public abstract CashFlow map(CashflowStatementGrpc cashflowStatementGrpc);
	
	public abstract IncomeStatement map(IncomeStatementGrpc incomeStatementGrpc);
	
    public BigDecimal map(DecimalValue value) {
        MathContext mc = new java.math.MathContext(value.getPrecision());
    	BigDecimal deserialized = new java.math.BigDecimal(
    	        new java.math.BigInteger(value.getValue().toByteArray()),
    	        value.getScale(),
    	        mc);

        return deserialized;
    }

}
