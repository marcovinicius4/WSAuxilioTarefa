package br.com.activity.modelo;

public class class_Exercise {
	private String Name;
	private String Text;
	private int Answer;
	private int answerStudent;
	//para que servem essas variaveis ?
	private String option1Text;
	private String option2Text;
	private String option3Text;
	private String option4Text;
	
	public String getName() {
		return Name;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public String getText() {
		return Text;
	}
	
	public void setText(String Text) {
		this.Text = Text;
	}
	
	public int getAnswer() {
		return Answer;
	}
	
	public void setAnswer(int Answer) {
		this.Answer = Answer;
	}
	
	public int getAnswerStudent() {
		return answerStudent;
	}
	
	public void serAnswerStudent(int answerStudent) {
		this.answerStudent = answerStudent;
	}
	
	public String getOption1Text() {
		return option1Text;
	}
	
	public void setOption1Text(String option1Text) {
		this.option1Text = option1Text;
	}
	
	public String getOption2Text() {
		return option2Text;
	}
	
	public void setOption2Text(String option2Text) {
		this.option2Text = option2Text;
	}
	
	public String getOption3Text() {
		return option3Text;
	}
	
	public void setOption3Text(String option3Text) {
		this.option3Text = option3Text;
	}
	
	public String getOption4Text() {
		return option4Text;
	}
	
	public void setOption4Text(String option4Text) {
		this.option4Text = option4Text;
	}
}
