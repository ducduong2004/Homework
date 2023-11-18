package lab9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Falculty {
	private String name;
	private String address;
	private List<Course> courses;



	public Falculty(String name, String address, List<Course> courses) {
		super();
		this.name = name;
		this.address = address;
		this.courses = courses;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public List<Course> getCourses() {
		return courses;
	}



	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Course getMaxPracticalCourse() {
		int maxStu = 0;
		Course result = null;
		for(Course c : courses) {
			int temp = c.getStudents().size();
			if(maxStu < temp) {
				maxStu = temp;
				result = c;
			}
		}
		return result;
	}
	
	public Course getMinPracticalCourse() {
		int minStu = courses.get(0).getStuNum();
		Course result = null;
		for(Course c : courses) {
			int temp = c.getStudents().size();
			if(minStu >= temp) {
				minStu = temp;
				result = c;
			}
		}
		return result;
	}


	public Map<Integer, List<Student>> groupStudentsByYear(){
		Map<Integer, List<Student>> map = new HashMap<Integer, List<Student>>();
		for(Course c : courses) {
			List<Student> listStu = c.getStudents();
			for(Student stu : listStu) {
				int year = stu.getYear();
				if(!map.containsKey(year)) {
					List<Student> list = new ArrayList<Student>();
					map.put(year, list);
				}
				List<Student> list = map.get(year);
				if( !list.contains(stu) ) {
					list.add(stu);
					map.put(year, list);
				}


			}
		}
		return map;
	}

	public Set<Course> filterCourses(String type){
		Set<Course> result = new HashSet<>();
		Falculty test = this;
		while(test.courses.size() > 0) {
			Course c = test.getMinPracticalCourse();
			if(c.getType().equals(type))result.add(c);
			test.getCourses().remove(c);
		}	
		return result;
	}




}
