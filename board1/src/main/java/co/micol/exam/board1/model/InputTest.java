package co.micol.exam.board1.model;


import java.util.*;

import co.micol.exam.board1.vo.CommonVo;

public class InputTest {
	Scanner sc = new Scanner(System.in);
	BoardServiceImpl boardServiceImpl = new BoardServiceImpl();
//	CommonVo dao = new CommonVo();
	List<CommonVo> list = new ArrayList<CommonVo>();
	CommonVo vo;

	public void menu() {
		boolean boolCheck = true;
		do { //do ~ while 다시 설명.
			System.out.println("1. 조 회 ");
			System.out.println("2. 입 력 ");
			System.out.println("3. 수 정 ");
			System.out.println("4. 삭 제 ");
			System.out.println("5. 종 료");
			System.out.println("=============================");
			System.out.println("원하는 번호를 선택하세요.");

			switch (sc.nextInt()) { //sc.nextInt()다시 설명 
			case 1:
				memberSelect();
				break;

			case 2:
				memberInput();
				break;

			case 3:
				memberUpdate();
				break;

			case 4:
				memberDelete();
				break;

			case 5:
				boolCheck = false;
				System.out.println("\n\n 작업이 종료 되었습니다.");
			break;
			}
		} while (boolCheck);
	}



	private CommonVo memberDelete() {
		boolean bool = true;
		System.out.println("삭제 할 회원 아이디를 입력하세요.");
		vo = new  CommonVo();
		vo.setId(sc.next());
		int n = boardServiceImpl.delete(vo);
		if(n != 0 ) {
			System.out.println("삭제 되었습니다.");
		}else {
			System.out.println("실패 되었습니다.");
		}
		return vo;
	}
	private void memberUpdate() { 
		
		System.out.println("업데이트 할 회원 정보를 입력하세요.");
		vo = new  CommonVo();
		System.out.print("수정할 아이디 : ");
		vo.setId(sc.next());
		System.out.print("변경될 패스워드 : ");
		vo.setPassword(sc.next());
		System.out.print("변경될 이름 : ");
		vo.setName(sc.next());
		System.out.print("변경될 전화번호 : ");
		vo.setTel(sc.next());
		int n = boardServiceImpl.update(vo);
		if(n != 0 ) {
			System.out.println("수정 되었습니다.");
		}else {
			System.out.println("실패 되었습니다.");
		}		
	}

	private void memberInput() { //입력하기
		System.out.println("입력 할 회원 정보를 입력하세요.");
		vo = new  CommonVo();
		System.out.print("아이디 : ");
		vo.setId(sc.next());
		System.out.print("패스워드 : ");
		vo.setPassword(sc.next());
		System.out.print("이름 : ");
		vo.setName(sc.next());
		System.out.print("전화번호 : ");
		vo.setTel(sc.next());
		int n = boardServiceImpl.insert(vo);
		if(n != 0 ) {
			System.out.println("입력 되었습니다.");
		}else {
			System.out.println("실패 되었습니다.");
		}
		
	}

	private void memberSelect() {
		boolean bool = true;
		do {
			System.out.println("1. 전체회원 조회");
			System.out.println("2. 회원조회");
			System.out.println("3. 돌아가기");
			System.out.println("============================");
			System.out.println("작업번호를  선택하새요.");
			
			switch (sc.nextInt()) {
			case 1:
				list = boardServiceImpl.selectList();
				System.out.println("*****전체회원 조회 ******");
				for (CommonVo board : list) {
					board.toString();
				}
				break;

			case 2:
				vo = new CommonVo();
				System.out.println("회원 아이디를 입력하세요> ");
				vo.setId(sc.next());
				vo = boardServiceImpl.select(vo);
				vo.toString();
				break;

			case 3:
				bool = false;
				break;
			}
		}while(bool);
	}
}
