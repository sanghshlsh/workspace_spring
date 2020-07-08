package kr.co.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AOPTestServiceimpl implements AOPTestService {

	//join points
	@Override
	public void aoptest() {
		//aop를 이용 for문을 제외하면 안보이게 만드는작업	core code만 남는다.
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < 100000; i++) {
			System.out.println(i);
		}
		
		long end = System.currentTimeMillis();
		
	}

	@Override
	public void aoptest2() {
		//aop 적용 코드
		for(int i = 0 ; i < 10 ; i++) {
			System.out.println(i);
		}
	}
	
	@Override
	public void aoptest3() {
		for(int i = 0 ; i < 100000; i++) {
			System.out.println(i);
		}
	}
	

}
