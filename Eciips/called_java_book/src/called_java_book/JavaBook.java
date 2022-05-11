package called_java_book;

public class JavaBook {

	//�����������
	private int noOfCopies;
	
	JavaBook(int noOfCopies){
		this.noOfCopies = noOfCopies;
	}
	
	JavaBook() {
		this(5);
	}
	
	
	public int getNoOfCopies() { 
		return noOfCopies;
	}


	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	
	
	public void increaseBook(int howMany) { // ����
		this.noOfCopies = noOfCopies + howMany;
	}
	
	
	public void decreaseBook(int howMany) { // ����
		
		if(this.noOfCopies - howMany <= 0)
		this.noOfCopies = 0;
		
		else
		this.noOfCopies = noOfCopies - howMany;
	}


	void MyBook(){
		System.out.println("i Got this Book");
	}
	
}