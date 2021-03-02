package com.spring.db;

public class AnonymousTest {

	public static void main(String[] args) {
		
		Car s = new Sonata();
		s.run();
		
		Car tesla = new Car() {

			@Override
			public void run() {
				System.out.println("테슬라는 소리없이 달립니다.");
				
			}
			
		};
		tesla.run();
		
		new Car() {
			@Override
			public void run() {
				System.out.println("포르쉐는 팍팍 달립니다.");
				
			}
		}.run();
		
		//lambda식 적용: 인터페이스 안에 추사에서드가 단 하나일 경우에만 가능.
		Car morning = () -> {
			System.out.println("모닝이 뿔뿔뿔 달립니다.");
		};
		
		morning.run();
		
		System.out.println("------------------------------------");
		
		//계산기 인터페이스
		Calculator sharp = new Calculator() {
			
			@Override
			public int add(int n1, int n2) {
				System.out.println("샤프 계산기의 덧셈!");
				return n1+n2;
			}
		};
		System.out.println(sharp.add(3, 10));
		
		Calculator casio = (x,y)->{
			System.out.println("카시오 계산기의 덧셈!");
			return x+y;
		};
		System.out.println(casio.add(3, 5));
	}
	
//	Calculator xiaomi = (x, y) -> x + y;
//	
//	System.out.prinln("샤오미 결과" + xiaomi.add(30,50));
//	

}
