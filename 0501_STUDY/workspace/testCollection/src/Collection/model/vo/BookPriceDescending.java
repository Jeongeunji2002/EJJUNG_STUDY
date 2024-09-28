package Collection.model.vo;

public class BookPriceDescending implements java.util.Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// 도서제목들끼리 비교 연선하는 정렬 기준 코드를 작성함
		int result = 0;

		// 부모타입에서 후손타입으로 형변환시에는 (down casting)
		// 반드시 실제 참조하는 클래스가 후손클래스타입인지 확인하고 형변환을 할 것
		if (o1 instanceof Book && o2 instanceof Book) {
			Book b1 = (Book) o1;
			Book b2 = (Book) o2;
			
			result = (b1.getPrice() < b2.getPrice())? 1 : ((b1.getPrice() == b2.getPrice())? 0 : -1);
			//오름차순
			//result = (b1.getPrice() > b2.getPrice())? 1 : ((b1.getPrice() == b2.getPrice())? 0 : -1);
		}
		return result; // 내림차순은 return -result;
	}

}
