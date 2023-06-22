package DAO;

public interface DAOInterface <T>{
	
	public int insert(T t);
	public int update(T t, int id);
	public int delete(int id);
	public int findById(T t);
	
	
	
	
}
