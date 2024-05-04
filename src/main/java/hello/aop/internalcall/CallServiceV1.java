package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 참고: 생성자 주입은 순환 사이클을 만들기 때문에
 * 오류가 발생하여 사용이 불가능하므로
 * 수정자를 통해 주입 받아야 한다.
 */
@Slf4j
@Component
public class CallServiceV1 {
    private CallServiceV1 callServiceV1;

    @Autowired
    public void setCallServiceV1(CallServiceV1 callServiceV1) {
        this.callServiceV1 = callServiceV1;
    }

    public void external() {
        log.info("call external");
        callServiceV1.internal(); // 외부 메서드 호출
    }

    public void internal() {
        log.info("call internal");
    }
}
