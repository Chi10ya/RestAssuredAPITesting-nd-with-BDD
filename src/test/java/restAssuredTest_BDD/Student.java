package restAssuredTest_BDD;

import java.util.List;

public class Student {
	
	public int id;
	public String firstName;
	public String lastName;
	public String email;
	public String programme;
	
	List<String> courses;
	
		public void setId(int id){
			this.id=id;			
		}
		
		public int getId(){
			return this.id;
		}
		
		public void setFirstName(String firstName){
			this.firstName = firstName;
		}
		
		public String getFirstName(){
			return this.firstName;
		}
		
		public void setLastName(String lastName){
			this.lastName = lastName;
		}
		
		public String getLastName(){
			return this.lastName;
		}
		
		public void setEmail(String email){
			this.email = email;
		}
		
		public String getemail(){
			return this.email;
		}
		
		public void setPrograme(String programme){
			this.programme = programme;
		}
		
		public String getPrograme(){
			return this.programme;
		}
		
		public void setCourses(List<String> courses){
			this.courses = courses;
		}
		
		public List<String> getCourses(){
			return courses;
		}
		
		public String getStudentRecord(){
			return (this.id+" "+this.firstName+" "+this.lastName+" "+this.email+" "+this.programme+" "+this.courses);
		}

}
