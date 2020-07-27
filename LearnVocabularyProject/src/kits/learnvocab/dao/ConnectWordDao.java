package kits.learnvocab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kits.learnvocab.config.ConnectionFactory;
import kits.learnvocab.dto.ConnectWordDto;
import kits.learnvocab.dto.TopicDto;
import kits.learnvocab.dto.WordvnDto;

public class ConnectWordDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	public ConnectWordDao() {
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();	
		return conn;
	}
	public List<ConnectWordDto> findAll() {
		List<ConnectWordDto> dtoList = new ArrayList<ConnectWordDto>();
		try {
			String queryString = "SELECT * FROM connectword ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			
		
			while (resultSet.next()) {
				ConnectWordDto lstp = new ConnectWordDto();
				lstp.setId(resultSet.getInt("id"));
				lstp.setName((resultSet.getString("name")));
				lstp.setLang_id(resultSet.getInt("lang_id"));
				lstp.setVn_id(resultSet.getInt("vn_id"));
				lstp.setTopic_id(resultSet.getInt("topic_id"));
				
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
	
	
//	public static void main(String[] args) {
//		ConnectWordDto cwdto = new ConnectWordDto();
//		
//		ConnectWordDao cwdao = new ConnectWordDao();
//		List<ConnectWordDto> ls = new ArrayList();
//		ls = cwdao.findAll();
//		
//		WordvnDto wvdto = new WordvnDto();
//		
//		WordVnDao wndao = new WordVnDao();
//		List<WordvnDto> lsmean = new ArrayList();
//		lsmean = wndao.mean();
//		System.out.println("press t to display mean");
//		for (int i =0; i < ls.size(); i++) {
//			System.out.println( ls.get(i).getName());
//			Scanner sc = new Scanner(System.in);
//			
//			String input = sc.next();
//			if(input.equals("t")) {	
//					System.out.println( lsmean.get(i).getName());			
//			}
//		}
//	}
}
