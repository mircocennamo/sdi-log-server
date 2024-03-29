package it.interno.log.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Utils {

    private final static String FORMAT_TIMESTAMP = "yyyy-MM-dd-HH.mm.ss.SSSSSS" ;

    public static Timestamp getTimestamp() {
        Timestamp tmsp = new Timestamp(Calendar.getInstance().getTimeInMillis()) ;
        int nanos = tmsp.getNanos() ;
        int rand = new Random().nextInt(1000) ;
        nanos+=rand*1000;
        tmsp.setNanos(nanos);
        return tmsp;
    }

    private static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static void myCopyProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    public static Timestamp convertStringToTimestampByFormat(String stringaDaConvertire) {
        if(!StringUtils.isNotBlank(stringaDaConvertire))
            return null ;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_TIMESTAMP);
        LocalDateTime localDateTime = LocalDateTime.from(formatter.parse(stringaDaConvertire));

        return Timestamp.valueOf(localDateTime);
    }
}
