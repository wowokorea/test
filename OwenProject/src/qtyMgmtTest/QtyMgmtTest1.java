package qtyMgmtTest;

public class QtyMgmtTest1 {
	
	public static void main(String[] args) {
		
		try {
			
			/*
			 * 1. 재고 수량을 먼저 파악 해야 하는 경우 select로 재고 수량 체크 (수량 > 0)
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 2. 주문정보 insert문
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 3. 재고 차감 update문
			 * 이때 where조건은 수량 > 0이 기본
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 4. 업데이트 후 한번 더 수량 테이블을 select 해서 해당 상품의 재고수량이 0보다 작아진 경우 exception을 발생시킨다
			 */
			
		} catch (Exception e) {
			/* 롤백 후 처리 */ 
		}
		
	}
	
}
