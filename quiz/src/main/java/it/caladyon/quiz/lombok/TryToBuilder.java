package it.caladyon.quiz.lombok;

import lombok.Builder;
import lombok.Data;

public class TryToBuilder {

	public static void main(String[] args) {
		Dto built = Dto.builder().field1(1).build();
		built.toBuilder().field2(2).build();
		System.out.println(built.getField2());
	}

	@Data
	@Builder(toBuilder = true)
	public static class Dto {
		private int field1;
		private int field2;
	}

}
