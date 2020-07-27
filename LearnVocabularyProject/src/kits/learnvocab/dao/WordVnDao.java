package kits.learnvocab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kits.learnvocab.config.ConnectionFactory;
import kits.learnvocab.dto.WordvnDto;

public class WordVnDao {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	public WordVnDao() {
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();	
		return conn;
	}
	public List<WordvnDto> mean() {
		List<WordvnDto> dtoList = new ArrayList<WordvnDto>();
		try {
			String queryString = "SELECT * FROM word_vn ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			
		
			while (resultSet.next()) {
				WordvnDto lstp = new WordvnDto();
				lstp.setId(resultSet.getInt("id"));
				lstp.setName((resultSet.getString("name")));
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
	public static void main(String[] args) {
		WordvnDto wndto = new WordvnDto();
		
		WordVnDao wndao = new WordVnDao();	
	
		List<WordvnDto> ls = new ArrayList();
		ls = wndao.mean();		
		for (int i =0; i < ls.size(); i++) {
			System.out.println(ls.get(i).getName());
		}
	}
}
