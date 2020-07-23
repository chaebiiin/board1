package co.micol.exam.board1.model;

import java.util.Scanner;

import co.micol.exam.board1.vo.CommonVo;

public class MemberLogin {
	private ServiceImpl service = new ServiceImpl();
	private CommonVo vo;
	Scanner sc = new Scanner(System.in);

	public void loginCheck() {
		System.out.println("사용자 아이디를 입력하세요.");
		String id = sc.next();
		System.out.println("패스워드를 입력하세요.");
		String pw = sc.next();

		vo = new CommonVo(id, pw); // 생성자를 통한 id, password값 전달
		vo = service.loginCheck(vo);

		if (vo.getName() == null) {
			System.out.println("아이디 혹은 패스워드가 틀렸습니다.");
		} else {
			System.out.println(vo.getName() + "님 환영합니다.");
		}
	}
}
