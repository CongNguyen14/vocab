package kits.learnvocab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kits.learnvocab.config.ConnectionFactory;
import kits.learnvocab.dto.TopicDto;
import kits.learnvocab.dto.UserDto;

public class UserDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	public UserDao() {
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();	
		return conn;
	}
	
	public  List<UserDto> findAll() {
		List<UserDto> dtoList = new ArrayList<UserDto>();
		try {
			String queryString = "SELECT * FROM user";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			
		
			while (resultSet.next()) {
				UserDto lstp = new UserDto();
				lstp.setUsername(resultSet.getString("username"));
				lstp.setPassword(resultSet.getString("password"));
				
				lstp.setRole(resultSet.getInt("role"));
				dtoList.add(lstp);
				
			}
			return dtoList;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(ptmt != null) {
					ptmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		return dtoList;
	}
	public void add(UserDto dto){
		try {
			String queryString ="INSERT INTO user(username, password) VALUES (?,?)";
			
		
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1,dto.getUsername());
			ptmt.setString(2,dto.getPassword());
			
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(ptmt != null) {
					ptmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
}
