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

	@Override
	public int delete(CommonVo vo) {
		return 0;
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
