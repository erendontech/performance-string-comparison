
public class PerformanceStringComparison {
	
	private static final int MEGA_BYTES = 10241024;
	private static final int TIMES = 9999;
	
	public static void main(String args[]){
		PerformanceStringComparison msg = new PerformanceStringComparison();
		msg.concatMultipleString(TIMES);
		msg.concatMultipleStringBuilder(TIMES);
		msg.concatMultipleStringBuffer(TIMES);
	}
	
	public void concatMultipleString(long _limit){
		System.out.println("Init concatMultipleString");
		System.gc();
		long start, end;
		start = System.currentTimeMillis();
		
		String message = new String();
		
		for(int i = 0; i <= _limit; i++){
			message = message + "Performance " + i;
			
			if(i == _limit){
			    Runtime rt = Runtime.getRuntime();
			    long usedMB = (rt.totalMemory()/MEGA_BYTES - rt.freeMemory()/MEGA_BYTES);
			    System.out.println(String.format("Memory usage: %s", usedMB));
			}
		}		
		
		end = System.currentTimeMillis();
		System.out.println(String.format("Time String %s milliseconds \n", (end-start)));
	}
	
	public void concatMultipleStringBuilder(long _limit){
		System.out.println("Init concatMultipleStringBuilder");
		System.gc();
		long start, end;
		start = System.currentTimeMillis();
		StringBuilder message = new StringBuilder();
		
		for(int i = 0; i <= _limit; i++){
			message.append("Performance ").append(i);
			if(i == _limit){
			    Runtime rt = Runtime.getRuntime();
			    long usedMB = (rt.totalMemory() - rt.freeMemory()) / 1024 / 1024;
			    System.out.println(String.format("Memory usage: %s", usedMB));
			}
		}		
		
		end = System.currentTimeMillis();
		System.out.println(String.format("Time StringBuilder %s milliseconds \n", (end-start)));
	}
	
	public void concatMultipleStringBuffer(long _limit){
		System.out.println("Init concatMultipleStringBuffer");
		System.gc();
		long start, end;
		start = System.currentTimeMillis();
		StringBuffer message = new StringBuffer();
		
		for(int i = 0; i <= _limit; i++){
			message.append("Performance ").append(i);
			if(i == _limit){
			    Runtime rt = Runtime.getRuntime();
			    long usedMB = (rt.totalMemory() - rt.freeMemory()) / 1024 / 1024;
			    System.out.println(String.format("Memory usage: %s", usedMB));
			}
		}		
		
		end = System.currentTimeMillis();
		System.out.println(String.format("Time StringBuffer %s milliseconds", (end-start)));
	}
	

}
