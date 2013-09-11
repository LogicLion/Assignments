import java.util.Scanner;


public class Assignment1 {
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		double idealArray[] = 
		{	0.0,0.2,0.4,0.6,0.8,1,1.2,1.4,1.6,1.8,
			2.0,2.2,2.4,2.6,2.8,3,3.2,3.4,3.6,3.8
		};
		
		double noisyArray[] = 
		{	0.008976173,0.015300936,0.38730289,0.65415467,0.705971749,
			1.307427486,1.071969875,1.11358872,1.688798266,1.334709476,
			2.40411576,2.310886173,2.432582514,2.174252365,2.727890154,
			3.222288922,3.43265852,3.823261752,3.184157161,3.933609629
		};
		
		System.out.println("Please enter in the size of your filter array.");
		int filterArraySize = input.nextInt();
		
		if(filterArraySize % 2 != 0 && filterArraySize > 0)
		{
			//On odd array.
			//Create array with user defined size.
			double[] filterArray = new double[filterArraySize];
			int inputCounter = 0;
			int inputValue = 0;
			
	
			//init array with user defined values.
			while(inputCounter < filterArraySize)
			{
				System.out.print("Input value: ");
				inputValue = input.nextInt();
				filterArray[inputCounter] = inputValue;
				inputCounter++;
			}
		}else{
			System.out.println("Incorrect value for array initilization.");
		}	
	}
	
	public static double[] filterSignal(double values[], double filter[])
	{
		
		double[] valuesAfterFilter = new double[values.length];
		for(int i = 0; i < valuesAfterFilter.length; i++)
		{
			if(i == 0 || i == valuesAfterFilter.length - 1)
			{
				valuesAfterFilter[i] = 0;
			}
		}
		return filter;
	}

}
