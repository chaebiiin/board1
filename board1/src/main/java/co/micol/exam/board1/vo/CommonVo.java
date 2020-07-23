package co.micol.exam.board1.vo;

public class CommonVo {
	private int no;
	private String id;
	private String password;
	private String name;
	private String tel;
	private String title;
	private String contents;

	public CommonVo() { // 디폴트 생성자
		super();
	}

	public CommonVo(String id, String password) { // 로그인 체크시 사용하려고 만든 생성자
		this.id = id;
		this.password = password;
	}
	

	public CommonVo(String id, String password, String name, String tel) { //Member table
		this.id = id;
		this.password = password;
		this.name = name;
		this.tel = tel;
	}
	

	public CommonVo(int no, String id, String title, String contents) { //board table
		this.no = no;
		this.id = id;
		this.title = title;
		this.contents = contents;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}
