package acme.framework.utilities;

import java.util.Date;

public class AcmeDuration {
	
	private AcmeDuration() {
		
	}
	
	public static Double getDuration(final Date eStart, final Date eEnd) {
		 
		 final long diff = Math.abs(eStart.getTime() - eEnd.getTime());
		 
		 final long periodMinutes = (diff/60)/1000;
		 return AcmeDuration.doPeriod(periodMinutes);
	 }
	
//	public static Double correctPeriod(final Double period) {
//		Double res = period;
//		if(res!=null) {
//			final Double dec = res - res.intValue();
//			if (dec >= .6) {
//				res = res + 1 - .6;
//			}
//		}
//
//		return res;
//	}
	
	public static Double doPeriod(final long period) {
		final Double res;
		System.out.println("period: "+period);
		final Double div = (double) period/60;
		System.out.println("div: "+div);
		final int entero = div.intValue();
		System.out.println("entero: "+entero);
		final Double decimal = (double)(period - (entero*60))/100;
		System.out.println("decimal: "+decimal);
		res = entero+decimal;
		System.out.println("res: "+res);

		return res;
	}
}
