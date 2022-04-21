package ec33nw.map.datahandler.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.google.protobuf.ByteString;

import iexcloud.gen.DecimalValue;
import pl.zankowski.iextrading4j.api.stocks.v1.Report;

public class GrpcRestDtoParser{
	
	public static final GrpcRestDtoParser INSTANCE = new GrpcRestDtoParser();
	
	private GrpcRestDtoParser() {
		super();
	}
	
	public <BLDR extends com.google.protobuf.GeneratedMessageV3.Builder<?>, RESTTYP extends Report>  
	BLDR parseRestToGrpc(Class<?> grpcClass, Class<?> restClass, BLDR builderObj, RESTTYP restObj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, NoSuchMethodException{
		List<Field> restFields = Arrays.asList(restClass.getDeclaredFields());
		List<Field> grpcFields = Arrays.asList(grpcClass.getDeclaredFields());	
		for(Field restField : restFields) {
			for(Field grpcField : grpcFields) {
				setRestToGrpcField(restField, restObj, grpcField, builderObj);
			}
		}
		
		return builderObj;
	}


	private <BLDR extends com.google.protobuf.GeneratedMessageV3.Builder<?>, RESTTYP extends Report>  
	void setRestToGrpcField(Field restField, RESTTYP restObj, Field grpcField, BLDR grpcBuilder) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, NoSuchMethodException {
		if((grpcField.getName()+"_").equalsIgnoreCase(restField.getName())) {	
				try {
					BigDecimal restValueBd = (BigDecimal)restField.get(restObj);
					Method setter = grpcBuilder.getClass().getDeclaredMethod("set"+(restField.getName().substring(0, 1).toUpperCase() + restField.getName().substring(1)), DecimalValue.class);
					DecimalValue serializedBd = DecimalValue.newBuilder()
					        .setScale(restValueBd.scale())
					        .setPrecision(restValueBd.precision())
					        .setValue(ByteString.copyFrom(restValueBd.unscaledValue().toByteArray()))
					        .build();					
					setter.invoke(grpcBuilder, serializedBd);
				} catch (ClassCastException e) {
					String restValueStr = (String)restField.get(restObj);
					Method setter = grpcBuilder.getClass().getDeclaredMethod("set"+(restField.getName().substring(0, 1).toUpperCase() + restField.getName().substring(1)), String.class);
					setter.invoke(grpcBuilder, restValueStr);
				} 
		}		
	}	
}
