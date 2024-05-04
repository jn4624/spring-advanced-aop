package hello.aop.internalcall;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

/**
 * ObjectProvider(Provider), ApplicationContext
 * 사용하여 지연(LAZY) 조회
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CallServiceV2 {
    private final ObjectProvider<CallServiceV2> callServiceProvider;

    public void external() {
        log.info("call external");
        CallServiceV2 callServiceV2 = callServiceProvider.getObject();
        callServiceV2.internal(); // 외부 메서드 호출
    }

    public void internal() {
        log.info("call internal");
    }
}
