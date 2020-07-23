package co.micol.exam.board1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.exam.board1.vo.CommonVo;

public class ServiceImpl implements Service {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<CommonVo> selectList() {
		List<CommonVo> list = new ArrayList<CommonVo>();
		CommonVo vo;
		String sql = "select * from member";	
		try {
			conn = DbConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			rs= psmt.executeQuery();
			while(rs.next()) {
				vo = new CommonVo();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				list.add(vo);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public CommonVo select(CommonVo vo) {
		return null;
	}

	@Override
	public int insert(CommonVo vo) {
		return 0;
	}

	@Override
	public int update(CommonVo vo) {
		return 0;
	}

	@Override // 다시 설명듣기.
	public int delete(CommonVo vo) {
		int n = 0;
		String sql = "delete from member where id =?";
		try {
			conn = DbConnect.getConnection();			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public CommonVo loginCheck(CommonVo vo) {
		String sql = "select * from member where id =? and password = ?";
		
		try {
			conn = DbConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			rs =psmt.executeQuery();
			if(rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();

		return vo;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
