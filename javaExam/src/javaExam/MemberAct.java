package javaExam;

import java.util.ArrayList;
import java.util.Scanner;

class Member{
	public String ID;
	public String name;
	public String area;
	
	public Member(String iD, String name, String area) {
		ID = iD;
		this.name = name;
		this.area = area;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	
}
public class MemberAct {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Member> list = new ArrayList<Member>();
		int menu=0;
		
		while (true) {
			System.out.println("=========헬스클럽 회원관리 프로그램=========");
			System.out.println("1.회원 정보 관리 | 2. 프로그램 종료");
			System.out.println("====================================");
			System.out.println("메뉴를 선택하세요. >>>");
			menu = scanner.nextInt();
			
			if (menu == 1) {
				while (true) {
					System.out.println("=========일반회원 정보관리=============");
					System.out.println("11.일반회원 정보입력 | 22.일반회원 정보삭제 | 33.일반회원 정보확인 | 0.이전 단계");
					System.out.println("====================================");
					System.out.println("메뉴를 선택하세요. >>>");
					int menu1 = scanner.nextInt();
					
					if (menu1 == 11) {
						System.out.println("가입할 회원 수를 입력하세요>>");
						int insertNum = scanner.nextInt();
						
						for (int i = 0; i < insertNum; i++) {
							System.out.println("회원정보를 입력하세요.");
							System.out.println("회원 아이디");
							String insertID = scanner.next();
							System.out.println("회원 이름");
							String insertName = scanner.next();
							System.out.println("회원 지역");
							String insertArea = scanner.next();
							
							list.add(new Member(insertID, insertName, insertArea));
						}
					}else if (menu1 == 22) {
						System.out.println("삭제할 회원번호를 입력하세요.");
						int removeNum = scanner.nextInt();
						list.remove(removeNum - 1); //remove의 인덱스는 0부터 시작이므로
						
						for (int i = 0; i < list.size(); i++) {
							Member member = list.get(i);
							System.out.println("회원 번호 "+(i+1));//i는 0부터니까 회원번호 1번부터 보기위해 +1
							System.out.println("회원 아이디 "+member.getID());
							System.out.println("회원 이름 "+member.getName());
							System.out.println("회원 지역 "+member.getArea());
						}
					}
					else if (menu1 == 33) {
						System.out.println("등록된 회원수는 "+list.size()+"입니다.");
						
						for (int i = 0; i < list.size(); i++) {
							Member member = list.get(i);
							System.out.println("회원 번호 "+(i+1));//i는 0부터니까 회원번호 1번부터 보기위해 +1
							System.out.println("회원 아이디 "+member.getID());
							System.out.println("회원 이름 "+member.getName());
							System.out.println("회원 지역 "+member.getArea());
						}
					}
					else if (menu1 == 0) {
						break;
					}
				}
			} else if(menu == 2) {
				System.out.println("====================================");
				System.out.println("헬스클럽 회원관리 프로그램을 종료합니다.");
				System.out.println("====================================");
				break;
			}
			
		}
	}
}
