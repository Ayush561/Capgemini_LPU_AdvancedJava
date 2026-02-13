package Assignment;

public class Main {
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		//dao.insertData();
		System.out.println(dao.fetchData(121));
		dao.showData();
		//dao.deleteData(121);
	}

}
