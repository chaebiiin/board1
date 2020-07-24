package co.micol.exam.board1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.exam.board1.vo.CommonVo;

public class BoardServiceImpl implements Service {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<CommonVo> selectList() {
		List<CommonVo> list = new ArrayList<CommonVo>();
		String sql = "select * from board";
		CommonVo vo;
		try {
			conn= DbConnect.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new CommonVo();
				vo.setNo(rs.getInt("no"));
				vo.setId(rs.getString("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
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
		String sql = "select * from board where no =?";
				
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getNo());
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int insert(CommonVo vo) {
		int insert = 0;
		String sql = "insert into board values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,  vo.getNo());
			psmt.setString(2, vo.getId());
			psmt.setString(3, vo.getTitle());
			psmt.setString(3, vo.getContents());
			insert = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return insert;
	}

	@Override
	public int update(CommonVo vo) {
		int update = 0;
		String sql = "update member set no = ?, title = ?, contents = ? where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getNo());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContents());
			psmt.setString(4, vo.getId());
			update = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  update;
	}

	@Override
	public  int delete(CommonVo vo) {
		int delete = 0;
		
		String sql = "delete from board where no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getNo());
			delete= psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return delete;
	}

	@Override
	public CommonVo loginCheck(CommonVo vo) {
		return null;
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
