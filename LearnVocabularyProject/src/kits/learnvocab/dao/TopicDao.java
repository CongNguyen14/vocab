package kits.learnvocab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kits.learnvocab.config.ConnectionFactory;
import kits.learnvocab.dto.TopicDto;

public class TopicDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	public TopicDao() {
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();	
		return conn;
	}
	
	public List<TopicDto> findAll() {
		List<TopicDto> dtoList = new ArrayList<TopicDto>();
		try {
			String queryString = "SELECT * FROM topic";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			
		
			while (resultSet.next()) {
				TopicDto lstp = new TopicDto();
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
	public void add(TopicDto dto){
		try {
			String queryString ="INSERT INTO topic(id, name) VALUES (?,?)";
			
		
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1,dto.getId());
			ptmt.setString(2,dto.getName());
			
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
	public void delete(TopicDto id) {
		try {
			String queryString ="delete from topic where id =?";
			
		
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("nhap id topic bn muon xoa");
			
			int id_delete = sc.nextInt();
		
			ptmt.setInt(1,id_delete);
			
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
	public void update(TopicDto dto) {
		try {
			String queryString ="update topic set name=? where id=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("nhap name topic bn muon update");
			String name_upd = sc.nextLine();
			System.out.println("nhap id topic bn muon update");
			int id_upd = sc.nextInt();
			ptmt.setString(1,name_upd);
			
			ptmt.setInt(2,id_upd);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
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
	

