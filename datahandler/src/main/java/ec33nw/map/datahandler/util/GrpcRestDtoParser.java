package ec33nw.map.datahandler.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.google.protobuf.ByteString;

import iexcloud.gen.Balancesheet.Builder;
import iexcloud.gen.DecimalValue;
import pl.zankowski.iextrading4j.api.stocks.v1.Report;

public class GrpcRestDtoParser{
	
	public static final GrpcRestDtoParser INSTANCE = new GrpcRestDtoParser();
	
	private GrpcRestDtoParser() {
		super();
	}
	
	public <B extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>, R extends Report>  
	B parseRestToGrpc(Class<?> bsGrpcClass, Class<?> restClass, B builderObj, R restObj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, NoSuchMethodException{
		List<Field> restFields = Arrays.asList(restClass.getDeclaredFields());
		List<Field> grpcFields = Arrays.asList(bsGrpcClass.getDeclaredFields());	
		for(Field restField : restFields) {
			for(Field grpcField : grpcFields) {
				setRestToGrpcField(restField, restObj, grpcField, builderObj);
			}
		}
		
		return builderObj;
	}


	private <B extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>, R extends Report>  
	void setRestToGrpcField(Field restField, R restObj, Field grpcField, B bsGrpcB) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, NoSuchMethodException {
		if((grpcField.getName()+"_").equalsIgnoreCase(restField.getName())) {	
				try {
					BigDecimal restValueBd = (BigDecimal)restField.get(restObj);
					Method setter = bsGrpcB.getClass().getDeclaredMethod("set"+(restField.getName().substring(0, 1).toUpperCase() + restField.getName().substring(1)), DecimalValue.class);
					DecimalValue serializedBd = DecimalValue.newBuilder()
					        .setScale(restValueBd.scale())
					        .setPrecision(restValueBd.precision())
					        .setValue(ByteString.copyFrom(restValueBd.unscaledValue().toByteArray()))
					        .build();					
					setter.invoke(bsGrpcB, serializedBd);
				} catch (ClassCastException e) {
					String restValueStr = (String)restField.get(restObj);
					Method setter = bsGrpcB.getClass().getDeclaredMethod("set"+(restField.getName().substring(0, 1).toUpperCase() + restField.getName().substring(1)), String.class);
					setter.invoke(bsGrpcB, restValueStr);
				} 
		} else {
			return;
		}		
	}	
}
