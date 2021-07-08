package com.yamdeng.reboot.java.basic;

import com.yamdeng.reboot.java.vo.BoardVo;

import java.util.Optional;
import java.util.OptionalInt;

// Optional<T>
public class OptionalFunction {

    public static void main(String[] args) {
        System.out.println("========== Optional ==========");
        System.out.println();

        basicOptional();

        System.out.println("========== OptionalFunction End ==========");
    }

    private static <T> void displayOptional(Optional<T> optional) {
        // get, isEmpty, isPresent
        T value = null;
        if(optional.isEmpty()) {
            value = optional.orElse(null);
        } else {
            value = optional.get();
        }
        System.out.println("optional.get() : " + value);
        System.out.println("optional.isEmpty() : " + optional.isEmpty());
        System.out.println("optional.isPresent() : " + optional.isPresent());
        System.out.println("optional.toString() : " + optional.toString());
    }

    private static void basicOptional() {

        BoardVo boardVo = new BoardVo();
        BoardVo boardVoJava = new BoardVo("자바");

        // Optional<T> 사용 방법 : empty, of, ofNullable(of 메서드는 null 값 자체를 Optional 객체로 만들수 없음)
        Optional<BoardVo> emptyOptional = Optional.empty();
        Optional<BoardVo> boardOptional = Optional.of(boardVo);
        Optional<BoardVo> nullableOptional = Optional.ofNullable(null);

//        displayOptional(boardOptional);
//        displayOptional(boardOptional);
//        displayOptional(nullableOptional);

        // ifPresent : 존재하면 Consumer 실행
//        emptyOptional.ifPresent((b) -> System.out.println("emptyOptional ifPresent : " + b));
//        boardOptional.ifPresent((b) -> System.out.println("boardOptional ifPresent : " + b));
        
        // ifPresentOrElse : 존재하면 consumer 실행하고 존재하지 않으면 Runnable 실행
        emptyOptional.ifPresentOrElse((b) -> System.out.println("emptyOptional ifPresentOrElse : " + b), () -> System.out.println("ifPresentOrElse else"));
        boardOptional.ifPresentOrElse((b) -> System.out.println("boardOptional ifPresentOrElse : " + b), () -> System.out.println("ifPresentOrElse else"));

        // or : 값이 존재하면 같은 Optional을 반환하고 값이 없으면 Supplier에서 만든 Optional을 반환
        Optional<BoardVo> newOptional1 = emptyOptional.or(() -> Optional.of(boardVo));
        Optional<BoardVo> newOptional2 = boardOptional.or(() -> Optional.of(boardVo));
        System.out.println("emptyOptional == newOptional1 : " + (emptyOptional == newOptional1));
        System.out.println("boardOptional == newOptional2 : " + (boardOptional == newOptional2));

        // orElse : 값이 존재하면 값을 반환하고, 값이 없으면 기본값을 반환
        // orElseGet : 값이 존재하면 값을 반환하고, 값이 없으면 Supplier에서 제공하는 값을 반환
        // orElseThrow : 값이 존재하면 값을 반환하고, 값이 없으면 Supplier에서 생성한 예외를 발생
        emptyOptional.orElse(new BoardVo("C++"));
        emptyOptional.orElseGet(() -> new BoardVo("C"));
        try {
            emptyOptional.orElseThrow(() -> new RuntimeException("ElseThrow Error"));
        } catch(Exception e) {
//            e.printStackTrace();
        }

        // filter : 값이 존재하고 프레디케이트와 일치하면 값을 포함하는 Optional을 반환하고, 값이 없거나 프레디케이트와 일치하지 않으면 빈 Optional을 반환
        newOptional1 = emptyOptional.filter((b) -> false);
        newOptional2 = boardOptional.filter(b -> false);
        System.out.println("emptyOptional == newOptional1 : " + (emptyOptional == newOptional1));
        System.out.println("boardOptional == newOptional2 : " + (boardOptional == newOptional2));

        // map : 값이 존재하면 제공된 매핑 함수를 적용함. 반환값은 Optional 임
        String emptyOptionalMapValue = emptyOptional.map(b -> b.toString()).orElseGet(() -> null);
        String boardOptionalMapValue = boardOptional.map(b -> b.toString()).get();
        System.out.println("emptyOptionalMapValue : " + emptyOptionalMapValue);
        System.out.println("boardOptionalMapValue : " + boardOptionalMapValue);

        // 기본형 특화 Optional
        OptionalInt optionalInt = OptionalInt.of(100);
        int intValue = optionalInt.getAsInt();
        System.out.println("intValue : " + intValue);

        // stream : 값이 존재하면 존재하는 값만 포함하는 스트림을 반환하고, 값이 없으면 빈 스트림을 반환
        int streamSumValue = optionalInt.stream().sum();
        System.out.println("sumValue : " + streamSumValue);

        // flatmap : 값이 존재하면 인수로 제공된 함수를 적용한 결과 Optional을 반환하고, 값이 없으면 빈 Optional을 반환
        boardOptional.flatMap(b -> Optional.of(b));
    }
}
