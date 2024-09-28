package poly.model.entity;

public class Circle implements IShape {
	
	private double radius; // 반지름
	
	public Circle() {}
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double area() {
		// 원 면적 계산 리턴
		return Math.PI * Math.pow(this.radius, 2);
	}

	@Override
	public double perimeter() {
		// 원 둘레 계산 리턴
		return 2 * Math.PI * this.radius;
	}

}
