package cn.jhsoft.netty.serial;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Test2 {

	public static void main(String[] args) {
		int id = 101;
		int age = 21;

		// 申请8个空间，两个int，每个int占4个字节。
		ByteBuffer buffer = ByteBuffer.allocate(8);
		buffer.putInt(id);
		buffer.putInt(age);
		byte[] array = buffer.array();
		System.out.println(Arrays.toString(buffer.array()));
		
		//====================================================
		// 反序列化
		ByteBuffer buffer2 = ByteBuffer.wrap(array);
		System.out.println("id:"+buffer2.getInt());
		System.out.println("age:"+buffer2.getInt());

	}

}
