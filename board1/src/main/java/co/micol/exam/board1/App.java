package co.micol.exam.board1;

import java.util.ArrayList;
import java.util.List;

import co.micol.exam.board1.model.BoardServiceImpl;
import co.micol.exam.board1.model.MemberLogin;
import co.micol.exam.board1.vo.CommonVo;

public class App {

	public static void main(String[] args) {
//		MemberLogin ml = new MemberLogin();
//		ml.loginCheck();
		BoardServiceImpl board = new BoardServiceImpl();
		List<CommonVo> list = new ArrayList<CommonVo>();
		list = board.selectList();
		for (CommonVo vo : list) {
			System.out.println("번호 | 아이디  |  제목     | 내용              ");
			System.out.print(vo.getNo() + "  | ");
			System.out.print(vo.getId() + "  |  ");
			System.out.print(vo.getTitle() + " |  ");
			System.out.println(vo.getContents() + " | ");
			
		}
	}
	
}
