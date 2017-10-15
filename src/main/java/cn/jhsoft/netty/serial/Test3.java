package cn.jhsoft.netty.serial;

import java.util.Arrays;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

public class Test3 {

	public static void main(String[] args) {

		// 动态buffer，自动扩容
		ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();
		buffer.writeInt(101);
		buffer.writeDouble(80.1);
		buffer.writeDouble(80.2);

		// byte大小是看 buffer写指针的位置，确定他的长度
		byte[] bytes = new byte[buffer.writerIndex()];
		buffer.readBytes(bytes);
		
		System.out.println(Arrays.toString(bytes));
		
		"abc".getBytes();
		
		//================================================
		ChannelBuffer wrappedBuffer = ChannelBuffers.wrappedBuffer(bytes);
		System.out.println(wrappedBuffer.readInt());
		System.out.println(wrappedBuffer.readDouble());
		System.out.println(wrappedBuffer.readDouble());

	}

}
