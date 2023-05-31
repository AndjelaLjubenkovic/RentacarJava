package model;
public class User {

	private int user_id;
	private String username;
	private String password;

	public int getUser_id() {
	    return user_id;
	}

	/**
	 * 
	 * @param user_id
	 */
	public void setUser_id(int user_id) {
	    this.user_id = user_id;
	}

	public String getUsername() {
	    return username;
	}

	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
	    this.username = username;
	}

	public String getPassword() {
	    return password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
	    this.password = password;
	}

	public User() {
	    // TODO - implement User.User
	    throw new UnsupportedOperationException();
	}

}