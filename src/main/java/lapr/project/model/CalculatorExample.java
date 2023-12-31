package lapr.project.model;

/**
 * @author Nuno Bettencourt {@literal <nmb@isep.ipp.pt>} on 24/10/2021.
 */
public class CalculatorExample {

	/**
	 * Calculate the sum of two int numbers.
	 *
	 * @param firstOperand First number to be added
	 * @param secondOperand Second number to be added
	 * @return Return the sum of both operands.
	 */
	public int sum(int firstOperand, int secondOperand)
	{
		return firstOperand + secondOperand;
	}

	public int subtract(int firstOperand, int secondOperand){
		return firstOperand-secondOperand;
	}

	
}
