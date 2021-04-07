package main;

public interface Operation {

	String getName();

	String getSymbol();

	void perform(int num1, int num2);

	boolean isOk();

	int getResult();

	String getErrorMessage();

}
